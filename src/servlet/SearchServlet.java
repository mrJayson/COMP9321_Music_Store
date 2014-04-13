package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;
import model.Parser;
import model.Processor;
import model.Rgx;
import model.Song;

/**
 * Servlet implementation class AlbumSearch
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String query = request.getParameter("query");
		String nextPage = "";
		if (type == null || query == null) {
			nextPage = "welcome.jsp";
		} else {
			request.setAttribute("query", query);

			Parser p = new Parser(getServletContext().getRealPath("/WEB-INF/musicDb.xml"));
			Processor pro = new Processor(p);
			List<Album> searchAlbums = null;
			List<Song> searchSongs = null;

			if (type.equals("album")) {
				searchAlbums = pro.searchAlbum(query);
				request.setAttribute("albumList", searchAlbums);
				nextPage = "albumResults.jsp";
			}
			else if (type.equals("song")) {
				searchSongs = pro.searchSong(query);
				request.setAttribute("songList", searchSongs);
				nextPage = "songResults.jsp";
			}
			if ((searchSongs == null || searchSongs.size() == 0) && (searchAlbums == null || searchAlbums.size() == 0)) {
				request.setAttribute("type", "empty");
			} else {
				request.setAttribute("type", type);
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("/"+nextPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
