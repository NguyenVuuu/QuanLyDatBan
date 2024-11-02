package entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private LocalDate ngayLap;
	private double tongTien;
	private double tienKhachDua;
	private double tienThua;
	private int diemSuDung;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private BanAn banAn;
	public HoaDon() {
		super();
	}
	public HoaDon(String maHoaDon, LocalDate ngayLap, double tongTien, double tienKhachDua, double tienThua,
			int diemSuDung, NhanVien nhanVien, KhachHang khachHang, BanAn banAn) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.tienKhachDua = tienKhachDua;
		this.tienThua = tienThua;
		this.diemSuDung = diemSuDung;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.banAn = banAn;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public LocalDate getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public double getTienKhachDua() {
		return tienKhachDua;
	}
	public void setTienKhachDua(double tienKhachDua) {
		this.tienKhachDua = tienKhachDua;
	}
	public double getTienThua() {
		return tienThua;
	}
	public void setTienThua(double tienThua) {
		this.tienThua = tienThua;
	}
	public int getDiemSuDung() {
		return diemSuDung;
	}
	public void setDiemSuDung(int diemSuDung) {
		this.diemSuDung = diemSuDung;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public BanAn getBanAn() {
		return banAn;
	}
	public void setBanAn(BanAn banAn) {
		this.banAn = banAn;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + ", tienKhachDua="
				+ tienKhachDua + ", tienThua=" + tienThua + ", diemSuDung=" + diemSuDung + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + ", banAn=" + banAn + "]";
	}
	
	
}
