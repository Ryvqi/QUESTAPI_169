package com.example.week12.ui.viewmodel

import com.example.week12.model.Mahasiswa

sealed class DetailUiState{
    data class Success(
        val mahasiwa: Mahasiswa
    ): HomeUiState()
    object Error: HomeUiState()
    object Loading: HomeUiState()
}