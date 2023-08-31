package com.example.buryclick3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newInstance = BlankFragment.newInstance("1111", "2222")

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment,newInstance)
        transaction.commit()


        val b =  findViewById<Button>(R.id.btn)
        val bb =  findViewById<Button>(R.id.btnB)
        b.setOnClickListener {
            Log.d("MainActivity","click b")
            return@setOnClickListener
        }

        bb.setOnClickListener {
            Log.d("MainActivity","click bb")
        }
    }
}