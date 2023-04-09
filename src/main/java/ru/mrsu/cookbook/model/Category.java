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
@Table(name = "CATEGORY_TAB", schema = "COOKBOOK")
@SequenceGenerator(name = "categoryGen", schema = "COOKBOOK", allocationSize = 1, sequenceName = "category_tab_id_seq")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryGen")
    Long id;
    String name;
}
