package tiendien;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vietnamese vn1 = new Vietnamese("VN1","Nguyên văn A",new Date(System.currentTimeMillis()),43,"Sinh hoat");
        Vietnamese vn2 = new Vietnamese("VN2","Nguyên văn B",new Date(System.currentTimeMillis()),93,"Sinh hoat");
        Vietnamese vn3 = new Vietnamese("VN3","Nguyên văn C",new Date(System.currentTimeMillis()),113,"Sinh hoat");
        Vietnamese vn4 = new Vietnamese("VN4","Nguyên văn D",new Date(System.currentTimeMillis()),223,"Sinh hoat");
        Foreigner f1 = new Foreigner("Foreigner1","Thomas Editor",new Date(System.currentTimeMillis()),124,"England");
        List<Customer> list = new ArrayList<>();
        list.add(vn1);
        list.add(vn2);
        list.add(vn3);
        list.add(vn4);
        list.add(f1);
        System.out.println("-----");
        for (Customer cus: list
             ) {
            System.out.println("Name: "+cus.getName()+",Total: "+ cus.total());
        }
    }
}
