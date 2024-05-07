package org.d3if3009.testinggudang.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3009.testinggudang.model.Gudang


@Dao
interface GudangDao {
    @Insert
    suspend fun insert(gudang: Gudang)

    @Update
    suspend fun update(gudang: Gudang)

//    @Query("SELECT * FROM gudang ORDER By kelas,nim ASC")
    @Query("SELECT * FROM gudang ORDER By tanggal DESC")
    fun getGudang(): Flow<List<Gudang>>

    @Query("SELECT * FROM gudang WHERE id = :id")
    suspend fun getGudangById(id: Long):Gudang?

    @Query("DELETE FROM gudang WHERE id = :id")
    suspend fun deleteById(id:Long)




}
