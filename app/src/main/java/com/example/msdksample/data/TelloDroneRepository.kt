package com.example.msdksample.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

/**
 * RoboMaster TT(Tello) 的簡易實作
 */
class TelloDroneRepository : DroneRepository {

    private val address = InetAddress.getByName("192.168.10.1")
    private val port = 8889
    private lateinit var socket: DatagramSocket

    override suspend fun initialize() = withContext(Dispatchers.IO) {
        socket = DatagramSocket()
        sendCommand("command") // 進入 SDK 控制模式
    }

    private suspend fun sendCommand(cmd: String) = withContext(Dispatchers.IO) {
        if (!this@TelloDroneRepository::socket.isInitialized) return@withContext
        val data = cmd.toByteArray()
        val packet = DatagramPacket(data, data.size, address, port)
        socket.send(packet)
    }

    override suspend fun sendTakeoffCommand() {
        sendCommand("takeoff")
    }

    override suspend fun sendLandCommand() {
        sendCommand("land")
    }

    private val moveDistance = 20 // 公分

    override suspend fun sendForwardCommand() {
        sendCommand("forward $moveDistance")
    }

    override suspend fun sendBackCommand() {
        sendCommand("back $moveDistance")
    }

    override suspend fun sendLeftCommand() {
        sendCommand("left $moveDistance")
    }

    override suspend fun sendRightCommand() {
        sendCommand("right $moveDistance")
    }

    override suspend fun startVideoStream() {
        sendCommand("streamon")
    }

    override suspend fun stopVideoStream() {
        sendCommand("streamoff")
    }

    override suspend fun cleanup() = withContext(Dispatchers.IO) {
        if (this@TelloDroneRepository::socket.isInitialized) {
            socket.close()
        }
    }
}
