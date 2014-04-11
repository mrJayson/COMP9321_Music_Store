package servlet;

import java.util.List;

public class Album {
	
	private String artist;
	private String title;
	private String albumID;
	private String genre;
	private String publisher;
	private String year;
	private List<Song> songList;
	
	public Album (String artist, String title, String albumID, String genre, String publisher, String year, List<Song> songList) {
		this.artist = artist;
		this.title = title;
		this.albumID = albumID;
		this.genre = genre;
		this.publisher = publisher;
		this.year = year;
		this.songList = songList;
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
	public String getGenre() {
		return this.genre;
	}
	public String getPublisher() {
		return this.publisher;
	}
	public String getYear() {
		return this.year;
	}
	public List<Song> getSongList() {
		return this.songList;
	}

}
