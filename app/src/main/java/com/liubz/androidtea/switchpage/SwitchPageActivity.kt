package com.liubz.androidtea.switchpage

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.liubz.androidtea.R
import com.liubz.androidtea.databinding.ActivitySwitchPageBinding

class SwitchPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySwitchPageBinding
    private val viewModel: SwitchPageViewModel by viewModels()

    // 建议使用 findFragmentByTag 避免 Activity 重建后重复创建实例
    private var infraredFragment: InfraredFragment? = null
    private var deformationFragment: DeformationFragment? = null
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwitchPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 恢复或初始化 Fragment
        infraredFragment = supportFragmentManager.findFragmentByTag("INFRARED") as? InfraredFragment ?: InfraredFragment()
        deformationFragment = supportFragmentManager.findFragmentByTag("DEFORMATION") as? DeformationFragment ?: DeformationFragment()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, infraredFragment!!, "INFRARED")
                .commit()
            currentFragment = infraredFragment
        } else {
            // Activity 重建时恢复 currentFragment 引用
            currentFragment = supportFragmentManager.fragments.firstOrNull { !it.isHidden }
        }

        binding.btnInfrared.setOnClickListener {
            infraredFragment?.let { switchToFragment(it, "INFRARED") }
        }

        binding.btnDeformation.setOnClickListener {
            deformationFragment?.let { switchToFragment(it, "DEFORMATION") }
        }
        
        // Activity 启动时并行拉取所有设备的连接状态
        viewModel.fetchInfraredStatus()
        viewModel.fetchDeformationStatus()
    }

    private fun switchToFragment(fragment: Fragment, tag: String) {
        if (fragment == currentFragment) return

        val transaction = supportFragmentManager.beginTransaction()

        // 使用 hide/show 模式，确保 Fragment 实例不被销毁，从而保持连接状态
        currentFragment?.let { transaction.hide(it) }

        if (fragment.isAdded) {
            transaction.show(fragment)
        } else {
            transaction.add(R.id.fragment_container, fragment, tag)
        }

        transaction.commit()
        currentFragment = fragment
    }
}
