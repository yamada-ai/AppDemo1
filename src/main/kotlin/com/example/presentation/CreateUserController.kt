package com.example.presentation

import com.example.presentation.model.CreateUserRequest
import com.example.usecase.user.register.CreateUserCommand
import com.example.usecase.user.register.CreateUserUsecase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CreateUserController(
    private val usecase : CreateUserUsecase
) {

    @PostMapping("/user")
    fun createUser(@RequestBody request: CreateUserRequest): ResponseEntity<CreateUserRequest> {
        // リクエストデータの処理を行う（例：データベースに保存するなど）
        val message = usecase.execute(toCommand(request))
        return ResponseEntity.status(HttpStatus.CREATED).body(request)
    }

    private fun toCommand(request: CreateUserRequest) = CreateUserCommand(
        name = request.name,
        email = request.email,
        age = request.age
    )

}