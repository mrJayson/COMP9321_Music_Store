package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Rgx {
	
	private String pattern;
	private String content;
	
	private Pattern p;
	private Matcher m;
	
	public Rgx (Album a, String pattern) {
		this.content = a.getTitle() + "\n" + a.getArtist() + "\n" + a.getGenre() + "\n" + a.getPublisher() + "\n" + a.getYear() + "\n " + a.getAlbumID();
		//this.content = a.getAlbumID();
		this.pattern = pattern.replaceAll("[^A-Za-z0-9- ]", "");
		compile();
	}
	public Rgx (Song s, String pattern) {
		this.content = s.getTitle() + "\n" + s.getArtist() + "\n" + s.getAlbumTitle() + "\n" + s.getGenre() + "\n" + s.getPublisher() + "\n" + s.getYear() + "\n" + s.getAlbumID() + "\n" + s.getSongID();
		this.pattern = pattern;
		compile();
	}
	
	private void compile () {
		this.p = Pattern.compile(this.pattern, Pattern.CASE_INSENSITIVE);
		this.m = this.p.matcher(this.content);
	}
	
	public boolean match () {
		if (this.pattern.equals("")) {
			return false;
		}
		if (this.m.find()) {
			return true;
		}
		return false;
	}

}