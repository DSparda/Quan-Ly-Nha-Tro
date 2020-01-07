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

        viewModel._state.value = parameterFragmentArgs.from

        viewModel.check.observe(this, Observer { check ->
            when (check) {
                0 -> {
                    this.findNavController()
                        .navigate(ParameterFragmentDirections.actionParameterToTitle("0"))
                    viewModel.doneToNavigating()
                }
                1 -> {
                    this.findNavController()
                        .navigate(
                            ParameterFragmentDirections.actionParameterToGeneral(
                                parameterFragmentArgs.maPhongKey
                            )
                        )
                    viewModel.doneToNavigating()
                }
            }
        })


        binding.apply {
            dienEditPar.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    viewModel.check1 = false
                    dienEditPar.setError("Vui lòng nhập")
                    buttonXacnhanPar.visibility = View.INVISIBLE
                } else {
                    viewModel._sodien.value = text.toString().toIntOrNull()
                    viewModel.check1 = true
                    if (viewModel.check(
                            viewModel.check1, viewModel.check2, viewModel.check3,
                            viewModel.check4, viewModel.check5, viewModel.check6
                        )
                    )
                        buttonXacnhanPar.visibility = View.VISIBLE
                }
            }
            nuocEditPar.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    nuocEditPar.setError("Vui lòng nhập")
                    viewModel.check2 = false
                    buttonXacnhanPar.visibility = View.INVISIBLE
                } else {
                    viewModel._sonuoc.value = text.toString().toIntOrNull()
                    viewModel.check2 = true
                    if (viewModel.check(
                            viewModel.check1, viewModel.check2, viewModel.check3,
                            viewModel.check4, viewModel.check5, viewModel.check6
                        )
                    )
                        buttonXacnhanPar.visibility = View.VISIBLE
                }

            }
            phongEditPar.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    viewModel.check3 = false
                    phongEditPar.setError("Vui lòng nhập")
                    buttonXacnhanPar.visibility = View.INVISIBLE
                } else {
                    viewModel._sophong.value = text.toString().toIntOrNull()
                    viewModel.check3 = true
                    if (viewModel.check(
                            viewModel.check1, viewModel.check2, viewModel.check3,
                            viewModel.check4, viewModel.check5, viewModel.check6
                        )
                    )
                        buttonXacnhanPar.visibility = View.VISIBLE
                }
            }
            xeEditPar.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    viewModel.check4 = false
                    xeEditPar.setError("Vui lòng nhập")
                    buttonXacnhanPar.visibility = View.INVISIBLE
                } else {
                    viewModel.check4 = true
                    viewModel._soxe.value = text.toString().toIntOrNull()
                    if (viewModel.check(
                            viewModel.check1, viewModel.check2, viewModel.check3,
                            viewModel.check4, viewModel.check5, viewModel.check6
                        )
                    )
                        buttonXacnhanPar.visibility = View.VISIBLE
                }
            }
            netEditPar.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    viewModel.check5 = false
                    buttonXacnhanPar.visibility = View.INVISIBLE
                    netEditPar.setError("Vui lòng nhập")
                } else {
                    viewModel.check5 = true
                    viewModel._sonet.value = text.toString().toIntOrNull()
                    if (viewModel.check(
                            viewModel.check1, viewModel.check2, viewModel.check3,
                            viewModel.check4, viewModel.check5, viewModel.check6
                        )
                    )
                        buttonXacnhanPar.visibility = View.VISIBLE
                }
            }
            racEditPar.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    viewModel.check6 = false
                    buttonXacnhanPar.visibility = View.INVISIBLE
                    racEditPar.setError("Vui lòng nhập")
                } else {
                    viewModel.check6 = true
                    viewModel._sorac.value = text.toString().toIntOrNull()
                    if (viewModel.check(
                            viewModel.check1, viewModel.check2, viewModel.check3,
                            viewModel.check4, viewModel.check5, viewModel.check6
                        )
                    )
                        buttonXacnhanPar.visibility = View.VISIBLE
                }
            }
        }

        return binding.root
    }
}