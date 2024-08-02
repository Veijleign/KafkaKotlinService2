package com.test.kafkaoutboxpatternsecond.domain.repository

import com.test.kafkaoutboxpatternsecond.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
}