package com.example.week12.repository

import com.example.week12.model.Mahasiswa
import com.example.week12.services.MahasiswaService

interface MahasiswaRepository{
    suspend fun getAllMahasiswa(): List<Mahasiswa>
    suspend fun getMahasiswabynim(nim: String): Mahasiswa
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(nim: String)
}

class NetworkMahasiswaRepository(
    private val mhsApiService: MahasiswaService
): MahasiswaRepository {
    override suspend fun getAllMahasiswa(): List<Mahasiswa> =
        mhsApiService.getAllMahasiswa()

    override suspend fun getMahasiswabynim(nim: String): Mahasiswa {
        return mhsApiService.getMahasiswabynim(nim)
    }

    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        mhsApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        mhsApiService.updateMahasiswa(nim, mahasiswa)
    }

    override suspend fun deleteMahasiswa(nim: String) {
        try {
            val response = mhsApiService.deleteMahasiswa(nim)
            if (!response.isSuccessful){
                throw Exception("Failed to delete mahasiswa. HTTP Status code: " + "${response.code()}")
            }
            else{
                response.message()
                println(response.message())
            }
        }
        catch (e: Exception){
            throw e
        }
    }
}