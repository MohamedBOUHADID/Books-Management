package com.moh.ProductBackend.Service;

import com.moh.ProductBackend.Dto.BookDto;
import com.moh.ProductBackend.Entity.Author;
import com.moh.ProductBackend.Entity.Book;
import com.moh.ProductBackend.Entity.CoverType;
import com.moh.ProductBackend.Entity.Publisher;
import com.moh.ProductBackend.Exception.BookNotFoundException;
import com.moh.ProductBackend.Exception.PublisherNotFoundException;
import com.moh.ProductBackend.Repository.AuthorRepository;
import com.moh.ProductBackend.Repository.BookRepository;
import com.moh.ProductBackend.Repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class BookService {

    AuthorRepository authorRepository;

    BookRepository bookRepository;

    PublisherRepository publisherRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBook(int id){
        return bookRepository.findById(id)
                .orElseThrow(()->  {throw new BookNotFoundException("book.not-found"); });
    }

    public Book createBook(BookDto bookDto) throws PublisherNotFoundException{
        Book book = Book.builder().name(bookDto.getName())
                       .amountOfPages(bookDto.getAmountOfPages())
                       .price(bookDto.getPrice())
                       .publishingYear(bookDto.getPublishingYear()).authors(new HashSet<>())
                       .coverType(CoverType.valueOf(bookDto.getCoverType().toUpperCase())).build();
        Publisher publisher = publisherRepository.findById(bookDto.getPublisherId()).orElseThrow(()->new PublisherNotFoundException("publisher.not.found"));
        Set<Author> authors = authorRepository.findAllByIdIn(bookDto.getAuthorsIds());
        book.setPublisher(publisher);
        book.getAuthors().addAll(authors);
        return bookRepository.save(book);
    }

    public Book updateBook(BookDto bookDto) throws PublisherNotFoundException{
        Book book = bookRepository.findBookByName(bookDto.getName());
        Publisher publisher = publisherRepository.findById(bookDto.getPublisherId()).orElseThrow(()->new PublisherNotFoundException("publisher.not.found"));
        Set<Author> authors = authorRepository.findAllByIdIn(bookDto.getAuthorsIds());
        book.setPublisher(publisher);
        book.getAuthors().addAll(authors);
        book.setAmountOfPages(bookDto.getAmountOfPages());
        book.setPublishingYear(bookDto.getPublishingYear());
        book.setCoverType(CoverType.valueOf(bookDto.getCoverType().toUpperCase()));
        return book;
    }

}
