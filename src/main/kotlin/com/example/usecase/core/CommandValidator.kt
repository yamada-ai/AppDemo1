package com.example.usecase.core

import jakarta.validation.ConstraintViolation
import jakarta.validation.Validator
import org.springframework.stereotype.Component

@Component
class CommandValidator(private val validator: Validator) {

    fun <T> validate(command: T): Set<ConstraintViolation<T>> {
        return validator.validate(command)
    }
}