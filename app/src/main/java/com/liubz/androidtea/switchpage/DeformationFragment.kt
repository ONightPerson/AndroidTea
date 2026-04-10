package com.liubz.androidtea.switchpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.liubz.androidtea.databinding.FragmentDeformationBinding
import com.liubz.androidtea.network.websocket.ConnectStatus

class DeformationFragment : Fragment() {

    private var _binding: FragmentDeformationBinding? = null
    private val binding get() = _binding!!
    
    // 与 Activity 共享同一个 ViewModel 实例
    private val viewModel: SwitchPageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // 观察连接状态。数据由 Activity 在进入页面时统一并行拉取。
        viewModel.deformationStatus.observe(viewLifecycleOwner) { status ->
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
        binding.tvContent.text = "建筑物形变设备状态: $statusText\n模拟数据：变形量 0.5mm，稳定性 良好。"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
