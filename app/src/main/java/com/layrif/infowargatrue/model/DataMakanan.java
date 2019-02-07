package com.layrif.infowargatrue.model;

import com.google.gson.annotations.SerializedName;

public class DataMakanan {

	@SerializedName("user_makanan")
	private String userMakanan;

	@SerializedName("id_makanan")
	private String idMakanan;

	@SerializedName("nama_makanan")
	private String namaMakanan;

	@SerializedName("alamat_makanan")
	private String alamatMakanan;

	@SerializedName("nohp_makanan")
	private String nohpMakanan;

	@SerializedName("img_makanan")
	private String imgMakanan;

	@SerializedName("waktu_makanan")
	private String waktuMakanan;

	public void setUserMakanan(String userMakanan){
		this.userMakanan = userMakanan;
	}

	public String getUserMakanan(){
		return userMakanan;
	}

	public void setIdMakanan(String idMakanan){
		this.idMakanan = idMakanan;
	}

	public String getIdMakanan(){
		return idMakanan;
	}

	public void setNamaMakanan(String namaMakanan){
		this.namaMakanan = namaMakanan;
	}

	public String getNamaMakanan(){
		return namaMakanan;
	}

	public void setAlamatMakanan(String alamatMakanan){
		this.alamatMakanan = alamatMakanan;
	}

	public String getAlamatMakanan(){
		return alamatMakanan;
	}

	public void setNohpMakanan(String nohpMakanan){
		this.nohpMakanan = nohpMakanan;
	}

	public String getNohpMakanan(){
		return nohpMakanan;
	}

	public void setImgMakanan(String imgMakanan){
		this.imgMakanan = imgMakanan;
	}

	public String getImgMakanan(){
		return imgMakanan;
	}

	public void setWaktuMakanan(String waktuMakanan){
		this.waktuMakanan = waktuMakanan;
	}

	public String getWaktuMakanan(){
		return waktuMakanan;
	}

	@Override
 	public String toString(){
		return 
			"DataMakanan{" +
			"user_makanan = '" + userMakanan + '\'' + 
			",id_makanan = '" + idMakanan + '\'' + 
			",nama_makanan = '" + namaMakanan + '\'' + 
			",alamat_makanan = '" + alamatMakanan + '\'' + 
			",nohp_makanan = '" + nohpMakanan + '\'' + 
			",img_makanan = '" + imgMakanan + '\'' + 
			",waktu_makanan = '" + waktuMakanan + '\'' + 
			"}";
		}
}