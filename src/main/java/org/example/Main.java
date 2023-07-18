package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        List<Book> books = new ArrayList<>();
        books.add(new Book ("The Handmaid's Tale", 50));
        books.add(new Book ("The Arsonist", 200)); 
        
        Author author = new Author("Margaret", "Thatcher", books);

    }
}
