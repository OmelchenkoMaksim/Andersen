package com.android.andersen_shopping_list

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var good0: TextView
    private lateinit var good1: TextView
    private lateinit var good2: TextView
    private lateinit var good3: TextView
    private lateinit var good4: TextView
    private lateinit var good5: TextView
    private lateinit var good6: TextView
    private lateinit var good7: TextView
    private lateinit var good8: TextView
    private lateinit var good9: TextView
    private lateinit var shopEditText: EditText

    private lateinit var buttonToGoods: Button
    private lateinit var buttonToShopLocation: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shopEditText = findViewById(R.id.edittext_shop)
        buttonToShopLocation = findViewById(R.id.button_search_shop)
        buttonToShopLocation.setOnClickListener(::openLocation)

        buttonToGoods = findViewById(R.id.button_to_goods)
        buttonToGoods.setOnClickListener(::toGoodsList)

        good0 = findViewById(R.id.good_0)
        good1 = findViewById(R.id.good_1)
        good2 = findViewById(R.id.good_2)
        good3 = findViewById(R.id.good_3)
        good4 = findViewById(R.id.good_4)
        good5 = findViewById(R.id.good_5)
        good6 = findViewById(R.id.good_6)
        good7 = findViewById(R.id.good_7)
        good8 = findViewById(R.id.good_8)
        good9 = findViewById(R.id.good_9)
    }

    override fun onStart() {
        super.onStart()
        for (i in 0..10) {
            when (i) {
                0 -> {
                    good0.text = GoodsStorage.results.get(i)
                    good0.visibility = View.VISIBLE
                }
                1 -> {
                    good1.text = GoodsStorage.results.get(i)
                    good1.visibility = View.VISIBLE
                }
                2 -> {
                    good2.text = GoodsStorage.results.get(i)
                    good2.visibility = View.VISIBLE
                }
                3 -> {
                    good3.text = GoodsStorage.results.get(i)
                    good3.visibility = View.VISIBLE
                }
                4 -> {
                    good4.text = GoodsStorage.results.get(i)
                    good4.visibility = View.VISIBLE
                }
                5 -> {
                    good5.text = GoodsStorage.results[i]
                    good5.visibility = View.VISIBLE
                }
                6 -> {
                    good6.text = GoodsStorage.results.get(i)
                    good6.visibility = View.VISIBLE
                }
                7 -> {
                    good7.text = GoodsStorage.results.get(i)
                    good7.visibility = View.VISIBLE
                }
                8 -> {
                    good8.text = GoodsStorage.results.get(i)
                    good8.visibility = View.VISIBLE
                }
                9 -> {
                    good9.text = GoodsStorage.results.get(i)
                    good9.visibility = View.VISIBLE
                }
            }
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun openLocation(view: View) {
        val loc = shopEditText.text.toString()
        val uri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        packageManager.let {
            if (intent.resolveActivity(it) != null) {
                try {
                    startActivity(intent)
                } catch (ex: ActivityNotFoundException) {
                    Log.d("ImplicitIntents", "Cant handle this intent")
                }
            }
        }
    }

    private fun toGoodsList(view: View) {
        val intentGoods = Intent(applicationContext, GoodsList::class.java)
        startActivity(intentGoods)
    }
}