package com.test.kafkaoutboxpatternsecond.domain.mapper

import com.test.kafkaoutboxpatternsecond.domain.entity.User
import com.test.kafkaoutboxpatternsecond.payload.UserDTO
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun toDto(entity: User): UserDTO = UserDTO(
        entity.userId,
        entity.email,
        entity.firstName,
        entity.lastName
    )

    fun update(entity: User, dto: UserDTO): User {
        entity.email = dto.username
        entity.firstName = dto.firstName
        entity.lastName = dto.lastName
        return entity
    }
}