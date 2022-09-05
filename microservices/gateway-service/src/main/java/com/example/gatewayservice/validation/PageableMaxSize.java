package com.example.gatewayservice.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PageableValidator.class)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PageableMaxSize {
    String message() default "Invalid size of page.";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

    int maxPageSize() default 100;
}
