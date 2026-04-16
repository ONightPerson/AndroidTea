package com.liubz.androidtea.di.koin.repository

import com.liubz.androidtea.di.koin.bean.User

/**
 * Created by liubaozhu on 2026/4/16
 */
/**
 * Created by liubozhu on 2026/4/16
 */
class UserRepository: IUserRepository {

    private val userList = mutableListOf<User>()

    override fun findUserOrNull(name: String): User? {
        return userList.find { it.name == name }
    }

    override fun addUser(user: User) {
        userList.add(user)
    }

    override fun addUsers(users: List<User>) {
        userList.addAll(users)
    }
}