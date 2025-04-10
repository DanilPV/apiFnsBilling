package ru.company.apiBilling.FNS.responseBilling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import ru.company.apiBilling.classesError.RestException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class GetHTTPClientTest {

    GetHTTPClient getHTTPClient = new GetHTTPClient();

    @Autowired
    @Value("${billing.url}")
    private String billingUrl;

    @Autowired
    @Value("${billing.keyApi}")
    private String keyApiBilling;




    @Test
    @DisplayName("Get URL")
    public void getMetodTest() throws Exception{


        assertEquals(
                 "{\"status\":\"Сбой\",\"message\":\"Запрос был выполнен ранее\",\"code\":1}" ,
                getHTTPClient.getMetod(billingUrl + "api/main/checkFnsInn?key=" + keyApiBilling + "&inn=5405331680"  ,
                        "Не удалось загрузить информацию о выполненных запросов по ИНН из Биллинга!",
                        HttpStatus.NOT_FOUND)
        );
    }


    @Test
    @DisplayName("Get URL Error URL")
    public void getMetodErrorURLTest() throws Exception{


        assertThrows(  RestException.class ,
                () -> { getHTTPClient.getMetod( " 32eapi/main/checkFnsInn?key=" + keyApiBilling + "&inn=5405331680"  ,
                        "Не удалось загрузить информацию о выполненных запросов по ИНН из Биллинга!",
                        HttpStatus.NOT_FOUND);}
        );


    }
}
