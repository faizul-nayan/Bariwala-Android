package com.mindorks.bariawala.android.ui.NewPost;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.ui.base.BaseViewHolder;
import com.mindorks.bariawala.android.ui.deshboard.SavedFragment.SavedAdapter;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nayan on 3/24/2018.
 */

public class NewPostImageAdapter  extends RecyclerView.Adapter<BaseViewHolder>{

    private List<Bitmap> mBitmapList;

    private SavedAdapter.Callback mCallback;

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    public NewPostImageAdapter(List<Bitmap> bitmapList) {
        this.mBitmapList = bitmapList;
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
                return new NewPostImageAdapter.ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.adpater_new_image, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new NewPostImageAdapter.ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.adpater_new_image, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mBitmapList != null && mBitmapList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mBitmapList != null && mBitmapList.size() > 0) {
            return mBitmapList.size();
        } else {
            return 1;
        }
    }

    public void setViewData(List<Bitmap> bitmapList){
        if(mBitmapList != null && mBitmapList.size() > 0){
            mBitmapList.clear();
        }
        this.mBitmapList = bitmapList;
        Log.e("setview", "size  ="+bitmapList.size());
        notifyDataSetChanged();
    }


    public interface Callback {
        void onSavedItemClick();
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {
        @BindView(R.id.imageView)
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void onBind(int position) {
            super.onBind(position);
            final Bitmap bitmap = mBitmapList.get(position);

            imageView.setImageBitmap(bitmap);

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
