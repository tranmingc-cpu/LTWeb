package controller;
import model.Cart;
import model.CartItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import DAO.CartDAO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
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
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		
		if(userId==0) {
			response.sendRedirect("login.jsp");
			return;
			
		}
		
		CartDAO  cartD= new CartDAO();
		ArrayList<CartItem> cart = cartD.getCart(userId);
		String action = request.getParameter("action");

		switch(action) {
		case"add":
			int foodID = Integer.parseInt(request.getParameter("foodId"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			try {
				cartD.addToCart(userId, foodID, quantity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "update" :
			int cartDetailId = Integer.parseInt(request.getParameter("foodId"));
			int quantity1 = Integer.parseInt(request.getParameter("quantity"));
			cartD.updateQuantity(cartDetailId, quantity1);
			break;
		case "remove" :
			int id = Integer.parseInt(request.getParameter("cartDetailId"));
			cartD.removeItem(userId, foodID);
			break;
			
		
		}
		response.sendRedirect("cart");
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
