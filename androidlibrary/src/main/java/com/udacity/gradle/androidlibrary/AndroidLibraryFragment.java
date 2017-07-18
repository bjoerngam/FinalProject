package com.udacity.gradle.androidlibrary;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.udacity.gradle.androidlibrary.AndroidLibraryActivity.INTENT_EXTRA;


public class AndroidLibraryFragment extends Fragment {

    TextView tvJoke;

    public AndroidLibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_android_library, container, false);

        String currentJoke = getActivity().getIntent().getStringExtra(INTENT_EXTRA);
        tvJoke =  rootView.findViewById(R.id.tvJoke);
        tvJoke.setText(currentJoke);
        // No adds here
        return rootView;
    }
}
