package com.moh.ProductBackend.Service;

import com.moh.ProductBackend.Dto.AuthorDto;
import com.moh.ProductBackend.Entity.Author;
import com.moh.ProductBackend.Exception.AuthorNotFoundException;
import com.moh.ProductBackend.Repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AuthorService {


    AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author createAuthor(AuthorDto authorDto){
        return authorRepository.save(Author.builder().firstName(authorDto.getFirstName()).lastName(authorDto.getLastName()).build());
    }

    public Author updateAuthor(AuthorDto authorDto){
        Author author = authorRepository.findById(authorDto.getId()).orElseThrow(() -> {throw new AuthorNotFoundException("author.not-found");});
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        return authorRepository.save(author);
    }
}
