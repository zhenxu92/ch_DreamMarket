package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CartDAO;
import dao.common.DBUtil;
import dao.common.IPUtile;
import dao.entity.Buser;
import dao.entity.Cart;
import dao.entity.Goods;
import dao.entity.GoodsType;

class CartDAOImpl implements CartDAO {
private Connection conn;
	
	public CartDAOImpl(Connection conn) {		
		this.conn = conn;
	}
	public List<Cart> selectCart(String bemail,String sessionid) throws SQLException {
		List<Cart> selectCart = new ArrayList<Cart>();
		Goods goods = null;
		Cart cart = null;
		Buser buser = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cid,goodstable.gno,goodstable.gname,goodstable.goprice,goodstable.grprice,goodstable.gstore,goodstable.gpicture,shoppingnum,carttable.bid FROM goodstable,carttable,busertable WHERE goodstable.gno=carttable.gno And carttable.bid=busertable.bid And bemail='"+ bemail +"'";
		if("You".equals(bemail)){
			sql = "SELECT cid,goodstable.gno,goodstable.gname,goodstable.goprice,goodstable.grprice,goodstable.gstore,goodstable.gpicture,shoppingnum,carttable_temporary.bid FROM goodstable,carttable_temporary WHERE goodstable.gno=carttable_temporary.gno And carttable_temporary.sessionid='"+ sessionid +"'";
		}
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			cart = new Cart();
			cart.setCid(rs.getInt(1));
			goods = new Goods();
			goods.setGno(rs.getString(2));
			goods.setGname(rs.getString(3));
			goods.setGoprice(rs.getInt(4));
			goods.setGrprice(rs.getInt(5));
			goods.setGstore(rs.getInt(6));
			goods.setGpicture(rs.getString(7));
			cart.setGoods(goods);
			cart.setShoppingnum(rs.getInt(8));
			buser = new Buser();
			buser.setBid(rs.getInt(9));
			buser.setBemail(bemail);
			cart.setBuser(buser);
			selectCart.add(cart);
		}
		rs.close();
		pstmt.close();
		return selectCart;
	}
	
	public int insert(Cart cart,Integer bid,String gno,String ip) throws SQLException {
		int result = -1;
		// ip user
		if(0==bid){
			String sessionID = IPUtile.CreatSessionID(ip);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String CartIdSql = "SELECT nextval('cid_sequence')";
			pstmt = conn.prepareStatement(CartIdSql);
			rs = pstmt.executeQuery();
			int cartId = -1;
			if(rs.next()){
				cartId = rs.getInt(1);
				cart.setCid(cartId);
			}
			// user 1 2 3
			// order 1 2 3
			// service (date)
			// DAO (
			// id date user 
			// 1	02 91
			// list results
			// loop through results
			// map.containsKey(query(1), getOrDefault() + 1)
			
			String CartGoodsGnoSql = "SELECT carttable_temporary.gno FROM carttable_temporary WHERE carttable_temporary.sessionid='"+sessionID+"'";
			System.out.println(CartGoodsGnoSql);
			pstmt = conn.prepareStatement(CartGoodsGnoSql);
			rs = pstmt.executeQuery();
			String[] gnoList = new String[10];
			
			int i = -1;
			while(rs.next()){
				i++;
				gnoList[i] = rs.getString(1);
				System.out.print(gnoList[i]);
				
			}
			
			for(int j = 0;j<gnoList.length;j++){
				if(gnoList[j]!=null&&gno.trim().equals(gnoList[j].trim())){
					String CartGoodsShoppingnumSql = "SELECT shoppingnum FROM carttable_temporary WHERE carttable_temporary.gno='"+gno.trim()+"'";
					pstmt = conn.prepareStatement(CartGoodsShoppingnumSql);
					rs = pstmt.executeQuery();
					if(rs.next()){
						cart.setShoppingnum(rs.getInt(1)+cart.getShoppingnum());
						String updateCartGoodsShoppingnumSql = "UPDATE carttable_temporary SET shoppingnum=? WHERE carttable_temporary.sessionid='"+sessionID+"' AND carttable_temporary.gno='"+gno+"'";
						pstmt = conn.prepareStatement(updateCartGoodsShoppingnumSql);
						pstmt.setInt(1, cart.getShoppingnum());
						result=pstmt.executeUpdate();
					}
				}
			}
			
			if(result == -1){
				String sql = "INSERT INTO carttable_temporary (cid, sessionid, bid, gno, shoppingnum) " +
				"VALUES (?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cart.getCid());
				pstmt.setString(2, sessionID);
				pstmt.setInt(3, bid);
				pstmt.setString(4, gno);
				pstmt.setInt(5, cart.getShoppingnum());
				result = pstmt.executeUpdate();
			}
			
			return result;
		// new coming user
		}else if(null == cart && null == gno){
			String sessionID = IPUtile.CreatSessionID(ip);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String CarttemSql = "SELECT 1 FROM carttable_temporary where sessionid='"+sessionID+"'";
			pstmt = conn.prepareStatement(CarttemSql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String updateCarttemSql = "UPDATE carttable_temporary SET bid="+bid+" WHERE carttable_temporary.sessionid='"+sessionID+"'";
				pstmt = conn.prepareStatement(updateCarttemSql);
				pstmt.executeUpdate();
				
				String cartTemMessage = "SELECT cid,bid,gno FROM carttable_temporary where sessionid='"+sessionID+"'";
				pstmt = conn.prepareStatement(cartTemMessage);
				rs = pstmt.executeQuery();
				while(rs.next()){
					cart = new Cart();
					Integer cid = rs.getInt(1);
					Integer ctbid = rs.getInt(2);
					String ctgno = rs.getString(3);
					CallableStatement c=conn.prepareCall("{call ifaddGoodsInCart(?,?)}");
					c.setString(1, ctgno);
					c.setInt(2, ctbid);
					c.execute();
					String deletesql = "DELETE FROM carttable_temporary WHERE cid="+cid+"";
					pstmt = conn.prepareStatement(deletesql);
					pstmt.executeUpdate();
				}
			}
			
			return 0;
		// existing logged in user
		}else{
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String CartIdSql = "SELECT nextval('cid_sequence')";
			pstmt = conn.prepareStatement(CartIdSql);
			rs = pstmt.executeQuery();
			int cartId = -1;
			if(rs.next()){
				cartId = rs.getInt(1);
				cart.setCid(cartId);
			}
			String CartGoodsGnoSql = "SELECT carttable.gno FROM carttable WHERE carttable.bid="+bid;
			pstmt = conn.prepareStatement(CartGoodsGnoSql);
			rs = pstmt.executeQuery();
			String[] gnoList = new String[10];
			
			int i = -1;
			while(rs.next()){
				i++;
				gnoList[i] = rs.getString(1);
				
			}
			for(int j = 0;j<gnoList.length;j++){
				if(gnoList[j]!=null&&gno.trim().equals(gnoList[j].trim())){
					String CartGoodsShoppingnumSql = "SELECT shoppingnum FROM carttable WHERE carttable.gno="+"'"+gno.trim()+"'";
					pstmt = conn.prepareStatement(CartGoodsShoppingnumSql);
					rs = pstmt.executeQuery();
					if(rs.next()){
						cart.setShoppingnum(rs.getInt(1)+cart.getShoppingnum());
						String updateCartGoodsShoppingnumSql = "UPDATE carttable SET shoppingnum=? WHERE carttable.bid=+"+bid+" AND carttable.gno="+"'"+gno+"'";
						pstmt = conn.prepareStatement(updateCartGoodsShoppingnumSql);
						pstmt.setInt(1, cart.getShoppingnum());
						result=pstmt.executeUpdate();
					}
				}
			}
			if(result == -1){
				String sql = "INSERT INTO carttable (cid,bid, gno, shoppingnum) " +
						"VALUES (?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cart.getCid());
				pstmt.setInt(2, bid);
				pstmt.setString(3, gno);
				pstmt.setInt(4, cart.getShoppingnum());
				result = pstmt.executeUpdate();
			}
			
		}
		
		return result;
		
	}
	public int deleteGoodsInCartByID(Integer cid,Integer bid) throws SQLException {
		int result=0;
		String deletesql = null;
		PreparedStatement pstmt = null;
		if(0 == bid){
			deletesql =  "DELETE From carttable_temporary WHERE cid=?";
			pstmt = conn.prepareStatement(deletesql);
			pstmt.setInt(1, cid);
			result = pstmt.executeUpdate();
		}else{
			deletesql =  "DELETE From carttable WHERE cid=?";
			pstmt = conn.prepareStatement(deletesql);
			pstmt.setInt(1, cid);
			result = pstmt.executeUpdate();
		}
		return result;
	}
	
	public List<Goods> selectChoisedGoodsInCart(Cart cart) throws SQLException {
		List<Goods> selectChoiseGoods = new ArrayList<Goods>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsType goodsType = null;
		Goods goods = null;
		for(Integer cid:cart.getCidList()){
			String sql = "SELECT goodstable.gno,goodstable.gname,goodstable.goprice,goodstable.grprice,goodstable.gstore,goodstable.gpicture,goodstype.typeid,goodstype.typename,carttable.shoppingnum FROM goodstype,goodstable,carttable Where goodstype.typeid=goodstable.typeid AND carttable.gno=goodstable.gno AND carttable.cid="+cid+" ORDER BY goodstype.typeid ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				goods = new Goods();
				goods.setGno(rs.getString(1));
				goods.setGname(rs.getString(2));
				goods.setGoprice(rs.getInt(3));
				goods.setGrprice(rs.getInt(4));
				goods.setGstore(rs.getInt(5));
				goods.setGpicture(rs.getString(6));
				goodsType = new GoodsType();
				goodsType.setTypeid(rs.getInt(7));
				goodsType.setTypename(rs.getString(8));
				goods.setGoodsType(goodsType);
				goods.setShoppingnum(rs.getInt(9));
				selectChoiseGoods.add(goods);
			}
		}
		return selectChoiseGoods;
	}
	public int updateShoppingnum(Integer cid, Integer shoppingnum,Integer bid)throws SQLException {
		int result=0;
		if(0 == bid){
			PreparedStatement pstmt = null;
			String deletesql =  "UPDATE carttable_temporary SET shoppingnum=? WHERE cid=?";
			pstmt = conn.prepareStatement(deletesql);
			pstmt.setInt(1, shoppingnum);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
			return result;
		}else{
			PreparedStatement pstmt = null;
			String deletesql =  "UPDATE carttable SET shoppingnum=? WHERE cid=?";
			pstmt = conn.prepareStatement(deletesql);
			pstmt.setInt(1, shoppingnum);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		}
		return result;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		CartDAO cartDAO = new CartDAOImpl(conn);
		Cart cart = new Cart();
		Integer cidList[] = {164,163,162};
		cart.setCidList(cidList);
		List<Goods> selectChoisedGoods = new ArrayList<Goods>();
		selectChoisedGoods = cartDAO.selectChoisedGoodsInCart(cart);
		for(Goods goods:selectChoisedGoods){
			System.out.println(goods.getGrprice()+"   "+goods.getShoppingnum());
		}
		DBUtil.closeConnection(conn);
	}
	public int updateGstoreBycid(Integer cid) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods goods = null;
		String sql = "SELECT goodstable.gno,goodstable.gstore,carttable.shoppingnum FROM goodstable,carttable Where carttable.gno=goodstable.gno AND carttable.cid="+cid+"";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()){
			goods = new Goods();
			goods.setGno(rs.getString(1));
			goods.setGstore(rs.getInt(2));
			goods.setShoppingnum(rs.getInt(3));
		}
		String updatesql =  "UPDATE goodstable SET gstore=? WHERE gno=?";
		pstmt = conn.prepareStatement(updatesql);
		pstmt.setInt(1, goods.getGstore()-goods.getShoppingnum());
		pstmt.setString(2, goods.getGno());
		int i = pstmt.executeUpdate();
		return i;
	}
	
	
}
