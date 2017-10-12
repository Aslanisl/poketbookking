package ru.mail.aslanisl.pocketbookkeeping.db.Expenditure

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import ru.mail.aslanisl.pocketbookkeeping.model.Expenditure
import java.util.*

@Entity(tableName = "expenditures")
data class ExpenditureEntity(
        @PrimaryKey()
        var id: Long? = null,
        @ColumnInfo(name = "price")
        var price: Int = 0,
        @ColumnInfo(name = "time")
        var time: Long = 0
)