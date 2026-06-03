package com.example.listapp_compose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.listapp_compose.model.Player
import com.example.listapp_compose.model.gswPlayers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber

class PlayerViewModel(private val namaTim: String) : ViewModel() {

    // Requirement StateFlow untuk mengelola data list item
    private val _playersState = MutableStateFlow<List<Player>>(emptyList())
    val playersState: StateFlow<List<Player>> = _playersState.asStateFlow()

    init {
        loadPlayers()
    }

    private fun loadPlayers() {
        // Mengisi data ke StateFlow
        _playersState.value = gswPlayers

        // Requirement Log saat data item masuk ke dalam list
        Timber.d("Log: Data pemain untuk tim $namaTim berhasil dimuat ke StateFlow.")
    }

    fun getPlayerById(id: Int?): Player? {
        val player = gswPlayers.find { it.id == id }
        if (player != null) {
            // Requirement Log data dari list yang dipilih
            Timber.d("Log: Berpindah ke Detail -> Nama: ${player.name}")
        }
        return player
    }
}