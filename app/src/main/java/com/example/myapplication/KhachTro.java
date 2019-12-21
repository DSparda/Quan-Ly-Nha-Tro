package com.example.myapplication;

public class KhachTro {

    public int Makt;
    public int Mapt;
    private String Hoten,GioiTinh,NgheNghiep;
    private int Sdt,Cmnd;

    public KhachTro(int makt, int mapt, String hoten, String gioiTinh, String ngheNghiep, int sdt, int cmnd) {
        Makt = makt;
        Mapt = mapt;
        Hoten = hoten;
        GioiTinh = gioiTinh;
        NgheNghiep = ngheNghiep;
        Sdt = sdt;
        Cmnd = cmnd;
    }

    public int getMakt() {
        return Makt;
    }

    public void setMakt(int makt) {
        Makt = makt;
    }








    public int getMapt() {
        return Mapt;
    }

    public void setMapt(int mapt) {
        Mapt = mapt;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getNgheNghiep() {
        return NgheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        NgheNghiep = ngheNghiep;
    }

    public int getSdt() {
        return Sdt;
    }

    public void setSdt(int sdt) {
        Sdt = sdt;
    }

    public int getCmnd() {
        return Cmnd;
    }

    public void setCmnd(int cmnd) {
        Cmnd = cmnd;
    }


}
