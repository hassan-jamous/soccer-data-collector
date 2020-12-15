package collector;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtil {
    HttpClient client = HttpClient.newHttpClient();

    public String sendGetHttpRequest(String url) {
        String htmlPage = null;

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> httpResponse = this.client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            htmlPage = httpResponse.body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return htmlPage;
    }
}

