package entity;

import java.util.Objects;

public class BanAn {
	private String maBan;
	private String tenBan;
	private int soChoNgoi;
	private boolean trangThai;
	private Phong phong;
	private KhuVuc khuVuc;
	public BanAn() {
		super();
	}
	public BanAn(String maBan, String tenBan, int soChoNgoi, boolean trangThai, Phong phong, KhuVuc khuVuc) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.soChoNgoi = soChoNgoi;
		this.trangThai = trangThai;
		this.phong = phong;
		this.khuVuc = khuVuc;
	}
	public String getMaBan() {
		return maBan;
	}
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	public String getTenBan() {
		return tenBan;
	}
	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}
	public int getSoChoNgoi() {
		return soChoNgoi;
	}
	public void setSoChoNgoi(int soChoNgoi) {
		this.soChoNgoi = soChoNgoi;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public KhuVuc getKhuVuc() {
		return khuVuc;
	}
	public void setKhuVuc(KhuVuc khuVuc) {
		this.khuVuc = khuVuc;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maBan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BanAn other = (BanAn) obj;
		return Objects.equals(maBan, other.maBan);
	}
	@Override
	public String toString() {
		return "BanAn [maBan=" + maBan + ", tenBan=" + tenBan + ", soChoNgoi=" + soChoNgoi + ", trangThai=" + trangThai
				+ ", phong=" + phong + ", khuVuc=" + khuVuc + "]";
	}
	
	
}
