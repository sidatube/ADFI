package tiendien;

import java.util.Date;

public class Foreigner extends Customer {
    private String country;

    public Foreigner(String code, String name, Date date, int electricNumber, String country) {
        super(code, name, date, electricNumber);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public double total(){
        if (getElectricNumber()<0){
            return super.total();
        }
        return getElectricNumber()*2000;
    }
}
