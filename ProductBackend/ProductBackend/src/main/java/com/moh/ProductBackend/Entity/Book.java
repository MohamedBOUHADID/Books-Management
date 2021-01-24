package com.moh.ProductBackend.Entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name="book")
public class Book  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", columnDefinition = "varchar(45)")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
           )
    private Set<Author> authors;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "publishing_year" ,columnDefinition = "int")
    private int publishingYear;

    @Column(name = "amount_page", columnDefinition = "int")
    private int amountOfPages;

    @Column(name = "price", columnDefinition = "decimal(10,2)")
    private BigDecimal price;

    @Column(name = "cover_type", columnDefinition = "varchar(45)")
    private CoverType coverType;
}
