package me.chip.bank.Bank;

public class ChipBank implements Bank {

    final String bankName;
    final String bankId;

    public ChipBank(String bankName, String bankId) {
        this.bankName = bankName;
        this.bankId = bankId;
    }

    @Override
    public String getBankName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'getBankName'"
        );
    }

    @Override
    public String getBankID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'getBankID'"
        );
    }

    @Override
    public String register(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'register'"
        );
    }

    @Override
    public void deposit(String accountId, double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'deposit'"
        );
    }

    @Override
    public double withdraw(String accountId, double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'withdraw'"
        );
    }

    @Override
    public boolean transfer(
        String fromAccountId,
        String toAccountId,
        String toBankId,
        double amount
    ) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'transfer'"
        );
    }

    @Override
    public boolean closeAccount(String accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'closeAccount'"
        );
    }
}
