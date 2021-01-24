package com.moh.ProductBackend.Repository;

import com.moh.ProductBackend.Entity.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface PublisherRepository extends CrudRepository<Publisher,Integer> {

    Optional<Publisher> getPublisherByPublisherName(String name);

    Optional<Publisher> getPublisherById(String Id);
}
