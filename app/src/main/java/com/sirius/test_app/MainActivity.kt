package com.sirius.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.databinding.ActivityMainBinding
import com.sirius.test_app.models.DataModel
import com.sirius.test_app.ui.adapters.ChipsAdapter
import com.sirius.test_app.ui.adapters.ReviewAdapter
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    val mBinding get() = _binding!!

    private lateinit var chipsRecyclerView: RecyclerView
    private lateinit var reviewRecyclerView: RecyclerView
    private lateinit var reviewAdapter: ReviewAdapter
    private lateinit var chipsAdapter: ChipsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val data = DataModel()

        chipsRecyclerView = mBinding.recyclerChips
        chipsAdapter = ChipsAdapter(data.tags)

        reviewRecyclerView = mBinding.recyclerReviews
        reviewAdapter = ReviewAdapter(data.reviews)

        init(data)

        chipsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        chipsRecyclerView.adapter = chipsAdapter

        reviewRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        reviewRecyclerView.adapter = reviewAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun init(dataModel: DataModel) {
        Picasso.get().load(dataModel.image).into(mBinding.imgBackground)
        Picasso.get().load(dataModel.logo).into(mBinding.imgLogo)
        mBinding.txtGameTitle.text = dataModel.name
        mBinding.ratingGame.rating = dataModel.rating
        mBinding.txtTotalMarks.text = dataModel.gradeCnt
        mBinding.txtGameDescription.text = dataModel.description
        mBinding.txtTotalRate.text = dataModel.rating.toString()
        mBinding.ratingGame2.rating = dataModel.rating
        mBinding.txtTotalMarks2.text = "${dataModel.gradeCnt} Reviews"
    }
}