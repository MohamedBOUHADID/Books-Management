package com.moh.ProductBackend.Service;

import com.moh.ProductBackend.Dto.PublisherDto;
import com.moh.ProductBackend.Entity.Publisher;
import com.moh.ProductBackend.Exception.PublisherNotFoundException;
import com.moh.ProductBackend.Repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PublisherService {


    PublisherRepository publisherRepository;

    public Publisher getPublisherByName(String name) throws Exception {
        return publisherRepository.getPublisherByPublisherName(name)
                .orElseThrow( () -> new PublisherNotFoundException("publisher.not-found"));
    }

    public Publisher createPublisher(PublisherDto publisherDto){
        publisherRepository.getPublisherById(String.valueOf(publisherDto.getId()))
                .ifPresent( publisher -> {throw new RuntimeException("the id is already used");});
        Publisher publisher = Publisher.builder().id(publisherDto.getId()).publisherName(publisherDto.getPublisherName()).build();
        return publisherRepository.save(publisher);
    }


    public Publisher updatePublisher(PublisherDto publisherDto){
        Publisher publisher= publisherRepository.getPublisherById(String.valueOf(publisherDto.getId()))
                .orElseThrow(() -> new PublisherNotFoundException("publisher.not-found"));
        publisher.setPublisherName(publisherDto.getPublisherName());
        return publisher;
    }
}
