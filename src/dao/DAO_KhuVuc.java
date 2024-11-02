package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhuVuc;


public class DAO_KhuVuc {
	public ArrayList<KhuVuc> layDSKhuVuc() {
		ArrayList<KhuVuc> dsKV = new ArrayList<KhuVuc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from KhuVuc";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maKV = rs.getString("maKhuVuc").trim();
				String tenKV = rs.getString("tenKhuVuc").trim();

				KhuVuc kv = new KhuVuc(maKV, tenKV);
				dsKV.add(kv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKV;
	}
	
	public boolean addKhuVuc(KhuVuc kv) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("INSERT INTO KhuVuC (maKhuVuc, tenKhuVuc) VALUES (?,?)");
	    	stmt.setString(1, kv.getMaKhuVuc());
	        stmt.setString(2, kv.getTenKhuVuc());

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
	
	public boolean suaKhuVuc(KhuVuc kv) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("UPDATE KhuVuc set tenKhuVuc = ? where maKhuVuc = ?");
	    	stmt.setString(1, kv.getTenKhuVuc());
	    	stmt.setString(2, kv.getMaKhuVuc());

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
	
	public boolean xoaKhuVuc(KhuVuc kv) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("DELETE FROM KhuVuc WHERE maKhuVuc = ?");
	    	stmt.setString(1, kv.getMaKhuVuc());

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
	
	public String layMaKV(String tenKV) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String maKV = null;
	    try {
            con = ConnectDB.getConnection();
            if (con != null) {
                stmt = con.prepareStatement("SELECT maKhuVuc FROM KhuVuc WHERE tenKhuVuc = ?");
                stmt.setString(1, tenKV);
                rs = stmt.executeQuery();
                if (rs.next()) {
                	maKV = rs.getString("maKhuVuc");
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
	    return maKV;
	}
	
	public String layTenKV(String maKV) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String tenKV = null;
	    try {
            con = ConnectDB.getConnection();
            if (con != null) {
                stmt = con.prepareStatement("SELECT tenKhuVuc FROM KhuVuc WHERE maKhuVuc = ?");
                stmt.setString(1, maKV);
                rs = stmt.executeQuery();
                if (rs.next()) {
                	tenKV = rs.getString("tenKhuVuc");
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
	    return tenKV;
	}
}
