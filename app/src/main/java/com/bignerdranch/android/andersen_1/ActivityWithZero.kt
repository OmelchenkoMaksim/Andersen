package com.bignerdranch.android.andersen_1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityWithZero : AppCompatActivity() {

    private var count: Int = 0
    private lateinit var showCount: TextView
    private lateinit var buttonZero: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_zero)
        Log.d("ActivityWithZero", "Hi DAD")
        val argument: Bundle? = getIntent().getExtras()
        if (argument != null) count = intent.getIntExtra("count", 0)
        showCount = findViewById(R.id.show_count)
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count")
        }
        showCount.setText(count.toString())
        buttonZero = findViewById(R.id.button_zero)
        if (count == 0) buttonZero.setBackgroundColor(Color.GRAY)
        if (count != 0) buttonZero.setBackgroundColor(Color.YELLOW)
    }

    fun showToastZero(view: View) {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count", count)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        count = savedInstanceState.getInt("count")
        super.onRestoreInstanceState(savedInstanceState)
    }

    fun countUpZero(view: View) {
        count++
        if (count != 0) buttonZero.setBackgroundColor(Color.YELLOW)
        Toast.makeText(this, R.string.toast_message_increase, Toast.LENGTH_SHORT).show()
        if (showCount != null) {
            showCount.setText(count.toString())
        }
    }

    fun countEqualsZero(view: View) {
        count = 0
        if (count == 0) view.setBackgroundColor(Color.GRAY)
        Toast.makeText(this, R.string.toast_message_to_zero, Toast.LENGTH_SHORT).show()
        if (showCount != null) {
            showCount.setText(count.toString())
        }
    }

    fun toMainActivity(view: View) {
        Toast.makeText(this, R.string.toast_message_change_activity, Toast.LENGTH_SHORT).show()
        val zeroAct: Intent = Intent(applicationContext, MainActivity::class.java)
        zeroAct.putExtra("count", count)
        startActivity(zeroAct)
    }


}
