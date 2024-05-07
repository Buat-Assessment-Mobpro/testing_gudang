package org.d3if3009.testinggudang.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3009.testinggudang.database.GudangDao
import org.d3if3009.testinggudang.model.Gudang

class MainViewModel(dao: GudangDao) : ViewModel() {

    val data : StateFlow<List<Gudang>> = dao.getGudang().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

}