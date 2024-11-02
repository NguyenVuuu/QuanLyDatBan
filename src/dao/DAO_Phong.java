package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhuVuc;
import entity.Phong;

public class DAO_Phong {
	public ArrayList<Phong> layDSPhong() {
		ArrayList<Phong> dsPhong = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			Statement stm = con.createStatement();
			String sql = "SELECT * FROM Phong";
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				int sucChua = rs.getInt("sucChua");
				
				KhuVuc kv = new KhuVuc();
				kv.setMaKhuVuc(rs.getString("maKhuVuc"));
				
				Phong p = new Phong(maPhong, tenPhong, sucChua, kv);
				
				dsPhong.add(p);
			}
		} catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return dsPhong;
	}
	
	public String getMaPhong(String tenPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String ma = null;
		
		try {
			Statement stm = con.createStatement();
			String sql = "SELECT maPhong FROM Phong where tenPhong = ?";
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				ma = rs.getString("maPhong");
				
			}
		} catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ma;
	}
	
	public String getTenPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String ma = null;
		
		try {
			Statement stm = con.createStatement();
			String sql = "SELECT tenPhong FROM Phong where maPhong = ?";
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				ma = rs.getString("tenPhong");
				
			}
		} catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ma;
	}
	
	public boolean themPhong(Phong p) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("INSERT INTO Phong (maPhong, tenPhong, sucChua, maKhuVuc) VALUES (?,?,?,?)");
	    	stmt.setString(1, p.getMaPhong());
	        stmt.setString(2, p.getTenPhong());
	        stmt.setInt(3, p.getSucChua());
	        stmt.setString(4, p.getKhuVuc().getMaKhuVuc());

	        n = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
	    }
	    return n > 0;
	}
	
	public boolean suaPhong(Phong p) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("UPDATE Phong set tenPhong = ?, sucChua = ?, maKhuVuc = ? where maPhong = ?");
	    	stmt.setString(1, p.getTenPhong());
	    	stmt.setInt(2, p.getSucChua());
	    	stmt.setString(3, p.getKhuVuc().getMaKhuVuc());
	    	stmt.setString(4, p.getMaPhong());

	        n = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
	    }
	    return n > 0;
	}
	
	public boolean xoaPhong(Phong p) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("DELETE FROM Phong WHERE maPhong = ?");
	    	stmt.setString(1, p.getMaPhong());

	        n = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
	    }
	    return n > 0;
	}
}
