package model;

public class MatBang {
    private String id;
    private int idTrangThai;
    private double dienTich;
    private int soTang;
    private int maLoai;
    private String moTa;
    private int giaTien;
    private String ngayThue;
    private String ngayTra;

    public MatBang() {
    }

    public MatBang(String id, int idTrangThai, double dienTich, int soTang, int maLoai, String moTa, int giaTien, String ngayThue, String ngayTra) {
        this.id = id;
        this.idTrangThai = idTrangThai;
        this.dienTich = dienTich;
        this.soTang = soTang;
        this.maLoai = maLoai;
        this.moTa = moTa;
        this.giaTien = giaTien;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }
}
