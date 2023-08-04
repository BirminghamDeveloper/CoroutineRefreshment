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

//        Log.d("MainActivity", "i am in Main Thread: ")

        GlobalScope.launch {
            printMyTextAfterDelay("Hashi is Rich")
            printMyTextAfterDelay("and Handsome")
        }
        /*runBlocking {

                printMyTextAfterDelay("Love it")
        }*/
//        Log.d("MainActivity", "i am Back to the Main Thread: ")
    }

    suspend fun printMyTextAfterDelay(myText: String){
            delay(2000)
            Log.d("MainActivity", "$myText")
    }
}