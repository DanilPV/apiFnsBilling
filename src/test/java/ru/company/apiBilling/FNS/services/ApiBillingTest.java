package ru.company.apiBilling.FNS.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.company.apiBilling.FNS.jsonSerializeObject.StatItem;
import ru.company.apiBilling.FNS.jsonSerializeObject.StatResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApiBillingTest {


    @Autowired
    private final ApiBilling apiBilling =  Mockito.mock(ApiBilling.class);

    @Test
    @DisplayName("Get Billing INN")
    public void checkBillingInnTest() throws Exception {

        Boolean apiBillings =   apiBilling.checkBillingInn( "5405331680" );
        assertEquals(true, apiBillings);

    }


    @Test
    @DisplayName("Get Billing is not INN")
    public void checkBillingNotInnTest() throws Exception {

        Boolean apiBillings =  apiBilling.checkBillingInn( "54053316834240" );
        assertEquals(false, apiBillings);

    }

}
