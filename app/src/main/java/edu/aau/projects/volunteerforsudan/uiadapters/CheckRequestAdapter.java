package edu.aau.projects.volunteerforsudan.uiadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.CustomCheckReqItemBinding;

public class CheckRequestAdapter extends RecyclerView.Adapter<CheckRequestAdapter.RequestHolder> {

    @NonNull
    @Override
    public RequestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_check_req_item, null);
        return new RequestHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class RequestHolder extends RecyclerView.ViewHolder {
        CustomCheckReqItemBinding bin;
        public RequestHolder(@NonNull View itemView) {
            super(itemView);
            bin = CustomCheckReqItemBinding.bind(itemView);
        }
    }
}
