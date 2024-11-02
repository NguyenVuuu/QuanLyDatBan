package entity;

import java.util.Objects;

public class ChiTietPhieuDatTruoc {
	private PhieuDatTruoc phieuDatTruoc;
	private GiaSanPham giaSanPham;
	private int soLuong;
	public ChiTietPhieuDatTruoc() {
		super();
	}
	public ChiTietPhieuDatTruoc(PhieuDatTruoc phieuDatTruoc, GiaSanPham giaSanPham, int soLuong) {
		super();
		this.phieuDatTruoc = phieuDatTruoc;
		this.giaSanPham = giaSanPham;
		this.soLuong = soLuong;
	}
	public PhieuDatTruoc getPhieuDatTruoc() {
		return phieuDatTruoc;
	}
	public void setPhieuDatTruoc(PhieuDatTruoc phieuDatTruoc) {
		this.phieuDatTruoc = phieuDatTruoc;
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
	@Override
	public int hashCode() {
		return Objects.hash(phieuDatTruoc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietPhieuDatTruoc other = (ChiTietPhieuDatTruoc) obj;
		return Objects.equals(phieuDatTruoc, other.phieuDatTruoc);
	}
	@Override
	public String toString() {
		return "ChiTietPhieuDatTruoc [phieuDatTruoc=" + phieuDatTruoc + ", giaSanPham=" + giaSanPham + ", soLuong="
				+ soLuong + "]";
	}
	
	
}
