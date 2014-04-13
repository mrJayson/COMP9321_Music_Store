package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document d;

	public Parser (String filePath) {
		try {
			this.d = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(filePath));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public List<Album> getAlbumList() {
		NodeList nl = this.d.getDocumentElement().getElementsByTagName("albumList");
		ArrayList<Album> albumList = new ArrayList<Album>();
		for (int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);
			Element e = (Element)n;
			String artist = e.getElementsByTagName("artist").item(0).getTextContent();
			String title = e.getElementsByTagName("title").item(0).getTextContent();
			String albumID = e.getElementsByTagName("albumID").item(0).getTextContent();
			String genre = e.getElementsByTagName("genre").item(0).getTextContent();
			String publisher = e.getElementsByTagName("publisher").item(0).getTextContent();
			String year = e.getElementsByTagName("year").item(0).getTextContent();
			String price = e.getElementsByTagName("price").item(e.getElementsByTagName("price").getLength()-1).getTextContent();
			albumList.add(new Album(artist, title, albumID, genre, publisher, year, price, getSongList(e)));
		}
		return albumList;
	}

	public List<Song> getSongList(Element elt) {
		NodeList nl = elt.getElementsByTagName("songList");
		ArrayList<Song> songList = new ArrayList<Song>();
		for (int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);
			Element e = (Element)n;
			String artist = e.getElementsByTagName("artist").item(0).getTextContent();
			String title = e.getElementsByTagName("title").item(0).getTextContent();
			String albumTitle = elt.getElementsByTagName("title").item(0).getTextContent();
			String genre = elt.getElementsByTagName("genre").item(0).getTextContent();
			String publisher = elt.getElementsByTagName("publisher").item(0).getTextContent();
			String year = elt.getElementsByTagName("year").item(0).getTextContent();
			String albumID = e.getElementsByTagName("albumID").item(0).getTextContent();
			String songID = e.getElementsByTagName("songID").item(0).getTextContent();
			String price = e.getElementsByTagName("price").item(0).getTextContent();
			songList.add(new Song(artist, title, albumTitle, genre, publisher, year, albumID, songID, price));
		}
		return songList;
	}

	public List<Song> getSongList() {
		NodeList albumNodeList = this.d.getDocumentElement().getElementsByTagName("albumList");
		ArrayList<Song> songList = new ArrayList<Song>();
		for (int i = 0; i < albumNodeList.getLength(); i++) {
			Node n = albumNodeList.item(i);
			Element e = (Element)n;
			songList.addAll(getSongList(e));
		}
		return songList;
	}
}
