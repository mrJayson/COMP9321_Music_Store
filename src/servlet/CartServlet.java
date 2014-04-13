package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Album;
import model.Cart;
import model.Parser;
import model.Processor;
import model.Rgx;
import model.Song;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cart c = (Cart) request.getSession().getAttribute("cart");
		Parser p = new Parser(getServletContext().getRealPath("/WEB-INF/musicDb.xml"));
		Processor pro = new Processor(p);
		String nextPage = "";
		
		if (request.getParameter("action").equals("add")) {
			String[] albumCheckboxes = request.getParameterValues("album");
			String[] songCheckboxes = request.getParameterValues("song");
			if (albumCheckboxes != null) {
				for (String albumID : albumCheckboxes) {
					c.addAlbum(pro.getAlbumFromID(albumID));
				}
			}
			if (songCheckboxes != null) {
				for (String songID : songCheckboxes) {
					c.addSong(pro.getSongFromID(songID));
				}
			}
			nextPage = "cart.jsp";
		}
		else if (request.getParameter("action").equals("remove")) {
			String[] removeAlbumCheckboxes = request.getParameterValues("album");
			String[] removeSongCheckboxes = request.getParameterValues("song");
			if (removeAlbumCheckboxes != null) {
				for (String albumID : removeAlbumCheckboxes) {
					c.removeAlbum(pro.getAlbumFromID(albumID));	
				}
			}
			if (removeSongCheckboxes != null) {
				for (String songID : removeSongCheckboxes) {
					c.removeSong(pro.getSongFromID(songID));
				}
			}
			nextPage = "cart.jsp";
		}


		RequestDispatcher rd = request.getRequestDispatcher("/" + nextPage);
		rd.forward(request, response);

	}

}
