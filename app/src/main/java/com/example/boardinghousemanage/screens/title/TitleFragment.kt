package com.example.boardinghousemanage.screens.title

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.boardinghousemanage.R
import com.example.boardinghousemanage.databinding.TitleFragmentBinding


class TitleFragment : Fragment() {

    private lateinit var viewModel: TitleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: TitleFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.title_fragment, container, false
        )

        viewModel = ViewModelProviders.of(this).get(TitleViewModel::class.java)

        //Kiểm tra nút nào được check và xử lý
        binding.apply {
            radioGr.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    radio1.id -> {
                        layoutTang1.visibility = View.VISIBLE
                        layoutTang2.visibility = View.GONE
                        layoutTang3.visibility = View.GONE
                        layoutTang4.visibility = View.GONE
                        layoutTang5.visibility = View.GONE
                    }
                    radio2.id -> {
                        layoutTang1.visibility = View.GONE
                        layoutTang2.visibility = View.VISIBLE
                        layoutTang3.visibility = View.GONE
                        layoutTang4.visibility = View.GONE
                        layoutTang5.visibility = View.GONE
                    }
                    radio3.id -> {
                        layoutTang1.visibility = View.GONE
                        layoutTang2.visibility = View.GONE
                        layoutTang3.visibility = View.VISIBLE
                        layoutTang4.visibility = View.GONE
                        layoutTang5.visibility = View.GONE
                    }
                    radio4.id -> {
                        layoutTang1.visibility = View.GONE
                        layoutTang2.visibility = View.GONE
                        layoutTang3.visibility = View.GONE
                        layoutTang4.visibility = View.VISIBLE
                        layoutTang5.visibility = View.GONE
                    }
                    radio5.id -> {
                        layoutTang1.visibility = View.GONE
                        layoutTang2.visibility = View.GONE
                        layoutTang3.visibility = View.GONE
                        layoutTang4.visibility = View.GONE
                        layoutTang5.visibility = View.VISIBLE
                    }
                }
            }

            return binding.root
        }
    }
}
