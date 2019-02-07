package com.layrif.infowargatrue.model;

import com.google.gson.annotations.SerializedName;

public class DataBangunan {

	@SerializedName("waktu_bangunan")
	private String waktuBangunan;

	@SerializedName("user_bangunan")
	private String userBangunan;

	@SerializedName("nama_bangunan")
	private String namaBangunan;

	@SerializedName("id_bangunan")
	private String idBangunan;

	@SerializedName("alamat_bangunan")
	private String alamatBangunan;

	@SerializedName("nohp_bangunan")
	private String nohpBangunan;

	@SerializedName("img_bangunan")
	private String imgBangunan;

	public void setWaktuBangunan(String waktuBangunan){
		this.waktuBangunan = waktuBangunan;
	}

	public String getWaktuBangunan(){
		return waktuBangunan;
	}

	public void setUserBangunan(String userBangunan){
		this.userBangunan = userBangunan;
	}

	public String getUserBangunan(){
		return userBangunan;
	}

	public void setNamaBangunan(String namaBangunan){
		this.namaBangunan = namaBangunan;
	}

	public String getNamaBangunan(){
		return namaBangunan;
	}

	public void setIdBangunan(String idBangunan){
		this.idBangunan = idBangunan;
	}

	public String getIdBangunan(){
		return idBangunan;
	}

	public void setAlamatBangunan(String alamatBangunan){
		this.alamatBangunan = alamatBangunan;
	}

	public String getAlamatBangunan(){
		return alamatBangunan;
	}

	public void setNohpBangunan(String nohpBangunan){
		this.nohpBangunan = nohpBangunan;
	}

	public String getNohpBangunan(){
		return nohpBangunan;
	}

	public void setImgBangunan(String imgBangunan){
		this.imgBangunan = imgBangunan;
	}

	public String getImgBangunan(){
		return imgBangunan;
	}

	@Override
 	public String toString(){
		return 
			"DataBangunan{" +
			"waktu_bangunan = '" + waktuBangunan + '\'' + 
			",user_bangunan = '" + userBangunan + '\'' + 
			",nama_bangunan = '" + namaBangunan + '\'' + 
			",id_bangunan = '" + idBangunan + '\'' + 
			",alamat_bangunan = '" + alamatBangunan + '\'' + 
			",nohp_bangunan = '" + nohpBangunan + '\'' + 
			",img_bangunan = '" + imgBangunan + '\'' + 
			"}";
		}
}