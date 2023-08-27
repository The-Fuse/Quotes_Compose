package com.rohit.quotescompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.rohit.quotescompose.models.Qoutes

object DataManager {

    var data = emptyArray<Qoutes>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQoute: Qoutes? = null
    fun loadAsset(context: Context) {
        val inputStream = context.assets.open("qoutes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson =Gson()
        data = gson.fromJson(json, Array<Qoutes>::class.java)
        isDataLoaded.value=true
    }

    fun switchPages(qoute: Qoutes) {
        if (currentPage.value == Pages.LISTING){
            currentQoute = qoute
            currentPage.value = Pages.DETAIL
        }else {
            currentPage.value = Pages.LISTING
        }
    }
}