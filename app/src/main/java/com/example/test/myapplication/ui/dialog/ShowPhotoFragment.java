package com.example.test.myapplication.ui.dialog;

import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.test.myapplication.R;

/**
 * Created by Administrator on 2016/6/16.
 */
public class ShowPhotoFragment extends DialogFragment {

    private Drawable bitmap;
    private View view;

    public ShowPhotoFragment(Drawable b) {
        this.bitmap = b;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.showphotolyout, container, false);
        ImageView img = (ImageView) view.findViewById(R.id.ShowImg);
        img.setImageDrawable(bitmap);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bitmap = null;
        view = null;
    }
}
