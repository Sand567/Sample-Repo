package com.sandeep.other.designpatterns.structural.proxy;

public class RealBook implements Book {

    private final String title;
    private final String author;
    private String content;

    RealBook(final String title, final String author) {
        this.title = title;
        this.author = author;
        loadContentFromDatabase(title, author);
    }

    private void loadContentFromDatabase(final String title, final String author) {
        System.out.println("loading content from database");

        // this is to imitate loading data from database
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.content = String.format("Interesting and a very content of %s by %s", title, author);
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
        return content;
    }
}
