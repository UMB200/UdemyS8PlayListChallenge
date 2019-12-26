package com.UmidJavaUdemy;
//Challenge Part 1
// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).
// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove()
//Challenge part 2
// Modify the playlist challenge so that the Album class uses an inner class.
// Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
// The inner SongList class will use an ArrayList and will provide a method to add a song.
// It will also provide findSong() methods which will be used by the containing Album class
// to add songs to the playlist.
// Neither the Song class or the Main class should be changed.


import java.util.*;

public class Main {
    private static List<Album> albumArrayList = new ArrayList<Album>();
    public static void main(String[] args) {

        //printSongs(addSong());
        play(addSong());

    }
    private static List<Song>  addSong(){
        Album album1 = new Album("Album 1");
        album1.addSong("Song 1", 10.0);
        album1.addSong("Song 2", 9.0);
        album1.addSong("Song 3", 8.0);
        album1.addSong("Song 4", 7.0);
        album1.addSong("Song 5", 8.0);
        album1.addSong("Song 6", 6.0);
        Album album2 = new Album("Album 2");
        album2.addSong("Song 7", 10.0);
        album2.addSong("Song 8", 9.0);
        album2.addSong("Song 9", 8.0);
        album2.addSong("Song 10", 7.0);
        album2.addSong("Song 11", 8.0);
        album2.addSong("Song 12", 6.0);
        List<Song> playlistLinkedList = new ArrayList<>();
        albumArrayList.add(album1);
        albumArrayList.add(album2);

        return playlistLinkedList;
    }
    private static void printSongs(List<Song> playlistName) {
        Iterator<Song> i = playlistName.iterator();
        System.out.println("==================");
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("==================");
    }

    private static void printInstructions(){
        System.out.println("Choose action: press\n");
        System.out.println("0 - quit\n" +
                           "1 - to start next song\n" +
                           "2 - to start previous song\n" +
                           "3 - to replay the current song\n" +
                           "4 - list songs in the playlist\n" +
                           "5 - to delete current song\n" +
                           "6 - to show options");
    }
    public static void play(List<Song> linkedList){
        albumArrayList.get(0).addSongToPlayList("Song 1", linkedList);
        albumArrayList.get(0).addSongToPlayList(2, linkedList);
        albumArrayList.get(0).addSongToPlayList(3, linkedList);
        albumArrayList.get(0).addSongToPlayList(4, linkedList);
        albumArrayList.get(0).addSongToPlayList(5, linkedList);
        albumArrayList.get(0).addSongToPlayList(6, linkedList);
        albumArrayList.get(1).addSongToPlayList("Song 7", linkedList);
        albumArrayList.get(1).addSongToPlayList("Song 8", linkedList);
        albumArrayList.get(1).addSongToPlayList(3, linkedList);
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        boolean moveForward = false;
        ListIterator<Song> songListIterator = linkedList.listIterator();
        if(linkedList.size() ==0){
            System.out.println("No songs in the playlist");
            return;
        }
        else {
            messageOption(songListIterator.next().toString());
            printInstructions();
        }
        while (!stop){
            int choice = scanner.nextInt();
            switch (choice){
                case 0:
                    System.out.println("Shutting down");
                    stop = true;
                    break;
                case 1:
                    if(!moveForward){
                        if(songListIterator.hasNext()){
                            songListIterator.next();
                        }
                        moveForward = true;
                    }
                    if (songListIterator.hasNext()) {
                        messageOption(songListIterator.next().toString());
                    }
                    else {
                        System.out.println("Reached end of the playlist");
                        moveForward = false;
                    }
                    break;
                case 2:
                    if(moveForward){
                        if(songListIterator.hasPrevious()){
                            songListIterator.previous();
                        }
                        moveForward = false;
                    }
                    if(songListIterator.hasPrevious()){
                        messageOption(songListIterator.previous().toString());
                    }
                    else {
                        System.out.println("Reached beginning of the playlist");
                        moveForward = true;
                    }
                    break;
                case 3:
                    if(moveForward){
                        if(songListIterator.hasPrevious()){
                            messageOption(songListIterator.next().toString());
                            moveForward = false;
                        }
                    } else{
                        if(songListIterator.hasNext()){
                            messageOption(songListIterator.previous().toString());
                            moveForward = true;
                        }
                        else {
                            System.out.println("Reached end of the playlist");
                        }
                    }
                    break;
                case 4:
                    printSongs(linkedList);
                    break;
                case 5:
                    if(linkedList.size() >0){
                        Iterator<Song> i = linkedList.iterator();

                        songListIterator.remove();
                        if(songListIterator.hasNext()){
                            System.out.println(linkedList.indexOf(i)+ " is deleted");
                            messageOption(songListIterator.next().toString());
                        }
                        else if(songListIterator.hasPrevious()) {
                            System.out.println("Reached end of the playlist");
                            messageOption(songListIterator.previous().toString());
                        }
                    }
                    break;
                case 6:
                    printInstructions();

            }
        }
    }
    public static void messageOption(String item){
        System.out.println("Now playing " + item);
    }

}
