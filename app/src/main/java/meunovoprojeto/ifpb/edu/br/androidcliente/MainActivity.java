package meunovoprojeto.ifpb.edu.br.androidcliente;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttEntreAsyncTask;
    EditText cliNome, cliSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cliNome = (EditText) findViewById(R.id.cliNome);
        cliSenha = (EditText) findViewById(R.id.cliSenha);
        buttEntreAsyncTask = (Button) findViewById(R.id.buttEntreAsyncTask);

        buttEntreAsyncTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.i("AndroidCliente", "Clique no botão da Entrasynctask");

        cliNome = (EditText) findViewById(R.id.cliNome);
        String nome = cliNome.getText().toString();

        cliSenha = (EditText) findViewById(R.id.cliSenha);
        nome = cliSenha.getText().toString();

        Loginasynctask loginAsyncTask = new Loginasynctask (view.getContext());
        String[] valores = {nome};

        loginAsyncTask.execute(valores);
    }


}


