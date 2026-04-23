package com.p2p.service;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;

public class LoanServiceTest {

    private LoanService loanService;

    @BeforeEach
    void setUp() {
        loanService = new LoanService();
    }

    // ============================================
    // A. LOAN CREATION
    // ============================================
    @Test // TC-01
    void shouldRejectLoanWhenBorrowerNotVerified() {
        Borrower borrower = new Borrower(false, 700);
        BigDecimal amount = BigDecimal.valueOf(1000);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
        assertEquals("Borrower not verified", exception.getMessage());
    }

    @Test // TC-02
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        Borrower borrower = new Borrower(true, 700);

        assertThrows(IllegalArgumentException.class, ()
                -> loanService.createLoan(borrower, BigDecimal.ZERO));

        assertThrows(IllegalArgumentException.class, ()
                -> loanService.createLoan(borrower, BigDecimal.valueOf(-100)));
    }

    @Test // TC-03
    void shouldApproveLoanWhenCreditScoreHigh() {
        Borrower borrower = new Borrower(true, 650);
        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    @Test // TC-04
    void shouldRejectLoanWhenCreditScoreLow() {
        Borrower borrower = new Borrower(true, 500);
        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }

    // ============================================
    // C. DISBURSEMENT (ACTIVATION)
    // ============================================
    @Test // TC-08
    void shouldNotActivateLoanIfNotFunded() {
        Borrower borrower = new Borrower(true, 700);
        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));
        // Status saat ini APPROVED, bukannya FUNDED

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.activateLoan(loan);
        });
    }

    @Test // TC-09
    void shouldActivateLoanWhenFunded() {
        Borrower borrower = new Borrower(true, 700);
        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));
        loan.fund(); // simulasi didanai

        loanService.activateLoan(loan);
        assertEquals(Loan.Status.ACTIVE, loan.getStatus());
    }

    // ============================================
    // D. REPAYMENT
    // ============================================
    @Test // TC-10
    void shouldAllowRepaymentWhenLoanActive() {
        Borrower borrower = new Borrower(true, 700);
        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));
        loan.fund();
        loanService.activateLoan(loan);

        loanService.repayLoan(loan, BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(500), loan.getOutstanding());
    }

    @Test // TC-11
    void shouldRejectRepaymentWhenAmountInvalid() {
        Borrower borrower = new Borrower(true, 700);
        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));
        loan.fund();
        loanService.activateLoan(loan);

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.repayLoan(loan, BigDecimal.ZERO);
        });
    }

    @Test // TC-12
    void shouldReduceOutstandingWhenRepay() {
        Borrower borrower = new Borrower(true, 700);
        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));
        loan.fund();
        loanService.activateLoan(loan);

        loanService.repayLoan(loan, BigDecimal.valueOf(300));
        assertEquals(BigDecimal.valueOf(700), loan.getOutstanding());
    }

    @Test // TC-13
    void shouldCompleteLoanWhenOutstandingZero() {
        Borrower borrower = new Borrower(true, 700);
        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));
        loan.fund();
        loanService.activateLoan(loan);

        loanService.repayLoan(loan, BigDecimal.valueOf(1000)); // Lunas

        assertEquals(BigDecimal.ZERO, loan.getOutstanding());
        assertEquals(Loan.Status.COMPLETED, loan.getStatus());
    }
}
