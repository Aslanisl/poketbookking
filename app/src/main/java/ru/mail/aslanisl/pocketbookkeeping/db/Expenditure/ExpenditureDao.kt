package ru.mail.aslanisl.pocketbookkeeping.db.Expenditure

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import io.reactivex.Flowable
import ru.mail.aslanisl.pocketbookkeeping.db.Expenditure.ExpenditureEntity

@Dao
interface ExpenditureDao {
    @Query("SELECT * FROM expenditures")
    fun loadExpenditures(): Flowable<List<ExpenditureEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExpenditure(expenditure: ExpenditureEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExpenditures(expenditures: List<ExpenditureEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateExpenditures(expenditures: List<ExpenditureEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateExpenditure(expenditure: ExpenditureEntity)

    @Query("select * from expenditures where id = :arg0")
    fun loadExpenditure(id: String) : Flowable<ExpenditureEntity>

    @Delete
    fun deleteExpenditure(expenditure: ExpenditureEntity)
}