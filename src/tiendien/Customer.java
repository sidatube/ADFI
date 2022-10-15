package tiendien;

import java.util.Date;

public class Customer {
    private String code;
    private String name;
    private Date date;
    private int electricNumber;

    public Customer() {
    }

    public Customer(String code, String name, Date date, int electricNumber) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.electricNumber = electricNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getElectricNumber() {
        return electricNumber;
    }

    public void setElectricNumber(int electricNumber) {
        this.electricNumber = electricNumber;
    }
    public double total(){
        return 0;
    }
}
