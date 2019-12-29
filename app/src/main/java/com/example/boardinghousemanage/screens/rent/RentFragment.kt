package com.example.boardinghousemanage.screens.rent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.boardinghousemanage.R
import com.example.boardinghousemanage.database.TroDatabase
import com.example.boardinghousemanage.databinding.RentFragmentBinding


class RentFragment : Fragment() {

    private lateinit var viewModel: RentViewModel
    private lateinit var viewModelFactory: RentViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: RentFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.rent_fragment, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = TroDatabase.getInstance(application).phongDao

        val rentFragmentArgs by navArgs<RentFragmentArgs>()

        viewModelFactory = RentViewModelFactory(rentFragmentArgs.maPhongKey, dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RentViewModel::class.java)

        binding.rentViewModel = viewModel
        binding.setLifecycleOwner(this)

        fun passEditValue() {
            binding.apply {
                viewModel._songuoi.value = songuoiEdit.text.toString().toInt()
                viewModel._soxe.value = songuoiEdit.text.toString().toInt()
                viewModel._sotiencoc.value = sotiencocEdit.text.toString().toInt()

            }
        }

        viewModel.eventInsert.observe(this, Observer { InsertTrigger ->
            if (InsertTrigger) {
                passEditValue()
                viewModel.onEventInsertComple()
            }
        })

        viewModel.navigateToTitle.observe(this, Observer { cancel ->
            if (cancel) {
                this.findNavController().navigate(RentFragmentDirections.actionRentToTitle())
                viewModel.doneToTitle()
            }
        })
        return binding.root
    }
}
