package com.eram.ethcheckermvp.view

import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ThreadUtil {
    companion object{
        private val executor: ExecutorService = Executors.newSingleThreadExecutor()
        private val handler = android.os.Handler(Looper.getMainLooper())

        fun startThread(runnable: Runnable){
            executor.submit(runnable)
        }

        fun startUIThread(delay:Int, runnable: Runnable){
            handler.postDelayed(runnable, delay.toLong())
        }

        fun stopThread(){
            executor.shutdown()
        }
    }
}