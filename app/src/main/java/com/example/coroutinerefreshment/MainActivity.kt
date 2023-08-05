package com.example.coroutinerefreshment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var myTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTextView = findViewById<TextView?>(R.id.textId)

        GlobalScope.launch {
            val dataUser = getUserFromNetwork()
            val localUser = getUserFromDatabase()

            if (dataUser == localUser){
                Log.d("MainActivity", "Equal")
            }else{
                Log.d("MainActivity", "Not Equal: ")
            }
        }

    }

    private suspend fun getUserFromNetwork(): String {
        delay(2000)
        return "Mustafa"
    }

    private suspend fun getUserFromDatabase(): String{
        delay(2000)
        return "Hashi"
    }
}