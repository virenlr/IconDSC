package com.lukehere.app.icondsc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;
import com.google.android.material.card.MaterialCardView;
import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.pojo.Alert;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class AlertsAdapter extends FirestorePagingAdapter<Alert, AlertsAdapter.AlertsViewHolder> {
    private LayoutInflater mInflater;
    private SwipeRefreshLayout mPullToRefresh;
    private Context mContext;

    public AlertsAdapter(Context context, SwipeRefreshLayout pullToRefresh, @NonNull FirestorePagingOptions<Alert> options) {
        super(options);
        mContext = context;
        mPullToRefresh = pullToRefresh;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AlertsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.alert_item, parent, false);
        return new AlertsViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull AlertsViewHolder holder, int position, @NonNull Alert alert) {
        holder.alertTitle.setText(alert.getAlertTitle());
        holder.alertBody.setText(alert.getAlertBody());
    }

    @Override
    protected void onLoadingStateChanged(@NonNull LoadingState state) {
        switch (state) {
            case LOADING_INITIAL:
                mPullToRefresh.setRefreshing(true);
                break;
            case LOADING_MORE:
                mPullToRefresh.setRefreshing(true);
                break;
            case LOADED:
                mPullToRefresh.setRefreshing(false);
                break;
            case FINISHED:
                mPullToRefresh.setRefreshing(false);
                break;
            case ERROR:
                Toast.makeText(mContext, mContext.getString(R.string.error_fetching_alerts), Toast.LENGTH_SHORT).show();
                retry();
                break;
        }
    }

    class AlertsViewHolder extends RecyclerView.ViewHolder {
        TextView alertTitle;
        TextView alertBody;
        MaterialCardView card;

        AlertsViewHolder(@NonNull View itemView) {
            super(itemView);

            alertTitle = itemView.findViewById(R.id.alert_title);
            alertBody = itemView.findViewById(R.id.alert_body);
            card = itemView.findViewById(R.id.alert_card);
        }
    }
}
