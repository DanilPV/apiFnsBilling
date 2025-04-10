package ru.company.apiBilling.FNS.responseBilling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResponseBilling {

    String status;
    String message;
    int code;
}
