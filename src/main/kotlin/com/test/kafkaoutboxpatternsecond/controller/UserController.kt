package com.test.kafkaoutboxpatternsecond.controller

import com.test.kafkaoutboxpatternsecond.payload.UserDTO
import com.test.kafkaoutboxpatternsecond.service.IUserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "Contains actions over user accounts")
class UserController(
    private val userService: IUserService
) {
    @GetMapping()
    @Operation(description = "Return list of all users")
    fun getUsers(): ResponseEntity<List<UserDTO>> =
        ResponseEntity.ok()
            .body(userService.getAllUsers())

}