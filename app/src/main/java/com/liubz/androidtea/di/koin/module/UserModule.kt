package com.liubz.androidtea.di.koin.module

import com.liubz.androidtea.di.koin.repository.IUserRepository
import com.liubz.androidtea.di.koin.repository.UserRepository
import com.liubz.androidtea.di.koin.service.IUserService
import com.liubz.androidtea.di.koin.service.UserService
import com.liubz.androidtea.di.koin.viewmodel.UserViewModel
import org.koin.dsl.module
import org.koin.plugin.module.dsl.viewModel

/**
 * Created by liubaozhu on 2026/4/16
 */
val appModule = module {
    single<IUserRepository> { UserRepository() }
    single<IUserService> { UserService(get()) }
    viewModel<UserViewModel>()
}