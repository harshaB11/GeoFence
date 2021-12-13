package com.vuedata.assettracking.adepter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eBY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016R#\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R#\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006\u001f"}, d2 = {"Lcom/vuedata/assettracking/adepter/DeviceListAdepter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/vuedata/assettracking/adepter/DeviceListAdepter$ViewHolder;", "mcontext", "Landroid/content/Context;", "mList", "Ljava/util/ArrayList;", "Lcom/amazonaws/services/geo/model/ListDevicePositionsResponseEntry;", "Lkotlin/collections/ArrayList;", "adapterOnClick", "Lkotlin/Function2;", "", "", "onClickOpenMap", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getAdapterOnClick", "()Lkotlin/jvm/functions/Function2;", "getMList", "()Ljava/util/ArrayList;", "getMcontext", "()Landroid/content/Context;", "getOnClickOpenMap", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class DeviceListAdepter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.vuedata.assettracking.adepter.DeviceListAdepter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context mcontext = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.amazonaws.services.geo.model.ListDevicePositionsResponseEntry> mList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<com.amazonaws.services.geo.model.ListDevicePositionsResponseEntry, java.lang.Integer, kotlin.Unit> adapterOnClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<com.amazonaws.services.geo.model.ListDevicePositionsResponseEntry, java.lang.Integer, kotlin.Unit> onClickOpenMap = null;
    
    public DeviceListAdepter(@org.jetbrains.annotations.NotNull()
    android.content.Context mcontext, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.amazonaws.services.geo.model.ListDevicePositionsResponseEntry> mList, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.amazonaws.services.geo.model.ListDevicePositionsResponseEntry, ? super java.lang.Integer, kotlin.Unit> adapterOnClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.amazonaws.services.geo.model.ListDevicePositionsResponseEntry, ? super java.lang.Integer, kotlin.Unit> onClickOpenMap) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMcontext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.amazonaws.services.geo.model.ListDevicePositionsResponseEntry> getMList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<com.amazonaws.services.geo.model.ListDevicePositionsResponseEntry, java.lang.Integer, kotlin.Unit> getAdapterOnClick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<com.amazonaws.services.geo.model.ListDevicePositionsResponseEntry, java.lang.Integer, kotlin.Unit> getOnClickOpenMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.vuedata.assettracking.adepter.DeviceListAdepter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.vuedata.assettracking.adepter.DeviceListAdepter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/vuedata/assettracking/adepter/DeviceListAdepter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ItemView", "Landroid/view/View;", "(Landroid/view/View;)V", "deviceName", "Landroid/widget/TextView;", "getDeviceName", "()Landroid/widget/TextView;", "mainlayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMainlayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "registeredTime", "getRegisteredTime", "removeDeviceIcon", "Landroid/widget/ImageView;", "getRemoveDeviceIcon", "()Landroid/widget/ImageView;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView deviceName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView registeredTime = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView removeDeviceIcon = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.constraintlayout.widget.ConstraintLayout mainlayout = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View ItemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getDeviceName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getRegisteredTime() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getRemoveDeviceIcon() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.constraintlayout.widget.ConstraintLayout getMainlayout() {
            return null;
        }
    }
}