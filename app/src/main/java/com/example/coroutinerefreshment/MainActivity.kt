package com.example.coroutinerefreshment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    // Jobs & Structured Concurrency Example
    lateinit var myTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTextView = findViewById<TextView?>(R.id.textId)

        // when assign job to launch it wont affected as launch will return Job type anyway
        val job: Job = GlobalScope.launch {
            launch { getUserFromNetwork() }
            launch { getUserFromDatabase() }
        }
    }

    private suspend fun getUserFromNetwork(): String {
        delay(2000)
        return "Mustafa"
    }

    private suspend fun getUserFromDatabase(): String {
        delay(3000)
        return "Mustafa"
    }
}