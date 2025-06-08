package com.example.msdksample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.msdksample.data.DroneRepository
import com.example.msdksample.model.DroneState
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * 主要視圖模型
 * 
 * 負責處理無人機相關的業務邏輯，包括：
 * - 無人機狀態管理
 * - 命令發送
 * - 錯誤處理
 */
class MainViewModel(
    private val droneRepository: DroneRepository
) : ViewModel() {

    private val _droneState = MutableLiveData<DroneState>()
    val droneState: LiveData<DroneState> = _droneState

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val _isConnected = MutableLiveData<Boolean>()
    val isConnected: LiveData<Boolean> = _isConnected

    init {
        initializeDrone()
    }

    /**
     * 初始化無人機連接
     */
    private fun initializeDrone() {
        viewModelScope.launch {
            try {
                droneRepository.initialize()
                _isConnected.value = true
            } catch (e: Exception) {
                _errorMessage.value = "無人機初始化失敗：${e.message}"
                _isConnected.value = false
            }
        }
    }

    /**
     * 發送起飛命令
     */
    fun sendTakeoffCommand() {
        viewModelScope.launch {
            try {
                droneRepository.sendTakeoffCommand()
            } catch (e: Exception) {
                _errorMessage.value = "起飛失敗：${e.message}"
            }
        }
    }

    /**
     * 發送降落命令
     */
    fun sendLandCommand() {
        viewModelScope.launch {
            try {
                droneRepository.sendLandCommand()
            } catch (e: Exception) {
                _errorMessage.value = "降落失敗：${e.message}"
            }
        }
    }

    /**
     * 發送前進命令
     */
    fun sendForwardCommand() {
        viewModelScope.launch {
            try {
                droneRepository.sendForwardCommand()
            } catch (e: Exception) {
                _errorMessage.value = "前進失敗：${e.message}"
            }
        }
    }

    /**
     * 發送後退命令
     */
    fun sendBackCommand() {
        viewModelScope.launch {
            try {
                droneRepository.sendBackCommand()
            } catch (e: Exception) {
                _errorMessage.value = "後退失敗：${e.message}"
            }
        }
    }

    /**
     * 發送左轉命令
     */
    fun sendLeftCommand() {
        viewModelScope.launch {
            try {
                droneRepository.sendLeftCommand()
            } catch (e: Exception) {
                _errorMessage.value = "左轉失敗：${e.message}"
            }
        }
    }

    /**
     * 發送右轉命令
     */
    fun sendRightCommand() {
        viewModelScope.launch {
            try {
                droneRepository.sendRightCommand()
            } catch (e: Exception) {
                _errorMessage.value = "右轉失敗：${e.message}"
            }
        }
    }

    /**
     * 開始視訊串流
     */
    fun startVideoStream() {
        viewModelScope.launch {
            try {
                droneRepository.startVideoStream()
            } catch (e: Exception) {
                _errorMessage.value = "視訊串流啟動失敗：${e.message}"
            }
        }
    }

    /**
     * 停止視訊串流
     */
    fun stopVideoStream() {
        viewModelScope.launch {
            try {
                droneRepository.stopVideoStream()
            } catch (e: Exception) {
                _errorMessage.value = "視訊串流停止失敗：${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.launch {
            droneRepository.cleanup()
        }
    }
} 