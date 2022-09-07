package com.myspringecommerceapp.modelDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    @NotBlank
    private String name;
//    @Nullable
    private List<SubcategoryDTO> subcategoriesDTO = new ArrayList<>();

}
