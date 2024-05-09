package org.d3if3009.testinggudang.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mahasiswa")
data class Mahasiswa(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val tanggal: String,
    val stok: String,
    val merek: String

)