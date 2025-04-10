package ru.company.apiBilling.FNS.jsonSerializeObject.checkCompanyInfo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CompanyInfo {

    @SerializedName("ИНН")
    private String inn;

    @SerializedName("ОГРН")
    private String ogrn;

    @SerializedName("НаимСокрЮЛ")
    private String shortName;

    @SerializedName("НаимПолнЮЛ")
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


//    {
//        "items": [
//        {
//            "ИП": {
//                    "ИНН": "424001226516",
//                    "ОГРН": "312421219300029",
//                    "ФИОПолн": "Козлова Фаина Леонтьевна",
//                    "ДатаОГРН": "2012-07-11",
//                    "Статус": "Прекратило деятельность",
//                    "ДатаПрекр": "2013-01-09",
//                    "АдресПолн": null,
//                    "ОснВидДеят": "Розничная торговля в неспециализированных магазинах преимущественно  пищевыми продуктами, включая напитки, и табачными изделиями",
//                    "ГдеНайдено": "ИННИП"
//        }
//        }
//    ],
//        "Count": 1
//    }

//    {
//        "items": [
//        {
//            "ЮЛ": {
//            "ИНН": "5405331680",
//                    "ОГРН": "1065405137390",
//                    "НаимСокрЮЛ": "АО \"СТ\"",
//                    "НаимПолнЮЛ": "АКЦИОНЕРНОЕ ОБЩЕСТВО \"СИСТЕМЫ ТЕЛЕКОМ\"",
//                    "ДатаОГРН": "2006-11-29",
//                    "Статус": "Действующее",
//                    "АдресПолн": "обл. Новосибирская, г. Новосибирск, ул. Орджоникидзе, д.47, оф.108",
//                    "ОснВидДеят": "Деятельность по предоставлению услуг телефонной связи",
//                    "ГдеНайдено": "ИНН"
//        }
//        }
//    ],
//        "Count": 1
//    }
}
