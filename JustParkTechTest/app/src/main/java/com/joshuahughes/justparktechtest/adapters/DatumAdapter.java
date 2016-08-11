package com.joshuahughes.justparktechtest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.joshuahughes.justparktechtest.R;
import com.joshuahughes.justparktechtest.Utils;
import com.joshuahughes.justparktechtest.models.Datum;

import java.util.List;

public class DatumAdapter extends RecyclerView.Adapter<DatumAdapter.ViewHolder> {

    private Context mContext;

    private List<Datum> mData;
    private ItemListener mListener;

    public DatumAdapter(Context context, List<Datum> data, ItemListener listener) {
        mContext = context;
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
            rowPrice.setText(Utils.getFormattedPrice(
                    datum.getCurrency().getSymbol(), datum.getPrice()));

            rowDistance.setText(Utils.getFormattedDistance(mContext.getResources(), datum));

            if(datum.getReviewCount() > 0){
                rowRatingsInfo.setText(
                        Utils.getFormattedReviewScore(mContext.getResources(), datum));
                rowRatingsBar.setMax(5);
                rowRatingsBar.setNumStars(5);
                rowRatingsBar.setRating(datum.getReviewAverage().floatValue());
            }
            else{
                rowRatingsInfo.setText(mContext.getResources().getString(R.string.no_review));
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
