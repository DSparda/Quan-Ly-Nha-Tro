package com.example.boardinghousemanage.screens.title

import android.app.Application
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Button
import androidx.core.graphics.drawable.toDrawable
import androidx.lifecycle.*
import com.example.boardinghousemanage.database.PhieuThuDao
import com.example.boardinghousemanage.database.PhongDao
import kotlinx.coroutines.*
import java.util.*

class TitleViewModel(
    val database: PhongDao,
    val databasePT: PhieuThuDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

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


    val tong101 = databasePT.getTong(101)
    val tong102 = databasePT.getTong(102)
    val tong103 = databasePT.getTong(103)
    val tong104 = databasePT.getTong(104)
    val tong105 = databasePT.getTong(105)
    val tong201 = databasePT.getTong(201)
    val tong202 = databasePT.getTong(202)
    val tong203 = databasePT.getTong(203)
    val tong204 = databasePT.getTong(204)
    val tong205 = databasePT.getTong(205)
    val tong301 = databasePT.getTong(301)
    val tong302 = databasePT.getTong(302)
    val tong303 = databasePT.getTong(303)
    val tong304 = databasePT.getTong(304)
    val tong305 = databasePT.getTong(305)
    val tong401 = databasePT.getTong(401)
    val tong402 = databasePT.getTong(402)
    val tong403 = databasePT.getTong(403)
    val tong404 = databasePT.getTong(404)
    val tong405 = databasePT.getTong(405)
    val tong501 = databasePT.getTong(501)
    val tong502 = databasePT.getTong(502)


    val checkDebt = MutableLiveData<Boolean>()
    fun checkLastest(liveData1: LiveData<Int>): Int {
        val check1 = liveData1.value
        if (check1 == null)
            return 0
        return check1
    }


    fun getTienTong101(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong101) { value ->
            if (p101State.value == 3)
                tienTong.value = checkLastest(tong101)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p101State.value == 3) tienTong.value =
                checkLastest(tong101)
            else tienTong.value = 101
        }
        return tienTong
    }

    fun getTienTong102(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong102) { value ->
            if (p102State.value == 3)
                tienTong.value = checkLastest(tong102)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p102State.value == 3) tienTong.value =
                checkLastest(tong102)
            else tienTong.value = 102
        }
        return tienTong
    }

    fun getTienTong103(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong103) { value ->
            if (p103State.value == 3)
                tienTong.value = checkLastest(tong103)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p103State.value == 3) tienTong.value =
                checkLastest(tong103)
            else tienTong.value = 103
        }
        return tienTong
    }

    fun getTienTong104(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong104) { value ->
            if (p104State.value == 3)
                tienTong.value = checkLastest(tong104)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p104State.value == 3) tienTong.value =
                checkLastest(tong104)
            else tienTong.value = 104
        }
        return tienTong
    }

    fun getTienTong105(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong105) { value ->
            if (p105State.value == 3)
                tienTong.value = checkLastest(tong105)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p105State.value == 3) tienTong.value =
                checkLastest(tong105)
            else tienTong.value = 105
        }
        return tienTong
    }

    fun getTienTong201(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong201) { value ->
            if (p201State.value == 3)
                tienTong.value = checkLastest(tong201)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p201State.value == 3) tienTong.value =
                checkLastest(tong201)
            else tienTong.value = 201
        }
        return tienTong
    }

    fun getTienTong202(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong202) { value ->
            if (p202State.value == 3)
                tienTong.value = checkLastest(tong202)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p202State.value == 3) tienTong.value =
                checkLastest(tong202)
            else tienTong.value = 202
        }
        return tienTong
    }

    fun getTienTong203(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong203) { value ->
            if (p203State.value == 3)
                tienTong.value = checkLastest(tong203)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p203State.value == 3) tienTong.value =
                checkLastest(tong203)
            else tienTong.value = 203
        }
        return tienTong
    }

    fun getTienTong204(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong204) { value ->
            if (p204State.value == 3)
                tienTong.value = checkLastest(tong204)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p204State.value == 3) tienTong.value =
                checkLastest(tong204)
            else tienTong.value = 204
        }
        return tienTong
    }

    fun getTienTong205(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong205) { value ->
            if (p205State.value == 3)
                tienTong.value = checkLastest(tong205)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p205State.value == 3) tienTong.value =
                checkLastest(tong205)
            else tienTong.value = 205
        }
        return tienTong
    }

    fun getTienTong301(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong301) { value ->
            if (p301State.value == 3)
                tienTong.value = checkLastest(tong301)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p301State.value == 3) tienTong.value =
                checkLastest(tong301)
            else tienTong.value = 301
        }
        return tienTong
    }

    fun getTienTong302(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong302) { value ->
            if (p302State.value == 3)
                tienTong.value = checkLastest(tong302)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p302State.value == 3) tienTong.value =
                checkLastest(tong302)
            else tienTong.value = 302
        }
        return tienTong
    }


    fun getTienTong303(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong303) { value ->
            if (p303State.value == 3)
                tienTong.value = checkLastest(tong303)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p303State.value == 3) tienTong.value =
                checkLastest(tong303)
            else tienTong.value = 303
        }
        return tienTong
    }


    fun getTienTong304(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong304) { value ->
            if (p304State.value == 3)
                tienTong.value = checkLastest(tong304)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p304State.value == 3) tienTong.value =
                checkLastest(tong304)
            else tienTong.value = 304
        }
        return tienTong
    }


    fun getTienTong305(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong305) { value ->
            if (p305State.value == 3)
                tienTong.value = checkLastest(tong305)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p305State.value == 3) tienTong.value =
                checkLastest(tong305)
            else tienTong.value = 305
        }
        return tienTong
    }


    fun getTienTong401(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong401) { value ->
            if (p401State.value == 3)
                tienTong.value = checkLastest(tong401)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p401State.value == 3) tienTong.value =
                checkLastest(tong401)
            else tienTong.value = 401
        }
        return tienTong
    }

    fun getTienTong402(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong402) { value ->
            if (p402State.value == 3)
            tienTong.value = checkLastest(tong402)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p402State.value == 3) tienTong.value =
                checkLastest(tong402)
            else tienTong.value = 402
        }
        return tienTong
    }


    fun getTienTong403(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong403) { value ->
            if (p403State.value == 3)
            tienTong.value = checkLastest(tong403)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p403State.value == 3) tienTong.value =
                checkLastest(tong403)
            else tienTong.value = 403
        }
        return tienTong
    }


    fun getTienTong404(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong404) { value ->
            if (p404State.value == 3)
            tienTong.value = checkLastest(tong404)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p401State.value == 3) tienTong.value =
                checkLastest(tong404)
            else tienTong.value = 404
        }
        return tienTong
    }


    fun getTienTong405(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong405) { value ->
            if (p405State.value == 3)
            tienTong.value = checkLastest(tong405)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p405State.value == 3) tienTong.value =
                checkLastest(tong405)
            else tienTong.value = 405
        }
        return tienTong
    }


    fun getTienTong501(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong501) { value ->
            if (p501State.value == 3)
            tienTong.value = checkLastest(tong501)
        }
        tienTong.addSource(checkDebt) { value ->

            if (checkDebt.value == true && p501State.value == 3) tienTong.value =
                checkLastest(tong501)
            else tienTong.value = 501
        }
        return tienTong
    }

    fun getTienTong502(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()
        tienTong.addSource(tong502) { value ->
            if (p502State.value == 3)
            tienTong.value = checkLastest(tong502)
        }
        tienTong.addSource(checkDebt) { value ->
            if (checkDebt.value == true && p502State.value == 3) tienTong.value =
                checkLastest(tong502)
            else tienTong.value = 502
        }
        return tienTong
    }


    val tong101Real = getTienTong101()
    val tong101String = Transformations.map(tong101Real) { value ->
        value.toString()
    }

    val tong102Real = getTienTong102()
    val tong102String = Transformations.map(tong102Real) { value ->
        value.toString()
    }

    val tong103Real = getTienTong103()
    val tong103String = Transformations.map(tong103Real) { value ->
        value.toString()
    }

    val tong104Real = getTienTong104()
    val tong104String = Transformations.map(tong104Real) { value ->
        value.toString()
    }

    val tong105Real = getTienTong105()
    val tong105String = Transformations.map(tong105Real) { value ->
        value.toString()
    }

    val tong201Real = getTienTong201()
    val tong201String = Transformations.map(tong201Real) { value ->
        value.toString()
    }
    val tong202Real = getTienTong202()
    val tong202String = Transformations.map(tong202Real) { value ->
        value.toString()
    }

    val tong203Real = getTienTong203()
    val tong203String = Transformations.map(tong203Real) { value ->
        value.toString()
    }

    val tong204Real = getTienTong204()
    val tong204String = Transformations.map(tong204Real) { value ->
        value.toString()
    }

    val tong205Real = getTienTong205()
    val tong205String = Transformations.map(tong205Real) { value ->
        value.toString()
    }

    val tong301Real = getTienTong301()
    val tong301String = Transformations.map(tong301Real) { value ->
        value.toString()
    }
    val tong302Real = getTienTong302()
    val tong302String = Transformations.map(tong302Real) { value ->
        value.toString()
    }
    val tong303Real = getTienTong303()
    val tong303String = Transformations.map(tong303Real) { value ->
        value.toString()
    }
    val tong304Real = getTienTong304()
    val tong304String = Transformations.map(tong304Real) { value ->
        value.toString()
    }
    val tong305Real = getTienTong305()
    val tong305String = Transformations.map(tong305Real) { value ->
        value.toString()
    }


    val tong401Real = getTienTong401()
    val tong401String = Transformations.map(tong401Real) { value ->
        value.toString()
    }

    val tong402Real = getTienTong402()
    val tong402String = Transformations.map(tong402Real) { value ->
        value.toString()
    }

    val tong403Real = getTienTong403()
    val tong403String = Transformations.map(tong403Real) { value ->
        value.toString()
    }

    val tong404Real = getTienTong404()
    val tong404tring = Transformations.map(tong404Real) { value ->
        value.toString()
    }

    val tong405Real = getTienTong405()
    val tong405String = Transformations.map(tong405Real) { value ->
        value.toString()
    }

    val tong501Real = getTienTong501()
    val tong501String = Transformations.map(tong501Real) { value ->
        value.toString()
    }

    val tong502Real = getTienTong502()
    val tong502String = Transformations.map(tong502Real) { value ->
        value.toString()
    }


    fun longPress(key: Int, state: Int) {
        uiScope.launch {
            update(key, state)
        }
    }

    private suspend fun update(key: Int, state: Int) {
        withContext(Dispatchers.IO) {
            database.updateState(key, state)
        }
    }

    fun mapColor(p: Int): Drawable =
        when (p) {
            1 -> Color.YELLOW.toDrawable()
            2 -> Color.GREEN.toDrawable()
            3 -> Color.RED.toDrawable()
            else -> Color.GRAY.toDrawable()
        }

    fun mapTag(p: Int): Int =
        when (p) {
            0 -> 0
            3 -> 3
            else -> 1
        }

    //region Xử lí radioButton check
    val _radioChecked = MutableLiveData<Int>()
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
        checkDebt.value = false
        _radioChecked.value = 0
    }

    fun rotate() {
        GlobalScope.launch(Dispatchers.Main) {
            if (checkDebt.value == true) checkDebt.value = false
            else if (checkDebt.value == false) checkDebt.value = true
        }
    }

    private val _maPhong = MutableLiveData<Int>()
    val maPhong: LiveData<Int>
        get() = _maPhong

    private val _check = MutableLiveData<Int>()
    val check: LiveData<Int>
        get() = _check

    fun onEventButton(v: View) {
        val b: Button = v as Button
        _maPhong.value = b.text.toString().toInt()
        when (b.tag) {
            0 -> _check.value = 0
            1 -> _check.value = 1
        }
    }

    fun doneNavigate() {
        _check.value = -1
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}