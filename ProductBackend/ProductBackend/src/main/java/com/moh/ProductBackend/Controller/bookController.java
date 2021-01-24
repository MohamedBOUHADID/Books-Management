package com.moh.ProductBackend.Controller;

import com.moh.ProductBackend.Dto.BookDto;
import com.moh.ProductBackend.Entity.Book;
import com.moh.ProductBackend.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class bookController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public List<Book> getAll(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id){
        return bookService.findBook(id);
    }

    @PostMapping("/")
    public Book createBook(@RequestBody @Valid BookDto bookDto) throws Exception {
        return bookService.createBook(bookDto);
    }

    @PutMapping("/")
    public Book updateBook(@RequestBody @Valid BookDto bookDto){
        return bookService.updateBook(bookDto);
    }
}
