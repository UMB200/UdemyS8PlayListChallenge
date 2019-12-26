package com.UmidJavaUdemy;
import java.util.ArrayList;
import java.util.List;
//Challenge part 2
// Modify the playlist challenge so that the Album class uses an inner class.
// Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
// The inner SongList class will use an ArrayList and will provide a method to add a song.
// It will also provide findSong() methods which will be used by the containing Album class
// to add songs to the playlist.
// Neither the Song class or the Main class should be changed.
public class Album {
    private String albumName;
    private SongList songList ;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songList = new SongList();
    }

    public boolean addSong(String newSongName, double duration) {
            return this.songList.addSong(new Song(newSongName, duration));
    }

    public boolean addSongToPlayList(int songNumber, List<Song> songList){
        Song currentSong = this.songList.findSong(songNumber);
        if(currentSong != null) {
            songList.add(currentSong);
            return true;
        }
            System.out.println("Song track " + songNumber + " does not exist in this album" );
            return false;

    }
    public boolean addSongToPlayList(String songName, List<Song> newSongList){
       Song currentSong = this.songList.findSong(songName);
       if(currentSong != null){
            newSongList.add(currentSong);
            return true;
        }
            System.out.println("Song " + songName + " does not exist in this album" );
            return false;

    }

    public String getAlbumName() {
        return albumName;
    }

    private class SongList {
        private ArrayList<Song> songArrayList;

        public SongList() {
            this.songArrayList = new ArrayList<Song>();
        }
        public boolean addSong(Song song){
            if(songArrayList.contains(song)){
                return false;
            }
            this.songArrayList.add(song);
            return true;
        }
        public Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if ((index >= 0) && index < songArrayList.size()) {
                Song song = songArrayList.get(index);
                return song;

            }
            return null;
        }

        public Song findSong(String songName) {
            for (int i = 0; i < songArrayList.size(); i++) {
                Song song = this.songArrayList.get(i);
                if (song.getSongTitle().equals(songName)) {
                    return song;
                }
            }
            return null;
        }
    }
}
