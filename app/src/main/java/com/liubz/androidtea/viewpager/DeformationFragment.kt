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
 * ViewPager-local deformation fragment. Uses viewpager-scoped ViewModel (ViewPagerViewModel)
 * so it is fully decoupled from the switchpage package and its layouts.
 */
class DeformationFragment : Fragment(R.layout.vp_fragment_deformation) {

    companion object {
        private const val TAG = "DeformationFragment"
    }


    // Share the same ViewModel instance with the activity so both fragments observe the same state
    private val viewModel: ViewPagerViewModel by activityViewModels()
    private lateinit var statusText: TextView
    private lateinit var fetchButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusText = view.findViewById(R.id.vp_deformation_status_text)
        fetchButton = view.findViewById(R.id.vp_deformation_fetch_button)

        // Observe the deformation status from the viewpager-scoped ViewModel
        viewModel.deformationStatus.observe(viewLifecycleOwner) { status ->
            Log.i(TAG, "onViewCreated: deformation status updated: $status")
            statusText.text = when (status) {
                ConnectStatus.Connecting -> "形变设备：连接中..."
                ConnectStatus.Open -> "形变设备：已连接 (模拟数据)"
                ConnectStatus.Closing -> "形变设备：关闭中..."
                ConnectStatus.Closed -> "形变设备：已断开"
                ConnectStatus.Canceled -> "形变设备：已取消"
            }
            fetchButton.isEnabled = status != ConnectStatus.Connecting
        }

        fetchButton.setOnClickListener {
            viewModel.fetchDeformationStatus()
        }
    }
}

