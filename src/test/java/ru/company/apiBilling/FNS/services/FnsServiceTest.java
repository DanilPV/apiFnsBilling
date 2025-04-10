package ru.company.apiBilling.FNS.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.company.apiBilling.FNS.jsonSerializeObject.StatItem;
import ru.company.apiBilling.FNS.jsonSerializeObject.StatResponse;
import ru.company.apiBilling.classesError.RestException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@AutoConfigureMockMvc
public class FnsServiceTest {


    @Autowired
    private final FnsService fnsService =  Mockito.mock(FnsService.class);


    @Value("${accept.key}")
    private String keyFns;

    @Test
    @DisplayName("Get stat FNS error Key")
    public void getStatErrorKeyTest() throws Exception {

        assertThrows(  RestException.class  ,
                () -> {  fnsService.getStat( "c9826еуну654нук832g3" );}
        );

    }

    @Test
    @DisplayName("Get stat FNS")
    public void getStatTest() throws Exception {
        System.out.println(keyFns);
        StatResponse statResponse =   fnsService.getStat( keyFns );
        assertEquals(StatItem.class, statResponse.getMethodList().get("search").getClass());

    }
}
