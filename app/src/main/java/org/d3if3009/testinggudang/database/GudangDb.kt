package org.d3if3009.testinggudang.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3009.testinggudang.model.Gudang

@Database(entities = [Gudang::class], version = 1, exportSchema = false)
abstract class GudangDb:RoomDatabase() {

    abstract val dao: GudangDao

    companion object{
        @Volatile
        private var INSTANCE: GudangDb? = null

        fun getInstance(context: Context): GudangDb {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GudangDb::class.java,
                        "gudang.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }

}
