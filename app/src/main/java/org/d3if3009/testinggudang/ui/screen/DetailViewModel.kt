package org.d3if3009.testinggudang.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3009.testinggudang.database.MahasiswaDao
import org.d3if3009.testinggudang.model.Mahasiswa
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel (private val dao: MahasiswaDao): ViewModel() {
    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(nama:String, stok:String, merek: String){
        val mahasiswa = Mahasiswa (
            nama = nama,
            tanggal = formatter.format(Date()),
            stok = stok,
            merek = merek
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.insert(mahasiswa)
        }
    }

    suspend fun getMahasiswa(id:Long): Mahasiswa?{
        return dao.getMahasiswaById(id)
    }

    fun  update(id: Long, nama: String,stok: String,merek: String){
        val mahasiswa = Mahasiswa(
            id = id,
            nama = nama,
            tanggal = formatter.format(Date()),
            stok = stok,
            merek = merek
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