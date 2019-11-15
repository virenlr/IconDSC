package com.lukehere.app.icondsc.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.activities.AuthenticationActivity;
import com.lukehere.app.icondsc.activities.HomeActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import static com.lukehere.app.icondsc.activities.HomeActivity.mBackCount;

public class SignOutFragment extends Fragment {

    public SignOutFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBackCount = 0;
        return inflater.inflate(R.layout.fragment_sign_out, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.sign_out_toolbar);
        ((HomeActivity) getActivity()).setToolbar(toolbar, getString(R.string.sign_out));

        MaterialButton mSignOutButton = view.findViewById(R.id.sign_out_button);
        mSignOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage(getString(R.string.are_you_sure_you_want_to_sign_out))
                        .setTitle(getString(R.string.warning));
                builder.setPositiveButton(getString(R.string.okay), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        FirebaseAuth.getInstance().signOut();
                        Intent i = new Intent(getContext(), AuthenticationActivity.class);
                        startActivity(i);
                        getActivity().finish();
                    }
                });
                builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}