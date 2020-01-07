package com.example.boardinghousemanage.screens.rent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
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
            inflater, R.layout.rent_fragment, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = TroDatabase.getInstance(application).phongDao

        val rentFragmentArgs by navArgs<RentFragmentArgs>()

        viewModelFactory =
            RentViewModelFactory(rentFragmentArgs.maPhongKey, dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RentViewModel::class.java)

        binding.rentViewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.navigateToTitle.observe(this, Observer { event ->
            if (event) {
                this.findNavController().navigate(RentFragmentDirections.actionRentToTitle(viewModel.maPhong.value.toString()))
                viewModel.doneToTitle()
            }
        })

        binding.apply {
            songuoiEditRen.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    viewModel.check1 = false
                    songuoiEditRen.setError("Vui lòng nhập")
                    buttonXacnhanRen.visibility = View.INVISIBLE
                } else {
                    viewModel._songuoi.value = text.toString().toIntOrNull()
                    viewModel.check1 = true
                    if (viewModel.check(viewModel.check1, viewModel.check2, viewModel.check3))
                        buttonXacnhanRen.visibility = View.VISIBLE
                }
            }
            soxeEditRen.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    viewModel.check2 = false
                    soxeEditRen.setError("Vui lòng nhập")
                    buttonXacnhanRen.visibility = View.INVISIBLE
                } else {
                    viewModel._soxe.value = text.toString().toIntOrNull()
                    viewModel.check2 = true
                    if (viewModel.check(viewModel.check1, viewModel.check2, viewModel.check3))
                        buttonXacnhanRen.visibility = View.VISIBLE
                }
            }

            sotiencocEditRen.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    viewModel.check3 = false
                    sotiencocEditRen.setError("Vui lòng nhập")
                    buttonXacnhanRen.visibility = View.INVISIBLE
                } else {
                    viewModel._sotiencoc.value = text.toString().toIntOrNull()
                    viewModel.check3 = true
                    if (viewModel.check(viewModel.check1, viewModel.check2, viewModel.check3))
                        buttonXacnhanRen.visibility = View.VISIBLE
                }
            }
        }
        return binding.root
    }
}
