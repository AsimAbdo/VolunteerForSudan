package edu.aau.projects.volunteerforsudan.uiadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.CustomServiceItemBinding;
import edu.aau.projects.volunteerforsudan.models.ServiceRequest;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceHolder> {

    Context context;
    List<ServiceRequest> serviceRequests;

    public ServiceAdapter() {
    }

    public ServiceAdapter(Context context, List<ServiceRequest> serviceRequests) {
        this.context = context;
        this.serviceRequests = serviceRequests;
    }

    @NonNull
    @Override
    public ServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_service_item, null);
        return new ServiceHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return serviceRequests.size();
    }

    public void setServices(List<ServiceRequest> serviceRequests) {
        this.serviceRequests = serviceRequests;
        notifyDataSetChanged();
    }

    public class ServiceHolder extends RecyclerView.ViewHolder {
        CustomServiceItemBinding bin;
        public ServiceHolder(@NonNull View itemView) {
            super(itemView);
            bin = CustomServiceItemBinding.bind(itemView);
        }
        void onBind(int request_position){
            ServiceRequest request = serviceRequests.get(request_position);
            bin.serviceItemTvType.setText(request.getType());
            bin.serviceItemTvDate.setText(request.getDate());
            bin.serviceItemTvVolunteer.setText(request.getVolunteer());
            bin.serviceItemTvAmount.setText(String.valueOf(request.getAmount()));
            bin.serviceItemTvLoc.setText(request.getLocation());
        }
    }
}
