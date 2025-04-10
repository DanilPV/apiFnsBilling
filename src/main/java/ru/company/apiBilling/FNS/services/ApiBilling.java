package ru.company.apiBilling.FNS.services;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.company.apiBilling.FNS.responseBilling.GetHTTPClient;
import ru.company.apiBilling.FNS.responseBilling.ResponseBilling;
import ru.company.apiBilling.classesError.RestException;

@Service
@RequiredArgsConstructor
public class ApiBilling {

    @Value("${billing.url}")
    private String billingUrl;


    @Value("${billing.keyApi}")
    private String keyApiBilling;



    public boolean checkBillingInn(String inn) {
        ResponseBilling responseBilling;
        GetHTTPClient getHTTPClient = new GetHTTPClient();

        String response = getHTTPClient.getMetod(billingUrl + "?key=" + keyApiBilling + "&inn=" + inn,
                "Не удалось загрузить информацию о выполненных запросов по ИНН из Биллинга!",
                HttpStatus.NOT_FOUND);

        try {
            responseBilling = new Gson().fromJson(response, ResponseBilling.class);
            if(responseBilling.getCode() == 1){
                return true;
            }
        } catch (JsonSyntaxException e) {
            throw new RestException("Ошибка при преобразовании в json", HttpStatus.OK);
        }



        return false;
    }

}
