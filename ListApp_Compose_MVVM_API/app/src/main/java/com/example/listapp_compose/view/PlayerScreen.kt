package com.example.listapp_compose.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.listapp_compose.viewmodel.PlayerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerScreen(navController: NavController, viewModel: PlayerViewModel){
    val listState = rememberLazyListState()

    // Requirement soal untuk Mengamati StateFlow dari ViewModel
    val players by viewModel.playersState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Golden State Warriors 2018") })
        }
    ) { paddingValues ->
        LazyColumn(
            state = listState,
            modifier = Modifier
              .fillMaxWidth()
              .padding(paddingValues)
        ) {
            item {
                Text(
                    text = "All Players",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp)
                )
                LazyRow(
                 contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(players){ player ->
                        PlayerItem(
                            player = player,
                            navController = navController,
                            modifier = Modifier.width(300.dp))
                    }
                }
            }

            item {
                Text(
                    text = "All Players",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }

            items(players){ player ->
                PlayerItem(
                    player = player,
                    navController = navController,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}