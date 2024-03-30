package com.example.jdbc_template_with_h2db

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JdbcTemplateWithH2dbApplication

fun main(args: Array<String>) {
	runApplication<JdbcTemplateWithH2dbApplication>(*args)
}