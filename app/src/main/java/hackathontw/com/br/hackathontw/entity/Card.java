package hackathontw.com.br.hackathontw.entity;

/**
 * Created by rblb on 4/8/17.
 */

public class Card {
    private int mResDrawableCard;
    private String mText;
    private String feedBackMessage;


    private boolean mAnswer;

    public Card(){}

    public Card(int resDrawableCard, String text, boolean answer, String feedBackMessage){
        this.mResDrawableCard = resDrawableCard;
        this.mText = text;
        this.mAnswer =  answer;
        this.feedBackMessage = feedBackMessage;

    }

    public int getmResDrawableCard() {
        return mResDrawableCard;
    }

    public void setmResDrawableCard(int mResDrawableCard) {
        this.mResDrawableCard = mResDrawableCard;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public String getFeedBackMessage() {
        return feedBackMessage;
    }

    public void setFeedBackMessage(String feedBackMessage) {
        this.feedBackMessage = feedBackMessage;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }

    public int getResDrawableCard(){
        return mResDrawableCard;
    }

    public String getText(){
        return mText;
    }

    public boolean getAnswer(){
        return mAnswer;
    }
}
