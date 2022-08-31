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
    @NotBlank
    private String name;
    @NotBlank
    private CategoryDTO categoryDTO;

}
