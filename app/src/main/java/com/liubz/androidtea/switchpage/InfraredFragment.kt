package com.liubz.androidtea.switchpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.liubz.androidtea.databinding.FragmentInfraredBinding
import com.liubz.androidtea.network.websocket.ConnectStatus

/**
 * 红外设备页面
 */
class InfraredFragment : Fragment() {

    private var _binding: FragmentInfraredBinding? = null
    private val binding get() = _binding!!
    
    // 使用 activityViewModels 确保与 Activity 共享同一个实例
    private val viewModel: SwitchPageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfraredBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // 观察连接状态并更新 UI。数据由 Activity 在启动时统一拉取。
        viewModel.infraredStatus.observe(viewLifecycleOwner) { status ->
            updateStatusUi(status)
        }
    }

    private fun updateStatusUi(status: ConnectStatus) {
        val statusText = when (status) {
            ConnectStatus.Connecting -> "连接中..."
            ConnectStatus.Open -> "已连接"
            ConnectStatus.Closing -> "关闭中..."
            ConnectStatus.Closed -> "已断开"
            ConnectStatus.Canceled -> "连接取消"
        }
        binding.tvContent.text = "红外设备状态: $statusText\n模拟数据：温度 25°C，湿度 60%。"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
