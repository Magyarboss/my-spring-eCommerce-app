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
//    private CategoryDTO categoryDTO;        //zasto ne ide ovako?
    @NotBlank
    private String name;

}
