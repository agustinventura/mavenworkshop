package com.svqjug.musicplayer;


import java.io.FileNotFoundException;
import java.util.List;

public class Playlist {

    private final List<String> songList;

    Playlist(List<String> songs) {
        songList = songs;
    }

    public String get(String songName) throws FileNotFoundException {
        if (!exists(songName)) {
            throw new FileNotFoundException("Song " + songName + " does not exists in playlist");
        }
        return songList.stream().filter(song -> song.equalsIgnoreCase(songName)).findFirst().get();
    }

    private boolean exists(final String songName) {
        return songList.stream().anyMatch(song -> song.equalsIgnoreCase(songName));
    }

    protected void add(String song) {
        if (song != null && !"".equals(song.trim())) {
            songList.add(song);
        }
    }
}
