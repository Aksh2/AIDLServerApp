package com.project.applicationb

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.project.applicationb.util.CryptoHelper


class SecureEncryptionService : Service() {
    private val binder = object : IEncryptionService.Stub() {
        override fun processEncrypted(requestData: String?): String? {
            Log.d("Server","Processing request data: $requestData")
            try {

                //val plainRequest = CryptoHelper.decrypt(requestData)
                //Log.d("Server", "Processed: $plainRequest")
                // Simulate processing
                //val response = "Processed: $plainRequest"
                //Log.d("Server", "Processed: $response")
                return requestData//CryptoHelper.encrypt(response)
            } catch (e: Exception) {
                Log.d("Server", "Error in encryption", e)
                return null
            }
        }

        override fun sendOneWay(requestData: ByteArray?) {
            try {
              //  val message = CryptoHelper.decrypt(requestData)
                //Log.d("Server", "Received: $message")
                Log.d("Server", "Received: $requestData")
                // Optional processing, no response
            } catch (e: Exception) {
                Log.d("Server", "One-way decrypt failed", e)
            }
        }

        override fun sendMessage(requestData: String?) {
            try {
                //  val message = CryptoHelper.decrypt(requestData)
                //Log.d("Server", "Received: $message")
                Log.d("Server", "send message Received: $requestData")
                // Optional processing, no response
            } catch (e: Exception) {
                Log.d("Server", "send message", e)
            }
        }
    }



    override fun onCreate() {
        Log.d(
            "Server",
            "Service Created"
        )
        super.onCreate()
    }

    override fun onDestroy() {
        Log.d(
            "Server",
            "Service Destroyed"
        )
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.d(
            "Server",
            "Binding service in thread id: ${Thread.currentThread().id} and name: ${Thread.currentThread().name} pid: ${android.os.Process.myPid()}"
        )
        return binder
    }
}
