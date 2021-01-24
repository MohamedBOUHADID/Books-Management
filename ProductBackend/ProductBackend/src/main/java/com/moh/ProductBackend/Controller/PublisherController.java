package com.moh.ProductBackend.Controller;

import com.moh.ProductBackend.Dto.PublisherDto;
import com.moh.ProductBackend.Entity.Publisher;
import com.moh.ProductBackend.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Publisher")
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


    @GetMapping("/{name}")
    public Publisher getPublisherByName(@PathVariable(name= "name") String name) throws Exception {
        return publisherService.getPublisherByName(name);
    }

    @PostMapping("/")
    public ResponseEntity<String> createPublisher(@RequestBody PublisherDto publisher){
        if(publisher.equals(null))
            return new ResponseEntity<>("publisher is null", HttpStatus.NOT_FOUND);
        publisherService.createPublisher(publisher);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PutMapping("/")
    public Publisher updatePublisher(@RequestBody PublisherDto publisherDto){
//        if(publisherDto.equals(null))
//            return new ResponseEntity<String>("publisher is null", HttpStatus.NOT_FOUND);
        return publisherService.updatePublisher(publisherDto);
    }
}
