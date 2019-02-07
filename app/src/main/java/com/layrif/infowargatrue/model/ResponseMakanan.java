package com.layrif.infowargatrue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMakanan{

	@SerializedName("result")
	private boolean result;

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private List<DataMakanan> data;

	public void setResult(boolean result){
		this.result = result;
	}

	public boolean isResult(){
		return result;
	}

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(List<DataMakanan> data){
		this.data = data;
	}

	public List<DataMakanan> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ResponseMakanan{" + 
			"result = '" + result + '\'' + 
			",pesan = '" + pesan + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}