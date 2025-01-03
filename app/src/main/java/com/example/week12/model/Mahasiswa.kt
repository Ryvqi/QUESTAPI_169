package com.example.week12.model

import kotlinx.serialization.*

@Serializable
data class Mahasiswa(
    val nim: String,
    val nama: String,
    val alamat: String,

    @SerialName("jenis_kelamin")
    val jenisKelamin: String,

    val kelas: String,
    val angkatan: String
)