package com.project.applicationb

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import com.project.applicationb.util.CryptoHelper.decrypt


class SecureEncryptionService : Service() {
    companion object {
        const val TAG = "Server"
    }

    private val mBinder = object : IEncryptionService.Stub() {

        override fun sendOneWayMessage(message: String?) {
            Log.d(
                TAG,
                "OneWay Message Received: $message."
            )
            try {
                val decryptedMessage = message?.decrypt()
                Log.d(TAG, "decrypted Message Received 1: $decryptedMessage")
            }catch (
                e: Exception
            ) {
                Log.d(TAG, "decrypted Message Received 1: ${e.printStackTrace()}")
            }


            /*if(message.isNullOrBlank().not()){
                Log.d(TAG, "decrypted Message Received 2: $decryptedMessage")

            }*/
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

    override fun unbindService(conn: ServiceConnection) {
        super.unbindService(conn)
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d(
            TAG,
            "Binding service intent $intent in thread id: ${Thread.currentThread().id} and name: ${Thread.currentThread().name} pid: ${android.os.Process.myPid()}"
        )
        return mBinder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
}
