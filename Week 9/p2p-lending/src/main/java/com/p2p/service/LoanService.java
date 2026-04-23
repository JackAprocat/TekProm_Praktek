package com.p2p.service;

import java.math.BigDecimal;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;

public class LoanService {

    //LOAN CREATION
    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        validateBorrower(borrower);
        validateAmount(amount);

        Loan loan = new Loan(amount);

        if (borrower.getCreditScore() >= 600) {
            loan.approve();
        } else {
            loan.reject();
        }

        return loan;
    }

    // DISBURSEMENT / AKTIVASI
    public void activateLoan(Loan loan) {
        if (loan.getStatus() != Loan.Status.FUNDED) {
            throw new IllegalArgumentException("Loan must be FUNDED before activation");
        }

        loan.activate();
    }

    // REPAYMENT / PEMBAYARAN CICILAN
    public void repayLoan(Loan loan, BigDecimal paymentAmount) {
        if (loan.getStatus() != Loan.Status.ACTIVE) {
            throw new IllegalArgumentException("Loan must be ACTIVE to be repaid");
        }

        loan.repay(paymentAmount);
    }

    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}
