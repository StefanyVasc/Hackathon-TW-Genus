package hackathontw.com.br.hackathontw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import hackathontw.com.br.hackathontw.entity.Usuario;
import hackathontw.com.br.hackathontw.util.Session;
import hackathontw.com.br.hackathontw.util.SharedPrefManager;

/**
 * Created by Uehara on 08/04/2017.
 */
public class CadastroActivity extends AppCompatActivity implements View.OnClickListener{

    private Integer avatar = 0;
    private EditText nome;
    private ImageView cachorineo , gatineo;
    private ImageView cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (EditText) findViewById(R.id.nomeValue);
        cachorineo = (ImageView) findViewById(R.id.cachorineo);
        gatineo = (ImageView) findViewById(R.id.gatineo);
        cadastrar = (ImageView) findViewById(R.id.cadastrar);

        cachorineo.setOnClickListener(this);
        gatineo.setOnClickListener(this);
        cadastrar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cachorineo:
                avatar = 1;
                Log.d("ESCOLHEU O " , " AVATAR 1");
                gatineo.setImageResource(R.drawable.gatineo);
                cachorineo.setImageResource(R.drawable.cachorineo_selecionado);
                break;
            case R.id.gatineo:
                Log.d("ESCOLHEU O " , " AVATAR 2");
                avatar = 2;
                cachorineo.setImageResource(R.drawable.cachorineo);
                gatineo.setImageResource(R.drawable.gatineo_selecionado);

                break;
            case R.id.cadastrar:
                String nomeValue = nome.getText().toString();
                if ( !nomeValue.equals("") && avatar != 0 ){
                    Usuario user = new Usuario();
                    user.setAvatar(avatar);
                    user.setNome(nome.getText().toString());
                    SharedPrefManager.getInstance(getApplicationContext()).saveUserInSharedPref(user);
                    Session.setUsuarioLogado(user);
                    startActivity(new Intent(this, MenuActivity.class));
                    finish();
                }else{
                    if ( nomeValue.equals("") && avatar == 0 ){
                        Toast.makeText(this, "Você precisa digitar seu nome e escolher seu avatar !", Toast.LENGTH_LONG).show();
                    }else  if (nomeValue.equals("")){
                        Toast.makeText(this, "Você precisa digitar seu nome !", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this, "Você precisa escolher seu avatar !", Toast.LENGTH_LONG).show();
                    }
                }
        }
    }
}
