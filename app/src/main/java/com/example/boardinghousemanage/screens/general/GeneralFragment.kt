package com.example.boardinghousemanage.screens.general


import android.os.Bundle
import android.view.*
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.boardinghousemanage.R
import com.example.boardinghousemanage.database.TroDatabase
import com.example.boardinghousemanage.databinding.GeneralFragmentBinding
import com.example.boardinghousemanage.screens.rent.GeneralViewModelFactory
import kotlinx.android.synthetic.main.general_fragment.*


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
        val dataPhong = TroDatabase.getInstance(application).phongDao
        val dataThamSo = TroDatabase.getInstance(application).thamSoDao
        val dataPhieuThu = TroDatabase.getInstance(application).phieuThuDao

        val generalFragmentArgs by navArgs<GeneralFragmentArgs>()

        viewModelFactory =
            GeneralViewModelFactory(
                generalFragmentArgs.maPhongKey,
                dataPhong,
                dataThamSo,
                dataPhieuThu,
                application
            )
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GeneralViewModel::class.java)

        binding.generalViewModel = viewModel
        binding.setLifecycleOwner(this)

        setHasOptionsMenu(true)

        binding.apply {
            dienEditGen.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    dienEditGen.setError("Vui lòng nhập")
                    buttonXacnhanGen1.visibility = View.INVISIBLE
                } else {
                    viewModel._soKiDien.value = text.toString().toIntOrNull()
                    buttonXacnhanGen1.visibility = View.VISIBLE
                }
            }
        }

        binding.apply {
            songuoiEditGen2.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    viewModel.check1 = false
                    songuoiEditGen2.setError("Vui lòng nhập")
                    buttonXacnhanGen3.visibility = View.INVISIBLE
                } else {
                    viewModel.soNguoiCN.value = text.toString().toIntOrNull()
                    viewModel.check1 = true
                    if (viewModel.check(viewModel.check1, viewModel.check2, viewModel.check3))
                        buttonXacnhanGen3.visibility = View.VISIBLE
                }
            }
            soxeEditGen2.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    viewModel.check2 = false
                    soxeEditGen2.setError("Vui lòng nhập")
                    buttonXacnhanGen3.visibility = View.INVISIBLE
                } else {
                    viewModel.soXeCN.value = text.toString().toIntOrNull()
                    viewModel.check2 = true
                    if (viewModel.check(viewModel.check1, viewModel.check2, viewModel.check3))
                        buttonXacnhanGen3.visibility = View.VISIBLE
                }
            }
            sotiencocEditGen2.doAfterTextChanged { text ->
                if (text.toString() == "") {
                    viewModel.check3 = false
                    sotiencocEditGen2.setError("Vui lòng nhập")
                    buttonXacnhanGen3.visibility = View.INVISIBLE
                } else {
                    viewModel.check3 = true
                    viewModel.soTienCocCN.value = text.toString().toIntOrNull()
                    if (viewModel.check(viewModel.check1, viewModel.check2, viewModel.check3))
                        buttonXacnhanGen3.visibility = View.VISIBLE
                }
            }
        }

        viewModel.navigateToTitle.observe(this, Observer { event ->
            if (event) {
                this.findNavController().navigate(GeneralFragmentDirections.actionGeneralToTitle(viewModel.maPhong.value.toString()))
                viewModel.doneToTitle()
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.flow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        this.findNavController()
            .navigate(
                GeneralFragmentDirections.actionGeneralToParameter(
                    viewModel.maPhong.value!!,
                    1
                )
            )
        return super.onOptionsItemSelected(item)
    }
}

