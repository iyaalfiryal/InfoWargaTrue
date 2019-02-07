package com.layrif.infowargatrue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBaju{

	@SerializedName("result")
	private boolean result;

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private List<DataBaju> data;

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

	public void setData(List<DataBaju> data){
		this.data = data;
	}

	public List<DataBaju> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ResponseBaju{" + 
			"result = '" + result + '\'' + 
			",pesan = '" + pesan + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}