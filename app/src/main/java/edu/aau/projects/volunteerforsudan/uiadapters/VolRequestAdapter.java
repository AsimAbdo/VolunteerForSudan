package edu.aau.projects.volunteerforsudan.uiadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.CustomVRequestItemBinding;
import edu.aau.projects.volunteerforsudan.models.ServiceRequest;

public class VolRequestAdapter extends RecyclerView.Adapter<VolRequestAdapter.RequestHolder> {
    Context context;
    List<ServiceRequest> requests;

    public VolRequestAdapter(Context context, List<ServiceRequest> requests) {
        this.context = context;
        this.requests = requests;
    }

    public void setRequests(List<ServiceRequest> requests) {
        this.requests = requests;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RequestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_v_request_item, null);
        return new RequestHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return requests == null ? 0 : requests.size();
    }

    public class RequestHolder extends RecyclerView.ViewHolder {
        CustomVRequestItemBinding bin;
        public RequestHolder(@NonNull View itemView) {
            super(itemView);
            bin = CustomVRequestItemBinding.bind(itemView);
        }

        void onBind(int pos){
            ServiceRequest request = requests.get(pos);

            bin.customVTvAmount.setText("20/" + request.getAmount());
            bin.customVTvDate.setText(request.getDate());
            bin.customVTvLocation.setText(request.getLocation());
            bin.customVTvType.setText(request.getType());
        }
    }
}
