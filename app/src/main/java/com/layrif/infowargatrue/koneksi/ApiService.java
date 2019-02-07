package com.layrif.infowargatrue.koneksi;

import com.layrif.infowargatrue.model.ResponseBaju;
import com.layrif.infowargatrue.model.ResponseBangunan;
import com.layrif.infowargatrue.model.ResponseElek;
import com.layrif.infowargatrue.model.ResponseMakanan;
import com.layrif.infowargatrue.model.ResponseMinuman;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("index.php/api/get_penjualbaju")
    Call<ResponseBaju> getAllBaju(@Query("api_key") String api_key,
                                  @Query("nama_baju") String nama_baju,
                                  @Query("alamat_baju") String alamat_baju,
                                  @Query("user_baju") String user_baju,
                                  @Query("nohp_baju") String nohp_baju,
                                  @Query("img_baju") String img_baju,
                                  @Query("waktu_baju") String waktu_baju);

    @GET("index.php/api/get_penjualmakanan")
    Call<ResponseMakanan>getAllMakanan(@Query("api_key") String api_key,
                                       @Query("nama_makanan") String nama_makanan,
                                       @Query("alamat_makanan") String alamat_makanan,
                                       @Query("user_makanan") String user_makanan,
                                       @Query("nohp_makanan") String nohp_makanan,
                                       @Query("img_makanan") String img_makanan,
                                       @Query("waktu_makanan") String waktu_makanan);

    @GET("index.php/api/get_penjualminuman")
    Call<ResponseMinuman>getAllMinuman(@Query("api_key") String api_key,
                                       @Query("nama_minuman") String nama_minuman,
                                     @Query("alamat_minuman") String alamat_minuman,
                                     @Query("user_minuman") String user_minuman,
                                     @Query("nohp_minuman") String nohp_minuman,
                                     @Query("img_minuman") String img_minuman,
                                     @Query("waktu_minuman") String waktu_minuman);

    @GET("index.php/api/get_tukangelektronik")
    Call<ResponseElek>getAllElek(@Query("api_key") String api_key,
                                 @Query("nama_elek") String nama_elek,
                                 @Query("alamat_elek") String alamat_elek,
                                 @Query("user_elek") String user_elek,
                                 @Query("nohp_elek") String nohp_elek,
                                 @Query("img_elek") String img_elek,
                                 @Query("waktu_elek") String waktu_elek);

    @GET("index.php/api/get_tukangbangunan")
    Call<ResponseBangunan>getAllbangunan(@Query("api_key") String api_key,
                                         @Query("nama_bangunan") String nama_bangunan,
                                         @Query("alamat_bangunan") String alamat_bangunan,
                                         @Query("user_bangunan") String user_bangunan,
                                         @Query("nohp_bangunan") String nohp_bangunan,
                                         @Query("img_bangunan") String img_bangunan,
                                         @Query("waktu_bangunan") String waktu_bangunan);
}
