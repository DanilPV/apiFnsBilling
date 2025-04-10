package ru.company.apiBilling.FNS.jsonSerializeObject.checkCompanyInfo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class IndividualEntrepreneurInfo {

    @SerializedName("ИНН")
    private String inn;

    @SerializedName("ОГРН")
    private String ogrn;

    @SerializedName("ФИОПолн")
    private String fullName;

    @SerializedName("ДатаОГРН")
    private String ogrnDate;

    @SerializedName("Статус")
    private String status;

    @SerializedName("ДатаПрекр")
    private String terminationDate;

    @SerializedName("АдресПолн")
    private String fullAddress;

    @SerializedName("ОснВидДеят")
    private String mainActivity;

    @SerializedName("ГдеНайдено")
    private String foundIn;

}
