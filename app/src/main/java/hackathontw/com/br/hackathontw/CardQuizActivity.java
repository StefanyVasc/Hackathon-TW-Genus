package hackathontw.com.br.hackathontw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import hackathontw.com.br.hackathontw.adapter.CardAdapter;
import hackathontw.com.br.hackathontw.components.FeedbackDialog;
import hackathontw.com.br.hackathontw.entity.Card;

/**
 * Created by rblb on 4/8/17.
 */

public class CardQuizActivity extends AppCompatActivity {
    private CardAdapter mAdapter;
    private ArrayList<Card> mCardList;
    private SwipeFlingAdapterView mFlingContainer;
    private int mScore = 0;
    private Integer level;
    private int stars = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_quiz);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                level = null;
            } else {
                level = extras.getInt("level");
            }
        } else {
            level = (Integer) savedInstanceState.getSerializable("level");
        }

        populateCardList(level);

        mFlingContainer = (SwipeFlingAdapterView) findViewById(R.id.swipe_frame);

        mAdapter = new CardAdapter(this, mCardList);
        mFlingContainer.setAdapter(mAdapter);
        mFlingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
            }

            @Override
            public void onLeftCardExit(Object o) {
                String feedBackMessage = mCardList.get(0).getFeedBackMessage();
                mCardList.remove(0);
                mAdapter.notifyDataSetChanged();
                Card card = (Card) o;
                FeedbackDialog dialog;
                if (card.getAnswer()) {
                    if(mCardList.isEmpty()){
                        calculateStars();
                    }
                    dialog = new FeedbackDialog(CardQuizActivity.this, false, stars, level,feedBackMessage);
                    dialog.show();
                } else {
                    mScore += 1;
                    if(mCardList.isEmpty()){
                        calculateStars();
                    }
                    dialog = new FeedbackDialog(CardQuizActivity.this, true, stars, level,feedBackMessage);
                    dialog.show();
                }
                if (mCardList.isEmpty()) {
                    Toast.makeText(CardQuizActivity.this, "Score: " + mScore, Toast.LENGTH_SHORT).show();
                    //TODO:finish level
                }
            }


            @Override
            public void onRightCardExit(Object o) {
                String feedBackMessage = mCardList.get(0).getFeedBackMessage();
                mCardList.remove(0);
                mAdapter.notifyDataSetChanged();
                Card card = (Card) o;
                FeedbackDialog dialog;
                if (card.getAnswer()) {
                    mScore += 1;
                    if(mCardList.isEmpty()){
                        calculateStars();
                    }
                    dialog = new FeedbackDialog(CardQuizActivity.this, true, stars, level,feedBackMessage);
                    dialog.show();
                } else {
                    if(mCardList.isEmpty()){
                        calculateStars();
                    }
                    dialog = new FeedbackDialog(CardQuizActivity.this, false, stars, level,feedBackMessage);
                    dialog.show();
                }
                if (mCardList.isEmpty()) {
                    Toast.makeText(CardQuizActivity.this, "Score: " + mScore, Toast.LENGTH_SHORT).show();
                    //TODO: finish level
                }
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
            }

            @Override
            public void onScroll(float scrollPercent) {
                View view = mFlingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);
                view.findViewById(R.id.item_left).setAlpha(scrollPercent < 0 ? -scrollPercent : 0);
                view.findViewById(R.id.item_right).setAlpha(scrollPercent > 0 ? scrollPercent : 0);
            }
        });

        mFlingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int i, Object o) {
                View view = mFlingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);

                mAdapter.notifyDataSetChanged();
            }
        });

    }

    private void calculateStars() {
        if (mScore == 3) {
            stars = 1;
        } else if (mScore == 4) {
            stars = 2;
        } else if (mScore >= 5) {
            stars = 3;
        }else{
            stars = 0;
        }
    }

    private void populateCardList(Integer level) {
        mCardList = new ArrayList<>();

        switch (level) {
            case 1:
                mCardList.add(new Card(R.drawable.desafio1_card1, "Meninas não podem brincar com brinquedos de meninos!", false, "Opa você errou! As meninas podem brincar com os brinquedos de meninos, assim como meninos podem brincar com brinquedos de meninas."));
                mCardList.add(new Card(R.drawable.desafio1_card2, "Meninos e meninas não podem gostas das mesmas coisas!", false, "Opa você errou! Meninos e meninas podem sim gostar das mesmas coisas!"));
                mCardList.add(new Card(R.drawable.desafio1_card3, "Meninas podem gostar de azul!", true, "As meninas podem gostar de qualquer cor que quiserem, inclusive a cor azul!"));
                mCardList.add(new Card(R.drawable.desafio1_card4, "Meninas podem jogar bola!", true,"As meninas podem praticar qualquer esporte, inclusive jogar bola!"));
                mCardList.add(new Card(R.drawable.desafio1_card5, "Meninos podem brincar com bonecas!", true, "Meninos podem brincar com qualquer brinquedo que eles queiram, inclusive bonecas."));
                mCardList.add(new Card(R.drawable.desafio1_card6, "Meninos podem brincar com coisas de meninas e vice-versa!", true, "Meninos e meninas podem sim brincar com qualquer coisa que eles queiram."));
                break;
            case 2:
                mCardList.add(new Card(R.drawable.desafio2_card1, "Mulheres não podem assumir cargos importantes!", false, "Ihh você errou! As mulheres podem e são capazes de assumir qualquer tipo de cargo!"));
                mCardList.add(new Card(R.drawable.desafio2_card2, "Mulheres são incapazes de executar certas tarefas!", false, "Ihh você errou! As mulheres podem executar qualquer tipo de tarefa, basta elas quererem!"));
                mCardList.add(new Card(R.drawable.desafio2_card3, "Mulheres podem preencher cargos altos, perigosos e complicados!", true, "Mulheres podem  preencher qualquer tipo de cargos que elas desejem."));
                mCardList.add(new Card(R.drawable.desafio2_card4, "Mulheres estão participando do mercado de trabalho.", true, "As mulheres estão cada vez participando mais do mercado de trabalho."));
                mCardList.add(new Card(R.drawable.desafio2_card5, "As mulheres podem ser o que quiserem, mas os homens não.", false, "Ihh você errou! Assim como as mulheres os homens pode ser o que desejarem ser!"));
                break;
            default:
                break;
        }

        long seed = System.nanoTime();
        Collections.shuffle(mCardList, new Random(seed));
    }
}
