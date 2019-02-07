package com.layrif.infowargatrue.model;

import com.google.gson.annotations.SerializedName;

public class DataMinuman {

	@SerializedName("id_minuman")
	private String idMinuman;

	@SerializedName("nama_minuman")
	private String namaMinuman;

	@SerializedName("img_minuman")
	private String imgMinuman;

	@SerializedName("user_minuman")
	private String userMinuman;

	@SerializedName("alamat_minuman")
	private String alamatMinuman;

	@SerializedName("nohp_minuman")
	private String nohpMinuman;

	@SerializedName("waktu_minuman")
	private String waktuMinuman;

	public void setIdMinuman(String idMinuman){
		this.idMinuman = idMinuman;
	}

	public String getIdMinuman(){
		return idMinuman;
	}

	public void setNamaMinuman(String namaMinuman){
		this.namaMinuman = namaMinuman;
	}

	public String getNamaMinuman(){
		return namaMinuman;
	}

	public void setImgMinuman(String imgMinuman){
		this.imgMinuman = imgMinuman;
	}

	public String getImgMinuman(){
		return imgMinuman;
	}

	public void setUserMinuman(String userMinuman){
		this.userMinuman = userMinuman;
	}

	public String getUserMinuman(){
		return userMinuman;
	}

	public void setAlamatMinuman(String alamatMinuman){
		this.alamatMinuman = alamatMinuman;
	}

	public String getAlamatMinuman(){
		return alamatMinuman;
	}

	public void setNohpMinuman(String nohpMinuman){
		this.nohpMinuman = nohpMinuman;
	}

	public String getNohpMinuman(){
		return nohpMinuman;
	}

	public void setWaktuMinuman(String waktuMinuman){
		this.waktuMinuman = waktuMinuman;
	}

	public String getWaktuMinuman(){
		return waktuMinuman;
	}

	@Override
 	public String toString(){
		return 
			"DataBaju{" +
			"id_minuman = '" + idMinuman + '\'' + 
			",nama_minuman = '" + namaMinuman + '\'' + 
			",img_minuman = '" + imgMinuman + '\'' + 
			",user_minuman = '" + userMinuman + '\'' + 
			",alamat_minuman = '" + alamatMinuman + '\'' + 
			",nohp_minuman = '" + nohpMinuman + '\'' + 
			",waktu_minuman = '" + waktuMinuman + '\'' + 
			"}";
		}
}