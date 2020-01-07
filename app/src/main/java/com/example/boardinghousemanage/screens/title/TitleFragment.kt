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
            buttonTang12.setOnLongClickListener {
                viewModel.p102State?.let {
                    if (viewModel.p102State.value == 3) {
                        viewModel.longPress(102, 2)
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




