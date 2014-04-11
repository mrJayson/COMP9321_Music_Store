package servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Rgx {
	
	private String pattern;
	private String content;
	
	private Pattern p;
	private Matcher m;
	
	public Rgx (Album a, String pattern) {
		this.content = a.getTitle() + "\n" + a.getArtist() + "\n" + a.getGenre() + "\n" + a.getPublisher() + "\n" + a.getYear() + "\n" + a.getAlbumID();
		this.pattern = pattern;
		compile();
	}
	public Rgx (Song s, String pattern) {
		this.content = s.getTitle() + "\n" + s.getArtist() + "\n" + s.getSongID() + "\n" + s.getAlbumID();
		this.pattern = pattern;
		compile();
	}
	
	private void compile () {
		this.p = Pattern.compile(this.pattern, Pattern.CASE_INSENSITIVE);
		this.m = this.p.matcher(this.content);
	}
	
	public boolean match () {
		if (this.m.find()) {
			return true;
		}
		return false;
	}

}