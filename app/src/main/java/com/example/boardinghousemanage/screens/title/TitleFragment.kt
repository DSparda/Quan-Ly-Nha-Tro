package com.example.boardinghousemanage.screens.title

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.boardinghousemanage.R
import com.example.boardinghousemanage.database.TroDatabase
import com.example.boardinghousemanage.databinding.TitleFragmentBinding
import java.util.*


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
        val dataSourcePT = TroDatabase.getInstance(application).phieuThuDao

        viewModelFactory = TitleViewModelFactory(dataSource, dataSourcePT, application)
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
                        .navigate(
                            TitleFragmentDirections.actionTitleFragmentToGeneralFragment(
                                viewModel.maPhong.value!!
                            )
                        )
                    viewModel.doneNavigate()
                }
            }
        })

        binding.apply {
            buttonTang11.setOnLongClickListener {
                viewModel.p101State?.let {
                    if (viewModel.p101State.value == 3) {
                        viewModel.longPress(101, 2)
                    }
                }
                true
            }
            buttonTang12.setOnLongClickListener {
                viewModel.p102State?.let {
                    if (viewModel.p102State.value == 3) {
                        viewModel.longPress(102, 2)
                    }
                }
                true
            }
            buttonTang13.setOnLongClickListener {
                viewModel.p103State?.let {
                    if (viewModel.p103State.value == 3) {
                        viewModel.longPress(103, 2)
                    }
                }
                true
            }
            buttonTang14.setOnLongClickListener {
                viewModel.p104State?.let {
                    if (viewModel.p104State.value == 3) {
                        viewModel.longPress(104, 2)
                    }
                }
                true
            }
            buttonTang15.setOnLongClickListener {
                viewModel.p105State?.let {
                    if (viewModel.p105State.value == 3) {
                        viewModel.longPress(105, 2)
                    }
                }
                true
            }
            buttonTang21.setOnLongClickListener {
                viewModel.p201State?.let {
                    if (viewModel.p201State.value == 3) {
                        viewModel.longPress(201, 2)
                    }
                }
                true
            }
            buttonTang22.setOnLongClickListener {
                viewModel.p202State?.let {
                    if (viewModel.p202State.value == 3) {
                        viewModel.longPress(202, 2)
                    }
                }
                true
            }
            buttonTang23.setOnLongClickListener {
                viewModel.p203State?.let {
                    if (viewModel.p203State.value == 3) {
                        viewModel.longPress(203, 2)
                    }
                }
                true
            }
            buttonTang24.setOnLongClickListener {
                viewModel.p204State?.let {
                    if (viewModel.p204State.value == 3) {
                        viewModel.longPress(204, 2)
                    }
                }
                true
            }
            buttonTang25.setOnLongClickListener {
                viewModel.p205State?.let {
                    if (viewModel.p205State.value == 3) {
                        viewModel.longPress(205, 2)
                    }
                }
                true
            }
            buttonTang31.setOnLongClickListener {
                viewModel.p301State?.let {
                    if (viewModel.p301State.value == 3) {
                        viewModel.longPress(301, 2)
                    }
                }
                true
            }
            buttonTang32.setOnLongClickListener {
                viewModel.p302State?.let {
                    if (viewModel.p302State.value == 3) {
                        viewModel.longPress(302, 2)
                    }
                }
                true
            }
            buttonTang33.setOnLongClickListener {
                viewModel.p303State?.let {
                    if (viewModel.p303State.value == 3) {
                        viewModel.longPress(303, 2)
                    }
                }
                true
            }
            buttonTang34.setOnLongClickListener {
                viewModel.p304State?.let {
                    if (viewModel.p304State.value == 3) {
                        viewModel.longPress(304, 2)
                    }
                }
                true
            }
            buttonTang35.setOnLongClickListener {
                viewModel.p305State?.let {
                    if (viewModel.p305State.value == 3) {
                        viewModel.longPress(305, 2)
                    }
                }
                true
            }
            buttonTang41.setOnLongClickListener {
                viewModel.p401State?.let {
                    if (viewModel.p401State.value == 3) {
                        viewModel.longPress(401, 2)
                    }
                }
                true
            }
            buttonTang42.setOnLongClickListener {
                viewModel.p402State?.let {
                    if (viewModel.p402State.value == 3) {
                        viewModel.longPress(402, 2)
                    }
                }
                true
            }
            buttonTang43.setOnLongClickListener {
                viewModel.p403State?.let {
                    if (viewModel.p403State.value == 3) {
                        viewModel.longPress(403, 2)
                    }
                }
                true
            }
            buttonTang44.setOnLongClickListener {
                viewModel.p404State?.let {
                    if (viewModel.p404State.value == 3) {
                        viewModel.longPress(404, 2)
                    }
                }
                true
            }
            buttonTang45.setOnLongClickListener {
                viewModel.p405State?.let {
                    if (viewModel.p405State.value == 3) {
                        viewModel.longPress(405, 2)
                    }
                }
                true
            }
            buttonTang51.setOnLongClickListener {
                viewModel.p501State?.let {
                    if (viewModel.p501State.value == 3) {
                        viewModel.longPress(501, 2)
                    }
                }
                true
            }
            buttonTang52.setOnLongClickListener {
                viewModel.p502State?.let {
                    if (viewModel.p502State.value == 3) {
                        viewModel.longPress(502, 2)
                    }
                }
                true
            }
        }

        val myTimer = Timer()
        myTimer.schedule(object : TimerTask() {
            override fun run() {
                viewModel.rotate()
            }
        }, 0, 2000)

        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.flow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        this.findNavController()
            .navigate(TitleFragmentDirections.actionTitleFragmentToParameterFragment(0, 0))
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        val titleFragmentArgs by navArgs<TitleFragmentArgs>()
        viewModel._radioChecked.value = titleFragmentArgs.radio.take(1).toInt()
        super.onResume()
    }
}




