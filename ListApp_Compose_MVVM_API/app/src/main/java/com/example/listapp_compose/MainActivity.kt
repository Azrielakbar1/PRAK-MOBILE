package com.example.listapp_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.listapp_compose.ui.theme.ListApp_ComposeTheme
import com.example.listapp_compose.view.PlayerDetailScreen
import com.example.listapp_compose.view.PlayerScreen
import com.example.listapp_compose.viewmodel.PlayerViewModel
import com.example.listapp_compose.viewmodel.PlayerViewModelFactory
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi Timber hanya di mode Debug (Soal 1.d)
        if (Timber.treeCount == 0) {
            Timber.plant(Timber.DebugTree())
        }

        setContent {
            ListApp_ComposeTheme {
                val navController = rememberNavController()

                val viewModel: PlayerViewModel = viewModel(
                    factory = PlayerViewModelFactory("Golden State Warriors")
                )

                NavHost(
                    navController = navController,
                    startDestination = "list_screen"
                ){
                    composable(route="list_screen"){
                        PlayerScreen(navController = navController, viewModel = viewModel)
                    }

                    composable(
                        route="detail_screen/{playerId}",
                        arguments = listOf(navArgument("playerId"){type= NavType.IntType})
                    ){backStackEntry ->
                        val playerId = backStackEntry.arguments?.getInt("playerId")


                        val player = viewModel.getPlayerById(playerId) // Ambil data dari ViewModel!

                        if (player != null){
                            PlayerDetailScreen(player = player)
                        }

                    }
                }
            }
        }
    }
}


