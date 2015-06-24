package com.goesta.main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.goesta.model.ZalandoAPIMedia;

public class WebServiceClient {

	private final String URL = "https://api.zalando.com/articles/";

	private static Client client = ClientBuilder.newClient();

	public ZalandoAPIMedia getMedia(String sku) {
		ZalandoAPIMedia media = client.target(URL).path(sku).path("media")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get(ZalandoAPIMedia.class);
		return media;
	}
	
	

}
