package com.ddd.station.util;

import java.net.URI;

public class Util {

    public static final String base = "/station";

    public static URI createURI(String id) {
        return URI.create(base + '/' + id);
    }
}
