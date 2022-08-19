package customer;

public class customer {
    private String name;
    private String birthday;
    private String address;
    private int idImage;

    public customer() {
    }

    public customer(String name, String birthday, String address, int idImage) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
