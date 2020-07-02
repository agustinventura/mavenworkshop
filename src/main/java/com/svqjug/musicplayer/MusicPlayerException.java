package com.svqjug.musicplayer;

public class MusicPlayerException extends RuntimeException {

    public static final String NULL_SONG_MESSAGE = "Can't play null song";
    public static final String NOT_IN_PLAYLIST_SONG_MESSAGE = "Can't play song not in playlist";

    public MusicPlayerException(String message) {
        super(message);
    }
}
