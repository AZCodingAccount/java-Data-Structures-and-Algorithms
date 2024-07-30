package com.zh.job.design;

import java.util.HashMap;
import java.util.Map;

public class Codec {
    Map<String, String> db = new HashMap<>();
    long id = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = Integer.toHexString(String.valueOf(id++).hashCode());
        while (db.containsKey(shortUrl)) {
            shortUrl = Integer.toHexString(String.valueOf(id++).hashCode());
        }
        db.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return db.get(shortUrl);
    }


    public static void main(String[] args) {
        System.out.println(new Codec().encode("www.bugdesigner.cn"));
    }
}