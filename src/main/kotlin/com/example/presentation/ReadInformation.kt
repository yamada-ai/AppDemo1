package com.example.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class ReadInformationController {

    @GetMapping("/info")
    fun getInfo(): ResponseEntity<String> {
        val data = "Hello, this is your information!"
        return ResponseEntity.ok(data)
    }
}