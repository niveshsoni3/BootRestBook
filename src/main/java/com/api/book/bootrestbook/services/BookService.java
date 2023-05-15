package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    /*private static List<Book> list = new ArrayList<Book>();

    static{
        list.add(new Book(12, "Java complete reference", "XYZ"));
        list.add(new Book(125, "Kotlin complete reference", "Android"));
        list.add(new Book(25, "Python complete reference", "Snake"));

    }*/

    //get all books
    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    //get single book
    public Book getBookByID(int id){
        Book book = null;
        try{
            book = this.bookRepository.findById(id);
            //book = list.stream().filter(b->b.getId() == id).findFirst().get();
        } catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //adding a book
    public Book addBook(Book b){
        Book book = bookRepository.save(b);
        //list.add(b);
        return book;
    }

    //delete single book
    public void deleteBook(int bid){
        bookRepository.deleteById(bid);
        /*list = list.stream().filter(b-> {//b->b.getId()!=bid
            if(b.getId()!= bid){
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());*/
    }

    //update book
    public void updateBook(Book book, int bid){
        book.setId(bid);
        bookRepository.save(book);
        /*list.stream().map(b->{
            if(b.getId() == bid){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());*/
    }

}
