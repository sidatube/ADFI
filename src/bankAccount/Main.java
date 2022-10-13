package bankAccount;

public class Main {
    public static void main(String[] args) {
        Account a = new Account(1, "A User", 50);
        Account b = new Account(2, "B User", 10);
        a.transfer(b, 100);
        System.out.println(a.toString() + "||" + b);
        a.transfer(b, 10);
        System.out.println(a.toString() + "||" + b);
    }
}
