package com.myspringecommerceapp.services;

import com.myspringecommerceapp.exceptions.NotFoundException;
import com.myspringecommerceapp.model.Category;
import com.myspringecommerceapp.model.Subcategory;
import com.myspringecommerceapp.repositories.SubcategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryServiceImpl(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public Subcategory findById(Long l) {
        Optional<Subcategory> subcategoryOptional = subcategoryRepository.findById(l);
        if(subcategoryOptional.isEmpty()){
            throw new NotFoundException("Subcategory Not Found. For ID value: " + l );
        }

        return  subcategoryOptional.get();
    }
}
