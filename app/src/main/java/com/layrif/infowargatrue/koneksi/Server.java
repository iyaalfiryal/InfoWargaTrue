package com.layrif.infowargatrue.koneksi;

public class Server {
    public static final String BASE_URL = "http://192.168.100.240/infowarga/";
    public static ApiService getApiService(){
        return RetrofitConfig.getClient(BASE_URL).create(ApiService.class);

    }
}
