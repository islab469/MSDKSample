package com.example.msdksample.model

/**
 * 無人機狀態數據類別
 *
 * @property batteryLevel 電池電量百分比
 * @property isFlying 是否在飛行中
 * @property height 當前高度（公尺）
 * @property speed 當前速度（公尺/秒）
 * @property temperature 設備溫度（攝氏度）
 */
data class DroneState(
    val batteryLevel: Int = 0,
    val isFlying: Boolean = false,
    val height: Float = 0f,
    val speed: Float = 0f,
    val temperature: Float = 0f
) 