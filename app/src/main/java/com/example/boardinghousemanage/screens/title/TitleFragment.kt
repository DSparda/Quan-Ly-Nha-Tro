package com.example.boardinghousemanage.screens.title

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.boardinghousemanage.R
import com.example.boardinghousemanage.database.TroDatabase
import com.example.boardinghousemanage.databinding.TitleFragmentBinding

class TitleFragment : Fragment() {

    private lateinit var viewModel: TitleViewModel
    private lateinit var viewModelFactory: TitleViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: TitleFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.title_fragment, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = TroDatabase.getInstance(application).phongDao

        viewModelFactory = TitleViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TitleViewModel::class.java)

        binding.titleViewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.check.observe(this, Observer { check ->
            when (check) {
                0 -> {
                    this.findNavController()
                        .navigate(TitleFragmentDirections.actionTitleToRent(viewModel.maPhong.value!!))
                    viewModel.doneNavigate()
                }
                1 -> {
                    this.findNavController()
                        .navigate(TitleFragmentDirections.actionTitleFragmentToGeneralFragment(viewModel.maPhong.value!!))
                    viewModel.doneNavigate()
                }
            }
        })

        return binding.root
    }
}

