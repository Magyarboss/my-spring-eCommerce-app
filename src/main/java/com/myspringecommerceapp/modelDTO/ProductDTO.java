package com.myspringecommerceapp.modelDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ProductDTO {

    private Long id;
    @NotBlank
    private String name;
    private String description;
    @NotNull
    private int quantityInStock;
    @NotNull
    private Double price;
//    private Byte[] image; TODO put it back to byte[]
    private String image;
    private Long categoryId;
    private Long subcategoryId;

}
