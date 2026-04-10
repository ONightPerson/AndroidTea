package com.liubz.androidtea.viewpager

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.liubz.androidtea.R
import com.liubz.androidtea.network.websocket.ConnectStatus

/**
 * ViewPager-local infrared fragment. Uses viewpager-scoped ViewModel (ViewPagerViewModel)
 * so it is fully decoupled from the switchpage package and its layouts.
 */
class InfraredFragment : Fragment(R.layout.vp_fragment_infrared) {

    companion object {
        private const val TAG = "InfraredFragment"
    }

    private val viewModel: ViewPagerViewModel by activityViewModels()
    private lateinit var statusText: TextView
    private lateinit var fetchButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusText = view.findViewById(R.id.vp_infrared_status_text)
        fetchButton = view.findViewById(R.id.vp_infrared_fetch_button)

        // Observe the infrared status from the viewpager-scoped ViewModel
        viewModel.infraredStatus.observe(viewLifecycleOwner) { status ->
            Log.i(TAG, "onViewCreated: infrared status updated: $status")
            statusText.text = when (status) {
                ConnectStatus.Connecting -> "红外设备：连接中..."
                ConnectStatus.Open -> "红外设备：已连接 (模拟画面)"
                ConnectStatus.Closing -> "红外设备：关闭中..."
                ConnectStatus.Closed -> "红外设备：已断开"
                ConnectStatus.Canceled -> "红外设备：已取消"
            }
            fetchButton.isEnabled = status != ConnectStatus.Connecting
        }

        fetchButton.setOnClickListener {
            viewModel.fetchInfraredStatus()
        }
    }
}

