package com.project.applicationb

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class SecureEncryptionService : Service() {
    companion object {
        const val TAG = "Server"
    }

    private val mBinder = object : IEncryptionService.Stub() {
        override fun sendOneWayMessage(message: String?) {
            Log.d(TAG, "OneWay Message Received: $message")
        }

        override fun twoWayMessaging(message: String?): String {
            Log.d(TAG, "TwoWay Message Received: $message")
            return "Response from Server from pid: ${android.os.Process.myPid()}"
        }

    }

    override fun onCreate() {
        Log.d(
            TAG, "Service Created"
        )
        super.onCreate()
    }

    override fun onDestroy() {
        Log.d(
            TAG, "Service Destroyed"
        )
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d(
            TAG,
            "Binding service in thread id: ${Thread.currentThread().id} and name: ${Thread.currentThread().name} pid: ${android.os.Process.myPid()}"
        )
        return mBinder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
}
