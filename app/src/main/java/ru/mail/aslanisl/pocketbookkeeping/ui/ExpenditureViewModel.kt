package ru.mail.aslanisl.pocketbookkeeping.ui

import android.arch.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.functions.Action
import io.reactivex.internal.operators.completable.CompletableFromAction
import ru.mail.aslanisl.pocketbookkeeping.db.Expenditure.ExpenditureDao
import ru.mail.aslanisl.pocketbookkeeping.db.Expenditure.ExpenditureEntity

class ExpenditureViewModel (private val dataSource: ExpenditureDao) : ViewModel() {

    fun insertExpenditure(expenditureEntity: ExpenditureEntity) : Completable{
        return CompletableFromAction(Action {
            dataSource.insertExpenditure(expenditureEntity)
        })
    }

    fun updateExpenditure(expenditureEntity: ExpenditureEntity) : Completable{
        return CompletableFromAction(Action {
            dataSource.updateExpenditure(expenditureEntity)
        })
    }

    fun deleteExpenditure(expenditureEntity: ExpenditureEntity) : Completable{
        return CompletableFromAction(Action {
            dataSource.deleteExpenditure(expenditureEntity)
        })
    }

    fun getExpenditures() : Flowable<List<ExpenditureEntity>> {
        return dataSource.loadExpenditures()
    }
}