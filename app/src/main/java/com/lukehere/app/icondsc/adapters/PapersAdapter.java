package com.lukehere.app.icondsc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.pojo.Paper;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PapersAdapter extends RecyclerView.Adapter<PapersAdapter.PapersViewHolder> {

    private ArrayList<Paper> mPapersArrayList;
    private LayoutInflater mInflater;

    public PapersAdapter(Context context, ArrayList<Paper> papersArrayList) {
        Context mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mPapersArrayList = papersArrayList;
    }

    @NonNull
    @Override
    public PapersAdapter.PapersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.paper_item, parent, false);
        return new PapersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PapersAdapter.PapersViewHolder holder, int position) {
        String authorDetails = mPapersArrayList.get(position).getAuthorDetails();
        String paperId = mPapersArrayList.get(position).getPaperId();
        String paperTitle = mPapersArrayList.get(position).getTitle();
        String room = mPapersArrayList.get(position).getRoom();
        String time = mPapersArrayList.get(position).getTime();

        if (authorDetails != null) {
            holder.mAuthorDetailsTextView.setText(authorDetails);
        }
        if (paperId != null) {
            holder.mPaperIdTextView.setText(paperId);
        }
        if (paperTitle != null) {
            holder.mTitleTextView.setText(paperTitle);
        }
        if (room != null) {
            holder.mRoomTextView.setText(room);
        }
        if (time != null) {
            holder.mTimeTextView.setText(time);
        }
    }

    @Override
    public int getItemCount() {
        return mPapersArrayList.size();
    }

    //-----------------------------------------------------------------------------------------
    class PapersViewHolder extends RecyclerView.ViewHolder {
        private TextView mAuthorDetailsTextView;
        private TextView mPaperIdTextView;
        private TextView mTitleTextView;
        private TextView mRoomTextView;
        private TextView mTimeTextView;

        PapersViewHolder(View itemView) {
            super(itemView);

            mAuthorDetailsTextView = itemView.findViewById(R.id.author_details_text_view);
            mPaperIdTextView = itemView.findViewById(R.id.paper_id_text_view);
            mTitleTextView = itemView.findViewById(R.id.paper_title_text_view);
            mRoomTextView = itemView.findViewById(R.id.room_text_view);
            mTimeTextView = itemView.findViewById(R.id.time_text_view);
        }
    }
    //-----------------------------------------------------------------------------------------
}
