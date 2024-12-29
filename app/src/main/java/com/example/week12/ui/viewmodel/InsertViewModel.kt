package com.example.week12.ui.viewmodel

data class InserUiState(
    val inserUiState: InserUiState = InsertUiEvent()
)

data class InsertUiEvent(
    val nim:String = "",
    val nama:String = "",
    val alamat:String = "",
    val jenisKelamin:String = "",
    val kelas:String = "",
    val angkatan:String = "",
)