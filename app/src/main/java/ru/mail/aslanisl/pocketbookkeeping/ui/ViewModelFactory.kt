package ru.mail.aslanisl.pocketbookkeeping.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import ru.mail.aslanisl.pocketbookkeeping.db.Expenditure.ExpenditureDao

class ViewModelFactory (private val dataSource: ExpenditureDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExpenditureViewModel::class.java)) {
            return ExpenditureViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}