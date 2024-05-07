package org.d3if3009.testinggudang.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3009.testinggudang.database.GudangDao
import org.d3if3009.testinggudang.model.Gudang

class DetailViewModel (private val dao: GudangDao): ViewModel() {

    fun insert(barang:String){
        val gudang = Gudang (
            barang = barang

        )
        viewModelScope.launch (Dispatchers.IO){
            dao.insert(gudang)
        }
    }

    suspend fun getGudang(id:Long): Gudang?{
        return dao.getGudangById(id)
    }

    fun  update(id: Long, barang: String){
        val gudang = Gudang(
            id = id,
            barang = barang
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.update(gudang)
        }

    }

    fun delete(id: Long){
        viewModelScope.launch(Dispatchers.IO){
            dao.deleteById(id)
        }
    }

}
