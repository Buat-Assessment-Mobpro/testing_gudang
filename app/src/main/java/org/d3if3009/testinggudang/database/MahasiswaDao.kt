package org.d3if3009.testinggudang.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3009.testinggudang.model.Mahasiswa

@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insert(mahasiswa: Mahasiswa)

    @Update
    suspend fun update(mahasiswa: Mahasiswa)

//    @Query("SELECT * FROM mahasiswa ORDER By kelas,stok ASC")
    @Query("SELECT * FROM mahasiswa")
    fun getMahasiswa(): Flow<List<Mahasiswa>>

    @Query("SELECT * FROM mahasiswa WHERE id = :id")
    suspend fun getMahasiswaById(id: Long):Mahasiswa?

    @Query("DELETE FROM mahasiswa WHERE id = :id")
    suspend fun deleteById(id:Long)




}