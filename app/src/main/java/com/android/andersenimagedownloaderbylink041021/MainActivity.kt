package com.android.andersenimagedownloaderbylink041021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var textField: EditText
    private lateinit var imageView: ImageView
    private lateinit var container: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textField = findViewById(R.id.editTextURL)
        textField.setOnClickListener(::onClick)
        container = findViewById(R.id.my_layout)
        container.setOnClickListener(::onClick)
        imageView = findViewById(R.id.imageViewFromInternet)
        imageView.setOnClickListener(::onClick)

        onClick(container)
    }

    private fun onClick(view: View) {
        Glide.with(this)
            .load(textField.text.toString())
            .placeholder(R.drawable.user_placeholder)
            .error(R.drawable.user_placeholder_error)
            .into(imageView)
    }
}