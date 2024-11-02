package entity;

import java.time.LocalDate;
import java.util.Objects;

public class PhieuDatTruoc {
	private String maPhieu;
	private LocalDate ngayDat;
	private BanAn banAn;
	private KhachHang khachHang;
	public PhieuDatTruoc() {
		super();
	}
	public PhieuDatTruoc(String maPhieu, LocalDate ngayDat, BanAn banAn, KhachHang khachHang) {
		super();
		this.maPhieu = maPhieu;
		this.ngayDat = ngayDat;
		this.banAn = banAn;
		this.khachHang = khachHang;
	}
	public String getMaPhieu() {
		return maPhieu;
	}
	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	public LocalDate getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(LocalDate ngayDat) {
		this.ngayDat = ngayDat;
	}
	public BanAn getBanAn() {
		return banAn;
	}
	public void setBanAn(BanAn banAn) {
		this.banAn = banAn;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhieu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDatTruoc other = (PhieuDatTruoc) obj;
		return Objects.equals(maPhieu, other.maPhieu);
	}
	@Override
	public String toString() {
		return "PhieuDatTruoc [maPhieu=" + maPhieu + ", ngayDat=" + ngayDat + ", banAn=" + banAn + ", khachHang="
				+ khachHang + "]";
	}
	
	
}
