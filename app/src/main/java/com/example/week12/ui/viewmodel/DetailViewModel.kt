package com.example.week12.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.week12.model.Mahasiswa
import com.example.week12.repository.MahasiswaRepository
import com.example.week12.ui.view.DestinasiDetail
import kotlinx.coroutines.launch
import java.io.IOException

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

    init {
        getMahasiswabynim()
    }

    fun getMahasiswabynim(){
        viewModelScope.launch {
            mhsUiState = DetailUiState.Loading
            mhsUiState = try {
                DetailUiState.Success(mhs.getMahasiswabynim(_nim))
            } catch (e: IOException){
                DetailUiState.Error
            } catch (e: HttpException){
                DetailUiState.Error
            }
        }
    }
}

fun Mahasiswa.toDetailUiEvent(): InsertUiEvent{
    return InsertUiEvent(
        nim = nim,
        nama = nama,
        alamat = alamat,
        jenisKelamin = jenisKelamin,
        kelas = kelas,
        angkatan = angkatan,
    )
}