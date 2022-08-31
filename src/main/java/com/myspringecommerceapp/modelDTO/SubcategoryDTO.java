package com.myspringecommerceapp.modelDTO;


import com.myspringecommerceapp.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Setter
@Getter
@NoArgsConstructor
public class SubcategoryDTO {

    private Long id;
    private Long categoryId;
    @NotBlank
    private String name;

}
