package ru.mail.aslanisl.pocketbookkeeping

import android.content.Context
import ru.mail.aslanisl.pocketbookkeeping.db.Expenditure.ExpenditureDao
import ru.mail.aslanisl.pocketbookkeeping.db.Expenditure.ExpendituresDatabase
import ru.mail.aslanisl.pocketbookkeeping.ui.ViewModelFactory

object Injection {

    fun provideExpendituresDataSource(context: Context) : ExpenditureDao {
        val database = ExpendituresDatabase.getInstance(context)
        return database.expenditureDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideExpendituresDataSource(context)
        return ViewModelFactory(dataSource)
    }
}