package com.solid.book;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

public class Book {
    private String title;
    private List<String> pages;
    private ListIterator<String> iterator;
    private String currentPage;

    public Book(String title, List<String> pages) {
        this.title = title;
        this.pages = pages;
        iterator = pages.listIterator();
        if (iterator.hasNext()) {
            currentPage = iterator.next();
        } else {
            currentPage = null;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public boolean turnToNextPage() {
        if (iterator.hasNext()) {
            currentPage = iterator.next();
            return true;
        } else {
            return false;
        }
    }
}

class PrintToFile {
    public PrintToFile() {
    }

    Book book;
    public void addBook(Book book) {
        this.book = book;
    }

    public void printToFile() {
        boolean isEven = false;
        String previousPage = "";
        try {
            FileWriter fileWriter = new FileWriter(this.book.getTitle() + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            do {
                if (isEven) {
                    previousPage = this.book.getCurrentPage();
                    isEven = false;
                } else {
                    printWriter.printf("%-25s : %25s%n", previousPage, this.book.getCurrentPage());
                    isEven = true;
                }
            } while (this.book.turnToNextPage());
            printWriter.close();
        } catch (IOException ex) {
            System.out.println("Cannot print this book due to IOException");
        }
    }
}

class PrintToScreen {
    public PrintToScreen() {
    }

    Book book;
    public void addBook(Book book) {
        this.book = book;
    }

    public void printToScreen() {
        do {
            System.out.println(this.book.getCurrentPage());
        } while (this.book.turnToNextPage());
    }
}