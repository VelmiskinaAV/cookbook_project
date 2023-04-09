package ru.mrsu.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    private Long id;
    private String name;
    private String shortDescription;
    private String photo;
    private String receipt;
    private Double rating;
    private Boolean editable;
    private Author author;
}
