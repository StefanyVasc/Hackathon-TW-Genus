package hackathontw.com.br.hackathontw.components;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import hackathontw.com.br.hackathontw.HistoryActivity;
import hackathontw.com.br.hackathontw.entity.Level;
import hackathontw.com.br.hackathontw.MenuActivity;
import hackathontw.com.br.hackathontw.R;
import hackathontw.com.br.hackathontw.util.Session;
import hackathontw.com.br.hackathontw.util.SharedPrefManager;

/**
 * Created by GilsonDeOliveira on 08/04/2017.
 */

public class EndStageDialog extends Dialog {

    public EndStageDialog(final Context context, int starts, final Integer level)
    {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.end_stage_dialog);

        Integer score = starts;

        ImageView titulo = (ImageView) findViewById(R.id.customTitle);

        ImageView stars = (ImageView) findViewById(R.id.imgFstStar);

        if ( score == 0){
            //titulo.setText(context.getResources().getString(R.string.end_stage_fail));
            titulo.setImageResource(R.drawable.fase_falha_title);
            stars.setImageResource(R.drawable.icone_nop);
        }else if ( score == 1){
            stars.setImageResource(R.drawable.one_star);
        }else if ( score == 2 ){
            stars.setImageResource(R.drawable.two_stars);
        }else if ( score == 3) {
            stars.setImageResource(R.drawable.three_stars);
        }

        Level levelAtual = Session.getUsuarioLogado().getLevels().get(level - 1);
        Level proximoLevel = Session.getUsuarioLogado().getLevels().get(level);

        Log.d("ATUAL SCORE", levelAtual.getScore() +" vai virar " + score );
        if (score > levelAtual.getScore() ) {
            levelAtual.setScore(score);
            Session.getUsuarioLogado().getLevels().set(level - 1, levelAtual);
        }

        //Verifica se o próximo nível está desbloqueado para poder modifica-lo
        if (proximoLevel.getLocked() && score > 0) {
            proximoLevel.setLocked(false);
            Session.getUsuarioLogado().getLevels().set(level, proximoLevel);
        }

        SharedPrefManager.getInstance(getContext()).saveUserInSharedPref(Session.getUsuarioLogado());

        ImageView dialogButtonAgain = (ImageView) this.findViewById(R.id.dialogButtonAgain);
        dialogButtonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(context, HistoryActivity.class);

                menu.putExtra("level", level);
                menu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(menu);
            }
        });

        ImageView dialogButton = (ImageView) this.findViewById(R.id.dialogButtonOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menu = new Intent(context, MenuActivity.class);
                menu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(menu);
            }
        });

        this.setCancelable(false);
    }
}