package com.liubz.androidtea.viewpager

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.liubz.androidtea.R

/**
 * A simple activity that shows a banner-like control (two buttons) to switch between
 * two pages implemented as Fragments and keeps them alive while switching.
 */
class BannerPagerActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var infraButton: Button
    private lateinit var deformButton: Button
    private val viewModel: ViewPagerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner_pager)

        // shared ViewModel scoped to Activity so fragments can observe the same statuses

        viewPager = findViewById(R.id.banner_viewpager)
        infraButton = findViewById(R.id.btn_banner_infrared)
        deformButton = findViewById(R.id.btn_banner_deformation)

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 2
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> InfraredFragment()
                    else -> DeformationFragment()
                }
            }
        }

        // Keep both pages alive (so switching back preserves fragment instance/state)
        viewPager.offscreenPageLimit = 1

        infraButton.setOnClickListener {
            viewPager.currentItem = 0
            updateButtonState(0)
        }

        deformButton.setOnClickListener {
            viewPager.currentItem = 1
            updateButtonState(1)
        }

        // reflect user swipes by updating banner buttons
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateButtonState(position)
            }
        })

        // initialize button state
        updateButtonState(viewPager.currentItem)
        viewModel.fetchInfraredStatus()
        viewModel.fetchDeformationStatus()
    }

    private fun updateButtonState(selected: Int) {
        infraButton.isEnabled = selected != 0
        deformButton.isEnabled = selected != 1
    }
}

