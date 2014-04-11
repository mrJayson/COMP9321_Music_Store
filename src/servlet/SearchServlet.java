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
		String query = request.getParameter("query");
		String type = request.getParameter("type");
		request.setAttribute("query", query);

		Parser p = new Parser(getServletContext().getRealPath("/WEB-INF/musicDb.xml"));
		if (type.equals("album")) {
			List<Album> albumList = p.getAlbumList();
			List<Album> searchAlbums = new ArrayList<Album>();
			for (Album a : albumList) {
				if (new Rgx(a, query).match()) {
					searchAlbums.add(a);
				}
			}
			if (searchAlbums.size() == 0) {
				request.setAttribute("type", "empty");
			} else {
				request.setAttribute("type", type);
			}
			request.setAttribute("albumList", searchAlbums);

		}
		else if (type.equals("song")) {
			List<Song> songList = p.getSongList();
			List<Song> searchSongs = new ArrayList<Song>();
			for (Song s : songList) {
				if (new Rgx(s, query).match()) {
					searchSongs.add(s);
				}
			}
			if (searchSongs.size() == 0) {
				request.setAttribute("type", "empty");
			} else {
				request.setAttribute("type", type);
			}
			request.setAttribute("songList", searchSongs);
		}

		String nextPage = "search.jsp";


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
