package com.mindorks.bariawala.android.ui.FeedDetails;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.di.component.ActivityComponent;
import com.mindorks.bariawala.android.ui.base.BaseDialog;
import com.mindorks.bariawala.android.ui.main.rating.RateUsDialog;
import com.mindorks.bariawala.android.ui.main.rating.RatingDialogMvpInteractor;
import com.mindorks.bariawala.android.ui.main.rating.RatingDialogMvpPresenter;
import com.mindorks.bariawala.android.ui.main.rating.RatingDialogMvpView;
import com.mindorks.bariawala.android.utils.AppUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.makeramen.roundedimageview.RoundedDrawable.TAG;

/**
 * Created by Nayan on 3/24/2018.
 */

public class MapDetailsDialog extends BaseDialog {

    private GoogleMap mGoogleMap;

    @BindView(R.id.mapView)
    MapView mMapView;

    public static MapDetailsDialog newInstance() {
        MapDetailsDialog fragment = new MapDetailsDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.map_details_dialog, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {

            component.inject(this);

            setUnBinder(ButterKnife.bind(this, view));
            MapsInitializer.initialize(getContext());

        }

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }


    @Override
    protected void setUp(View view) {


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
