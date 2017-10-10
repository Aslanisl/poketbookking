package ru.mail.aslanisl.pocketbookkeeping

import android.app.Application
import android.arch.persistence.room.Room
import ru.mail.aslanisl.pocketbookkeeping.db.AppDatabase

class App : Application(){

    companion object {
        var database: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        App.database = Room.databaseBuilder(this, AppDatabase::class.java, "bookkeeping-db").build()
    }
}