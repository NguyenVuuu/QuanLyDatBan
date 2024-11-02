package entity;

import java.util.Objects;

public class GiaSanPham {
	private String maGiaSanPham;
	private SanPham sanPham;
	private DonViTinh donVi;
	private double donGia;
	private String anhSanPham;
	public GiaSanPham() {
		super();
	}
	public GiaSanPham(String maGiaSanPham, SanPham sanPham, DonViTinh donVi, double donGia, String anhSanPham) {
		super();
		this.maGiaSanPham = maGiaSanPham;
		this.sanPham = sanPham;
		this.donVi = donVi;
		this.donGia = donGia;
		this.anhSanPham = anhSanPham;
	}
	
	public GiaSanPham(String maGiaSanPham) {
		super();
		this.maGiaSanPham = maGiaSanPham;
	}
	public String getMaGiaSanPham() {
		return maGiaSanPham;
	}
	public void setMaGiaSanPham(String maGiaSanPham) {
		this.maGiaSanPham = maGiaSanPham;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public DonViTinh getDonVi() {
		return donVi;
	}
	public void setDonVi(DonViTinh donVi) {
		this.donVi = donVi;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getAnhSanPham() {
		return anhSanPham;
	}
	public void setAnhSanPham(String anhSanPham) {
		this.anhSanPham = anhSanPham;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maGiaSanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaSanPham other = (GiaSanPham) obj;
		return Objects.equals(maGiaSanPham, other.maGiaSanPham);
	}
	@Override
	public String toString() {
		return "GiaSanPham [maGiaSanPham=" + maGiaSanPham + ", sanPham=" + sanPham + ", donVi=" + donVi + ", donGia="
				+ donGia + ", anhSanPham=" + anhSanPham + "]";
	}
	
	
}
