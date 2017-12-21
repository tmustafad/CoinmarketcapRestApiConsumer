package com.coinmarket.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {

	public Coin() {
	}

	private String id;
	private String name;
	private String price_usd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice_usd() {
		return price_usd;
	}

	public void setPrice_usd(String price_usd) {
		this.price_usd = price_usd;
	}

}
