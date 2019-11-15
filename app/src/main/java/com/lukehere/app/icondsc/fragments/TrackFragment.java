package com.lukehere.app.icondsc.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.adapters.PapersAdapter;
import com.lukehere.app.icondsc.pojo.Paper;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.lukehere.app.icondsc.activities.PaperPresentationActivity.PAPERS_ARRAY_LIST;

public class TrackFragment extends Fragment {
    private ArrayList<Paper> mPapersArrayList;

    public TrackFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle args = getArguments();
        if (args != null && args.containsKey(PAPERS_ARRAY_LIST)) {
            mPapersArrayList = args.getParcelableArrayList(PAPERS_ARRAY_LIST);
        }

        return inflater.inflate(R.layout.fragment_track, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView mPapersRecyclerView = view.findViewById(R.id.papers_recycler_view);
        mPapersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PapersAdapter papersAdapter = new PapersAdapter(getContext(), mPapersArrayList);
        mPapersRecyclerView.setAdapter(papersAdapter);
    }
}
