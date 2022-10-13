package bankAccount;

public class Account {
    private int id;
    private String name;
    private int balance = 0;

    public Account() {
    }

    public Account(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.balance = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void credit(int amount) {
        if (checkAmount(amount))
            this.balance += amount;
    }

    private boolean checkAmount(int amount) {
        if (amount <= 0) {
            System.out.println("Số tiền nhỏ hơn 0");
            return false;
        }
        return true;
    }

    private boolean checkBalance(int amount) {
        if (this.balance < amount) {
            return false;
        }
        return true;
    }

    public boolean debit(int amount) {
        if (!checkAmount(amount)) {
            System.out.println("Số tiền nhỏ hơn 0");
            return false;
        }
        if (!checkBalance(amount)) {
            System.out.println("Thanh toán không thành công");
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public void transfer(Account b, int amount) {
        if (!checkAmount(amount)) {
            System.out.println("Số tiền nhỏ hơn 0");
            return ;
        }
        if (!checkBalance(amount)) {
            System.out.println("Chuyển khoản không thành công");
            return ;
        }
        this.debit(amount);
        b.credit(amount);
        System.out.println("Chuyển khoản thành công");
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
