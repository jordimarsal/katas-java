package net.jordimp.katas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Balance {

    private Double amount;
    private String phone_number;
    private String currency;
    private String expiration_date;

}

