package com.aurx.main.songs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MusicPlayback {
    List<Song> songs=new ArrayList<>();
    public void addSong(Song song){
        songs.add(song);
    }
    public void playSongs(){
        System.out.println("Starting Shuffling the songs");
        shufflingSongs();
        System.out.println("After Shuffling:");
            for(Song s:songs){
                System.out.println(s.getSongName());
            }
    }

    private void shufflingSongs() {
        Random random=new Random();
        for(int i=0;i<songs.size();i++){
            Collections.swap(songs,i,random.nextInt(i+1));
        }
    }
}
