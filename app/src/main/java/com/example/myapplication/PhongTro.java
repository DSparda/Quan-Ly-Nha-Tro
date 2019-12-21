package com.example.myapplication;

public class PhongTro {
    public int Mapt;
    private String Tenpt,loai,TrangThai;
    private int Tang,SoLuongtd;

    public PhongTro(int mapt, String tenpt, String loai, String trangThai, int tang, int soLuongtd) {
        Mapt = mapt;
        Tenpt = tenpt;
        this.loai = loai;
        TrangThai = trangThai;
        Tang = tang;
        SoLuongtd = soLuongtd;
    }

    public int getMapt() {
        return Mapt;
    }

    public void setMapt(int mapt) {
        Mapt = mapt;
    }

    public String getTenpt() {
        return Tenpt;
    }

    public void setTenpt(String tenpt) {
        Tenpt = tenpt;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public int getTang() {
        return Tang;
    }

    public void setTang(int tang) {
        Tang = tang;
    }

    public int getSoLuongtd() {
        return SoLuongtd;
    }

    public void setSoLuongtd(int soLuongtd) {
        SoLuongtd = soLuongtd;
    }




}
