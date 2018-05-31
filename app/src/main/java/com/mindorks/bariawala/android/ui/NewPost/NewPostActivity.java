package com.mindorks.bariawala.android.ui.NewPost;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.ui.base.BaseActivity;
import com.mindorks.bariawala.android.utils.CameraPermission;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewPostActivity extends BaseActivity implements NewPostMvpView {

    @BindView(R.id.recyclerView)
    ListView mRecyclerView;
    @BindView(R.id.locationLayout)
    LinearLayout mLocationLayout;
    @BindView(R.id.postDetailsLayout)
    LinearLayout mDetailsLayout;
    @BindView(R.id.categoryTextView)
    TextView mCategoryTextView;
    @BindView(R.id.categoryDetailsTextView)
    TextView mCategoryDetailsTextView;
    @BindView(R.id.locationDetailsTextView)
    TextView mLocationDetailsTextView;
    @BindView(R.id.locationSpinner)
    Spinner mLocationSpinner;
    @BindView(R.id.contactDetailsLayout)
    LinearLayout mContactDetailsLayout;
    @BindView(R.id.photoRecylerView)
    RecyclerView mPhotoRecyclerView;
    @BindView(R.id.cameraImageView)
    ImageView mCameraImageView;


    private String userChoosenTask = "";
    private String category = "";
    private String location = "";

    private Bitmap image;

    private static final int SELECT_PICTURE = 1;
    private final int CAMERA_REQUEST_CODE = 2222;

    private LinearLayoutManager mLinearLayoutManager;
    private ArrayAdapter<String> mAdapter;

    @Inject
    NewPostMvpPresenter<NewPostMvpView, NewPostMvpInteractor> mPresenter;

    @Inject
    NewPostImageAdapter mImageAdaprter;
    private LinearLayoutManager mHorizontalLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(NewPostActivity.this);
        setUp();
        mRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mRecyclerView.setVisibility(View.GONE);
                mLocationLayout.setVisibility(View.VISIBLE);
                category = mRecyclerView.getItemAtPosition(i).toString();
                mCategoryTextView.setText(category);
            }
        });

    }


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, NewPostActivity.class);
        return intent;
    }

    @Override
    protected void setUp() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        loadInitViewData(mPresenter.getInitViewData());
    }

    @Override
    public void loadInitViewData(List<String> list) {
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        mRecyclerView.setAdapter(mAdapter);

    }

    @OnClick(R.id.locationButton)
    void locationSelect() {
        mLocationLayout.setVisibility(View.GONE);
        mDetailsLayout.setVisibility(View.VISIBLE);
        mCategoryDetailsTextView.setText(category);
        mLocationDetailsTextView.setText(mLocationSpinner.getSelectedItem().toString());
    }

    @OnClick(R.id.categoryTextView)
    void categoryClick() {
        mLocationLayout.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.categoryDetailsTextView)
    void categoryDetailsClick() {
        mDetailsLayout.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.locationDetailsTextView)
    void locationDetailsClick() {
        mDetailsLayout.setVisibility(View.GONE);
        mLocationLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.nextBtn)
    void nextButtonClick() {
        mDetailsLayout.setVisibility(View.GONE);
        mContactDetailsLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.addPhotoButton)
    void addPhotoButtonClick() {
        selectImage();
    }


    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Gallery",
                "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(NewPostActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = CameraPermission.checkPermission(NewPostActivity.this);

                if (items[item].equals("Take Photo")) {
                    userChoosenTask = "Take Photo";
                    if (result)
                        cameraIntent();

                } else if (items[item].equals("Choose from Gallery")) {
                    userChoosenTask = "Choose from Gallery";
                    if (result)
                        galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_PICTURE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case CameraPermission.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if (userChoosenTask.equals("Choose from Gallery"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub

        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
//                Uri selectedImageUri = data.getData();
//                //selectedImagePath = getPath(selectedImageUri);
//                try {
//                    image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
//                    mCameraImageView.setImageBitmap(image);
//                    //int imageHeight = image.getHeight();
//                    //imageView.setMaxHeight(imageHeight);
//                    //flag = true;
//                } catch (FileNotFoundException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }

                if (data.getData() != null) {

                    Uri mImageUri = data.getData();

                } else {
                    if (data.getClipData() != null) {
                        ClipData mClipData = data.getClipData();
                        ArrayList<Bitmap> mArrayUri = new ArrayList<Bitmap>();
                        for (int i = 0; i < mClipData.getItemCount(); i++) {

                            ClipData.Item item = mClipData.getItemAt(i);
                            Uri uri = item.getUri();
                            Bitmap bitmap = null;
                            try {
                                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            mArrayUri.add(Bitmap.createScaledBitmap(bitmap, 180, 180, true));

                        }
                        Log.e("LOG_TAG", "Selected Images" + mArrayUri.size());
                        mCameraImageView.setVisibility(View.GONE);
                        mImageAdaprter.setViewData(mArrayUri);
                        mPhotoRecyclerView.setAdapter(mImageAdaprter);
                        mHorizontalLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                        mPhotoRecyclerView.setLayoutManager(mHorizontalLayout);
                    }

                }

            } else if (data != null && requestCode == CAMERA_REQUEST_CODE) {
                image = (Bitmap) data.getExtras().get("data");
            } else {
                //callbackManager.onActivityResult(requestCode,resultCode,data);
            }
        }
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm = null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bm != null) {
            mCameraImageView.setImageBitmap(bm);
        } else {
            Log.e("NewPost", "null");
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (thumbnail != null) {
            mCameraImageView.setImageBitmap(thumbnail);
        } else {
            Log.e("NewPost", "null");
        }
    }

    private Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                                   boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }
}
