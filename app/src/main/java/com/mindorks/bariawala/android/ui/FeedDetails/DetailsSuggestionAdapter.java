package com.mindorks.bariawala.android.ui.FeedDetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
 * Created by Faizul Haque Nayan on 18/03/18.
 */

public class DetailsSuggestionAdapter extends RecyclerView.Adapter<DetailsSuggestionAdapter.CardViewHolder> {

    private Context mContext;
    private List<FeedCardData> mProcessData;
    private LayoutInflater inflater;
    private FeedDetailsMvpPresenter mPresenter;

    public DetailsSuggestionAdapter(Context context, FeedDetailsMvpPresenter presenter) {
        this.mContext = context;
        this.mPresenter = presenter;
        this.inflater = LayoutInflater.from(mContext);
        mProcessData = new ArrayList<>();
    }

    public void setViewData(List<FeedCardData> processData){
        Log.e("setViewData",""+processData.toString());
        if(mProcessData != null && mProcessData.size() > 0){
            mProcessData.clear();
        }
        this.mProcessData = processData;
        notifyDataSetChanged();
    }

    @Override
    public DetailsSuggestionAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.details_suggestion_adapter, parent, false);
        DetailsSuggestionAdapter.CardViewHolder cardViewHolder = new DetailsSuggestionAdapter.CardViewHolder(view);
        return cardViewHolder;
    }
    @Override
    public void onBindViewHolder(DetailsSuggestionAdapter.CardViewHolder holder, int position) {
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

        public CardViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            titleTextView = (TextView) itemView.findViewById(R.id.title_text_view);
            priceTextView = (TextView) itemView.findViewById(R.id.price_text_view);
            locationTextView = (TextView) itemView.findViewById(R.id.location_text_view);
            timeTextView = (TextView) itemView.findViewById(R.id.time_text_view);
        }

        public void bind(final FeedCardData cardData, final FeedDetailsMvpPresenter processPresenter) {

            imageView.setImageResource(cardData.getPhotoId());
            titleTextView.setText(cardData.getTitle());
            priceTextView.setText("Tk : "+String.valueOf(cardData.getPrice()));
            locationTextView.setText(cardData.getLocation());
            timeTextView.setText(cardData.getTime());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //processPresenter.onClick(cardData);
                }
            });

        }
    }
}
