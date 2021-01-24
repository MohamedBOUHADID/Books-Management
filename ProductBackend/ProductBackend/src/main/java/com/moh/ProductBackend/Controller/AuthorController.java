package com.moh.ProductBackend.Controller;

import com.moh.ProductBackend.Dto.AuthorDto;
import com.moh.ProductBackend.Entity.Author;
import com.moh.ProductBackend.Service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {


    private final AuthorService authorService;

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


    @PostMapping("/")
    public String createAuthor(@RequestBody AuthorDto author){
        return authorService.createAuthor(author).toString();
    }
}
