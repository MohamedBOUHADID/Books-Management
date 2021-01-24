package com.moh.ProductBackend.Repository;

import com.moh.ProductBackend.Entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;


public interface AuthorRepository extends CrudRepository<Author,Integer> {

    List<Author> findAll();

    Set<Author> findAllByIdIn(int[] ids);


}
