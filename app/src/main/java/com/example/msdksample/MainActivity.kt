package com.example.msdksample

import android.os.Bundle
import android.view.SurfaceView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.msdksample.data.TelloDroneRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val droneRepository = TelloDroneRepository()
    private lateinit var surfaceView: SurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        surfaceView = findViewById(R.id.video_view)

        lifecycleScope.launch {
            droneRepository.initialize()
        }

        findViewById<Button>(R.id.btn_takeoff).setOnClickListener {
            lifecycleScope.launch { droneRepository.sendTakeoffCommand() }
        }

        findViewById<Button>(R.id.btn_land).setOnClickListener {
            lifecycleScope.launch { droneRepository.sendLandCommand() }
        }

        findViewById<Button>(R.id.btn_forward).setOnClickListener {
            lifecycleScope.launch { droneRepository.sendForwardCommand() }
        }

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            lifecycleScope.launch { droneRepository.sendBackCommand() }
        }

        findViewById<Button>(R.id.btn_left).setOnClickListener {
            lifecycleScope.launch { droneRepository.sendLeftCommand() }
        }

        findViewById<Button>(R.id.btn_right).setOnClickListener {
            lifecycleScope.launch { droneRepository.sendRightCommand() }
        }
        // 可在此將視訊串流畫面呈現在 surfaceView，示例僅啟動串流
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch { droneRepository.startVideoStream() }
    }

    override fun onPause() {
        super.onPause()
        lifecycleScope.launch { droneRepository.stopVideoStream() }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleScope.launch { droneRepository.cleanup() }
    }
}
