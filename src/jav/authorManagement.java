package jav;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;



public class authorManagement {
    private author[] authors;
    private static int index = 0;
    private int count = 10;
    public authorManagement() {
        this.authors = new author[count];
    }

    public void setAuthors(author[] authors) {
        this.authors = authors;
    }

    public author[] getAuthors() {
        return authors;
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

    /**
     * add an author (著者追加)
     *
     * @param a the author to add (著者記入)
     * @return added an author or not?  (著者追加したチェック)
     */

    public boolean add(author a) {
        if (findId(a.getId()) != null) {
            return false;
        }
        if (index == count) {
            authors = Arrays.copyOf(authors, count + 10);
        }
        authors[index++] = a;
        return true;
    }


    public author findId(String id) {
        if (index != 0) {
            for (int i = 0; i <= count; i++) {
                if (Objects.equals(authors[i].getId(), id)) {
                    return authors[i];
                }
            }
        }
        return null;
    }

    public boolean remove(String id) {
        int index = -1;
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] != null && authors[i].getId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Author with ID " + id + " not found!");
            return false;
        }

        for (int i = index; i < authors.length - 1; i++) {
            authors[i] = authors[i + 1];
        }
        authors[authors.length - 1] = null;
        System.out.println("Removed author with ID " + id);
        return true;
    }



    public boolean edit(String id, Scanner sc) {
        author authorToEdit = findId(id);
        if (authorToEdit != null) {
            System.out.println("New ID:");
            authorToEdit.setId(sc.nextLine());
            System.out.println("New Name:");
            authorToEdit.setName(sc.nextLine());
            System.out.println("New Gender:");
            authorToEdit.setGender(sc.nextLine());
            System.out.println("New Age:");
            authorToEdit.setAge(sc.nextInt());
            return true;
        }
        return false;
    }


    public void output() {
        if (index != 0) {
            System.out.printf("\n|%s|%s|%s|%s|", centerString(10, "ID"), centerString(20, "Name"), centerString(5, "Age"), centerString(10, "Gender"));
            for (int i = 0; i < index; i++) {
                System.out.printf("\n|%s|%s|%5d|%s|", centerString(10, authors[i].getId()), centerString(20, authors[i].getName()), authors[i].getAge(), centerString(10, authors[i].getGender()));
            }
        } else {
            System.out.println("\n No authors found!");
        }
        System.out.println();
    }

    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }


    public author findName(String name) {
        if (index != 0) {
            for (int i = 0; i < index; i++) {
                if (authors[i].getName().equalsIgnoreCase(name)) {
                    return authors[i];
                }
            }
        }
        return null;
    }

    public author input(Scanner scanner) {
        author aut = new author();
        System.out.println("Nhập thông tin tác giả:");
        System.out.print("\nNhập Id: ");
        aut.setId(scanner.nextLine());
        System.out.print("\nNhập Tên: ");
        aut.setName(scanner.nextLine());
        System.out.print("\nNhập Giới tính: ");
        aut.setGender(scanner.nextLine());
        System.out.print("\nNhập Tuổi: ");
        aut.setAge(Integer.parseInt(scanner.nextLine()));
        return aut;
    }
}




