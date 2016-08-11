package com.joshuahughes.justparktechtest.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;

import com.joshuahughes.justparktechtest.R;
import com.joshuahughes.justparktechtest.models.Datum;
import com.joshuahughes.justparktechtest.models.Metadata;
import com.joshuahughes.justparktechtest.models.RegionSearchResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MapFragment extends Fragment implements
        OnMapReadyCallback,
        OnMarkerClickListener,
        OnMapClickListener{


    private MapView mapView;
    private GoogleMap googleMap;

    private CameraPosition cameraPosition;
    private final String cameraPositionKey = "cameraPosition";

    private RegionSearchResponse regionSearchResponse;
    private final String regionSearchResponseKey = "regionSearchResponse";

    private Integer selectedDatumId;
    private final String selectedDatumIdKey = "selectedDatum";

    private Marker selectedMarker;
    private HashMap<String,Integer> markerToDatumMap;
    private OnFragmentInteractionListener mListener;

    public MapFragment() {
        // Required empty public constructor
    }


    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public interface OnFragmentInteractionListener {
        void onMapFragmentMarkerClick(Datum datum);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        if(savedInstanceState != null){
            cameraPosition = savedInstanceState.getParcelable(cameraPositionKey);
            regionSearchResponse = savedInstanceState.getParcelable(regionSearchResponseKey);
            savedInstanceState.remove(regionSearchResponseKey);
            selectedDatumId = savedInstanceState.getInt(selectedDatumIdKey);
        }

        mapView = (MapView) view.findViewById(R.id.googleMap);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putParcelable(cameraPositionKey, cameraPosition);
        outState.putParcelable(regionSearchResponseKey, regionSearchResponse);
        if(selectedDatumId != null) {
            outState.putInt(selectedDatumIdKey, selectedDatumId);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume(){
        mapView.onResume();
        super.onResume();

    }

    @Override
    public void onPause(){
        mapView.onPause();
        super.onPause();
        if(googleMap != null) {
            cameraPosition = googleMap.getCameraPosition();
        }
    }

    @Override
    public void onDestroy(){
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory(){
        mapView.onLowMemory();
        super.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap map){
        googleMap = map;

        googleMap.getUiSettings().setMapToolbarEnabled(false);;
        googleMap.setPadding(0,144,0,0);
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMapClickListener(this);

        if(cameraPosition == null) {
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.5560241, -0.2817075), 9.0f));
        }
        else{
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }

        if(regionSearchResponse != null){
            LatLng inputLatlng = drawStartLocationMarker(regionSearchResponse.getMetadata());
            List<LatLng> latLngs = drawMarkers(regionSearchResponse.getData());

            if(selectedDatumId != null) {
                for (Datum selectedDatum : regionSearchResponse.getData()) {
                    if (selectedDatum.getId().equals(selectedDatumId)){
                        mListener.onMapFragmentMarkerClick(selectedDatum);
                    }
                }
            }
        }
    }

    @Override
    public void onMapClick(LatLng point) {
        if(selectedDatumId != null){
            deSelectCurrentMarker();
            selectedDatumId = null;
            selectedMarker = null;
            mListener.onMapFragmentMarkerClick(null);
        }
    }

    @Override
    public boolean onMarkerClick(final Marker marker){

        deSelectCurrentMarker();

        //set new selected marker
        Datum newDatum = getDatumFromMarkerMap(marker);
        if(newDatum != null) {
            marker.setIcon(BitmapDescriptorFactory.fromBitmap(createMarkerBitmap(newDatum, true)));
            selectedMarker = marker;
            selectedDatumId = newDatum.getId();
        }

        mListener.onMapFragmentMarkerClick(newDatum);

        return false;
    }

    public void DrawNewResponse(RegionSearchResponse rsr){

        regionSearchResponse = rsr;

        googleMap.clear();

        LatLng inputLatlng = drawStartLocationMarker(regionSearchResponse.getMetadata());
        List<LatLng> latLngs = drawMarkers(regionSearchResponse.getData());

        latLngs.add(inputLatlng);

        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(getLatLngBounds(latLngs),150));
    }


    private List<LatLng> drawMarkers(List<Datum> data){

        List<LatLng> latLngs = new ArrayList<>();
        markerToDatumMap = new HashMap<>();

        for(int i = 0; i < data.size(); i++){

            LatLng latLng = new LatLng(
                    data.get(i).getLocation().getLatitude(),
                    data.get(i).getLocation().getLongitude()
            );
            latLngs.add(latLng);

            boolean preSelected = (selectedDatumId != null && selectedDatumId.equals(data.get(i).getId()));

            Marker marker = googleMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .icon(BitmapDescriptorFactory.fromBitmap(createMarkerBitmap(data.get(i), preSelected)))
            );
            if(preSelected){
                selectedMarker = marker;
            }

            markerToDatumMap.put(marker.getId(), data.get(i).getId());
        }

        return latLngs;
    }

    private LatLng drawStartLocationMarker(Metadata metadata){
        LatLng inputLatLng = new LatLng(
                regionSearchResponse.getMetadata().getLocationLat(),
                regionSearchResponse.getMetadata().getLocationLng()
        );
        googleMap.addMarker(new MarkerOptions()
                .position(inputLatLng)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        );

        return inputLatLng;
    }

    private LatLngBounds getLatLngBounds(List<LatLng> latLngs){
        final LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for(int i = 0; i< latLngs.size(); i++){
            builder.include(latLngs.get(i));
        }

        return builder.build();
    }

    private Bitmap createMarkerBitmap(Datum datum, boolean selected){

        IconGenerator iconGenerator = new IconGenerator(getActivity());

        if(selected){
            iconGenerator.setColor(getActivity().getResources().getColor(R.color.justParkPrimary));
            iconGenerator.setTextAppearance(R.style.MarkerTextSelected);
        }
        else {
            iconGenerator.setTextAppearance(R.style.MarkerText);
        }

        return iconGenerator.makeIcon(datum.getCurrency().getSymbol() +
                String.format("%.2f",datum.getPrice()));
    }

    private Datum getDatumFromMarkerMap(Marker marker){
        Integer datumId = markerToDatumMap.get(marker.getId());

        for(Datum datum : regionSearchResponse.getData()){
            if(datum.getId().equals(datumId)){
                return datum;
            }
        }
        return null;
    }

    private void deSelectCurrentMarker(){
        //re-set previously selected marker (if there is one)
        if(selectedMarker != null) {
            Datum prevDatum = getDatumFromMarkerMap(selectedMarker);
            selectedMarker.setIcon(BitmapDescriptorFactory.fromBitmap(createMarkerBitmap(prevDatum, false)));
        }
    }

    public RegionSearchResponse getRegionSearchResponseData(){
        return regionSearchResponse;
    }
}
