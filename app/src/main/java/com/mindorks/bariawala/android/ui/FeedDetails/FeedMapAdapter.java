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
import com.mindorks.bariawala.android.ui.deshboard.FeedFragment.FeedsMvpPresenter;
import com.mindorks.bariawala.android.ui.model.FeedCardData;
import com.mindorks.bariawala.android.ui.model.FeedMapModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faizul Haque Nayan on 18/03/20.
 */

public class FeedMapAdapter extends RecyclerView.Adapter<FeedMapAdapter.CardViewHolder>{

    private Context mContext;
    private List<FeedMapModel> mProcessData;
    private LayoutInflater inflater;
    private FeedDetailsMvpPresenter mPresenter;

    public FeedMapAdapter(Context context, FeedDetailsMvpPresenter presenter) {
        this.mContext = context;
        this.mPresenter = presenter;
        this.inflater = LayoutInflater.from(mContext);
        mProcessData = new ArrayList<>();
    }

    public void setViewData(List<FeedMapModel> processData){
        if(mProcessData != null && mProcessData.size() > 0){
            mProcessData.clear();
        }
        this.mProcessData = processData;
        notifyDataSetChanged();
    }

    @Override
    public FeedMapAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.horizontal_map_list, parent, false);
        FeedMapAdapter.CardViewHolder cardViewHolder = new FeedMapAdapter.CardViewHolder(view);
        return cardViewHolder;
    }
    @Override
    public void onBindViewHolder(FeedMapAdapter.CardViewHolder holder, int position) {
        holder.bind(mProcessData.get(position), mPresenter);
    }


    @Override
    public int getItemCount() {
        return mProcessData.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleTextView;

        public CardViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_view_map);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTv);
        }

        public void bind(final FeedMapModel cardData, final FeedDetailsMvpPresenter processPresenter) {

            imageView.setImageResource(cardData.getPhotoId());
            titleTextView.setText(cardData.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("feedMapAdapter","Item click");
                    processPresenter.onMapClick();
                }
            });

        }
    }
}
