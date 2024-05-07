package org.d3if3009.testinggudang.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gudang")
data class Gudang(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val barang: String

)
