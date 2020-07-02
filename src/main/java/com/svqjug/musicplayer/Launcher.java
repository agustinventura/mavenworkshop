package com.svqjug.musicplayer;

import java.util.ArrayList;

public class Launcher {

    public static void main (String... args) {
        MusicPlayer player = new MusicPlayer(new Playlist(new ArrayList<>()));
        String song = "Shake it out";
        player.add(song);
        player.play(song);
    }
}
