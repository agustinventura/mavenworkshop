package com.svqjug.musicplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;

public class MusicPlayer {

    private static Logger logger = LoggerFactory.getLogger(MusicPlayer.class);
    private final Playlist playlist;
    private String currentSong;

    public MusicPlayer(Playlist playlist) {
        this.playlist = playlist;
    }

    public void play(String songName) throws MusicPlayerException {
        if (songName == null) {
            throw new MusicPlayerException(MusicPlayerException.NULL_SONG_MESSAGE);
        }
        try {
            currentSong = playlist.get(songName);
        } catch (FileNotFoundException e) {
            logger.error("Song " + songName + " is not in playlist");
            throw new MusicPlayerException(MusicPlayerException.NOT_IN_PLAYLIST_SONG_MESSAGE);
        }
        logger.info("Playing " + currentSong);
    }

    public void add(String songName) {
        this.playlist.add(songName);
    }
}
