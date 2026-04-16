package com.liubz.androidtea.di.koin.repository

import com.liubz.androidtea.di.koin.bean.User

/**
 * Created by liubozhu on 2026/4/16
 */
interface IUserRepository {
    fun findUserOrNull(name: String): User?

    fun addUser(user: User)

    fun addUsers(users: List<User>)
}