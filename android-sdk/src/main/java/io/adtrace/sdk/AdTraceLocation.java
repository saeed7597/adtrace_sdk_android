package io.adtrace.sdk;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

public class AdTraceLocation extends Service {

    private static String TAG = AdTraceLocation.class.getName();
    private final Context mContext;
    boolean isNetworkEnabled = false;
    Location location;
    double latitude;
    double longitude;
    protected LocationManager locationManager;

    private String provider_info;

    public AdTraceLocation(Context context) {
        this.mContext = context;
        getLocation();
    }

    public void getLocation() {

        try {
            locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);

            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (isNetworkEnabled) {

                provider_info = LocationManager.NETWORK_PROVIDER;

                if (provider_info!=null && !provider_info.isEmpty()) {
                    if (ActivityCompat.checkSelfPermission(mContext,
                                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(provider_info);
                        updateCoordinates();
                    }
                }

            }

        } catch (Exception e) {
            Log.e(TAG, "Impossible to connect to LocationManager", e);
        }
    }

    public void updateCoordinates() {
        if (location != null && getLongitude() != 0 && getLatitude() != 0) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }
    }

    public double getLatitude() {
        if (location != null) {
            latitude = location.getLatitude();
        }

        return latitude;
    }

    public double getLongitude() {
        if (location != null) {
            longitude = location.getLongitude();
        }

        return longitude;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}