package com.lukehere.app.icondsc.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.activities.HomeActivity;

import static com.lukehere.app.icondsc.activities.HomeActivity.mBackCount;

public class AboutFragment extends Fragment {

    private MaterialButton mPrivacyPolicyButton;

    public AboutFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBackCount = 0;
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.about_toolbar);
        ((HomeActivity) getActivity()).setToolbar(toolbar, getString(R.string.about));

        mPrivacyPolicyButton = view.findViewById(R.id.privacy_policy_button);
        mPrivacyPolicyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.freeprivacypolicy.com/privacy/view/f523fdd7391d2e01af72ee1a3b2f8a95"));
                startActivity(i);
            }
        });
    }

}
