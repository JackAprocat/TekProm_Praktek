package com.p2p.service;

import com.p2p.domain.Lender;
import com.p2p.domain.Loan;

public class FundingService {

    //funding loan
    public void fundLoan(Lender lender, Loan loan) {
        //cuma status APPROVED yang bisa didanai
        if (loan.getStatus() != Loan.Status.APPROVED) {
            throw new IllegalStateException("Hanya pinjaman dengan status APPROVED yang dapat didanai");
        }

        //cek saldo Lender
        if (!lender.hasSufficientBalance(loan.getAmount())) {
            throw new IllegalArgumentException("Saldo Lender tidak mencukupi");
        }

        //kurangi saldo Lender dan ubah status pinjaman menjadi FUNDED
        lender.deductBalance(loan.getAmount());
        loan.fund();
    }
}
