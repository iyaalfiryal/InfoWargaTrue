package com.layrif.infowargatrue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMinuman{

	@SerializedName("result")
	private boolean result;

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private List<DataMinuman> data;

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

	public void setData(List<DataMinuman> data){
		this.data = data;
	}

	public List<DataMinuman> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ResponseMinuman{" + 
			"result = '" + result + '\'' + 
			",pesan = '" + pesan + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}