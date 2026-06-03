package com.example.listapp_compose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.listapp_compose.model.Player

@Composable
fun PlayerDetailScreen(player: Player){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())//agar halaman bisa di-scroll jika teks panjang
    ){
        Image(
            painter = painterResource(id = player.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        Column(modifier= Modifier.padding(16.dp)) {
            Row(
                modifier= Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text= player.name, style = MaterialTheme.typography.headlineMedium)
                Text(text = player.jerseyNum, style = MaterialTheme.typography.headlineSmall)
            }

            Spacer(modifier= Modifier.height(8.dp))

            Text(text= "About Player:", fontWeight = FontWeight.Bold)
            Text(
                text = player.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}