package com.example.showoff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Songs {
    private String song,artist;
    public Songs(){}
    public Songs(String song,String artist){
        this.song = song;
        this.artist = artist;
    }

    public String getSong() {
        return song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
