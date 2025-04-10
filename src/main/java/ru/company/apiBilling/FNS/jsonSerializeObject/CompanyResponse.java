package ru.company.apiBilling.FNS.jsonSerializeObject;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.company.apiBilling.FNS.dto.FnsCheckResult;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CompanyResponse {

    @SerializedName("items")
    private List<CompanyItem> items;

    @SerializedName("Count")
    private int count;

    public FnsCheckResult convertToCheckResult(CompanyResponse companyResponse,int countCheck){
        FnsCheckResult checkResult = new FnsCheckResult();
        checkResult.setCountCheck(String.valueOf(countCheck));
        if ( companyResponse.getItems().getFirst().getIndividualEntrepreneur() != null) {

            checkResult.setInn(companyResponse.getItems().getFirst().getIndividualEntrepreneur().getInn());
            checkResult.setOgrn(companyResponse.getItems().getFirst().getIndividualEntrepreneur().getOgrn());
            checkResult.setFullName(companyResponse.getItems().getFirst().getIndividualEntrepreneur().getFullName());
            checkResult.setOgrnDate(companyResponse.getItems().getFirst().getIndividualEntrepreneur().getOgrnDate());
            checkResult.setStatus(companyResponse.getItems().getFirst().getIndividualEntrepreneur().getStatus());
            checkResult.setFullAddress(companyResponse.getItems().getFirst().getIndividualEntrepreneur().getFullAddress());
            checkResult.setMainActivity(companyResponse.getItems().getFirst().getIndividualEntrepreneur().getMainActivity());
            checkResult.setTerminationDate(companyResponse.getItems().getFirst().getIndividualEntrepreneur().getTerminationDate());
            checkResult.setFoundIn(companyResponse.getItems().getFirst().getIndividualEntrepreneur().getFoundIn());

        }
        if ( companyResponse.getItems().getFirst().getCompanyInfo() != null) {

            checkResult.setInn(companyResponse.getItems().getFirst().getCompanyInfo().getInn());
            checkResult.setOgrn(companyResponse.getItems().getFirst().getCompanyInfo().getOgrn());
            checkResult.setFullName(companyResponse.getItems().getFirst().getCompanyInfo().getFullName());
            checkResult.setOgrnDate(companyResponse.getItems().getFirst().getCompanyInfo().getOgrnDate());
            checkResult.setStatus(companyResponse.getItems().getFirst().getCompanyInfo().getStatus());
            checkResult.setFullAddress(companyResponse.getItems().getFirst().getCompanyInfo().getFullAddress());
            checkResult.setMainActivity(companyResponse.getItems().getFirst().getCompanyInfo().getMainActivity());
            checkResult.setTerminationDate(companyResponse.getItems().getFirst().getCompanyInfo().getTerminationDate());
            checkResult.setFoundIn(companyResponse.getItems().getFirst().getCompanyInfo().getFoundIn());

        }


        return checkResult;
    }
}
