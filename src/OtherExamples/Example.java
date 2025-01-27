package OtherExamples;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        List<Account> accounts = List.of(
                new Account(3333, "530012"),
                new Account(15000, "771843"),
                new Account(0, "681891")
        );
        Map<Boolean, List<Account>> accountsByBalance = accounts.stream()
                .collect(Collectors.partitioningBy(account -> account.getBalance() >= 10000));

        for (Map.Entry<Boolean, List<Account>> booleanListEntry : accountsByBalance.entrySet()) {
            System.out.println(booleanListEntry);
        }
    }

}

class Account {
    int balance;
    String number;

    public Account(int balance, String number) {
        this.balance = balance;
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", number='" + number + '\'' +
                '}';
    }
}
