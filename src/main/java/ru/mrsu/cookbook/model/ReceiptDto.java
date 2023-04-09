package ru.mrsu.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDto {
    private String photo;
    private String name;
    private String shortDescription;
}
