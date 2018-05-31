package com.mindorks.bariawala.android.ui.deshboard.FeedFragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehedi on 1/23/17.
 * Modify by Faizul Haque Nayan
 */

public class FeedCardAdapter extends RecyclerView.Adapter<FeedCardAdapter.CardViewHolder> {

    private Context mContext;
    private List<FeedCardData> mProcessData;
    private LayoutInflater inflater;
    private FeedsMvpPresenter mPresenter;

    public FeedCardAdapter(Context context, FeedsMvpPresenter presenter) {
        this.mContext = context;
        this.mPresenter = presenter;
        this.inflater = LayoutInflater.from(mContext);
        mProcessData = new ArrayList<>();
    }

    public void setViewData(List<FeedCardData> processData){
        if(mProcessData != null && mProcessData.size() > 0){
            mProcessData.clear();
        }
        this.mProcessData = processData;
        notifyDataSetChanged();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.feed_card_layout, parent, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }
    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.bind(mProcessData.get(position), mPresenter);
    }


    @Override
    public int getItemCount() {
        return mProcessData.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleTextView;
        TextView priceTextView;
        TextView locationTextView;
        TextView timeTextView;
        ImageView favImageView;

        public CardViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTv);
            priceTextView = (TextView) itemView.findViewById(R.id.priceTv);
            locationTextView = (TextView) itemView.findViewById(R.id.locationTv);
            timeTextView = (TextView) itemView.findViewById(R.id.timeTv);
            favImageView = (ImageView) itemView.findViewById(R.id.favImageView);
        }

        public void bind(final FeedCardData cardData, final FeedsMvpPresenter processPresenter) {
           
            imageView.setImageResource(cardData.getPhotoId());
            titleTextView.setText(cardData.getTitle());
            priceTextView.setText("Tk : "+String.valueOf(cardData.getPrice()));
            locationTextView.setText(cardData.getLocation());
            timeTextView.setText(cardData.getTime());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    processPresenter.onClick(cardData);
                }
            });

            favImageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    favImageView.setImageResource(R.mipmap.ic_favorite_black_24dp);
                }
            });

        }
    }
}
