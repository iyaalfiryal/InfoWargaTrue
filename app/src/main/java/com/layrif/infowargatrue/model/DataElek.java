package com.layrif.infowargatrue.model;

import com.google.gson.annotations.SerializedName;

public class DataElek {

	@SerializedName("nama_elek")
	private String namaElek;

	@SerializedName("user_elek")
	private String userElek;

	@SerializedName("alamat_elek")
	private String alamatElek;

	@SerializedName("nohp_elek")
	private String nohpElek;

	@SerializedName("img_elek")
	private String imgElek;

	@SerializedName("waktu_elek")
	private String waktuElek;

	@SerializedName("id_elek")
	private String idElek;

	public void setNamaElek(String namaElek){
		this.namaElek = namaElek;
	}

	public String getNamaElek(){
		return namaElek;
	}

	public void setUserElek(String userElek){
		this.userElek = userElek;
	}

	public String getUserElek(){
		return userElek;
	}

	public void setAlamatElek(String alamatElek){
		this.alamatElek = alamatElek;
	}

	public String getAlamatElek(){
		return alamatElek;
	}

	public void setNohpElek(String nohpElek){
		this.nohpElek = nohpElek;
	}

	public String getNohpElek(){
		return nohpElek;
	}

	public void setImgElek(String imgElek){
		this.imgElek = imgElek;
	}

	public String getImgElek(){
		return imgElek;
	}

	public void setWaktuElek(String waktuElek){
		this.waktuElek = waktuElek;
	}

	public String getWaktuElek(){
		return waktuElek;
	}

	public void setIdElek(String idElek){
		this.idElek = idElek;
	}

	public String getIdElek(){
		return idElek;
	}

	@Override
 	public String toString(){
		return 
			"DataElek{" +
			"nama_elek = '" + namaElek + '\'' + 
			",user_elek = '" + userElek + '\'' + 
			",alamat_elek = '" + alamatElek + '\'' + 
			",nohp_elek = '" + nohpElek + '\'' + 
			",img_elek = '" + imgElek + '\'' + 
			",waktu_elek = '" + waktuElek + '\'' + 
			",id_elek = '" + idElek + '\'' + 
			"}";
		}
}