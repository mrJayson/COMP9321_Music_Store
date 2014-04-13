package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Album> albumList;
	private List<Song> songList;
	private List<Song> duplicatedSongs;
	private List<Album> duplicatedAlbums;
	private int totalPrice;//price is stored in cents

	public Cart() {
		setAlbumList(new ArrayList<Album>());
		setSongList(new ArrayList<Song>());
		setDuplicatedSongs(new ArrayList<Song>());
		setDuplicatedAlbums(new ArrayList<Album>());
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
			calculateDuplication();
			setTotalPrice(this.totalPrice + Integer.parseInt(String.valueOf(Math.round(Float.parseFloat(a.getPrice()) * 100))));
		}
	}
	public void removeAlbum(Album a) {
		for (Album album : this.albumList) {
			if (album.getAlbumID().equals(a.getAlbumID())) {
				this.albumList.remove(album);
				calculateDuplication();
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
			calculateDuplication();
			setTotalPrice(this.totalPrice + Integer.parseInt(String.valueOf(Math.round(Float.parseFloat(s.getPrice()) * 100))));
		}
	}
	public void removeSong(Song s) {
		for (Song song : this.songList) {
			if (song.getSongID().equals(s.getSongID())) {
				this.songList.remove(song);
				calculateDuplication();
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
	
	private void calculateDuplication () {
		this.duplicatedSongs.clear();
		this.duplicatedAlbums.clear();
		
		List<Album> totalAlbums = new ArrayList<Album>();
		for (Album a : this.albumList) {
			totalAlbums.add(a);
		}
		Collections.sort(totalAlbums, new Comparator<Album>(){
		     public int compare(Album o1, Album o2){
		         return o1.getAlbumID().compareTo(o2.getAlbumID());
		     }
		});
		for (int i = 0, j = 1; j < totalAlbums.size(); i++, j++) {
			if (totalAlbums.get(i).getAlbumID().equals(totalAlbums.get(j).getAlbumID())) {
				this.duplicatedAlbums.add(totalAlbums.get(i));
			}
		}
		for (int i = 0, j = 1; j < duplicatedAlbums.size(); i++, j++) {
			if (duplicatedAlbums.get(i).getAlbumID().equals(duplicatedAlbums.get(j).getAlbumID())) {
				this.duplicatedAlbums.remove(duplicatedAlbums.get(i));
				i--;
				j--;
			}
		}
		
		
		List<Song> totalSongs = new ArrayList<Song>();
		for (Album a : this.albumList) {
			for (Song s : a.getSongList()) {
				totalSongs.add(s);
			};
		}
		for (Song s : this.songList) {
			totalSongs.add(s);
		}
		Collections.sort(totalSongs, new Comparator<Song>(){
		     public int compare(Song o1, Song o2){
		         return o1.getSongID().compareTo(o2.getSongID());
		     }
		});
		for (int i = 0, j = 1; j < totalSongs.size(); i++, j++) {
			if (totalSongs.get(i).getSongID().equals(totalSongs.get(j).getSongID())) {
				this.duplicatedSongs.add(totalSongs.get(i));
			}
		}
		for (int i = 0, j = 1; j < duplicatedSongs.size(); i++, j++) {
			if (duplicatedSongs.get(i).getSongID().equals(duplicatedSongs.get(j).getSongID())) {
				this.duplicatedSongs.remove(duplicatedSongs.get(i));
				i--;
				j--;
			}
		}
	}

	public List<Album> getDuplicatedAlbums() {
		return duplicatedAlbums;
	}

	public void setDuplicatedAlbums(List<Album> duplicatedAlbums) {
		this.duplicatedAlbums = duplicatedAlbums;
	}
	
	public List<Song> getDuplicatedSongs() {
		return duplicatedSongs;
	}
	
	private void setDuplicatedSongs(List<Song> duplicatedSongs) {
		this.duplicatedSongs = duplicatedSongs;
	}

	public boolean isCartNotEmpty() {
		return (this.songList != null && this.songList.size() != 0) || (this.albumList != null && this.albumList.size() != 0);
	}

	public boolean isDuplicated() {
		return (this.duplicatedSongs != null) && (this.duplicatedSongs.size() != 0) || (this.duplicatedAlbums != null) && (this.duplicatedAlbums.size() != 0);
	}





}
