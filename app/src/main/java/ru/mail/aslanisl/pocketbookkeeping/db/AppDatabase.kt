package ru.mail.aslanisl.pocketbookkeeping.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ru.mail.aslanisl.pocketbookkeeping.db.dao.ExpenditureDao
import ru.mail.aslanisl.pocketbookkeeping.db.entity.ExpenditureEntity

@Database(entities = arrayOf(ExpenditureEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    val DATABASE_NAME: String = "BOOKKEEPING_DB"

    abstract fun expenditureDao(): ExpenditureDao
}