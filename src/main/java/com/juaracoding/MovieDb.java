package com.juaracoding;

import org.json.simple.JSONObject;


public class MovieDb {
    private String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhNTg5OGY0NTE1M2U5ZDVkMTI2MTBjNjdkODE5OWZjZCIsInN1YiI6IjY1MmZjZDFjYTgwMjM2MDBjMzE2NzNlMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.oMFAx6jCJAALpQ1sDwoUpDWHo4PZElew9d1BRemsgCc";
    private String endpoint = "https://api.themoviedb.org/3/movie";
    private String nowPlaying = "now_playing?language=en-US&page=1";
    private String popularMovie = "popular?language=en-US&page=1";

    private JSONObject request;

    public MovieDb(){
        this.request = new JSONObject();
    }

    public JSONObject getRequest() {
        return request;
    }
    public String getEndpoint() {
        return endpoint;
    }

    public String getToken() {
        return token;
    }

    public String getNowPlaying() {
        return nowPlaying;
    }

    public String getPopularMovie() {
        return popularMovie;
    }

    public String addRatingMovie(String id){
        return id + "/rating";
    }
}
