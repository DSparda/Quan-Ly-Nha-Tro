package com.example.boardinghousemanage.screens.general

import android.app.Application
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import androidx.lifecycle.*
import com.example.boardinghousemanage.database.*
import kotlinx.coroutines.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class GeneralViewModel(
    MaPhong: Int,
    val databasePhong: PhongDao,
    val databaseThamSo: ThamSoDao,
    val databasePhieuThu: PhieuThuDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _maPhong = MutableLiveData<Int>()
    val maPhong: LiveData<Int>
        get() = _maPhong
    val maPhongString = Transformations.map(maPhong) { key ->
        key.toString()
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

    fun radio1Checked() {
        _radioChecked.value = 1
    }

    fun radio2Checked() {
        _radioChecked.value = 2
    }

    fun radio3Checked() {
        _radioChecked.value = 3
    }
    //endregion


    init {
        _radioChecked.value = 1
        _maPhong.value = MaPhong
    }


    //region Tiền điện
    val _soKiDien = MutableLiveData<Int>()
    val donGiaDien = databaseThamSo.getDien()
    fun getTienDien(): LiveData<Int> {


        val tienDien = MediatorLiveData<Int>()

        tienDien.addSource(_soKiDien) { value ->
            tienDien.value = timesLastest(_soKiDien, donGiaDien)
        }

        tienDien.addSource(donGiaDien) { value ->
            tienDien.value = timesLastest(_soKiDien, donGiaDien)
        }
        return tienDien
    }

    val tienDienReal = getTienDien()
    //endregion


    //region Tiền nước
    val soNguoi = databasePhong.getNguoi(_maPhong.value)
    val soNguoiString = Transformations.map(soNguoi) { value ->
        "Số người: $value"
    }
    val donGiaNuoc = databaseThamSo.getNuoc()
    fun getTienNuoc(): LiveData<Int> {

        val tienNuoc = MediatorLiveData<Int>()

        tienNuoc.addSource(soNguoi) { value ->
            tienNuoc.value = timesLastest(soNguoi, donGiaNuoc)
        }

        tienNuoc.addSource(donGiaNuoc) { value ->
            tienNuoc.value = timesLastest(soNguoi, donGiaNuoc)
        }
        return tienNuoc
    }

    val tienNuocReal = getTienNuoc()
    val tienNuocString = Transformations.map(tienNuocReal) { value ->
        value.toString() + ".000"
    }
    //endregion


    fun timesLastest(liveData1: LiveData<Int>, livedata2: LiveData<Int>): Int {
        val check1 = liveData1.value
        val check2 = livedata2.value
        if (check1 == null || check2 == null)
            return 0

        return check1 * check2
    }

    fun getTienTong(): LiveData<Int> {
        val tienTong = MediatorLiveData<Int>()

        tienTong.addSource(tienDienReal) { value ->
            tienTong.value = plusLastest(
                tienDienReal,
                tienNuocReal,
                tienPhongReal,
                tienXeReal,
                tienNetReal,
                tienRacReal
            )
        }

        tienTong.addSource(tienNuocReal) { value ->
            tienTong.value = plusLastest(
                tienDienReal,
                tienNuocReal,
                tienPhongReal,
                tienXeReal,
                tienNetReal,
                tienRacReal
            )
        }

        return tienTong
    }

    val tienTongReal = getTienTong()
    val tienTongString = Transformations.map(tienTongReal) { tien ->
        tien.toString() + ".000"
    }

    fun plusLastest(
        liveData1: LiveData<Int>,
        liveData2: LiveData<Int>,
        liveData3: LiveData<Int>,
        liveData4: LiveData<Int>,
        liveData5: LiveData<Int>,
        liveData6: LiveData<Int>
    ): Int {
        val check1 = liveData1.value
        val check2 = liveData2.value
        val check3 = liveData3.value
        val check4 = liveData4.value
        val check5 = liveData5.value
        val check6 = liveData6.value

        if (check1 == null || check2 == null || check3 == null || check4 == null || check5 == null || check6 == null)
            return 0

        return check1 + check2 + check3 + check4 + check5 + check6
    }

    val phong = databaseThamSo.getPhong()
    fun getTienPhong(): LiveData<Int> {
        val tienPhong = MediatorLiveData<Int>()
        tienPhong.addSource(phong) { value ->
            tienPhong.value = checkLastest(phong)
        }
        return tienPhong
    }

    val tienPhongReal = getTienPhong()
    val tienPhongString = Transformations.map(tienPhongReal) { tien ->
        tien.toString() + ".000"
    }


    //region Tiền xe
    val soXe = databasePhong.getXe(_maPhong.value)
    val soXeString = Transformations.map(soXe) {value ->
        "Số xe: $value"
    }
    val donGiaXe = databaseThamSo.getXe()
    fun getTienXe(): LiveData<Int> {

        val tienXe = MediatorLiveData<Int>()

        tienXe.addSource(soXe) { value ->
            tienXe.value = timesLastest(soXe, donGiaXe)
        }

        tienXe.addSource(donGiaXe) { value ->
            tienXe.value = timesLastest(soXe, donGiaXe)
        }
        return tienXe
    }

    val tienXeReal = getTienXe()
    val tienXeString = Transformations.map(tienXeReal) { tien ->
        tien.toString() + ".000"
    }
//endregion

    val net = databaseThamSo.getMang()
    fun getTienNet(): LiveData<Int> {
        val tienNet = MediatorLiveData<Int>()
        tienNet.addSource(net) { value ->
            tienNet.value = checkLastest(net)
        }
        return tienNet
    }

    val tienNetReal = getTienNet()
    val tienNetString = Transformations.map(tienNetReal) { tien ->
        tien.toString() + ".000"
    }

    val rac = databaseThamSo.getRac()
    fun getTienRac(): LiveData<Int> {
        val tienRac = MediatorLiveData<Int>()
        tienRac.addSource(rac) { value ->
            tienRac.value = checkLastest(rac)
        }
        return tienRac
    }

    fun checkLastest(liveData1: LiveData<Int>): Int {
        val check1 = liveData1.value
        if (check1 == null)
            return 0
        return check1
    }

    val tienRacReal = getTienRac()
    val tienRacString = Transformations.map(tienRacReal) { tien ->
        tien.toString() + ".000"
    }

    val now = Calendar.getInstance()
    val thang = now.get(Calendar.MONTH) + 1
    val nam = now.get(Calendar.YEAR)
    val thoiGianString = "$thang/$nam"

    private val _navigateToTitle = MutableLiveData<Boolean>()
    val navigateToTitle: LiveData<Boolean>
        get() = _navigateToTitle

    fun onXacNhanTP() {
        uiScope.launch {
            delete(maPhong.value!!)
            _navigateToTitle.value = true
        }
    }

    private suspend fun delete(maPhong: Int) {
        withContext(Dispatchers.IO) {
            databasePhong.delete(maPhong)
        }
    }

    fun onHuy() {
        _navigateToTitle.value = true
    }

    fun doneToTitle() {
        _navigateToTitle.value = false
    }

    var soNguoiCN = MutableLiveData<Int>()
    var soXeCN = MutableLiveData<Int>()
    var soTienCocCN = MutableLiveData<Int>()

    val soTienCoc = databasePhong.getTienCoc(_maPhong.value)
    val soTienCocString = Transformations.map (soTienCoc) {value ->
        "Số tiền cọc: $value.000"
    }

    val phongString = Transformations.map(maPhong) { value ->
        "Phòng: $value"
    }

    fun onXacNhanCN() {
        uiScope.launch {
            update(_maPhong.value!!, soNguoiCN.value!!, soXeCN.value!!, soTienCocCN.value!!)
            _radioChecked.value = 0
        }
    }

    private suspend fun update(key: Int, nguoi: Int, xe: Int, tienCoc: Int) {
        withContext(Dispatchers.IO) {
            databasePhong.update(key, nguoi, xe, tienCoc)
        }
    }

    fun onXacNhanThuPhi() {
        uiScope.launch {
            val newPhieuThu = PhieuThu(
                maPhong.value!!,
                thang,
                nam,
                tienDienReal.value!!,
                tienNuocReal.value!!,
                tienPhongReal.value!!,
                tienXeReal.value!!,
                tienNetReal.value!!,
                tienRacReal.value!!,
                tienTongReal.value!!
            )
            updateState(_maPhong.value!!)
            insert(newPhieuThu)
            _navigateToTitle.value = true
        }
    }

    private suspend fun insert(phieuThu: PhieuThu) {
        withContext(Dispatchers.IO) {
            databasePhieuThu.insert(phieuThu)
        }
    }

    private suspend fun updateState(key: Int) {
        withContext(Dispatchers.IO) {
            databasePhong.updateState(key, 3)
        }
    }

    var check1 = false
    var check2 = false
    var check3 = false

    fun check(c1: Boolean, c2: Boolean, c3: Boolean): Boolean {
        if (c1 == true && c2 == true && c3 == true)
            return true
        return false
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}