package phone;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.insertPhone("Banh","0123456789");
        pb.insertPhone("Dau","0987654321");
        pb.insertPhone("An","0123789456");
        pb.insertPhone("Anh","0159487236");
        pb.insertPhone("Cuong","0963852741");
        pb.insertPhone("Cuong","0741852963");
        System.out.println(pb);
        pb.removePhone("An");
        System.out.println(pb);
        pb.searchPhone("Dau");
        pb.updatePhone("Cuong","0963852741","0369258147");
        System.out.println(pb);
        pb.sort();
        System.out.println(pb);

    }
}
