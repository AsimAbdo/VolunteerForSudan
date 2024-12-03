package edu.aau.projects.volunteerforsudan.uiadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.CustomContributeItemBinding;

public class ContributionAdapter extends RecyclerView.Adapter<ContributionAdapter.ContributionHolder> {

    @NonNull
    @Override
    public ContributionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_contribute_item, null);
        return new ContributionHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContributionHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ContributionHolder extends RecyclerView.ViewHolder {
        CustomContributeItemBinding bin;
        public ContributionHolder(@NonNull View itemView) {
            super(itemView);
            bin =CustomContributeItemBinding.bind(itemView);
        }
    }
}
