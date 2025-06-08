package com.example.msdksample.data

/**
 * 無人機操作儲存庫介面
 * 
 * 定義所有與無人機互動的操作方法
 */
interface DroneRepository {
    /**
     * 初始化無人機連接
     */
    suspend fun initialize()

    /**
     * 發送起飛命令
     */
    suspend fun sendTakeoffCommand()

    /**
     * 發送降落命令
     */
    suspend fun sendLandCommand()

    /**
     * 發送前進命令
     */
    suspend fun sendForwardCommand()

    /**
     * 發送後退命令
     */
    suspend fun sendBackCommand()

    /**
     * 發送左轉命令
     */
    suspend fun sendLeftCommand()

    /**
     * 發送右轉命令
     */
    suspend fun sendRightCommand()

    /**
     * 開始視訊串流
     */
    suspend fun startVideoStream()

    /**
     * 停止視訊串流
     */
    suspend fun stopVideoStream()

    /**
     * 清理資源
     */
    suspend fun cleanup()
} 