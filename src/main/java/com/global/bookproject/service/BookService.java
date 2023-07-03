package com.global.bookproject.service;

import com.global.bookproject.entity.Auther;
import com.global.bookproject.entity.Book;
import com.global.bookproject.exception.AutherNumberOfBookException;
import com.global.bookproject.repository.AutherRepo;
import com.global.bookproject.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public List <Book> findAll(){
        return bookRepo.findAll();
    }

    public Book findById(Long id){
        return bookRepo.findById(id).orElseThrow();
    }

    public Book createBook(Book book){

        Long authID = book.getAuther().getAutherID();
        int bookCount = bookRepo.getBookCountByAuthorID(authID);
        if (bookCount>1){
            throw new AutherNumberOfBookException("This Auter has 2 Books " + authID);
        }
        return bookRepo.save(book);
    }

    public Book updateBook(Book book){
        Book tempBook = findById(book.getBookID());
        tempBook.setBookName(book.getBookName());
        tempBook.setBookPrice(book.getBookPrice());
        tempBook.setBookWeight(book.getBookWeight());
        return bookRepo.save(tempBook);
    }

        public void deleteBook(Long id){
          bookRepo.deleteById(id);
    }

}
