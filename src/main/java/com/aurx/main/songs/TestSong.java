package com.aurx.main.songs;

public class TestSong {
    public static void main(String[] args) {
        MusicPlayback playback=new MusicPlayback();
        playback.addSong(new Song("song 1"));
        playback.addSong(new Song("song 2"));
        playback.addSong(new Song("song 3"));
        playback.addSong(new Song("song 4"));
        playback.addSong(new Song("song 100"));
        playback.playSongs();
    }
}
