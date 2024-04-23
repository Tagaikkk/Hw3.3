class LimitException extends Exception {
    private double remainingAmount;

    public LimitException(String message, double remainingAmount) {
        super(message);
        this.remainingAmount = remainingAmount;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }
}

// b) Класс BankAccount
class BankAccount {
    private double amount;

    public BankAccount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        amount += sum;
        System.out.println("Пополнение на " + sum + " сом. Текущий остаток: " + amount + " сом.");
    }

    public void withdraw(double sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Недостаточно средств на счете", amount);
        }
        amount -= sum;
        System.out.println("Снятие " + sum + " сом. Текущий остаток: " + amount + " сом.");
    }
}