package com.joshuahughes.justparktechtest.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.joshuahughes.justparktechtest.R;
import com.joshuahughes.justparktechtest.models.Datum;

import java.util.List;

/**
 * Created by joshuahughes on 11/08/2016.
 */
public class DatumAdapter extends RecyclerView.Adapter<DatumAdapter.ViewHolder> {
    private List<Datum> mData;
    private ItemListener mListener;

    public DatumAdapter(List<Datum> data, ItemListener listener) {
        mData = data;
        mListener = listener;
    }

    public void setListener(ItemListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView rowTitle;
        public TextView rowPrice;
        public TextView rowDistance;
        public TextView rowRatingsInfo;
        public RatingBar rowRatingsBar;
        public Datum datum;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            rowTitle  = (TextView) itemView.findViewById(R.id.rowTitle);
            rowPrice = (TextView) itemView.findViewById(R.id.rowPrice);
            rowDistance = (TextView) itemView.findViewById(R.id.rowDistance);
            rowRatingsInfo = (TextView) itemView.findViewById(R.id.rowRatingsInfo);
            rowRatingsBar = (RatingBar) itemView.findViewById(R.id.rowRatingsBar);
        }

        public void setData(Datum d) {
            this.datum = d;
            rowTitle.setText(datum.getTitle());
            rowPrice.setText(datum.getCurrency().getSymbol() +
                    String.format("%.2f",datum.getPrice()));

            String dist = "";
            if(datum.getDistance() > 1){
                dist = String.format("%.2f km", datum.getDistance());
            }
            else {
                String distInMeters = Double.toString(Math.floor(datum.getDistance() * 1000));
                dist = distInMeters + " m";
            }
            rowDistance.setText(dist);

            if(datum.getReviewCount() > 0){
                rowRatingsInfo.setText(datum.getReviewAverage() + " (" + datum.getReviewCount() +")");
                rowRatingsBar.setMax(5);
                rowRatingsBar.setNumStars(5);
                rowRatingsBar.setRating(datum.getReviewAverage().floatValue());
            }
            else{
                rowRatingsInfo.setText(" - Not review yet");
                rowRatingsBar.setVisibility(View.GONE);
            }

        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(datum);
            }
        }
    }

    public interface ItemListener {
        void onItemClick(Datum datum);
    }
}
