package model;

import java.util.ArrayList;
import java.util.List;

public class Processor {
	
	private Parser p;
	
	public Processor (Parser p) {
		this.p = p;
	}
	
	public List<Album> searchAlbum (String query) {
		List<Album> albumList = p.getAlbumList();
		List<Album> searchAlbums = new ArrayList<Album>();
		for (Album a : albumList) {
			if (new Rgx(a, query).match()) {
				searchAlbums.add(a);
			}
		}
		return searchAlbums;
	}
	public List<Song> searchSong (String query) {
		List<Song> songList = p.getSongList();
		List<Song> searchSongs = new ArrayList<Song>();
		for (Song s : songList) {
			if (new Rgx(s, query).match()) {
				searchSongs.add(s);
			}
		}
		return searchSongs;
	}
	public Album getAlbumFromID (String albumID) {
		List<Album> albumList = p.getAlbumList();
		for (Album a : albumList) {
			if (new Rgx(a, albumID).match()) {
				return a;
			}
		}
		return null;
	}
	public Song getSongFromID (String songID) {
		List<Song> songList = p.getSongList();
		for (Song s : songList) {
			if (new Rgx(s, songID).match()) {
				return s;
			}
		}
		return null;
	}

}
