package com.example.msdksample.utils

import android.content.Context
import android.widget.Toast

/**
 * 顯示 Toast 訊息的擴展函數
 *
 * @param message 要顯示的訊息
 * @param duration Toast 顯示時間長度，預設為 Toast.LENGTH_SHORT
 */
fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
} 