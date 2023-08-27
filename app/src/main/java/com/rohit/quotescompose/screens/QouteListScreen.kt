package com.rohit.quotescompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rohit.quotescompose.R
import com.rohit.quotescompose.models.Qoutes

@Composable
fun QouteListScreen(data: Array<Qoutes>, onClick: (qoute: Qoutes)-> Unit) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            modifier = Modifier.padding(8.dp,24.dp)
                .fillMaxWidth(1f)
        )
        QouteList(data,onClick)
    }
}