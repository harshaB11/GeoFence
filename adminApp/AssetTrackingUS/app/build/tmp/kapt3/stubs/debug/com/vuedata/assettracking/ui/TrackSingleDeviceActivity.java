package com.vuedata.assettracking.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 62\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00016B\u0005\u00a2\u0006\u0002\u0010\u0005J(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0002J\u0012\u0010$\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010\'\u001a\u00020\u001dH\u0014J\b\u0010(\u001a\u00020\u001dH\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u001dH\u0014J\b\u0010-\u001a\u00020\u001dH\u0014J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020&H\u0014J\b\u00100\u001a\u00020\u001dH\u0014J\b\u00101\u001a\u00020\u001dH\u0014J\u0010\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0013H\u0002J\u0010\u00104\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0013H\u0002J\u0006\u00105\u001a\u00020\u001dR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/vuedata/assettracking/ui/TrackSingleDeviceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/core/app/ActivityCompat$OnRequestPermissionsResultCallback;", "Lcom/mapbox/mapboxsdk/maps/OnMapReadyCallback;", "Lcom/mapbox/mapboxsdk/maps/MapboxMap$OnMapClickListener;", "()V", "binding", "Lcom/vuedata/assettracking/databinding/ActivityTrackSingleDeviceBinding;", "getBinding", "()Lcom/vuedata/assettracking/databinding/ActivityTrackSingleDeviceBinding;", "setBinding", "(Lcom/vuedata/assettracking/databinding/ActivityTrackSingleDeviceBinding;)V", "deviceid", "", "getDeviceid", "()Ljava/lang/String;", "setDeviceid", "(Ljava/lang/String;)V", "lastSymbol", "Lcom/mapbox/mapboxsdk/plugins/annotation/Symbol;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mapboxMap", "Lcom/mapbox/mapboxsdk/maps/MapboxMap;", "symbolManager", "Lcom/mapbox/mapboxsdk/plugins/annotation/SymbolManager;", "insertTrackerIconOnMap", "", "point", "Lcom/mapbox/mapboxsdk/geometry/LatLng;", "title", "imageId", "", "description", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLowMemory", "onMapClick", "", "onMapReady", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "setSelectedIconTracker", "symbol", "setTrackerIcon", "trackDevice", "Companion", "app_debug"})
public final class TrackSingleDeviceActivity extends androidx.appcompat.app.AppCompatActivity implements androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback, com.mapbox.mapboxsdk.maps.OnMapReadyCallback, com.mapbox.mapboxsdk.maps.MapboxMap.OnMapClickListener {
    @org.jetbrains.annotations.NotNull()
    public static final com.vuedata.assettracking.ui.TrackSingleDeviceActivity.Companion Companion = null;
    private static final java.lang.String MARKER_TRACKER = "MARKER_";
    private static final java.lang.String MARKER_SELECTED_TRACKER = "MARKER_SELECTED_";
    private com.mapbox.mapboxsdk.plugins.annotation.SymbolManager symbolManager;
    private com.mapbox.mapboxsdk.plugins.annotation.Symbol lastSymbol;
    private com.mapbox.mapboxsdk.maps.MapboxMap mapboxMap;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String deviceid;
    public com.vuedata.assettracking.databinding.ActivityTrackSingleDeviceBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler mainHandler = null;
    
    public TrackSingleDeviceActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDeviceid() {
        return null;
    }
    
    public final void setDeviceid(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.vuedata.assettracking.databinding.ActivityTrackSingleDeviceBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.vuedata.assettracking.databinding.ActivityTrackSingleDeviceBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Handler getMainHandler() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void trackDevice() {
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.mapbox.mapboxsdk.maps.MapboxMap mapboxMap) {
    }
    
    private final void insertTrackerIconOnMap(com.mapbox.mapboxsdk.geometry.LatLng point, java.lang.String title, int imageId, java.lang.String description) {
    }
    
    private final void setTrackerIcon(com.mapbox.mapboxsdk.plugins.annotation.Symbol symbol) {
    }
    
    private final void setSelectedIconTracker(com.mapbox.mapboxsdk.plugins.annotation.Symbol symbol) {
    }
    
    @java.lang.Override()
    public boolean onMapClick(@org.jetbrains.annotations.NotNull()
    com.mapbox.mapboxsdk.geometry.LatLng point) {
        return false;
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    @java.lang.Override()
    public void onLowMemory() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/vuedata/assettracking/ui/TrackSingleDeviceActivity$Companion;", "", "()V", "MARKER_SELECTED_TRACKER", "", "MARKER_TRACKER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}