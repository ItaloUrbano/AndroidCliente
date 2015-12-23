package meunovoprojeto.ifpb.edu.br.androidcliente;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

/**
 * Created by Ultrabook Dell on 23/12/2015.
 */
public class Loginasynctask extends AsyncTask <String, Void, Response> {

    Context context;

    public Loginasynctask(Context activity) {

        this.context = activity;
    }
    @Override
    protected void onPreExecute() {

        Log.i("AndroidCliente", "OnPreExecute");
    }

    @Override
    protected Response doInBackground(String... valores) {
        Log.i("AndroidCliente", "doInBackground: " + valores[0]);

        Response response = null;
        HttpURLConnection connection = null;

        try {

            connection = HttpService.sendGetRequest("servicoservlet");

            int statusCodeHttp = connection.getResponseCode();
            String contentValue = HttpService.getHttpContent(connection);

            response = new Response(statusCodeHttp, contentValue);

        } catch (MalformedURLException ex) {

            Log.e("AndroidCliente","MalformedURLException");

        } catch (IOException ex) {

            Log.e("AndroidCliente","MalformedURLException");

        } finally {

            connection.disconnect();
        }

        return response;
    }
    @Override
    protected void onPostExecute(Response response) {

        try {

            int status = response.getStatusCodeHttp();

            if (status == HttpURLConnection.HTTP_OK) {

                JSONObject json = new JSONObject(response.getContentValue());

                String nome = json.getString("nome");
                Log.i("AndroidCliente", "Nome: " + nome);
                Toast.makeText(context, nome, Toast.LENGTH_LONG).show();

                String senha = json.getString("senha");
                Log.i("AndroidCliente", "Senha: " + senha);
                Toast.makeText(context, senha, Toast.LENGTH_LONG).show();

            }

        } catch (JSONException e) {

            Log.e("AndroidClientep", "JSONException: " + e);
        }
    }
}