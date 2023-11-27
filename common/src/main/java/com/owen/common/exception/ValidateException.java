package com.owen.common.exception;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wenqiang
 * @date 2023/09/16 11:08
 **/
public class ValidateException extends RuntimeException {
    private static final long serialVersionUID = 8508877502270865898L;
    private final Set<ConstraintViolation<Object>> errors;

    public ValidateException(Set<ConstraintViolation<Object>> errors) {
        this.errors = errors;
    }

    public List<String> getMessages() {
        return (List)this.errors.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }
}