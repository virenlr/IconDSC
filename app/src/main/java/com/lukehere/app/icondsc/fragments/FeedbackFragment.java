package com.lukehere.app.icondsc.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.activities.HomeActivity;
import com.lukehere.app.icondsc.pojo.Feedback;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import static com.lukehere.app.icondsc.activities.HomeActivity.mBackCount;

public class FeedbackFragment extends Fragment {
    private Feedback mFeedback;
    private RatingBar mQuestionOne, mQuestionTwo, mQuestionThree, mQuestionFour, mQuestionFive, mQuestionSix, mQuestionSeven;
    private EditText mQuestionEight, mQuestionNine, mQuestionTen, mQuestionFinal;
    private ProgressBar mFeedbackProgressBar;
    private ProgressBar mFeedbackSubmittedProgressBar;
    private TextView feedbackAlreadySubmitted;

    private DocumentReference docRef;

    public FeedbackFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBackCount = 0;
        return inflater.inflate(R.layout.fragment_feedback, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.feedback_toolbar);
        ((HomeActivity) getActivity()).setToolbar(toolbar, getString(R.string.feedback));

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseFirestore mDb = FirebaseFirestore.getInstance();

        docRef = mDb.collection("attendees").document(mAuth.getUid() + "").collection("feedback").document("feedback");
        mFeedbackProgressBar = view.findViewById(R.id.feedback_progress_bar);
        mQuestionOne = view.findViewById(R.id.feedback_question_one);
        mQuestionTwo = view.findViewById(R.id.feedback_question_two);
        mQuestionThree = view.findViewById(R.id.feedback_question_three);
        mQuestionFour = view.findViewById(R.id.feedback_question_four);
        mQuestionFive = view.findViewById(R.id.feedback_question_five);
        mQuestionSix = view.findViewById(R.id.feedback_question_six);
        mQuestionSeven = view.findViewById(R.id.feedback_question_seven);
        mQuestionEight = view.findViewById(R.id.feedback_question_eight);
        mQuestionNine = view.findViewById(R.id.feedback_question_nine);
        mQuestionTen = view.findViewById(R.id.feedback_question_ten);
        mQuestionFinal = view.findViewById(R.id.feedback_question_final);
        MaterialButton mSubmitButton = view.findViewById(R.id.submit_feedback_button);
        mFeedbackSubmittedProgressBar = view.findViewById(R.id.feedback_submitted_progress_bar);
        feedbackAlreadySubmitted = view.findViewById(R.id.feedback_already_submitted_text_view);

        mFeedbackProgressBar.setVisibility(View.VISIBLE);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    mFeedback = documentSnapshot.toObject(Feedback.class);

                    if (mFeedback != null) {
                        mQuestionOne.setRating(mFeedback.getFeedbackOne());
                        mQuestionTwo.setRating(mFeedback.getFeedbackTwo());
                        mQuestionThree.setRating(mFeedback.getFeedbackThree());
                        mQuestionFour.setRating(mFeedback.getFeedbackFour());
                        mQuestionFive.setRating(mFeedback.getFeedbackFive());
                        mQuestionSix.setRating(mFeedback.getFeedbackSix());
                        mQuestionSeven.setRating(mFeedback.getFeedbackSeven());
                        mQuestionEight.setText(mFeedback.getFeedbackEight());
                        mQuestionNine.setText(mFeedback.getFeedbackNine());
                        mQuestionTen.setText(mFeedback.getFeedbackTen());
                        mQuestionFinal.setText(mFeedback.getFeedbackFinal());
                        feedbackAlreadySubmitted.setVisibility(View.VISIBLE);
                    }
                }

                mFeedbackProgressBar.setVisibility(View.GONE);
            }
        });


        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float feedbackOne, feedbackTwo, feedbackThree, feedbackFour, feedbackFive, feedbackSix, feedbackSeven;

                feedbackOne = mQuestionOne.getRating();
                feedbackTwo = mQuestionTwo.getRating();
                feedbackThree = mQuestionThree.getRating();
                feedbackFour = mQuestionFour.getRating();
                feedbackFive = mQuestionFive.getRating();
                feedbackSix = mQuestionSix.getRating();
                feedbackSeven = mQuestionSeven.getRating();

                String feedbackEight = mQuestionEight.getText().toString().trim();
                String feedbackNine = mQuestionNine.getText().toString().trim();
                String feedbackTen = mQuestionTen.getText().toString().trim();
                String feedbackExtra = mQuestionFinal.getText().toString().trim();

                mFeedback = new Feedback(feedbackOne, feedbackTwo, feedbackThree, feedbackFour, feedbackFive, feedbackSix, feedbackSeven, feedbackEight, feedbackNine, feedbackTen, feedbackExtra);

                mFeedbackSubmittedProgressBar.setVisibility(View.VISIBLE);
                docRef.set(mFeedback).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (isAdded() && getActivity() != null && mFeedbackSubmittedProgressBar != null) {
                            mFeedbackSubmittedProgressBar.setVisibility(View.GONE);
                        }

                        if (isAdded() && getActivity() != null && feedbackAlreadySubmitted != null) {
                            feedbackAlreadySubmitted.setText(getString(R.string.thank_you_for_your_feedback));
                            feedbackAlreadySubmitted.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        });
    }
}