package org.example.utils;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataHeroeFromApi {
    private Integer id;
    private String name;
    private String description;
    private String modified;

    public DataHeroeFromApi(String hero) throws IOException {
        RestApi example = new RestApi();
        AppGetPropertyValues prop = new AppGetPropertyValues();
        String hash2 = prop.getPropValues("hash");
        String apiKey = prop.getPropValues("apikey");

        String response;

        String url1 = "https://gateway.marvel.com/v1/public/characters?nameStartsWith=";
        String url2 = "&limit=1&offset=1&ts=1&apikey=";
        String hash = "hash=";
        String url = String.format("%s%s%s%s%s%s", url1, hero, url2, apiKey, hash,hash2);
        
        response = example.run(url);

        JSONObject responseH = new JSONObject(response);
        JSONObject data = responseH.getJSONObject("data");
        JSONArray results = data.getJSONArray("results");
        JSONObject objectResults = results.getJSONObject(0);

        this.id = objectResults.getInt("id");
        this.name = objectResults.getString("name");
        this.description = objectResults.getString("description");
        this.modified = objectResults.getString("modified");
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

}
