package com.joshuahughes.justparktechtest.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joshuahughes.justparktechtest.R;
import com.joshuahughes.justparktechtest.SimpleDividerItemDecoration;
import com.joshuahughes.justparktechtest.adapters.DatumAdapter;
import com.joshuahughes.justparktechtest.models.Datum;
import com.joshuahughes.justparktechtest.models.RegionSearchResponse;

import java.util.List;


public class ListBottomSheetFragment extends BottomSheetDialogFragment {

    private RegionSearchResponse regionSearchResponse;
    private static final String regionSearchResponseKey = "rsrKey";

    public static ListBottomSheetFragment newInstance(RegionSearchResponse regionSearchResponse) {
        ListBottomSheetFragment fragment = new ListBottomSheetFragment();
        Bundle args = new Bundle();
        args.putParcelable(regionSearchResponseKey, regionSearchResponse);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            regionSearchResponse = getArguments().getParcelable(regionSearchResponseKey);
        }
    }

    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {

        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss();
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        }
    };

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.fragment_list_bottom_sheet, null);

        RecyclerView recyclerView = (RecyclerView) contentView.findViewById(R.id.resultsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        recyclerView.setAdapter(new DatumAdapter(regionSearchResponse.getData(), new DatumAdapter.ItemListener() {
            @Override
            public void onItemClick(Datum datum) {

            }
        }));

        dialog.setContentView(contentView);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();

        if( behavior != null && behavior instanceof BottomSheetBehavior ) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
        }
    }



}
