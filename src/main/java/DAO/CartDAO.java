package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Cart;
import model.CartItem;
import model.Food;

public class CartDAO {
	public ArrayList<CartItem> getCart(int userId) {
		 ArrayList<CartItem> list = new ArrayList<>();

		String sql = "SELECT * FROM CART INNER JOIN(CARTDETAIL INNER JOIN FOOD ON CARTDETAIL.FOODID = FOOD.ID)"
				+ "  ON CART.ID = CARTDETAIL.ID " + "WHERE CART.USERID = ? ";
		try {
			Connection con = DBConnect.getConnect();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			 Food food = new Food();
             food.setId(rs.getInt("foodId"));
             food.setName(rs.getString("NAME"));
             food.setPrice(rs.getDouble("PRICE"));

             // CartDetail
             CartItem cd = new CartItem();
             cd.setId(rs.getInt("cartDetailId"));
             cd.setQuantity(rs.getInt("QUANTITY"));
             cd.setFood(food);

             list.add(cd);
         }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	private int getCartIdByUser(int userId, Connection con) throws Exception {
	    String sql = "SELECT ID FROM CART WHERE USERID = ?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, userId);
	    ResultSet rs = ps.executeQuery();

	    if (rs.next()) return rs.getInt("ID");

	    // nếu chưa có cart → tạo mới
	    String insert = "INSERT INTO CART(USERID) VALUES(?)";
	    ps = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
	    ps.setInt(1, userId);
	    ps.executeUpdate();

	    rs = ps.getGeneratedKeys();
	    if (rs.next()) return rs.getInt(1);

	    throw new Exception("Cannot create cart");
	}
// thêm sp vào giỏ hàng 
	public void addToCart(int userId , int foodId,int quantity) throws Exception {
		String checksql = " SELECT CD.ID , CD.QUANTITY " +
	"FROM CART C JOIN CARTDETAIL CD ON C.ID = CD.CARTID "+
				"WHERE C.USERID = ? AND CD.FOODID = ? ";
		String updatesql = "UPDATE CARTDETAIL SET QUANTITY = ? WHERE ID = ?";
		String insertSql = "INSERT INTO CARTDETAIL(CARTID, FOODID, QUANTITY) VALUES(?, ?, ?)";
		try(Connection con = DBConnect.getConnect()){
			int cartId = getCartIdByUser(userId, con);
			PreparedStatement ps = con.prepareStatement(checksql);
			ps.setInt(1, userId);
			ps.setInt(2, foodId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int cartDetailID = rs.getInt("ID");
				int newQty = rs.getInt("QUANTITY") +quantity;
				PreparedStatement ps1 = con.prepareStatement(updatesql);
				ps1.setInt(1, newQty);
				ps1.setInt(1, cartDetailID);
				ps1.executeUpdate();
			} else {
				 PreparedStatement ps2 = con.prepareStatement(insertSql);
		            ps2.setInt(1, cartId);
		            ps2.setInt(2, foodId);
		            ps2.setInt(3, quantity);
		            ps2.executeUpdate();
		        }
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	// giảm số lượng trong giỏ hàng 
	public void decreaseQuantity(int userId, int foodId) {
	    String sql =
	        "UPDATE CARTDETAIL cd " +
	        "JOIN CART c ON cd.CARTID = c.ID " +
	        "SET cd.QUANTITY = cd.QUANTITY - 1 " +
	        "WHERE c.USERID = ? AND cd.FOODID = ? AND cd.QUANTITY > 1";

	    try (Connection con = DBConnect.getConnect();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, userId);
	        ps.setInt(2, foodId);
	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	// thêm số lượgn sản phẩm đã có sẵn trong giỏ hàng
	public void updateQuantity (int cartdetailId, int quantity) {
		String sql = "UPADATE CARTDETAIL SET QUANTITY = ? WHERE ID = ? ";
		try (Connection con = DBConnect.getConnect()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setInt(2, cartdetailId);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// xóa khỏi giỏ hàng
	public void removeItem(int userId, int foodId) {
	    String sql =
	        "DELETE cd FROM CARTDETAIL cd " +
	        "JOIN CART c ON cd.CARTID = c.ID " +
	        "WHERE c.USERID = ? AND cd.FOODID = ?";

	    try (Connection con = DBConnect.getConnect();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, userId);
	        ps.setInt(2, foodId);
	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	}


