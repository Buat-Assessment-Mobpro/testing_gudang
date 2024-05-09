package org.d3if3009.testinggudang.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3009.testinggudang.database.MahasiswaDao
import org.d3if3009.testinggudang.model.Mahasiswa

class MainViewModel(dao: MahasiswaDao) : ViewModel() {

    val data : StateFlow<List<Mahasiswa>> = dao.getMahasiswa().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

}