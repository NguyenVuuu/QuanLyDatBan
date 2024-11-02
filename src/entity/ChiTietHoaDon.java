package entity;

import java.util.Objects;

public class ChiTietHoaDon {
	private HoaDon hoaDon;
	private GiaSanPham giaSanPham;
	private int soLuong;
	private double thanhTien;
	public ChiTietHoaDon() {
		super();
	}
	public ChiTietHoaDon(HoaDon hoaDon, GiaSanPham giaSanPham, int soLuong, double thanhTien) {
		super();
		this.hoaDon = hoaDon;
		this.giaSanPham = giaSanPham;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public GiaSanPham getGiaSanPham() {
		return giaSanPham;
	}
	public void setGiaSanPham(GiaSanPham giaSanPham) {
		this.giaSanPham = giaSanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(hoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return Objects.equals(hoaDon, other.hoaDon);
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", giaSanPham=" + giaSanPham + ", soLuong=" + soLuong
				+ ", thanhTien=" + thanhTien + "]";
	}
	
	
}
