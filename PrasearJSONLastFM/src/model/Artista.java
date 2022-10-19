package model;

import com.google.gson.annotations.SerializedName;

public class Artista {

	@SerializedName("@attr")
	private ranking ranking;
	private String url;
	private String playcount;
	private String name;
	
	
	
	@Override
	public String toString() {
		return "Artista [ranking=" + ranking + ", url=" + url + ", playcount=" + playcount + ", name=" + name + "]";
	}
	
	
}
