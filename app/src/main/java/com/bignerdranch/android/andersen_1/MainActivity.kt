package com.bignerdranch.android.andersen_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class MainActivity : AppCompatActivity() {

    private var mCount: Int = 0
    private lateinit var mShowCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "Hi MOM")
        val argument: Bundle? = getIntent().getExtras()
        if (argument != null) mCount = intent.getIntExtra("count", 0)
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count")
        }
        mShowCount = findViewById(R.id.show_count)
        mShowCount.setText(mCount.toString())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count", mCount)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        mCount = savedInstanceState.getInt("count")
        super.onRestoreInstanceState(savedInstanceState)
    }

    // внутри метода показывающего всплывающее сообщение находится переменная Toast
    // хранящая параметр контекста, само сообщение и время его показа
    // а так же вызов ее метода show
    fun showToast(view: View) {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun countUp(view: View) {
        mCount++
        Toast.makeText(this, R.string.toast_message_increase, Toast.LENGTH_SHORT).show()
        mShowCount.setText(mCount.toString())
    }

    fun toZeroActivity(view: View) {
        Toast.makeText(this, R.string.toast_message_change_activity, Toast.LENGTH_SHORT).show()
        val zeroAct: Intent = Intent(applicationContext, ActivityWithZero::class.java)
        zeroAct.putExtra("count", mCount)
        startActivity(zeroAct)
    }


}