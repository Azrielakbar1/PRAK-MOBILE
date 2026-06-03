package com.example.listapp_compose.view

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.listapp_compose.model.Player
import timber.log.Timber

@Composable
fun PlayerItem(
    player: Player,
    navController: NavController,
    modifier: Modifier = Modifier,
){
    val context = LocalContext.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape= RoundedCornerShape(12.dp), //requirement Rounded Corner di Modul
        elevation= CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = player.imageRes),
                contentDescription = player.name,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = player.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = player.jerseyNum,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp
                    )
                }

                Row(
                    modifier= Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = player.position,
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f),
                        maxLines = 2
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = {
                            Timber.d("Log: Tombol Intent (Instagram) ditekan")//Requirement soal logcat
                            val intent= Intent(Intent.ACTION_VIEW, Uri.parse(player.instagramUrl))
                            context.startActivity(intent)
                        },
                        modifier = Modifier.weight(1f).padding(end = 4.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {Text(text= player.btnExternal,
                        fontSize = 12.sp,
                        maxLines = 1
                    ) }

                    Button(
                        onClick = {
                            Timber.d("Log: Tombol Detail ditekan")//Requirement soal logcat
                            navController.navigate("detail_screen/${player.id}")
                        },
                        modifier = Modifier.weight(1f).padding(start = 4.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {Text(text= player.btnInternal,
                        fontSize = 12.sp,
                        maxLines = 1)}
                }
            }
        }
    }
}