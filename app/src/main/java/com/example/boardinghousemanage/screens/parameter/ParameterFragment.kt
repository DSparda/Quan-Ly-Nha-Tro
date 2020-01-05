package com.example.boardinghousemanage.screens.parameter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
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

        viewModelFactory = ParameterViewModelFactory(dataSource, application)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ParameterViewModel::class.java)

        binding.parameterViewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.navigateToTitle.observe(this, Observer { event ->
            if (event) {
                this.findNavController().navigate(ParameterFragmentDirections.actionParameterFragmentToTitleFragment())
                viewModel.doneToTitle()
            }
        })


        binding.apply {
            dienEditPar.doOnTextChanged { text, start, count, after ->
                viewModel._sodien.value = text.toString().toInt()
            }
            nuocEditPar.doOnTextChanged { text, start, count, after ->
                viewModel._sonuoc.value = text.toString().toInt()
            }
            phongEditPar.doOnTextChanged { text, start, count, after ->
                viewModel._sophong.value = text.toString().toInt()
            }
            xeEditPar.doOnTextChanged { text, start, count, after ->
                viewModel._soxe.value = text.toString().toInt()
            }
            netEditPar.doOnTextChanged { text, start, count, after ->
                viewModel._sonet.value = text.toString().toInt()
            }
            racEditPar.doOnTextChanged { text, start, count, after ->
                viewModel._sorac.value = text.toString().toInt()
            }
        }

        return binding.root
    }
}