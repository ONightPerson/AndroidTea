package com.liubz.androidtea.di.koin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liubz.androidtea.databinding.ActivityUserBinding
import com.liubz.androidtea.di.koin.viewmodel.UserViewModel
import org.koin.android.ext.android.inject

/**
 * Created by liubaozhu on 2026/4/16
 */
/**
 * Created by liubozhu on 2026/4/16
 */
class UserActivity : AppCompatActivity() {
    private val viewModel: UserViewModel by inject()

    private val binding by lazy { ActivityUserBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.sayHello.text = viewModel.sayHello("Alice")
    }
}