package ru.mail.aslanisl.pocketbookkeeping.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import ru.mail.aslanisl.pocketbookkeeping.db.entity.ExpenditureEntity
import ru.mail.aslanisl.pocketbookkeeping.model.Expenditure

@Dao
interface ExpenditureDao {
    @Query("SELECT * FROM expenditures")
    fun loadExpenditures(): LiveData<List<ExpenditureEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExpendityre(expenditure: Expenditure)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExpenditures(expenditures: List<ExpenditureEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateExpenditures(expenditures: List<ExpenditureEntity>)

    @Query("select * from expenditures where id = :expenditureId")
    fun loadExpenditure(expenditureId: String) : LiveData<ExpenditureEntity>

    @Query("select * from expenditures where id = :expenditureId")
    fun loadExpenditureSync(expenditureId: String) : ExpenditureEntity

    @Delete
    fun deleteExpenditure(expenditure: Expenditure)
}