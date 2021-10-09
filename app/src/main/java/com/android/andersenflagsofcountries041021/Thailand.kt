package com.android.andersenflagsofcountries041021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Thailand : AppCompatActivity() {

    private lateinit var buttonNextCountry: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thailand)
        buttonNextCountry = findViewById(R.id.button_to_next_country)
        buttonNextCountry.setOnClickListener(::toNextCountry)
    }
    private fun toNextCountry(view: View) {
        val intent = Intent(this, Denmark::class.java)
        startActivity(intent)
    }
}