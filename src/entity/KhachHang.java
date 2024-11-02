package entity;

import java.time.LocalDate;
import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String soDienThoai;
	private LocalDate ngayThamGia;
	private int diemTichLuy;
	public KhachHang() {
		super();
	}
	public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, LocalDate ngayThamGia,
			int diemTichLuy) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.ngayThamGia = ngayThamGia;
		this.diemTichLuy = diemTichLuy;
	}
	
	public KhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public LocalDate getNgayThamGia() {
		return ngayThamGia;
	}
	public void setNgayThamGia(LocalDate ngayThamGia) {
		this.ngayThamGia = ngayThamGia;
	}
	public int getDiemTichLuy() {
		return diemTichLuy;
	}
	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachHang, other.maKhachHang);
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", soDienThoai="
				+ soDienThoai + ", ngayThamGia=" + ngayThamGia + ", diemTichLuy=" + diemTichLuy + "]";
	}
	
	
	
}
