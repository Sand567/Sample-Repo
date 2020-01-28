package com.sandeep.other.designpatterns.structural.proxy;

public class ProxyBook implements Book {
    private final String title;
    private final String author;
    private RealBook realBook;

    ProxyBook(final String title, final String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getContent() {
        if (realBook == null) {
            realBook = new RealBook(title, author);
        }

        return realBook.getContent();
    }

    @Override
    public String toString() {
        return "ProxyBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", realBook=" + realBook +
                '}';
    }
}
