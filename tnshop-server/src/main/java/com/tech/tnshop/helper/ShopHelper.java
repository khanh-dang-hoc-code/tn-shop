package com.tech.tnshop.helper;

import com.tech.tnshop.exception.BadRequestException;
import com.tech.tnshop.exception.InternalServerException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public class ShopHelper {


    static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    // create a validator instance
    static Validator validator = validatorFactory.getValidator();

    public static LocalDate parseStringToLocalDate(String localDateString) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;

        return LocalDate.parse(localDateString, dateTimeFormatter);
    }

    public static <T> String validateObject(T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        StringBuilder message = new StringBuilder();
        if (!violations.isEmpty()) {
            // handle validation errors
            for (ConstraintViolation<T> violation : violations) {
                message.append(violation.getMessage());
            }
        }
        return message.toString();
    }

    public static <T> void validateObjectRequiredFields(T object)  {
        for (Field field : object.getClass().getDeclaredFields()) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            try {
                for (Annotation annotation : annotations) {
                    field.setAccessible(true);
                    if (annotation.annotationType() == NotNull.class) {
                        NotNull notNullAnnotation = (NotNull) annotation;
                        if (field.get(object) == null) {
                            throw new BadRequestException(notNullAnnotation.message());
                        }
                    }
                    if (annotation.annotationType() == Pattern.class) {
                        Pattern patternAnnotation = field.getDeclaredAnnotation(Pattern.class);
                        String fieldValue = field.get(object).toString();
                        if (fieldValue != null && !fieldValue.matches(patternAnnotation.regexp())) {
                            throw new BadRequestException(patternAnnotation.message());
                        }
                    }
                }
            } catch (IllegalAccessException exception) {
                throw new InternalServerException("Server Error");
            }
        }
    }

}
