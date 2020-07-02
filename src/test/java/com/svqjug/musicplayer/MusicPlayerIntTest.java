package com.svqjug.musicplayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MusicPlayerIntTest {

    private MusicPlayer sut;
    private Playlist playlist;

    @BeforeEach
    public void setUp() {
        playlist = new Playlist(new ArrayList<>());
        sut = new MusicPlayer(playlist);
    }

    @Test
    public void givenANullSongToPlayShouldThrowMusicPlayerException() {
        Exception exception = assertThrows(
                MusicPlayerException.class,
                () -> sut.play(null));

        assertThat(exception.getMessage()).isEqualTo(MusicPlayerException.NULL_SONG_MESSAGE);
    }

    @Test
    public void givenNotInPlaylistSongToPlayShouldThrowMusicPlayerException() {
        Exception exception = assertThrows(
                MusicPlayerException.class,
                () -> sut.play("not added song"));

        assertThat(exception.getMessage()).isEqualTo(MusicPlayerException.NOT_IN_PLAYLIST_SONG_MESSAGE);
    }

    @Test
    public void givenAddedToPlaylistSongShouldPlayIt() {
        String song = "test song";
        sut.add(song);
        sut.play(song);
    }
}
