package com.goesta.imageDownloader;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

/**
 * Huhu
 *
 */
public class App {
	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("customer", "zalando");
		map.put("key", "F2Epkzl");
		ArrayList<String> list = new ArrayList<String>();
		list.add("DI151D02A-O11");
		list.add("HY554B00X-Q11");
		list.add("BA251A00I-O11");
		map.put("list", list);
		// System.out.println(new Gson().toJson(map));
		Response response = client
				.target("http://reporting.zuumeo.com/rest/zalando/sku")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(new Gson().toJson(map)), Response.class);
		System.out
				.println(new Gson().toJson(response.readEntity(String.class)));
	}
}
