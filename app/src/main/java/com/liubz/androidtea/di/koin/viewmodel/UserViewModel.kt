package com.liubz.androidtea.di.koin.viewmodel

import androidx.lifecycle.ViewModel
import com.liubz.androidtea.di.koin.service.IUserService

/**
 * Created by liubaozhu on 2026/4/16
 */
/**
 * Created by liubozhu on 2026/4/16
 */
class UserViewModel(
    private val userService: IUserService
): ViewModel() {
    fun sayHello(name: String): String {
        val user = userService.getUser(name)
        val msg = userService.prepareHelloMsg(user)
        return "[UserViewModel] $msg"
    }
}