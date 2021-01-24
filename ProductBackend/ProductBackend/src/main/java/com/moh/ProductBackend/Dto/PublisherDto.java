package com.moh.ProductBackend.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class PublisherDto {
    private int id;
    private String publisherName;
}
