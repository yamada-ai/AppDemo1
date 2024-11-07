package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppDemo1Application

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
	runApplication<AppDemo1Application>(*args)
}
