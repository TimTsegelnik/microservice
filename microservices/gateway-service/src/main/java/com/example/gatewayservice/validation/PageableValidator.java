package com.example.gatewayservice.validation;

import org.springframework.data.domain.Pageable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PageableValidator  implements ConstraintValidator<PageableMaxSize, Pageable> {

    private int maxPageSize;
    @Override
    public void initialize(PageableMaxSize constraintAnnotation) {
        maxPageSize = constraintAnnotation.maxPageSize();
    }

    @Override
    public boolean isValid(Pageable value, ConstraintValidatorContext context) {
        return value.getPageSize() <= maxPageSize;
    }
}
