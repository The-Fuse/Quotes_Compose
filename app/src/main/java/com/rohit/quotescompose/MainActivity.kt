package com.rohit.quotescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rohit.quotescompose.models.Qoutes
import com.rohit.quotescompose.screens.QouteDetails
import com.rohit.quotescompose.screens.QouteListItem
import com.rohit.quotescompose.screens.QouteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAsset(applicationContext)
        }

        setContent {
            app()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun app() {
    if (DataManager.isDataLoaded.value){

        if(DataManager.currentPage.value == Pages.LISTING){
            QouteListScreen(data = DataManager.data){
                DataManager.switchPages(it)
            }
        }else{
            DataManager.currentQoute?.let { QouteDetails(qoute = it) }
        }

    }
    else{
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ){
            Text(
                text = "Loading....",
                style = MaterialTheme.typography.headlineSmall
            )

        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}