package entity;

import java.util.Objects;

public class KhuVuc {
	private String maKhuVuc;
	private String tenKhuVuc;
	
	public KhuVuc() {
		// TODO Auto-generated constructor stub
	}

	public KhuVuc(String maKhuVuc, String tenKhuVuc) {
		super();
		this.maKhuVuc = maKhuVuc;
		this.tenKhuVuc = tenKhuVuc;
	}

	public String getMaKhuVuc() {
		return maKhuVuc;
	}

	public void setMaKhuVuc(String maKhuVuc) {
		this.maKhuVuc = maKhuVuc;
	}

	public String getTenKhuVuc() {
		return tenKhuVuc;
	}

	public void setTenKhuVuc(String tenKhuVuc) {
		this.tenKhuVuc = tenKhuVuc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKhuVuc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhuVuc other = (KhuVuc) obj;
		return Objects.equals(maKhuVuc, other.maKhuVuc);
	}

	@Override
	public String toString() {
		return "KhuVuc [maKhuVuc=" + maKhuVuc + ", tenKhuVuc=" + tenKhuVuc + "]";
	}
	
	
}
