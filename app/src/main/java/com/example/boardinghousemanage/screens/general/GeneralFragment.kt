package com.example.boardinghousemanage.screens.general


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.example.boardinghousemanage.R
import com.example.boardinghousemanage.database.TroDatabase
import com.example.boardinghousemanage.databinding.GeneralFragmentBinding
import com.example.boardinghousemanage.screens.rent.GeneralViewModelFactory
import com.example.boardinghousemanage.screens.rent.RentFragmentArgs


class GeneralFragment : Fragment() {

    private lateinit var viewModel: GeneralViewModel
    private lateinit var viewModelFactory: GeneralViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GeneralFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.general_fragment, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = TroDatabase.getInstance(application).phongDao

        val generalFragmentArgs by navArgs<GeneralFragmentArgs>()

        viewModelFactory =
            GeneralViewModelFactory(generalFragmentArgs.maPhongKey, dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GeneralViewModel::class.java)

        binding.generalViewModel = viewModel
        binding.setLifecycleOwner(this)

        return binding.root
    }
}

