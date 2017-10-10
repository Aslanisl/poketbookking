package ru.mail.aslanisl.pocketbookkeeping.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import ru.mail.aslanisl.pocketbookkeeping.model.Expenditure
import java.util.*

@Entity(tableName = "expenditures")
data class ExpenditureEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        var price: Int,
        var time: Long
)