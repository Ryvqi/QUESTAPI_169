package com.example.week12.ui.viewmodel

import com.example.week12.model.Mahasiswa

sealed class HomeUiState{
    data class Success(
        val mahasiwa: List<Mahasiswa>
    ): HomeUiState()
    object Error: HomeUiState()
    object Loading: HomeUiState()
}