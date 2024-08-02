package com.test.kafkaoutboxpatternsecond.service

import com.test.kafkaoutboxpatternsecond.domain.entity.User
import com.test.kafkaoutboxpatternsecond.domain.mapper.UserMapper
import com.test.kafkaoutboxpatternsecond.domain.repository.UserRepository
import com.test.kafkaoutboxpatternsecond.payload.CreateUserDTO
import com.test.kafkaoutboxpatternsecond.payload.UserDTO
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : IUserService {

    override fun getUserById(id: Long): UserDTO = userMapper.toDto(getEntity(id))

    override fun getAllUsers(): MutableList<UserDTO> =
        userRepository.findAll().map { userMapper.toDto(it) }.toMutableList()

    override fun createUser(dto: CreateUserDTO): UserDTO {

        val userAccount = User(
            null,
            dto.username,
            dto.firstName,
            dto.lastName
        )

        userAccount.password = dto.password

        return userMapper.toDto(userRepository.save(userAccount))
    }

    override fun getEntity(id: Long): User = userRepository.findById(id)
        .orElseThrow {
            EntityNotFoundException("Not found user with id: $id")
        }

    override fun update(id: Long, dto: UserDTO): UserDTO = userMapper.toDto(
        userRepository.save(
            userMapper.update(getEntity(id), dto)
        )
    )

    override fun delete(id: Long) = userRepository.delete(getEntity(id))

}