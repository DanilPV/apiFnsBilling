package ru.company.apiBilling.FNS.services;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.company.apiBilling.FNS.dto.FnsCheckResult;
import ru.company.apiBilling.FNS.responseBilling.GetHTTPClient;
import ru.company.apiBilling.classesError.RestException;
import ru.company.apiBilling.FNS.jsonSerializeObject.CompanyResponse;
import ru.company.apiBilling.FNS.jsonSerializeObject.StatResponse;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FnsService {

    private boolean debug = false;

    @Value("${fns.key}")
    private String keyFns;

    @Value("${fns.url}")
    private String fnsUrl;

    @Value("${accept.key}")
    private String acceptKey;

    @Autowired
    ApiBilling apiBilling = new ApiBilling();

    GetHTTPClient getHTTPClient = new GetHTTPClient();

    public FnsCheckResult getByInn(String inn,String key) {

        if (inn.length() != 10 && inn.length() != 12) {
            throw new RestException("Не верный ИНН.", HttpStatus.OK);
        }

        if(!Objects.equals(key, acceptKey)){
            throw new RestException("Отказано в доступе!", HttpStatus.OK);
        }

        if(inn.equals("000000000")){//
            debug = true;
        }

        CompanyResponse itemsCompanyResult;
        StatResponse stat = getStat(acceptKey);

        if (apiBilling.checkBillingInn(inn) & !debug) {
            throw new RestException("Запрос по данному ИНН уже выполнен.", HttpStatus.OK);
        }

        if (stat.getMethodList().isEmpty()) {
            throw new RestException("Лимит Запросов на проверку истрачен.", HttpStatus.OK);
        }


        int countSearch = stat.getMethodList().get("search").getSpent();
        int countLimit = stat.getMethodList().get("search").getLimit();

        if (countSearch < countLimit) {
            String response;

            response = getHTTPClient.getMetod(fnsUrl + "search?key=" + keyFns + "&page=1&q=" + inn,
                        "Не удалось загрузить информацию о Компании.",
                        HttpStatus.NOT_FOUND);

            try {

                itemsCompanyResult = new Gson().fromJson(response, CompanyResponse.class);

            } catch (JsonSyntaxException e) {

                throw new RestException("Не верный ответ." + response, HttpStatus.OK);

            }



        } else {
            throw new RestException("Лимит Запросов на проверку истрачен.", HttpStatus.OK);
        }

        if (itemsCompanyResult.getCount() == 0){
            throw new RestException("Такой ИНН не найден.", HttpStatus.OK);
        }

        return itemsCompanyResult.convertToCheckResult(itemsCompanyResult, countSearch + 1);
    }



    public StatResponse getStat(String key) {

        if(!Objects.equals(key, acceptKey)){
            throw new RestException("Отказано в доступе!", HttpStatus.OK);
        }

        StatResponse statResponse  ;


        String response = getHTTPClient.getMetod(fnsUrl + "stat?key=" + keyFns,
                "Не удалось загрузить статистику.",
                HttpStatus.NOT_FOUND);
        statResponse = new Gson().fromJson(response, StatResponse.class);

        return statResponse;

    }
}
