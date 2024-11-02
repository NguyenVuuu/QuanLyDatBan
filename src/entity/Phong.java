package entity;

import java.util.Objects;

public class Phong {
	private String maPhong;
	private String tenPhong;
	private int sucChua;
	private KhuVuc khuVuc;
	public Phong() {
		super();
	}
	
	
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}


	public Phong(String maPhong, String tenPhong, int sucChua, KhuVuc khuVuc) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.sucChua = sucChua;
		this.khuVuc = khuVuc;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public int getSucChua() {
		return sucChua;
	}
	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}
	public KhuVuc getKhuVuc() {
		return khuVuc;
	}
	public void setKhuVuc(KhuVuc khuVuc) {
		this.khuVuc = khuVuc;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phong other = (Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", sucChua=" + sucChua + ", khuVuc=" + khuVuc
				+ "]";
	}
	
	
}
