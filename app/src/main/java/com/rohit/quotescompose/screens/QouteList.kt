package com.rohit.quotescompose.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.rohit.quotescompose.models.Qoutes


@Composable
fun QouteList(data: Array<Qoutes>, onClick: (qoute: Qoutes)-> Unit) {

    LazyColumn(content = {
        items(data) {
            QouteListItem(qoute = it,onClick)
        }
    })
}