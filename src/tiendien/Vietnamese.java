package tiendien;

import java.util.Date;

public class Vietnamese extends Customer {
    private String doituong;

    public Vietnamese(String code, String name, Date date, int electricNumber, String doituong) {
        super(code, name, date, electricNumber);
        this.doituong = doituong;
    }

    public String getDoituong() {
        return doituong;
    }

    public void setDoituong(String doituong) {
        this.doituong = doituong;
    }

    @Override
    public double total() {
        if (getElectricNumber() < 0) {
            return super.total();
        } else if (this.getElectricNumber() < 50) {
            return getElectricNumber() * 1000;
        } else if (getElectricNumber() >= 50 && getElectricNumber() < 100) {
            return 50 * 1000 + (getElectricNumber() - 50) * 1200;
        } else if (getElectricNumber() >= 100 && getElectricNumber() < 200) {
            return 50 * 1000 + 50 * 1200 + (getElectricNumber() - 100) * 1500;
        } else {
            return 50 * 2200 + 100 * 1500 + (getElectricNumber() - 200) * 2000;
        }
    }

}
