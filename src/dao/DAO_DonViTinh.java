package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DonViTinh;

public class DAO_DonViTinh {
	public ArrayList<DonViTinh> layDSDonViTinh() {
		ArrayList<DonViTinh> dsDVT = new ArrayList<DonViTinh>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from DonViTinh";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maDVT = rs.getString("maDonVi").trim();
				String tenDVT = rs.getString("tenDonVi").trim();

				DonViTinh dvt = new DonViTinh(maDVT, tenDVT);
				dsDVT.add(dvt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDVT;
	}
	
	public boolean themDonViTinh(DonViTinh dvt) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("INSERT INTO DonViTinh (maDonVi, tenDonVi) VALUES (?,?)");
	    	stmt.setString(1, dvt.getMaDonVi());
	        stmt.setString(2, dvt.getTenDonVi());

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
	
	public boolean suaDonViTinh(DonViTinh dvt) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("UPDATE DonViTinh set tenDonVi = ? where maDonVi = ?");
	    	stmt.setString(1, dvt.getTenDonVi());
	    	stmt.setString(2, dvt.getMaDonVi());

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
	
	public String layMaDVT(String tenDVT) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String maDVT = null;
	    try {
            con = ConnectDB.getConnection();
            if (con != null) {
                stmt = con.prepareStatement("SELECT maDonVi FROM DonViTinh WHERE tenDonVi = ?");
                stmt.setString(1, tenDVT);
                rs = stmt.executeQuery();
                if (rs.next()) {
                	maDVT = rs.getString("maDonVi");
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
	    return maDVT;
	}
	
	public String layTenDVT(String maDVT) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String tenDVT = null;
	    try {
            con = ConnectDB.getConnection();
            if (con != null) {
                stmt = con.prepareStatement("SELECT tenDonVi FROM DonViTinh WHERE maDonVi = ?");
                stmt.setString(1, maDVT);
                rs = stmt.executeQuery();
                if (rs.next()) {
                	tenDVT = rs.getString("tenDonVi");
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
	    return tenDVT;
	}
}	
