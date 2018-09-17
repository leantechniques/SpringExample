package payroll;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResponseResults {

    private final ClientHttpResponse response;
    private JSONObject json;

    ResponseResults(final ClientHttpResponse response) throws IOException {
        this.response = response;

        final InputStream bodyInputStream = response.getBody();

        BufferedReader streamReader = new BufferedReader(new InputStreamReader(bodyInputStream, "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();

        String inputStr;
        while ((inputStr = streamReader.readLine()) != null)
            responseStrBuilder.append(inputStr);

        try {
            json = new JSONObject(responseStrBuilder.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            json = null;
        }
    }

    public ClientHttpResponse getResponse() {
        return response;
    }

    public JSONObject getJson() {
        return json;
    }
}
