package com.vuedata.assettracking.okhttp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/vuedata/assettracking/okhttp/SigV4Interceptor;", "Lokhttp3/Interceptor;", "credentialsProvider", "Lcom/amazonaws/auth/AWSCredentialsProvider;", "serviceName", "", "(Lcom/amazonaws/auth/AWSCredentialsProvider;Ljava/lang/String;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "app_debug"})
public final class SigV4Interceptor implements okhttp3.Interceptor {
    private final com.amazonaws.auth.AWSCredentialsProvider credentialsProvider = null;
    private final java.lang.String serviceName = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.vuedata.assettracking.okhttp.SigV4Interceptor.Companion Companion = null;
    
    public SigV4Interceptor(@org.jetbrains.annotations.NotNull()
    com.amazonaws.auth.AWSCredentialsProvider credentialsProvider, @org.jetbrains.annotations.NotNull()
    java.lang.String serviceName) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/vuedata/assettracking/okhttp/SigV4Interceptor$Companion;", "", "()V", "toAWSRequest", "Lcom/amazonaws/DefaultRequest;", "request", "Lokhttp3/Request;", "serviceName", "", "toSignedOkHttpRequest", "awsRequest", "originalRequest", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.amazonaws.DefaultRequest<java.lang.Object> toAWSRequest(@org.jetbrains.annotations.NotNull()
        okhttp3.Request request, @org.jetbrains.annotations.NotNull()
        java.lang.String serviceName) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final okhttp3.Request toSignedOkHttpRequest(@org.jetbrains.annotations.NotNull()
        com.amazonaws.DefaultRequest<java.lang.Object> awsRequest, @org.jetbrains.annotations.NotNull()
        okhttp3.Request originalRequest) {
            return null;
        }
    }
}