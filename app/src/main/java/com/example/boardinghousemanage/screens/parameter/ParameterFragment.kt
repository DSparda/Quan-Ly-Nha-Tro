package com.example.boardinghousemanage.screens.parameter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.boardinghousemanage.R
import com.example.boardinghousemanage.database.TroDatabase
import com.example.boardinghousemanage.databinding.ParameterFragmentBinding

class ParameterFragment : Fragment() {

    private lateinit var viewModel: ParameterViewModel
    private lateinit var viewModelFactory: ParameterViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ParameterFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.parameter_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = TroDatabase.getInstance(application).thamSoDao

        val parameterFragmentArgs by navArgs<ParameterFragmentArgs>()

        viewModelFactory = ParameterViewModelFactory(dataSource, application)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ParameterViewModel::class.java)

        binding.parameterViewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.check.observe(this, Observer { check ->
            when (check) {
                0 -> {
                    this.findNavController()
                        .navigate(ParameterFragmentDirections.actionParameterToTitle())
                    viewModel.doneToNavigating()
                }
                1 -> {
                    this.findNavController()
                        .navigate(ParameterFragmentDirections.actionParameterToGeneral(parameterFragmentArgs.maPhongKey ))
                    viewModel.doneToNavigating()
                }
            }
        })


        binding.apply {
            dienEditPar.doAfterTextChanged{ text ->
                viewModel._sodien.value = text.toString().toIntOrNull()
            }
            nuocEditPar.doAfterTextChanged { text ->
                viewModel._sonuoc.value = text.toString().toIntOrNull()
            }
            phongEditPar.doAfterTextChanged { text ->
                viewModel._sophong.value = text.toString().toIntOrNull()
            }
            xeEditPar.doAfterTextChanged { text ->
                viewModel._soxe.value = text.toString().toIntOrNull()
            }
            netEditPar.doAfterTextChanged { text ->
                viewModel._sonet.value = text.toString().toIntOrNull()
            }
            racEditPar.doAfterTextChanged { text ->
                viewModel._sorac.value = text.toString().toIntOrNull()
            }
        }

        return binding.root
    }
}