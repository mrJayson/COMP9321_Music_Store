package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Album> albumList;
	private List<Song> songList;
	private List<Song> duplicatedTracks;
	private int totalPrice;//price is stored in cents

	public Cart() {
		setAlbumList(new ArrayList<Album>());
		setSongList(new ArrayList<Song>());
		setDuplicatedTracks(new ArrayList<Song>());
		setTotalPrice(0);
	}

	public List<Album> getAlbumList() {
		return this.albumList;
	}
	private void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}
	public void addAlbum(Album a) {
		if (a != null) {
			
			for (Song s : a.getSongList()) {
				if (trackIsDuplicated(s)) {
					addDuplicatedTrack(s);
				}
			}
			this.albumList.add(a);
			setTotalPrice(this.totalPrice + Integer.parseInt(String.valueOf(Math.round(Float.parseFloat(a.getPrice()) * 100))));
		}
	}
	public void removeAlbum(Album a) {
		for (Album album : this.albumList) {
			if (album.getAlbumID().equals(a.getAlbumID())) {
				this.albumList.remove(album);
				for (Song s : a.getSongList()) {
					if (trackIsDuplicated(s)) {
						removeDuplicatedTrack(s);
					}
				}
				setTotalPrice(this.totalPrice - Integer.parseInt(String.valueOf(Math.round(Float.parseFloat(a.getPrice()) * 100))));
				return;
			}
		}
	}
	public List<Song> getSongList() {
		return this.songList;
	}
	private void setSongList(List<Song> songList) {
		this.songList = songList;
	}
	public void addSong(Song s) {
		if (s != null) {
			
			if (trackIsDuplicated(s)) {
				addDuplicatedTrack(s);
			}
			this.songList.add(s);
			setTotalPrice(this.totalPrice + Integer.parseInt(String.valueOf(Math.round(Float.parseFloat(s.getPrice()) * 100))));
		}
	}
	public void removeSong(Song s) {
		for (Song song : this.songList) {
			if (song.getSongID().equals(s.getSongID())) {
				this.songList.remove(song);
				if (trackIsDuplicated(s)) {
					removeDuplicatedTrack(s);
				}
				setTotalPrice(this.totalPrice - Integer.parseInt(String.valueOf(Math.round(Float.parseFloat(s.getPrice()) * 100))));
				return;
			}
		}
	}
	public float getTotalPrice() {
		return ((float) this.totalPrice)/100;
	}
	public void setTotalPrice(int totalPrice) {
		if (totalPrice < 0) {
			this.totalPrice = 0;
		}
		this.totalPrice = totalPrice;
	}
	
	private boolean trackIsDuplicated(Song song) {
		for (Album a : this.albumList) {
			for (Song s : a.getSongList()) {
				if (song.getSongID().equals(s.getSongID())) {
					return true;
				}
			}
		}
		for (Song s : this.songList) {
			if (song.getSongID().equals(s.getSongID())) {
				return true;
			}
		}
		return false;
	}
	
	private void addDuplicatedTrack(Song s) {
		this.duplicatedTracks.add(s);
	}
	
	private void removeDuplicatedTrack(Song s) {
		for (Song song : this.duplicatedTracks) {
			if (song.getSongID().equals(s.getSongID())) {
				System.out.println();
				this.duplicatedTracks.remove(song);
				return;
			}
		}
	}

	public List<Song> getDuplicatedTracks() {
		return duplicatedTracks;
	}
	
	private void setDuplicatedTracks(List<Song> duplicatedTracks) {
		this.duplicatedTracks = duplicatedTracks;
	}

	public boolean isCartNotEmpty() {
		return (this.songList != null && this.songList.size() != 0) || (this.albumList != null && this.albumList.size() != 0);
	}

	public boolean isDuplicated() {
		return (this.duplicatedTracks != null) && (this.duplicatedTracks.size() != 0);
	}



}
