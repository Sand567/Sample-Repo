package com.sandeep.other.designpatterns.structural.proxy;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class ProxyDemo {
    public static void main(String[] args) {
        findContentByAuthorAndTitle("GoF", "Design Patterns").entrySet()
                .forEach(b -> System.out.println(b.getKey() + " --> " + b.getValue()));
    }

    /**
     * Finds the right book for our test purposes and then loads its content.
     */
    public static Map<String, String> findContentByAuthorAndTitle(final String author, final String title) {
        return filterByTitle(filterByAuthor(findAllBooks(), author), title)
                .collect(toMap(Book::getTitle, Book::getContent));
    }

    /*
     * The following methods are really simple and I think straightforward too.
     */
    private static Stream<Book> findAllBooks() {
        return Stream.of(
                new ProxyBook("Design Patterns", "Gabor Laszlo Hajba"),
                new ProxyBook("Design Patterns", "GoF"),
                new ProxyBook("Python 3 in Anger", "Gabor Laszlo Hajba"),
                new ProxyBook("Design Patterns", "Head First"));
    }

    private static Stream<Book> filterByAuthor(final Stream<Book> books, final String author) {
        return books.filter(b -> author.equals(b.getAuthor()));
    }

    private static Stream<Book> filterByTitle(final Stream<Book> books, final String title) {
        return books.filter(b -> title.equals(b.getTitle()));
    }
}
