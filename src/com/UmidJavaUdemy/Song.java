package com.UmidJavaUdemy;

import java.util.ArrayList;

public class Song {
    private String songTitle;
    private double songDuration;

    public Song(String songTitle, double songDuration) {
        this.songTitle = songTitle;
        this.songDuration = songDuration;
    }

    public Song(String newSongName) {
        this.songTitle = newSongName;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public double getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(double songDuration) {
        this.songDuration = songDuration;
    }

    @Override
    public String toString() {
        return  songTitle + ": duration " + songDuration + " min";
    }
}
