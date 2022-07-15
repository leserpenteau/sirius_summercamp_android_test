package com.sirius.test_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.databinding.ChipItemBinding

class ChipsAdapter(private val chipList: List<String>): RecyclerView.Adapter<ChipsAdapter.ChipHolder>() {

    class ChipHolder(val binding: ChipItemBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChipHolder {
        val binding = ChipItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChipHolder(binding)
    }

    override fun onBindViewHolder(holder: ChipHolder, position: Int) {
        with(holder) {
            with(chipList[position]) {
                binding.chip.text = this
            }
        }
    }

    override fun getItemCount(): Int = chipList.size
}