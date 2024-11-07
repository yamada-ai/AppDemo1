package com.example.usecase.user.register

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [AgeValidator::class])
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class ValidAge(
    val message: String = "Age must be at least 18",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)


class AgeValidator : ConstraintValidator<ValidAge, Int> {
    override fun isValid(value: Int?, context: ConstraintValidatorContext): Boolean {
        // 年齢がnullでなく、かつ18歳以上であればtrue
        return value != null && value >= 18
    }
}