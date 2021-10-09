package com.android.andersen_shopping_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.RuntimeException

class GoodsList : AppCompatActivity() {

    private lateinit var buttonToMain: Button
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private val clickListener: View.OnClickListener = View.OnClickListener {
        val view = it as Button
        val index = when (view.id) {
            R.id.good_0 -> 0
            R.id.good_1 -> 1
            R.id.good_2 -> 2
            R.id.good_3 -> 3
            R.id.good_4 -> 4
            R.id.good_5 -> 5
            R.id.good_6 -> 6
            R.id.good_7 -> 7
            R.id.good_8 -> 8
            R.id.good_9 -> 9
            else -> {
                throw RuntimeException("Unexpected view id.")
            }
        }

        GoodsStorage.addGoodWithIndex(index, view.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods_list)

        buttonToMain = findViewById(R.id.button_to_main)
        buttonToMain.setOnClickListener(::onReturnButtonClicked)

        button0 = findViewById(R.id.good_0)
        button0.setOnClickListener(clickListener)

        button1 = findViewById(R.id.good_1)
        button1.setOnClickListener(clickListener)

        button2 = findViewById(R.id.good_2)
        button2.setOnClickListener(clickListener)

        button3 = findViewById(R.id.good_3)
        button3.setOnClickListener(clickListener)

        button4 = findViewById(R.id.good_4)
        button4.setOnClickListener(clickListener)

        button5 = findViewById(R.id.good_5)
        button5.setOnClickListener(clickListener)

        button6 = findViewById(R.id.good_6)
        button6.setOnClickListener(clickListener)

        button7 = findViewById(R.id.good_7)
        button7.setOnClickListener(clickListener)

        button8 = findViewById(R.id.good_8)
        button8.setOnClickListener(clickListener)

        button9 = findViewById(R.id.good_9)
        button9.setOnClickListener(clickListener)
    }



    private fun onReturnButtonClicked(view: View) {
        finish()
    }
}