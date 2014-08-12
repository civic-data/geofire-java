package com.firebase.geofire;

import com.firebase.client.FirebaseError;

public class GeoQueryEventTestListener extends TestListener implements GeoQueryEventListener {

    private final boolean recordEntered;
    private final boolean recordMoved;
    private final boolean recordExited;

    public GeoQueryEventTestListener() {
        this(true, true, true);
    }

    public GeoQueryEventTestListener(boolean recordEntered, boolean recordMoved, boolean recordExited) {
        this.recordEntered = recordEntered;
        this.recordMoved = recordMoved;
        this.recordExited = recordExited;
    }

    public static String keyEntered(String key, double latitude, double longitude) {
        return String.format("KEY_ENTERED(%s,%f,%f)", key, latitude, longitude);
    }

    public static String keyMoved(String key, double latitude, double longitude) {
        return String.format("KEY_MOVED(%s,%f,%f)", key, latitude, longitude);
    }

    public static String keyExited(String key) {
        return String.format("KEY_EXITED(%s)", key);
    }

    @Override
    public void onKeyEntered(String key, double latitude, double longitude) {
        if (recordEntered) {
            this.addEvent(keyEntered(key, latitude, longitude));
        }
    }

    @Override
    public void onKeyExited(String key) {
        if (recordExited) {
            this.addEvent(keyExited(key));
        }
    }

    @Override
    public void onKeyMoved(String key, double latitude, double longitude) {
        if (recordMoved) {
            this.addEvent(keyMoved(key, latitude, longitude));
        }
    }

    @Override
    public void onGeoQueryReady() {
    }

    @Override
    public void onGeoQueryError(FirebaseError error) {
    }
}
