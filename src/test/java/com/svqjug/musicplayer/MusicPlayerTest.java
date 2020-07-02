package com.svqjug.musicplayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MusicPlayerTest {

    private MusicPlayer sut;
    private Playlist playlist;

    @BeforeEach
    public void setUp() {
        playlist = mock(Playlist.class);
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
    public void givenNotInPlaylistSongToPlayShouldThrowMusicPlayerException() throws FileNotFoundException {
        when(playlist.get(any(String.class))).thenThrow(FileNotFoundException.class);
        Exception exception = assertThrows(
                MusicPlayerException.class,
                () -> sut.play("not added song"));

        assertThat(exception.getMessage()).isEqualTo(MusicPlayerException.NOT_IN_PLAYLIST_SONG_MESSAGE);
    }

    @Test
    public void givenAddedToPlaylistSongShouldPlayIt() throws FileNotFoundException {
        String song = "test song";
        when(playlist.get(any(String.class))).thenReturn(song);
        sut.play(song);
    }
}
