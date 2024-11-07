package com.example.usecase.user.register
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class CreateUserCommand(
    @field:NotBlank(message = "Name is required")
    val name: String,

    @field:Email(message = "Email should be valid")
    val email: String,

    @field:ValidAge  // カスタムバリデーションを適用
    val age: Int
)
