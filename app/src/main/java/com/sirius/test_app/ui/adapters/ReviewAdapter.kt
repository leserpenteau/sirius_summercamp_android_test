package com.sirius.test_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.models.ReviewModel
import com.sirius.test_app.databinding.ReviewItemBinding
import com.squareup.picasso.Picasso

class ReviewAdapter(private val reviewList: List<ReviewModel>): RecyclerView.Adapter<ReviewAdapter.ReviewHolder>() {

    class ReviewHolder(val binding: ReviewItemBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewHolder {
        val binding = ReviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewHolder, position: Int) {
        with(holder) {
            with(reviewList[position]) {
                Picasso.get().load(this.userImage).into(binding.imgProfile)
                binding.txtUsername.text = this.userName
                binding.txtDate.text = this.date
                binding.txtReview.text = this.message
            }
        }
    }

    override fun getItemCount(): Int = reviewList.size
}