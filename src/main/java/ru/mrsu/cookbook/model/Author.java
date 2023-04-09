package ru.mrsu.cookbook.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUTHOR_TAB", schema = "COOKBOOK")
public class Author {

    @Id
    String id;
    String name;
    String surname;
}