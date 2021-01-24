package com.moh.ProductBackend.Dto;


import com.moh.ProductBackend.Entity.Author;
import com.moh.ProductBackend.Entity.CoverType;
import com.moh.ProductBackend.Entity.Publisher;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
public class BookDto {

    @NotNull(message = "name must not be null")
    private String name;
    private int[] authorsIds;
    private int publisherId;
    private int publishingYear;
    private int amountOfPages;
    private BigDecimal price;
    private String coverType;


}
