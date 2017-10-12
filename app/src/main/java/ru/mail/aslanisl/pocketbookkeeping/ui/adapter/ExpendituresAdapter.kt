package ru.mail.aslanisl.pocketbookkeeping.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_expenditures.*
import ru.mail.aslanisl.pocketbookkeeping.R
import ru.mail.aslanisl.pocketbookkeeping.db.Expenditure.ExpenditureEntity

class ExpendituresAdapter : RecyclerView.Adapter<ExpendituresAdapter.ViewHolder>() {
    private var expenditures: MutableList<ExpenditureEntity> = mutableListOf()

    fun addExpenditures(expenditures: List<ExpenditureEntity>){
        this.expenditures.clear()
        this.expenditures.addAll(expenditures)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_expenditures, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindExpenditure(expenditures[position])
    }

    override fun getItemCount(): Int {
        return expenditures.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val priceText: TextView = itemView.findViewById(R.id.item_expenditure_price)

        fun bindExpenditure(expenditureEntity: ExpenditureEntity){
            with(expenditureEntity){
                priceText.text = "${expenditureEntity.price}"
            }
        }
    }
}