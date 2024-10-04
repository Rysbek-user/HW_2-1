public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);

        try {
            while (true) {
                try {
                    account.withDraw(6000);
                    System.out.println("Успешно снято 6000 сом. Остаток: " + account.getAmount());
                } catch (LimitException e) {
                    System.out.println(e.getMessage() + " Остаток: " + e.getRemainingAmount());
                    account.withDraw((int) e.getRemainingAmount());
                    System.out.println("Успешно снято остаток. Остаток: " + account.getAmount());
                    break;
                }
            }
        } catch (LimitException e) {
            e.printStackTrace();
        }
    }
}

