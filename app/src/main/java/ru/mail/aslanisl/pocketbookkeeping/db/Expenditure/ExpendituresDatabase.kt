package ru.mail.aslanisl.pocketbookkeeping.db.Expenditure

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(ExpenditureEntity::class), version = 1, exportSchema = false)
abstract class ExpendituresDatabase : RoomDatabase() {

    abstract fun expenditureDao(): ExpenditureDao

    companion object {
        val DATABASE_NAME: String = "BOOKKEEPING_DB"

        @Volatile private var INSTANCE: ExpendituresDatabase? = null

        fun getInstance(context: Context): ExpendituresDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        ExpendituresDatabase::class.java, DATABASE_NAME)
                        .build()
    }
}