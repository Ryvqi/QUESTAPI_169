package com.example.week12.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.week12.model.Mahasiswa
import com.example.week12.repository.MahasiswaRepository

sealed class DetailUiState{
    data class Success(
        val mahasiwa: Mahasiswa
    ): DetailUiState()
    object Error: DetailUiState()
    object Loading: DetailUiState()
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val mhs: MahasiswaRepository
): ViewModel(){
    var mhsUiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    private val _nim: String = checkNotNull(savedStateHandle[DestinasiDetail.NIM])
}