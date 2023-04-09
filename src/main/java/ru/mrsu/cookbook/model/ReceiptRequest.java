package ru.mrsu.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptRequest {
    private String name;
    private String shortDescription;
    private String photo;
    private String receipt;
    private Author author;
    private Double rating;
}
