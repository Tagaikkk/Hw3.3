public class Main {
    public static void main(String[] args) {
        // Создание счета клиента и пополнение на 15 000 сом
        BankAccount account = new BankAccount(15000);

        try {
            // e) Бесконечный цикл с попыткой снятия по 6000 сом
            while (true) {
                account.withdraw(6000);
            }
        } catch (LimitException e) {
            // Обработка исключения LimitException
            System.out.println("Исключение: " + e.getMessage());
            System.out.println("Снятие доступной суммы: " + e.getRemainingAmount() + " сом.");
            // Снятие оставшейся доступной суммы
            try {
                account.withdraw(e.getRemainingAmount());
            } catch (LimitException ex) {
                System.out.println("Не удалось снять доступную сумму.");
            }
        }
    }
}