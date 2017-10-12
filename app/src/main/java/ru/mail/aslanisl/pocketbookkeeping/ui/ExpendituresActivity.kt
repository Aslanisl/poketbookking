package ru.mail.aslanisl.pocketbookkeeping.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import ru.mail.aslanisl.pocketbookkeeping.App
import ru.mail.aslanisl.pocketbookkeeping.Injection
import ru.mail.aslanisl.pocketbookkeeping.R
import ru.mail.aslanisl.pocketbookkeeping.db.Expenditure.ExpenditureEntity
import ru.mail.aslanisl.pocketbookkeeping.ui.adapter.ExpendituresAdapter
import java.util.*

class ExpendituresActivity : BaseActivity() {

    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: ExpenditureViewModel
    private val disposable = CompositeDisposable()

    private lateinit var expendituresRecycler: RecyclerView
    private lateinit var expendituresAdapter: ExpendituresAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelFactory = Injection.provideViewModelFactory(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ExpenditureViewModel::class.java)

        expendituresRecycler = findViewById<RecyclerView>(R.id.expenditures_recycler)
        expendituresRecycler.layoutManager = LinearLayoutManager(this)

        expendituresAdapter = ExpendituresAdapter()
        expendituresRecycler.adapter = expendituresAdapter

        random_expenditure.setOnClickListener { addRandomExpenditure() }
    }

    override fun onStart() {
        super.onStart()

        disposable.add(viewModel.getExpenditures()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ expendituresAdapter.addExpenditures(it) },
                        {  error -> Log.e(TAG, "Unable to get expenditures", error)}))
    }

    override fun onStop() {
        super.onStop()

        // clear all the subscription
        disposable.clear()
    }

    private fun addRandomExpenditure(){
        var get = Random()
        val id : Long = get.nextLong()
        val expenditure = ExpenditureEntity(id, 2500, 2500)

        disposable.add(viewModel.insertExpenditure(expenditure)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, { error -> Log.e(TAG, "Unable to insert expenditure", error)}))
    }

    companion object {
        private val TAG = ExpendituresActivity::class.java.simpleName
    }
}
