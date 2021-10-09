package com.android.andersen_shopping_list

object GoodsStorage {
    var results = HashMap<Int, String>()
    fun addGoodWithIndex(index: Int, value: String) {
        results[index] = value
    }
}