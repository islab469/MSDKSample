package com.example.msdksample.ui.main

import android.os.Bundle
import android.view.SurfaceView
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.msdksample.R
import com.example.msdksample.databinding.ActivityMainBinding
import com.example.msdksample.utils.showToast

/**
 * 主要活動畫面
 * 
 * 此活動負責處理與無人機的主要互動，包括：
 * - 起飛/降落控制
 * - 方向控制（前、後、左、右）
 * - 視訊串流顯示
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeViews()
        observeViewModel()
    }

    /**
     * 初始化所有視圖元件
     * 設定按鈕點擊監聽器和初始狀態
     */
    private fun initializeViews() {
        with(binding) {
            btnTakeoff.setOnClickListener {
                viewModel.sendTakeoffCommand()
            }

            btnLand.setOnClickListener {
                viewModel.sendLandCommand()
            }

            btnForward.setOnClickListener {
                viewModel.sendForwardCommand()
            }

            btnBack.setOnClickListener {
                viewModel.sendBackCommand()
            }

            btnLeft.setOnClickListener {
                viewModel.sendLeftCommand()
            }

            btnRight.setOnClickListener {
                viewModel.sendRightCommand()
            }
        }
    }

    /**
     * 觀察 ViewModel 中的數據變化
     * 處理無人機狀態更新和錯誤訊息
     */
    private fun observeViewModel() {
        viewModel.droneState.observe(this) { state ->
            updateDroneStateUI(state)
        }

        viewModel.errorMessage.observe(this) { error ->
            error?.let { showToast(it) }
        }

        viewModel.isConnected.observe(this) { connected ->
            updateConnectionStatus(connected)
        }
    }

    /**
     * 更新無人機狀態相關的 UI 元件
     */
    private fun updateDroneStateUI(state: DroneState) {
        with(binding) {
            // TODO: 根據無人機狀態更新 UI
        }
    }

    /**
     * 更新連線狀態相關的 UI 元件
     */
    private fun updateConnectionStatus(isConnected: Boolean) {
        with(binding) {
            btnTakeoff.isEnabled = isConnected
            btnLand.isEnabled = isConnected
            btnForward.isEnabled = isConnected
            btnBack.isEnabled = isConnected
            btnLeft.isEnabled = isConnected
            btnRight.isEnabled = isConnected
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.startVideoStream()
    }

    override fun onPause() {
        super.onPause()
        viewModel.stopVideoStream()
    }
} 