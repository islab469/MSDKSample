package com.example.msdksample

import android.os.Bundle
import android.view.SurfaceView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var surfaceView: SurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        surfaceView = findViewById(R.id.video_view)

        findViewById<Button>(R.id.btn_takeoff).setOnClickListener {
            // TODO: 發送起飛命令
        }

        findViewById<Button>(R.id.btn_land).setOnClickListener {
            // TODO: 發送降落命令
        }

        findViewById<Button>(R.id.btn_forward).setOnClickListener {
            // TODO: 發送前進命令
        }

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            // TODO: 發送後退命令
        }

        findViewById<Button>(R.id.btn_left).setOnClickListener {
            // TODO: 發送左轉命令
        }

        findViewById<Button>(R.id.btn_right).setOnClickListener {
            // TODO: 發送右轉命令
        }

        // TODO: 初始化 Tello 視訊串流並綁定 surfaceView
    }
}
