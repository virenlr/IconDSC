package com.lukehere.app.icondsc.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.activities.HomeActivity;
import com.lukehere.app.icondsc.activities.PaperPresentationActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import static com.lukehere.app.icondsc.activities.HomeActivity.mBackCount;
import static com.lukehere.app.icondsc.activities.PaperPresentationActivity.PAPER_SESSION;

public class ScheduleFragment extends Fragment {

    public ScheduleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBackCount = 0;
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.schedule_toolbar);
        ((HomeActivity) getActivity()).setToolbar(toolbar, getString(R.string.schedule));

        MaterialCardView parallelPaperPresentation1Card = view.findViewById(R.id.parallel_paper_presentation_card_1);
        MaterialCardView parallelPaperPresentation2Card = view.findViewById(R.id.parallel_paper_presentation_card_2);

        parallelPaperPresentation1Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), PaperPresentationActivity.class);
                i.putExtra(PAPER_SESSION, 1);
                startActivity(i);
            }
        });

        parallelPaperPresentation2Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), PaperPresentationActivity.class);
                i.putExtra(PAPER_SESSION, 2);
                startActivity(i);
            }
        });

        View.OnClickListener auditoriumBlockOneLocation = setLocation("Christ University Administrative Block and MBA block, Bengaluru, Karnataka 560074");
        View.OnClickListener rockvillaPUBlockLocation = setLocation("Christ PU College - Residential, Mysore Road, Kanminike, Kumbalgodu P.O, Bengaluru, Karnataka 560074");
        View.OnClickListener auditoriumPUBlockLocation = setLocation("Christ PU College - Residential, Mysore Road, Kanminike, Kumbalgodu P.O, Bengaluru, Karnataka 560074");
        View.OnClickListener openAuditoriumLocation = setLocation("CUFE Open Auditorium, Bengaluru, Karnataka 560074");
        View.OnClickListener northCanteenLocation = setLocation("North Canteen, Bengaluru, Karnataka 560074");
        View.OnClickListener southCanteenLocation = setLocation("South Canteen, Bengaluru, Karnataka 560074");

        MaterialButton locationOneButton = view.findViewById(R.id.location_one_button);
        locationOneButton.setOnClickListener(auditoriumBlockOneLocation);

        MaterialButton locationTwoButton = view.findViewById(R.id.location_two_button);
        locationTwoButton.setOnClickListener(auditoriumBlockOneLocation);

        MaterialButton locationThreeButton = view.findViewById(R.id.location_three_button);
        locationThreeButton.setOnClickListener(auditoriumBlockOneLocation);

        MaterialButton locationFourButton = view.findViewById(R.id.location_four_button);
        locationFourButton.setOnClickListener(northCanteenLocation);

        MaterialButton locationFiveButton = view.findViewById(R.id.location_five_button);
        locationFiveButton.setOnClickListener(rockvillaPUBlockLocation);

        MaterialButton locationSixButton = view.findViewById(R.id.location_six_button);
        locationSixButton.setOnClickListener(rockvillaPUBlockLocation);

        MaterialButton locationSevenButton = view.findViewById(R.id.location_seven_button);
        locationSevenButton.setOnClickListener(auditoriumPUBlockLocation);

        MaterialButton locationEightButton = view.findViewById(R.id.location_eight_button);
        locationEightButton.setOnClickListener(openAuditoriumLocation);

        MaterialButton locationNineButton = view.findViewById(R.id.location_nine_button);
        locationNineButton.setOnClickListener(northCanteenLocation);

        MaterialButton locationTenButton = view.findViewById(R.id.location_ten_button);
        locationTenButton.setOnClickListener(auditoriumBlockOneLocation);

        MaterialButton locationElevenButton = view.findViewById(R.id.location_eleven_button);
        locationElevenButton.setOnClickListener(auditoriumBlockOneLocation);

        MaterialButton locationTwelveButton = view.findViewById(R.id.location_twelve_button);
        locationTwelveButton.setOnClickListener(auditoriumBlockOneLocation);

        MaterialButton locationThirteenButton = view.findViewById(R.id.location_thirteen_button);
        locationThirteenButton.setOnClickListener(auditoriumBlockOneLocation);

        MaterialButton locationFourteenButton = view.findViewById(R.id.location_fourteen_button);
        locationFourteenButton.setOnClickListener(southCanteenLocation);
    }

    private View.OnClickListener setLocation(final String address) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(getContext(), getString(R.string.google_maps_needs_to_be_installed), Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}