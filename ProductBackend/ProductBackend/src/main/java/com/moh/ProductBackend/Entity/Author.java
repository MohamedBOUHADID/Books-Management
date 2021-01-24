package com.moh.ProductBackend.Entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name",columnDefinition = "varchar(10)")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "varchar(10)")
    private String lastName;



}
