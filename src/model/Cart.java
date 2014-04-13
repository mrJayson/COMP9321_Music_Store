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
	private int totalPrice;//price is stored in cents

	public Cart() {
		setAlbumList(new ArrayList<Album>());
		setSongList(new ArrayList<Song>());
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
			this.albumList.add(a);
			setTotalPrice(this.totalPrice + Integer.parseInt(String.valueOf(Math.round(Float.parseFloat(a.getPrice()) * 100))));
		}
	}
	public void removeAlbum(Album a) {
		for (Album album : this.albumList) {
			if (album.getAlbumID().equals(a.getAlbumID())) {
				this.albumList.remove(album);
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
			this.songList.add(s);
			setTotalPrice(this.totalPrice + Integer.parseInt(String.valueOf(Math.round(Float.parseFloat(s.getPrice()) * 100))));
		}
	}
	public void removeSong(Song s) {
		for (Song song : this.songList) {
			if (song.getSongID().equals(s.getSongID())) {
				this.songList.remove(song);
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


}
