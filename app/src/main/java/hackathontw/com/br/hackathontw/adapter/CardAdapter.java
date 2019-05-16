package hackathontw.com.br.hackathontw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import hackathontw.com.br.hackathontw.R;
import hackathontw.com.br.hackathontw.entity.Card;

/**
 * Created by rblb on 4/8/17.
 */

public class CardAdapter extends BaseAdapter {

    private List<Card> mList;
    private Context mContext;
    private ViewHolder viewHolder;

    public CardAdapter(Context context, List<Card> list){
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.background = (FrameLayout) view.findViewById(R.id.background);
            viewHolder.card = (ImageView) view.findViewById(R.id.card_image);
            viewHolder.card_text = (TextView) view.findViewById(R.id.card_text);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Glide.with(mContext).load(mList.get(position).getResDrawableCard()).into(viewHolder.card);

        viewHolder.card_text.setText(mList.get(position).getText());

        return view;
    }

    public class ViewHolder{
        public FrameLayout background;
        public ImageView card;
        public TextView card_text;
    }
}
