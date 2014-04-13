package model;

import java.io.Serializable;

public class Song implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String artist;
	private String title;
	private String albumTitle;
	private String genre;
	private String publisher;
	private String year;
	private String albumID;
	private String songID;
	private String price;

	public Song (String artist, String title, String albumTitle, String genre, String publisher, String year, String albumID, String songID, String price) {
		this.artist = artist;
		this.title = title;
		this.albumTitle = albumTitle;
		this.genre = genre;
		this.publisher = publisher;
		this.year = year;
		this.albumID = albumID;
		this.songID = songID;
		this.price = price;
	}

	public String getArtist() {
		return this.artist;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAlbumID() {
		return this.albumID;
	}
	public String getSongID() {
		return this.songID;
	}
	public String getPrice() {
		return this.price;
	}
	public String getAlbumTitle() {
		return albumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
