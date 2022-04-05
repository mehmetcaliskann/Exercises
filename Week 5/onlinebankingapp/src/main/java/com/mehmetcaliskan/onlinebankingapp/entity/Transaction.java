package com.mehmetcaliskan.onlinebankingapp.entity;

import com.mehmetcaliskan.onlinebankingapp.validator.TcKimlikNo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Transaction {
    @TcKimlikNo
    private String senderTcKimlikNo;
    @TcKimlikNo
    private String receiverTcKimlikNo;
    private LocalDateTime performedAt;
    @Min(value = 0, message = "Amount must be greater than 0")
    private BigDecimal amount;

    public Transaction(String senderTcKimlikNo, String receiverTcKimlikNo, BigDecimal amount) {
        this.senderTcKimlikNo = senderTcKimlikNo;
        this.receiverTcKimlikNo = receiverTcKimlikNo;
        this.amount = amount;
        this.performedAt = LocalDateTime.now();
    }

    public boolean isValid(BigDecimal senderBalance) {
        return senderBalance.compareTo(amount) >= 0;
    }
}
