package com.liubz.androidtea.di.koin.service

import com.liubz.androidtea.di.koin.bean.User

/**
 * Created by liubozhu on 2026/4/16
 */
interface IUserService {
    fun getUser(name: String): User?

    fun loadUsers()

    fun prepareHelloMsg(user: User?): String
}