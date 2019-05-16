package hackathontw.com.br.hackathontw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;

import hackathontw.com.br.hackathontw.entity.Level;
import hackathontw.com.br.hackathontw.entity.Usuario;
import hackathontw.com.br.hackathontw.util.Session;

/**
 * Created by Uehara on 08/04/2017.
 */
public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView level1,level2,level3,level4,level5,level6,level7,level8,level9;
    private ArrayList<ImageView> levels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        level1 = (ImageView) findViewById(R.id.level1);
        level2 = (ImageView) findViewById(R.id.level2);
        level3 = (ImageView) findViewById(R.id.level3);
        level4 = (ImageView) findViewById(R.id.level4);
        level5 = (ImageView) findViewById(R.id.level5);
        level6 = (ImageView) findViewById(R.id.level6);
        level7 = (ImageView) findViewById(R.id.level7);
        level8 = (ImageView) findViewById(R.id.level8);
        level9 = (ImageView) findViewById(R.id.level9);

        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        levels.add(level5);
        levels.add(level6);
        levels.add(level7);
        levels.add(level8);
        levels.add(level9);

        Usuario objetoUsuario = Session.getUsuarioLogado();
        ArrayList<Level> levelsUsuario = objetoUsuario.getLevels();
        for (int i = 0 ; i < levelsUsuario.size() ; i++){

            if ( ! levelsUsuario.get(i).getLocked() ){

                levels.get(i).setOnClickListener(this);

                if (levelsUsuario.get(i).getScore() == 1 ){
                    levels.get(i).setImageResource(R.drawable.one_star);
                }
                else if (levelsUsuario.get(i).getScore() == 2 ){
                    levels.get(i).setImageResource(R.drawable.two_stars);
                }
                else if (levelsUsuario.get(i).getScore() == 3 ){
                    levels.get(i).setImageResource(R.drawable.three_stars);
                }
            }else{
                levels.get(i).setImageResource(R.drawable.locked);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent history = new Intent(this, HistoryActivity.class);
        switch (v.getId()){
            case R.id.level1:
                history.putExtra("level", 1);
                startActivity(history);
                break;
            case R.id.level2:
                history.putExtra("level", 2);
                startActivity(history);
                break;
            case R.id.level3:
                history.putExtra("level", 3);
                startActivity(history);
                break;
            case R.id.level4:
                history.putExtra("level", 4);
                startActivity(history);
                break;
            case R.id.level5:
                history.putExtra("level", 5);
                startActivity(history);
                break;
            case R.id.level6:
                history.putExtra("level", 6);
                startActivity(history);
                break;
            case R.id.level7:
                history.putExtra("level", 7);
                startActivity(history);
                break;
            case R.id.level8:
                history.putExtra("level", 8);
                startActivity(history);
                break;
            case R.id.level9:
                history.putExtra("level", 9);
                startActivity(history);
                break;
        }


    }
}
