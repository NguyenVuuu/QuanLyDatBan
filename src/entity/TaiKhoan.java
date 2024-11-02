package entity;

import java.util.Objects;

public class TaiKhoan {
	private NhanVien tenTaiKhoan;
	private String matKhau;
	public TaiKhoan() {
		super();
	}
	public TaiKhoan(NhanVien tenTaiKhoan, String matKhau) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}
	public NhanVien getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(NhanVien tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public int hashCode() {
		return Objects.hash(matKhau);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(matKhau, other.matKhau);
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + "]";
	}
	
	
}
