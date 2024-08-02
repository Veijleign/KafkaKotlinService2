package com.test.kafkaoutboxpatternsecond.service

import com.test.kafkaoutboxpatternsecond.domain.entity.User
import com.test.kafkaoutboxpatternsecond.payload.CreateUserDTO
import com.test.kafkaoutboxpatternsecond.payload.UserDTO

interface IUserService {
    fun getUserById(id: Long): UserDTO
    fun getAllUsers(): MutableList<UserDTO>
    fun createUser(dto: CreateUserDTO): UserDTO
    fun getEntity(id: Long): User
    fun update(id: Long, dto: UserDTO): UserDTO
    fun delete(id: Long)
}