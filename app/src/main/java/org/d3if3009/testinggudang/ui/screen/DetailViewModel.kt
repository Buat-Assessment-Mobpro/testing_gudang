package org.d3if3009.testinggudang.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3009.testinggudang.database.MahasiswaDao
import org.d3if3009.testinggudang.model.Mahasiswa

class DetailViewModel (private val dao: MahasiswaDao): ViewModel() {

    fun insert(nama:String, stok:String, kelas: String){
        val mahasiswa = Mahasiswa (
            nama = nama,
            stok = stok,
            kelas = kelas
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.insert(mahasiswa)
        }
    }

    suspend fun getMahasiswa(id:Long): Mahasiswa?{
        return dao.getMahasiswaById(id)
    }

    fun  update(id: Long, nama: String,stok: String,kelas: String){
        val mahasiswa = Mahasiswa(
            id = id,
            nama = nama,
            stok = stok,
            kelas = kelas
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.update(mahasiswa)
        }

    }

    fun delete(id: Long){
        viewModelScope.launch(Dispatchers.IO){
            dao.deleteById(id)
        }
    }

}