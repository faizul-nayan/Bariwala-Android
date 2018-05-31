package com.mindorks.bariawala.android.ui.deshboard.SavedFragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.ui.base.BaseViewHolder;
import com.mindorks.bariawala.android.ui.feed.blogs.BlogAdapter;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Faizul Haque Nayan on 18/03/19.
 */

public class SavedAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<FeedCardData> mProcessData;

    private SavedAdapter.Callback mCallback;

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    public SavedAdapter(List<FeedCardData> feedCardDataList) {
        this.mProcessData = feedCardDataList;
    }

    public void setCallback(SavedAdapter.Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.details_suggestion_adapter, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.details_suggestion_adapter, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mProcessData != null && mProcessData.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mProcessData != null && mProcessData.size() > 0) {
            return mProcessData.size();
        } else {
            return 1;
        }
    }

    public void setViewData(List<FeedCardData> processData){
        if(mProcessData != null && mProcessData.size() > 0){
            mProcessData.clear();
        }
        this.mProcessData = processData;
        notifyDataSetChanged();
    }


    public interface Callback {
        void onSavedItemClick();
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.title_text_view)
        TextView titleTextView;
        @BindView(R.id.price_text_view)
        TextView priceTextView;
        @BindView(R.id.location_text_view)
        TextView locationTextView;
        @BindView(R.id.time_text_view)
        TextView timeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void onBind(int position) {
            super.onBind(position);
            final FeedCardData feedCardData = mProcessData.get(position);

            imageView.setImageResource(feedCardData.getPhotoId());
            titleTextView.setText(feedCardData.getTitle());
            priceTextView.setText("Tk : "+String.valueOf(feedCardData.getPrice()));
            locationTextView.setText(feedCardData.getLocation());
            timeTextView.setText(feedCardData.getTime());

        }

        @Override
        protected void clear() {

        }

        @Override
        public void onClick(View view) {
            mCallback.onSavedItemClick();
        }
    }
}
