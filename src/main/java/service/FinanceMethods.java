package service;

import repository.FinanceRepository;

public class FinanceMethods {
    private final FinanceRepository financeRepository;

    public FinanceMethods(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    public void showIncomeTable() {

        System.out.println("*** Income Table ***");
        System.out.println();
        financeRepository.getRepoIncomeInfo();

    }


    public void showExpenseTable() {

        financeRepository.getRepoExpenseInfo();

    }

    public void showPaymentTrackingTable() {

        financeRepository.getRepoPaymentTrackingInfo();


    }

}