/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lks.demo.controller;

import com.lks.demo.model.Book;
import com.lks.demo.service.BookService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Neeraj
 */
@RestController
public class BookController {
    
    @Resource(name="BookService")
    private BookService bookService;
 
    @RequestMapping(value= "/book/all", method= RequestMethod.GET)
    public List<Book> getAllBooks() {
        System.out.println(this.getClass().getSimpleName() + " - Get all books service is invoked.");
        return bookService.getAllBooks();
    }
    
   @RequestMapping(value= "/book/add", method= RequestMethod.POST)
    public Book addNewBook(@RequestBody Book book) throws Exception{
        try {
            System.out.println(this.getClass().getSimpleName() + " - Create new book method is invoked.");
            return bookService.addNewBook(book);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @RequestMapping(value= "/book/update/{id}", method= RequestMethod.PUT)
	public Book updateBook(@RequestBody Book upBook, @PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update book details by id is invoked.");

		Book book =  bookService.getBookById(id);
		if (book==null)
			throw new Exception("Could not find book with id- " + id);

		/* IMPORTANT - To prevent the overiding of the existing value of the variables in the database, 
		 * if that variable is not coming in the @RequestBody annotation object. */		
		if(upBook.getGenre()== null || upBook.getGenre().isEmpty())
			upBook.setGenre(book.getGenre());
		if(upBook.getTitle()== null || upBook.getTitle().isEmpty())
			upBook.setTitle(book.getTitle());
		if(upBook.getYear()== 0)
			upBook.setYear(book.getYear());
                if(upBook.getAuthorId()== 0)
			upBook.setAuthorId(book.getAuthorId());

		// Required for the "where" clause in the sql query template.
		upBook.setBookId(id);
		return bookService.updateBook(upBook);
	}
        
        @RequestMapping(value= "/book/delete/{id}", method= RequestMethod.DELETE)
	public void deleteBookById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete book by id is invoked.");

		Book book =  bookService.getBookById(id);
		if(book==null)
			throw new Exception("Could not find book with id- " + id);

		bookService.deleteBook(id);
	}

    @RequestMapping(value= "/book/{id}", method= RequestMethod.GET)
    public Book getBookById(@PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Get books service is invoked.");
		Book book=bookService.getBookById(id);
		return book;
    }
    
}
