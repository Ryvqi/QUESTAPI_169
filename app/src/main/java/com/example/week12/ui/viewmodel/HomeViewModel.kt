package com.example.week12.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.week12.model.Mahasiswa
import com.example.week12.repository.MahasiswaRepository

sealed class HomeUiState{
    data class Success(
        val mahasiwa: List<Mahasiswa>
    ): HomeUiState()
    object Error: HomeUiState()
    object Loading: HomeUiState()
}

class HomeViewModel (private val mhs: MahasiswaRepository): ViewModel(){
    var mhsUIState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set
}