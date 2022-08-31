package com.myspringecommerceapp.modelDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    @NotBlank
    private String name;
    private String description;
    @NotNull
    private int quantityInStock;
    @NotNull
    private Double price;
    private Byte[] image;
    private CategoryDTO categoryDTO;
    private SubcategoryDTO subcategoryDTO;

}
