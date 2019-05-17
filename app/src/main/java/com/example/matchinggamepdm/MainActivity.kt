package com.example.matchinggamepdm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btPlay: Button
    lateinit var btListTeachers: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btPlay = findViewById(R.id.btPlay)
        this.btListTeachers = findViewById(R.id.btListTeachers)

        btPlay.setOnClickListener({play(it)})
        btListTeachers.setOnClickListener({list(it)})

    }

    fun play(view: View){
        var intent = Intent(this, GameActivity::class.java)
        startActivityForResult(intent,1)
    }

    fun list(view: View){
        var intent = Intent(this, ListTeachers::class.java)
        startActivityForResult(intent,1)
    }

}