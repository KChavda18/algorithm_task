package com.dev.algorithmtask

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.dev.algorithmtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val rulesList: ArrayList<String> by lazy {
        ArrayList<String>().apply {
            add("None")
            add("Odd")
            add("Even")
            add("Prime")
            add("Fibonacci")
        }
    }
    private val numberList: List<Int> by lazy {
        (1..100).toList()
    }
    private val numberListAdapter: NumberListAdapter by lazy {
        NumberListAdapter(numberList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupRuleSpinner()
        setupGridList()
    }

    private fun setupRuleSpinner() {
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, rulesList)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.ruleSpinner.adapter = spinnerAdapter
        binding.ruleSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedRule = rulesList[position].lowercase()
                highlightedNumbers(selectedRule)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun highlightedNumbers(selectedRule: String) {
        val highlightedNumbers: Set<Int> = when (selectedRule) {
            "odd" -> findOddNumbers()
            "even" -> findEvenNumbers()
            "prime" -> findPrimeNumbers()
            "fibonacci" -> findFibonacciNumbers()
            else -> emptySet()
        }
        numberListAdapter.highlightedNumbers(highlightedNumbers)
    }

    private fun setupGridList() {
        binding.numberGrid.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 5)
            adapter = numberListAdapter
        }
    }
}