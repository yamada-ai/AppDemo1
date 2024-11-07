package com.example.usecase.user.register

import com.example.usecase.core.CommandValidator
import jakarta.validation.ConstraintViolationException
import org.springframework.stereotype.Service

@Service
class CreateUserUsecase(private val validator: CommandValidator) {

    fun execute(command: CreateUserCommand): String {
        val violations = validator.validate(command)
        if (violations.isNotEmpty()) {
            val errorMessages = violations.joinToString("; ") { it.message }
            throw ConstraintViolationException(errorMessages, violations)
        }

        // ユーザー作成ロジックを実行
        return "User ${command.name} with email ${command.email} and age ${command.age} created successfully!"
    }
}