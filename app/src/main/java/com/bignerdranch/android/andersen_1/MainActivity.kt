package com.bignerdranch.android.andersen_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE_MAIN: String =
    "com.big_nerd_ranch.android.andersen_1.main_activity.extra.MESSAGE"
open class MainActivity : AppCompatActivity() {

    private var mCount: Int = 0
    private var keyCount: String = "countState"
    private var tagMainActivity: String = MainActivity::javaClass.name
    private lateinit var mShowCount: TextView
    private lateinit var buttonShowToast: Button
    private lateinit var buttonCount: Button
    private lateinit var buttonToZeroActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tagMainActivity, getString(R.string.funny_log_mom))

        buttonShowToast = findViewById(R.id.button_toast)
        buttonShowToast.setOnClickListener(::showToast)

        buttonCount = findViewById(R.id.button_count)
        buttonCount.setOnClickListener(::countUp)

        buttonToZeroActivity = findViewById(R.id.button_to_two_activity)
        buttonToZeroActivity.setOnClickListener(::toZeroActivity)

        val argument: Bundle? = intent.extras
        if (argument != null) mCount = intent.getIntExtra(EXTRA_MESSAGE_MAIN, 0)
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(keyCount)
        }
        mShowCount = findViewById(R.id.show_count)
        mShowCount.text = mCount.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(keyCount, mCount)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        mCount = savedInstanceState.getInt(keyCount)
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun showToast(view: View) {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun countUp(view: View) {
        mCount++
        Toast.makeText(this, R.string.toast_message_increase, Toast.LENGTH_SHORT).show()
        mShowCount.text = mCount.toString()
    }

    private fun toZeroActivity(view: View) {
        Toast.makeText(this, R.string.toast_message_change_activity, Toast.LENGTH_SHORT).show()
        val zeroAct = Intent(applicationContext, ActivityWithZero::class.java)
        zeroAct.putExtra(EXTRA_MESSAGE_MAIN, mCount)
        startActivity(zeroAct)
    }
}