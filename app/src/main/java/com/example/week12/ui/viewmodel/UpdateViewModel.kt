package com.example.week12.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week12.model.Mahasiswa
import com.example.week12.repository.MahasiswaRepository
import com.example.week12.ui.view.DestinasiUpdate
import kotlinx.coroutines.launch

class UpdateViewModel (
    savedStateHandle: SavedStateHandle,
    private val mhs: MahasiswaRepository
): ViewModel(){
    var uiState by mutableStateOf(InserUiState())
        private set

    private val _nim: String = checkNotNull(savedStateHandle[DestinasiUpdate.NIM])

    init {
        viewModelScope.launch {
            val mahasiswa = mhs.getMahasiswabynim(_nim)
            uiState = mahasiswa.toInserUiEvent()
        }
    }

    fun updateMahasiswa(){
        viewModelScope.launch {
            try {
                val mahasiswa = uiState.inserUiEvent.toMhs()
                mhs.updateMahasiswa(_nim, mahasiswa)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun updateState(insertUiEvent: InsertUiEvent){
        uiState = uiState.copy(inserUiEvent = insertUiEvent)
    }
}

fun Mahasiswa.toInserUiEvent(): InserUiState = InserUiState(
    inserUiEvent = this.toDetailUiEvent()
)