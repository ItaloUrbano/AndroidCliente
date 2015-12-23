package meunovoprojeto.ifpb.edu.br.androidcliente;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Ultrabook Dell on 23/12/2015.
 */
public class HttpService {

    private static final String URL_CONTEXT = "http://192.168.253.56:8080/rest-servlet-service/";

    public static HttpURLConnection sendGetRequest(String service)
            throws MalformedURLException, IOException {

        HttpURLConnection connection = null;

        URL url = new URL(URL_CONTEXT + service);

        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        return connection;
    }
    public void sendJsonPostRequest(String service, JSONObject json) {
        //TODO: Implementar conexão com o Servidor REST.
    }

    public static String getHttpContent(HttpURLConnection connection) {

        StringBuilder builder = new StringBuilder();

        try {

            InputStream content = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    content, "iso-8859-1"), 8);

            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            content.close();

        } catch (IOException e) {

            Log.e("AndroidCliente", "IOException: " + e);
        }

        return builder.toString();
    }
}
