package com.lukehere.app.icondsc.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.activities.HomeActivity;
import com.lukehere.app.icondsc.adapters.AlertsAdapter;
import com.lukehere.app.icondsc.pojo.Alert;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import static com.lukehere.app.icondsc.activities.HomeActivity.mBackCount;


public class AlertsFragment extends Fragment {
    private FirebaseFirestore firestoreDB;
    private RecyclerView mAlertsRecyclerView;
    private SwipeRefreshLayout pullToRefresh;

    public AlertsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBackCount = 0;
        return inflater.inflate(R.layout.fragment_alerts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.alerts_toolbar);
        ((HomeActivity) getActivity()).setToolbar(toolbar, getString(R.string.alerts));

        firestoreDB = FirebaseFirestore.getInstance();
        mAlertsRecyclerView = view.findViewById(R.id.alerts_recycler_view);
        mAlertsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        pullToRefresh = view.findViewById(R.id.pull_to_refresh);
        pullToRefresh.setColorSchemeColors(Color.BLUE);

        loadAlerts();

        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadAlerts();
            }
        });
    }

    private void loadAlerts() {
        CollectionReference mAlertsCollection = firestoreDB.collection("alerts");
        Query baseQuery = mAlertsCollection.orderBy("priority", Query.Direction.DESCENDING);

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPrefetchDistance(15)
                .setPageSize(5)
                .build();
        FirestorePagingOptions<Alert> options = new FirestorePagingOptions.Builder<Alert>()
                .setLifecycleOwner(this)
                .setQuery(baseQuery, config, Alert.class)
                .build();

        AlertsAdapter mAlertsAdapter = new AlertsAdapter(getContext(), pullToRefresh, options);
        mAlertsRecyclerView.setAdapter(mAlertsAdapter);
    }
}