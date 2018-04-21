package com.example.lathaibinh.bookhotel.model;

import java.io.Serializable;

public class DataRoom implements Serializable {
    private String HinhAnh;
    private String TenPhong;
    private String ThongTinPhong;
    private String Gia;

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String tenPhong) {
        TenPhong = tenPhong;
    }

    public String getThongTinPhong() {
        return ThongTinPhong;
    }

    public void setThongTinPhong(String thongTinPhong) {
        ThongTinPhong = thongTinPhong;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }
}
