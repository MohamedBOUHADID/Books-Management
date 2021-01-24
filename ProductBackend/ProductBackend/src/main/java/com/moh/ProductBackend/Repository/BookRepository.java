package com.moh.ProductBackend.Repository;

import com.moh.ProductBackend.Entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Integer> {

    public List<Book> findAll();
    public Book findBookByName(String name);
}
