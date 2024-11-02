package entity;

import java.util.Objects;

public class DonViTinh {
	private String maDonVi;
	private String tenDonVi;
	public DonViTinh() {
		super();
	}
	public DonViTinh(String maDonVi, String tenDonVi) {
		super();
		this.maDonVi = maDonVi;
		this.tenDonVi = tenDonVi;
	}
	public String getMaDonVi() {
		return maDonVi;
	}
	public void setMaDonVi(String maDonVi) {
		this.maDonVi = maDonVi;
	}
	public String getTenDonVi() {
		return tenDonVi;
	}
	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDonVi);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonViTinh other = (DonViTinh) obj;
		return Objects.equals(maDonVi, other.maDonVi);
	}
	@Override
	public String toString() {
		return "DonViTinh [maDonVi=" + maDonVi + ", tenDonVi=" + tenDonVi + "]";
	}
	
	
}
