package com.liubz.androidtea.di.koin.service

import com.liubz.androidtea.di.koin.bean.User
import com.liubz.androidtea.di.koin.repository.IUserRepository

/**
 * Created by liubaozhu on 2026/4/16
 */
/**
 * Created by liubozhu on 2026/4/16
 */
class UserService(private val userRepository: IUserRepository) : IUserService {
    override fun getUser(name: String): User? {
        return userRepository.findUserOrNull(name)
    }

    override fun loadUsers() {
        userRepository.addUsers(
            listOf(
                User("Alice", 18),
                User("Bob", 23),
                User("Charlie", 12)
            )
        )
    }

    override fun prepareHelloMsg(user: User?): String {
        return user?.let { "Hello, ${it.name}" } ?: "Hello, guest"
    }
}