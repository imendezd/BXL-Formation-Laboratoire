package be.bxl.formation.labo_final.helpers;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestHelper {

    private RequestHelper() {
    }

    public static JSONObject sendRequestGet(String url) {
        JSONObject response = null;
        HttpURLConnection connection = null;

        try {
            // Create the url
            URL target = new URL(url);

            // Send the request
            connection = (HttpURLConnection) target.openConnection();
            connection.connect();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return null;
            }

            // Read data recived
            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
            reader.close();
            streamReader.close();

            response = new JSONObject(data.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
                connection.disconnect();
            }
        }

        return response;
    }
}
