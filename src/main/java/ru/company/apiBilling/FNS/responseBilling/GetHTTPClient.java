package ru.company.apiBilling.FNS.responseBilling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import ru.company.apiBilling.FNS.services.FnsService;
import ru.company.apiBilling.classesError.RestException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

@NoArgsConstructor
@Getter
@Setter
public class GetHTTPClient {

    public String getMetod(String url, String error, HttpStatus httpStatus){

        String response;

        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> responseCompany = client.send(request, HttpResponse.BodyHandlers.ofString());
            response = responseCompany.body();

        } catch (Exception e) {
            Logger.getLogger(GetHTTPClient.class.getName()).info(e.getMessage());
            throw new RestException(error, httpStatus);
        }

        return response;
    }

}
