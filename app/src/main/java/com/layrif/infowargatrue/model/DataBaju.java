package com.layrif.infowargatrue.model;

import com.google.gson.annotations.SerializedName;


public class DataBaju {

	@SerializedName("id_baju")
	private String idBaju;

	@SerializedName("waktu_baju")
	private String waktuBaju;

	@SerializedName("alamat_baju")
	private String alamatBaju;

	@SerializedName("img_baju")
	private String imgBaju;

	@SerializedName("nohp_baju")
	private String nohpBaju;

	@SerializedName("user_baju")
	private String userBaju;

	@SerializedName("nama_baju")
	private String namaBaju;

	public void setIdBaju(String idBaju){
		this.idBaju = idBaju;
	}

	public String getIdBaju(){
		return idBaju;
	}

	public void setWaktuBaju(String waktuBaju){
		this.waktuBaju = waktuBaju;
	}

	public String getWaktuBaju(){
		return waktuBaju;
	}

	public void setAlamatBaju(String alamatBaju){
		this.alamatBaju = alamatBaju;
	}

	public String getAlamatBaju(){
		return alamatBaju;
	}

	public void setImgBaju(String imgBaju){
		this.imgBaju = imgBaju;
	}

	public String getImgBaju(){
		return imgBaju;
	}

	public void setNohpBaju(String nohpBaju){
		this.nohpBaju = nohpBaju;
	}

	public String getNohpBaju(){
		return nohpBaju;
	}

	public void setUserBaju(String userBaju){
		this.userBaju = userBaju;
	}

	public String getUserBaju(){
		return userBaju;
	}

	public void setNamaBaju(String namaBaju){
		this.namaBaju = namaBaju;
	}

	public String getNamaBaju(){
		return namaBaju;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"id_baju = '" + idBaju + '\'' + 
			",waktu_baju = '" + waktuBaju + '\'' + 
			",alamat_baju = '" + alamatBaju + '\'' + 
			",img_baju = '" + imgBaju + '\'' + 
			",nohp_baju = '" + nohpBaju + '\'' + 
			",user_baju = '" + userBaju + '\'' + 
			",nama_baju = '" + namaBaju + '\'' + 
			"}";
		}
}