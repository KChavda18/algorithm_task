package com.dev.algorithmtask

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.algorithmtask.databinding.GridItemBinding

class NumberListAdapter(private val numberList: List<Int>) :
    RecyclerView.Adapter<NumberListAdapter.NumberItemViewHolder>() {

    private var highlightedNumbers: Set<Int> = emptySet()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NumberListAdapter.NumberItemViewHolder {
        return NumberItemViewHolder(
            GridItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    override fun onBindViewHolder(holder: NumberListAdapter.NumberItemViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class NumberItemViewHolder(private val binding: GridItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.txtGridNumber.text = numberList[position].toString()

            if (highlightedNumbers.contains(numberList[position])) {
                binding.txtGridNumber.setTextColor(Color.RED)
            } else {
                binding.txtGridNumber.setTextColor(Color.LTGRAY)
            }
        }
    }

    fun highlightedNumbers(highlightedNumbers: Set<Int>) {
        this.highlightedNumbers = highlightedNumbers
        notifyItemRangeChanged(0, numberList.size)
    }
}