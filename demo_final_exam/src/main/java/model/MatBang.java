package model;

public class MatBang {
    private String id;
    private int idNote;
    private int area;
    private int soTang;
    private int idType;
    private String note;
    private int price;
    private String startDate;
    private String endDate;

    public MatBang() {
    }

    public MatBang(String id, int idNote, int area, int soTang, int idType, String note, int price, String startDate, String endDate) {
        this.id = id;
        this.idNote = idNote;
        this.area = area;
        this.soTang = soTang;
        this.idType = idType;
        this.note = note;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
