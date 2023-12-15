package jav;

import java.util.Scanner;

public class Programs {
    static int selection;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bookManagement bookList = inputBook();
        authorManagement authorList = inputAuthor();


        do {
            System.out.println("------------ Put your hands up ---------------");
            System.out.println("1. Author Management");
            System.out.println("2. Book Management");
            System.out.println("3. Exit");
            selection = Integer.parseInt(sc.nextLine());
            switch (selection) {
                case 1:
                    do {
                        System.out.println("----------Yolo-------");
                        System.out.println("1. Add");
                        System.out.println("2. Show");
                        System.out.println("3. Edit");
                        System.out.println("4. Delete");
                        System.out.println("5. Back");
                        selection = Integer.parseInt(sc.nextLine());
                        switch (selection) {
                            case 1:
                                author newAuthor = authorList.input(sc);
                                authorList.add(newAuthor);
                                break;
                            case 2:
                                authorList.output();
                                break;
                            case 3:
                                System.out.print("\n ID to change: ");
                                String editIdAuthor = sc.nextLine();
                                author editAuthor = authorList.findId(editIdAuthor);
                                authorList.edit(String.valueOf(editAuthor), sc);
                                break;
                            case 4:
                                System.out.print("\n ID to delete: ");
                                String deleteIdAuthor = sc.nextLine();
                                authorList.remove(deleteIdAuthor);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("just quit!!!");
                                break;
                        }
                    } while (selection != 5);
                    break;

                case 2:
                    do {
                        System.out.println("---------BBTY---------");
                        System.out.println("1. Add");
                        System.out.println("2. Show");
                        System.out.println("3. Search by Title");
                        System.out.println("4. Search by Author");
                        System.out.println("5. Edit");
                        System.out.println("6. Back to oldschool");
                        selection = Integer.parseInt(sc.nextLine());
                        switch (selection) {
                            case 1:
                                book newBook = bookList.input(sc, authorList);
                                if (newBook != null) {
                                    bookList.add(newBook);
                                    System.out.println("yes sir");
                                }
                                break;
                            case 2:
                                bookList.print();
                                break;
                            case 3:
                                System.out.print("\n Title: ");
                                String searchTitle = sc.nextLine();
                                if (bookList.findByTitle(searchTitle) != null) {
                                    bookList.findByTitle(searchTitle).output();
                                } else {
                                    System.out.println("\n no way ");
                                }
                                break;
                            case 4:
                                System.out.print("\n the author u want ???");
                                String searchAuthor = sc.nextLine();
                                author aut = authorList.findName(searchAuthor);
                                if (authorList.findName(searchAuthor) != null) {
                                    book[] searchResult = bookList.findByAuthor(aut);
                                    bookList.output(searchResult);
                                } else {
                                    System.out.print("\n not there ");
                                }
                                break;
                            case 5:
                                System.out.print("\n the ID u love ??? ");
                                String editIdBook = sc.nextLine();
                                if (bookList.edit(editIdBook, sc, authorList)) {
                                    System.out.println("okeeeeeee");
                                } else {
                                    System.out.println("r u serious");
                                }
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("repick pls");
                                break;
                        }
                    } while (selection != 6);
                    break;
                case 3:
                    System.out.println("bai bai");
                    break;
                default:
                    System.out.println("only count to 3, sr");
            }
        } while (selection != 3);

    }


    static authorManagement inputAuthor() {
        authorManagement authorList = new authorManagement();
        authorList.setIndex(5);
        author[] authors = new author[5];
        authors[0] = new author("1", "m", 11, "134");
        authors[1] = new author("2", "m", 12, "133");
        authors[2] = new author("3", "f", 13, "132");
        authors[3] = new author("4", "f", 14, "131");
        authors[4] = new author("5", "f", 15, "130");
        authorList.setAuthors(authors);
        return authorList;
    }

    static bookManagement inputBook() {
        bookManagement bookList = new bookManagement();
        authorManagement authorList = inputAuthor();
        bookList.setIndex(5);
        book[] books = new book[5];
        books[0] = new book("10", authorList.getAuthors()[0], "Heloo", 30000);
        books[1] = new book("20", authorList.getAuthors()[1], "Há Lô", 30000);
        books[2] = new book("30", authorList.getAuthors()[2], "Bá Bì", 30000);
        books[3] = new book("40", authorList.getAuthors()[3], "Làm Gì Đấy", 30000);
        books[4] = new book("50", authorList.getAuthors()[4], "Ăn Cưm Chưa", 30000);
        bookList.setBook(books);
        return bookList;
    }

}




