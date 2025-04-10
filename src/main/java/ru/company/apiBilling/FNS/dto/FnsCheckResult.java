package ru.company.apiBilling.FNS.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FnsCheckResult {

    private String inn;
    private String ogrn;
    private String fullName;
    private String ogrnDate;
    private String status;
    private String fullAddress;
    private String mainActivity;
    private String foundIn;
    private String terminationDate;
    private String countCheck;

}
