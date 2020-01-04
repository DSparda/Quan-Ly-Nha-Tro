package com.example.boardinghousemanage.screens.title

import android.app.Application
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Button
import androidx.core.graphics.drawable.toDrawable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.boardinghousemanage.R
import com.example.boardinghousemanage.R.color
import com.example.boardinghousemanage.database.Phong
import com.example.boardinghousemanage.database.PhongDao
import kotlinx.coroutines.*

class TitleViewModel(
    val database: PhongDao,
    application: Application
) : AndroidViewModel(application) {

    val p101State = database.getState(101)
    val p102State = database.getState(102)
    val p103State = database.getState(103)
    val p104State = database.getState(104)
    val p105State = database.getState(105)
    val p201State = database.getState(201)
    val p202State = database.getState(202)
    val p203State = database.getState(203)
    val p204State = database.getState(204)
    val p205State = database.getState(205)
    val p301State = database.getState(301)
    val p302State = database.getState(302)
    val p303State = database.getState(303)
    val p304State = database.getState(304)
    val p305State = database.getState(305)
    val p401State = database.getState(401)
    val p402State = database.getState(402)
    val p403State = database.getState(403)
    val p404State = database.getState(404)
    val p405State = database.getState(405)
    val p501State = database.getState(501)
    val p502State = database.getState(502)

    fun mapColor(p: Int): Drawable {
        return when (p) {
            1 -> Color.YELLOW.toDrawable()
            2 -> Color.GREEN.toDrawable()
            3 -> Color.RED.toDrawable()
            else -> Color.GRAY.toDrawable()
        }
    }


    //region Xử lí radioButton check
    private val _radioChecked = MutableLiveData<Int>()
    val radioChecked: LiveData<Int>
        get() = _radioChecked

    val layoutChecked1 = Transformations.map(radioChecked) { radio ->
        if (radio == 1)
            View.VISIBLE
        else View.GONE
    }
    val layoutChecked2 = Transformations.map(radioChecked) { radio ->
        if (radio == 2)
            View.VISIBLE
        else View.GONE
    }
    val layoutChecked3 = Transformations.map(radioChecked) { radio ->
        if (radio == 3)
            View.VISIBLE
        else View.GONE
    }
    val layoutChecked4 = Transformations.map(radioChecked) { radio ->
        if (radio == 4)
            View.VISIBLE
        else View.GONE
    }
    val layoutChecked5 = Transformations.map(radioChecked) { radio ->
        if (radio == 5)
            View.VISIBLE
        else View.GONE
    }

    fun radio1Checked() {
        _radioChecked.value = 1
    }

    fun radio2Checked() {
        _radioChecked.value = 2
    }

    fun radio3Checked() {
        _radioChecked.value = 3
    }

    fun radio4Checked() {
        _radioChecked.value = 4
    }

    fun radio5Checked() {
        _radioChecked.value = 5
    }
    //endregion


    init {
        _radioChecked.value = 0
    }

    private val _maPhong = MutableLiveData<Int>()
    val maPhong: LiveData<Int>
        get()= _maPhong

    private val _check = MutableLiveData<Int>()
    lateinit var check: LiveData<Int>
        get() = _check
    fun onEventButton(v: View) {
        val b: Button = v as Button
        _maPhong.value = b.text.toString().toInt()
        check = database.getState(_maPhong.value!!)
    }


    fun doneNavigate() {
        _check.value = -1
    }
}