package com.lukehere.app.icondsc.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.card.MaterialCardView;
import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.activities.HomeActivity;
import com.lukehere.app.icondsc.activities.SpeakerDetailsActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import static com.lukehere.app.icondsc.activities.HomeActivity.mBackCount;
import static com.lukehere.app.icondsc.activities.SpeakerDetailsActivity.SPEAKER_NUMBER;


public class SpeakersFragment extends Fragment {
    private MaterialCardView speaker1Card, speaker2Card, speaker3Card, speaker4Card, speaker5Card;
    private ImageView mSpeakerImageOne, mSpeakerImageTwo, mSpeakerImageThree, mSpeakerImageFour, mSpeakerImageFive;

    public SpeakersFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBackCount = 0;
        return inflater.inflate(R.layout.fragment_speakers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.speakers_toolbar);
        ((HomeActivity) getActivity()).setToolbar(toolbar, getString(R.string.speaker_details));

        speaker1Card = view.findViewById(R.id.speaker_card_1);
        speaker2Card = view.findViewById(R.id.speaker_card_2);
        speaker3Card = view.findViewById(R.id.speaker_card_3);
        speaker4Card = view.findViewById(R.id.speaker_card_4);
        speaker5Card = view.findViewById(R.id.speaker_card_5);

        mSpeakerImageOne = view.findViewById(R.id.speaker_image_one);
        mSpeakerImageTwo = view.findViewById(R.id.speaker_image_two);
        mSpeakerImageThree = view.findViewById(R.id.speaker_image_three);
        mSpeakerImageFour = view.findViewById(R.id.speaker_image_four);
        mSpeakerImageFive = view.findViewById(R.id.speaker_image_five);

        speaker1Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpeakerDetailsActivity(1);
            }
        });

        speaker2Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpeakerDetailsActivity(2);
            }
        });

        speaker3Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpeakerDetailsActivity(3);
            }
        });

        speaker4Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpeakerDetailsActivity(4);
            }
        });

        speaker5Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpeakerDetailsActivity(5);
            }
        });
    }

    private void openSpeakerDetailsActivity(int num) {
        Intent i = new Intent(getContext(), SpeakerDetailsActivity.class);
        i.putExtra(SPEAKER_NUMBER, num);
        ActivityOptionsCompat options = null;

        switch (num) {
            case 1:
                Pair<View, String> p1 = Pair.create((View) mSpeakerImageOne, "speaker_image");
                Pair<View, String> p2 = Pair.create((View) speaker1Card, "speaker_card");
                options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getContext(), p1, p2);
                break;
            case 2:
                Pair<View, String> p3 = Pair.create((View) mSpeakerImageTwo, "speaker_image");
                Pair<View, String> p4 = Pair.create((View) speaker2Card, "speaker_card");
                options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getContext(), p3, p4);
                break;

            case 3:
                Pair<View, String> p5 = Pair.create((View) mSpeakerImageThree, "speaker_image");
                Pair<View, String> p6 = Pair.create((View) speaker3Card, "speaker_card");
                options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getContext(), p5, p6);
                break;

            case 4:
                Pair<View, String> p7 = Pair.create((View) mSpeakerImageFour, "speaker_image");
                Pair<View, String> p8 = Pair.create((View) speaker4Card, "speaker_card");
                options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getContext(), p7, p8);
                break;

            case 5:
                Pair<View, String> p9 = Pair.create((View) mSpeakerImageFive, "speaker_image");
                Pair<View, String> p10 = Pair.create((View) speaker5Card, "speaker_card");
                options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getContext(), p9, p10);
                break;
        }

        startActivity(i, options.toBundle());
    }
}