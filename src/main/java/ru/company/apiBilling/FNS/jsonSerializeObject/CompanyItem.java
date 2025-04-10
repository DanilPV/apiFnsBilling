package ru.company.apiBilling.FNS.jsonSerializeObject;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.company.apiBilling.FNS.jsonSerializeObject.checkCompanyInfo.CompanyInfo;
import ru.company.apiBilling.FNS.jsonSerializeObject.checkCompanyInfo.IndividualEntrepreneurInfo;

@NoArgsConstructor
@Getter
@Setter
public class CompanyItem {


    @SerializedName("ЮЛ")
    private CompanyInfo companyInfo;

    @SerializedName("ИП")
    private IndividualEntrepreneurInfo individualEntrepreneur;

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
