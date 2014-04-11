package servlet;

public class Song {
	
	private String artist;
	private String title;
	private String albumID;
	private String songID;
	
	public Song (String artist, String title, String albumID, String songID) {
		this.artist = artist;
		this.title = title;
		this.albumID = albumID;
		this.songID = songID;
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
	

}
