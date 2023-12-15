package jav;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class bookManagement {
    private book[] books;
    private static int index = 0;
    private int count = 10;

    public void setBooks(book[] books) {
        this.books = books;
    }

    public book[] getBooks() {
        return books;
    }

    public void setAuthors(author[] authors) {
        this.books = books;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public bookManagement() {
        books = new book[count];
    }

    /**
     * add an author (本追加)
     *
     * @param a the author to add (本記入)
     * @return added an author or not?  (本追加したチェック)
     */
    public boolean add(book a) {
        if (findId(a.getId()) == null) {
            return false;
        }
        if (index == count) {
            books = Arrays.copyOf(books, count + 10);
        }
        this.books[index++] = a;
        return true;
    }

    private book findId(String id) {
        if (index != 0) {
            for (int i = 0; i < index; i++) {
                if ((Objects.equals(books[i].getId(), id))) {
                    return books[i];
                }
            }
        }
        return null;
    }


    public boolean edit(String id, Scanner scanner, authorManagement authorList) {
        if (index != 0) {
            book editBook = findId(id);
            if (editBook != null) {
                System.out.println("Title: " + editBook.getTitle());
                System.out.print("New Title: ");
                editBook.setTitle(scanner.nextLine());
                System.out.println("Author: " + editBook.getAuthor().getName());
                System.out.print("New Author: ");
                String authorName = scanner.nextLine();
                author newAuthor = authorList.findName(authorName);
                if (newAuthor == null) {
                    System.out.println("No no no!");
                    return false;
                }
                editBook.setAuthor(newAuthor);
                System.out.println("Price " + editBook.getPrice());
                System.out.println("New Price: ");
                editBook.setPrice(Double.parseDouble(scanner.nextLine()));
                return true;
            }
        }
        return false;
    }

    public book input(Scanner scanner, authorManagement authorList) {
        book book = new book();
        System.out.println("Nhập thông tin sách: ");
        System.out.print("\nNhập Id: ");
        book.setId(scanner.nextLine());
        System.out.print("\nNhập Title sách: ");
        book.setTitle(scanner.nextLine());
        System.out.print("\nNhập Id Tác giả: ");
        String idAuthor = scanner.nextLine();
        if(authorList.findId(idAuthor) !=null){
            book.setAuthor(authorList.findId(idAuthor));
        }else {
            System.out.println("Không có tác giả này!");
            return null;
        }
        System.out.print("\nNhập Giá: ");
        book.setPrice(Double.parseDouble(scanner.nextLine()));
        return book;
    }


    public book findByTitle(String title) {
        if (index != 0) {
            for (int i = 0; i <= index; i++) {
                if (Objects.equals(books[i].getTitle().toUpperCase(), title.toUpperCase())) {
                    return books[i];
                }
            }
        }
        return null;
    }

    public book[] findByAuthor(author aut) {
        book[] result = new book[0];
        if (index != 0) {
            for (int i = 0; i < index; i++) {
                if (books[i].getAuthor().getName().equalsIgnoreCase(aut.getName())) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = books[i];
                }
            }
        }
        return result;
    }


    public void print() {
        if (index != 0) {
            System.out.printf("\n| %-10s | %-20s | %-10s | %-10s |", "ID", "Title", "Author", "Price");
            for (int i = 0; i < index; i++) {
                System.out.printf("\n| %-10s | %-20s | %-10s | %-10s |",
                        books[i].getId(),
                        books[i].getTitle(),
                        books[i].getAuthor().getName(),
                        books[i].getPrice());
            }
            System.out.println();
        }
    }

    public void output(book[] searchResult) {
        if (index != 0) {
            System.out.printf("\n| %-10s | %-20s | %-10s | %-10s |", "ID", "Name", "Age", "Gender");
            for (int i = 0; i < index; i++) {
                System.out.printf("\n| %-10s | %-20s | %-10s | %-10s |",
                        books[i].getId(),
                        books[i].getTitle(),
                        books[i].getAuthor().getName(),
                        books[i].getPrice());
            }
            System.out.println();
        }
    }


    public void setBook(book[] books) {
        this.books = books;
    }
}









