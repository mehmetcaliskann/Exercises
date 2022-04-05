package com.mehmetcaliskan.onlinebankingapp.entity;

import com.mehmetcaliskan.onlinebankingapp.validator.TcKimlikNo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class User {
    @TcKimlikNo
    private String tcKimlikNo;

    @Size(min = 6, max = 64, message = "Şifre geçersiz!")
    private String password;

    private LocalDate birthDate;
    private BigDecimal balance;

    public boolean isPasswordValid() {
        String birthDateStr = birthDate.toString();
        String birthDateWithoutMinus = birthDateStr.replace("-", "");

        return !password.contains(birthDateStr) && !password.contains(birthDateWithoutMinus);
    }
}
