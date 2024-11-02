package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.SanPham;

public class DAO_SanPham {
	public ArrayList<SanPham> layDSSanPham() {
		ArrayList<SanPham> dsSP = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			Statement stm = con.createStatement();
			String sql = "SELECT * FROM SanPham";
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				String maSP = rs.getString("maSanPham").trim();
				String tenSP = rs.getString("tenSanPham").trim();
				boolean trangThai = rs.getBoolean("trangThai");
				
				SanPham sp = new SanPham(maSP, tenSP, trangThai);
				
				dsSP.add(sp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
	}
	
	public ArrayList<SanPham> layDSSanPhamKinhDoanh() {
		ArrayList<SanPham> dsSP = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			Statement stm = con.createStatement();
			String sql = "SELECT * FROM SanPham WHERE trangThai = 1";
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				String maSP = rs.getString("maSanPham").trim();
				String tenSP = rs.getString("tenSanPham").trim();
				boolean trangThai = rs.getBoolean("trangThai");
				
				SanPham sp = new SanPham(maSP, tenSP, trangThai);
				
				dsSP.add(sp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
	}
	
	public boolean themSP(SanPham sp) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("INSERT INTO SanPham (maSanPham, tenSanPham, trangThai) VALUES (?, ?, ?)");
	    	stmt.setString(1, sp.getMaSanPham());
	        stmt.setString(2, sp.getTenSanPham());
	        stmt.setBoolean(3, sp.isTrangThai());

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
	
	public boolean suaSanPham(SanPham sp) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("UPDATE SanPham set tenSanPham = ?, trangThai = ? where maSanPham = ?");
	    	stmt.setString(1, sp.getTenSanPham());
	    	stmt.setBoolean(2, sp.isTrangThai());
	    	stmt.setString(3, sp.getMaSanPham());

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
	
	public String layMaSP(String tenSP) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String maSP = null;
	    try {
            con = ConnectDB.getConnection();
            if (con != null) {
                stmt = con.prepareStatement("SELECT maSanPham FROM SanPham WHERE tenSanPham = ?");
                stmt.setString(1, tenSP);
                rs = stmt.executeQuery();
                if (rs.next()) {
                	maSP = rs.getString("maSanPham");
                }
            }
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
	    return maSP;
	}
	
	public String layTenSP(String maSP) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String tenSP = null;
	    try {
            con = ConnectDB.getConnection();
            if (con != null) {
                stmt = con.prepareStatement("SELECT tenSanPham FROM SanPham WHERE maSanPham = ?");
                stmt.setString(1, maSP);
                rs = stmt.executeQuery();
                if (rs.next()) {
                	tenSP = rs.getString("tenSanPham");
                }
            }
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
	    return tenSP;
	}
}
