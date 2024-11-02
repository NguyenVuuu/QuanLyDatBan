USE [master]
GO

CREATE DATABASE [QuanLyNH]
GO

USE [QuanLyNH]
GO


--Tạo bảng
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nchar](10) NOT NULL,
	[tenNhanVien] [nvarchar](255) NOT NULL,
	[soDienThoai] [nchar](10) NOT NULL,
	[ngayVaoLam] [date] NOT NULL,
	[chucVu] [nvarchar](255) NOT NULL,
	[trangThai] [bit] NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)) ON [PRIMARY]
GO

CREATE TABLE [dbo].[TaiKhoan](
	[taiKhoan] [nchar](10) NOT NULL,
	[matKhau] [nchar](255) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[taiKhoan] ASC
)) ON [PRIMARY]
GO

ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[TaiKhoan] ([taiKhoan])
GO

ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO

CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nchar](10) NOT NULL,
	[tenKhachHang] [nvarchar](255) NOT NULL,
	[soDienThoai] [nchar](10) NOT NULL,
	[ngayThamGia] [date] NOT NULL,
	[diemTichLuy] [int] NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)) ON [PRIMARY]
GO

CREATE TABLE [dbo].[KhuVuc](
	[maKhuVuc] [nchar](10) NOT NULL,
	[tenKhuVuc] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK_KhuVuc] PRIMARY KEY CLUSTERED 
(
	[maKhuVuc] ASC
)) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Phong](
	[maPhong] [nchar](10) NOT NULL,
	[tenPhong] [nvarchar](255) NOT NULL,
	[sucChua] [int] NOT NULL,
	[maKhuVuc] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_KhuVuc] FOREIGN KEY([maKhuVuc])
REFERENCES [dbo].[KhuVuc] ([maKhuVuc])
GO

ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_KhuVuc]
GO

CREATE TABLE [dbo].[BanAn](
	[maBan] [nchar](10) NOT NULL,
	[tenBan] [nvarchar](255) NOT NULL,
	[soChoNgoi] [int] NOT NULL,
	[trangThai] [bit] NOT NULL,
	[maKhuVuc] [nchar](10) NOT NULL,
	[maPhong] [nchar](10) NULL,
 CONSTRAINT [PK_BanAn] PRIMARY KEY CLUSTERED 
(
	[maBan] ASC
)) ON [PRIMARY]
GO

ALTER TABLE [dbo].[BanAn]  WITH CHECK ADD  CONSTRAINT [FK_BanAn_KhuVuc] FOREIGN KEY([maKhuVuc])
REFERENCES [dbo].[KhuVuc] ([maKhuVuc])
GO

ALTER TABLE [dbo].[BanAn] CHECK CONSTRAINT [FK_BanAn_KhuVuc]
GO

ALTER TABLE [dbo].[BanAn]  WITH CHECK ADD  CONSTRAINT [FK_BanAn_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO

ALTER TABLE [dbo].[BanAn] CHECK CONSTRAINT [FK_BanAn_Phong]
GO

CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nchar](20) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[tongTien] [float] NOT NULL,
	[tienKhachDua] [float] NOT NULL,
	[tienThua] [float] NOT NULL,
	[diemSuDung] [int] NOT NULL,
	[maNhanVien] [nchar](10) NOT NULL,
	[maKhachHang] [nchar](10) NOT NULL,
	[maBan] [nchar](10) NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)) ON [PRIMARY]
GO

ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_BanAn] FOREIGN KEY([maBan])
REFERENCES [dbo].[BanAn] ([maBan])
GO

ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_BanAn]
GO

ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO

ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO

ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO

ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO

CREATE TABLE [dbo].[SanPham](
	[maSanPham] [nchar](10) NOT NULL,
	[tenSanPham] [nvarchar](255) NOT NULL,
	[trangThai] [bit] NOT NULL,

 CONSTRAINT [PK_MonAn] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DonViTinh](
	[maDonVi] [nchar](10) NOT NULL,
	[tenDonVi] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_DonViTinh] PRIMARY KEY CLUSTERED 
(
	[maDonVi] ASC
)) ON [PRIMARY]
GO


CREATE TABLE [dbo].[GiaSanPham](
	[maGiaSanPham] [nchar](10) NOT NULL,
	[maSanPham] [nchar](10) NOT NULL,
	[maDonVi] [nchar](10) NOT NULL,
	[donGia] [float] NOT NULL,
	[anhSanPham] [nchar](255) NOT NULL,
 CONSTRAINT [PK_GiaSanPham] PRIMARY KEY CLUSTERED 
(
	[maGiaSanPham] ASC
)) ON [PRIMARY]
GO

ALTER TABLE [dbo].[GiaSanPham]  WITH CHECK ADD  CONSTRAINT [FK_GiaSanPham_DonViTinh] FOREIGN KEY([maDonVi])
REFERENCES [dbo].[DonViTinh] ([maDonVi])
GO

ALTER TABLE [dbo].[GiaSanPham] CHECK CONSTRAINT [FK_GiaSanPham_DonViTinh]
GO

ALTER TABLE [dbo].[GiaSanPham]  WITH CHECK ADD  CONSTRAINT [FK_GiaSanPham_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO

ALTER TABLE [dbo].[GiaSanPham] CHECK CONSTRAINT [FK_GiaSanPham_SanPham]
GO


CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHoaDon] [nchar](20) NOT NULL,
	[maGiaSanPham] [nchar](10) NOT NULL,
	[soLuong] [int] NOT NULL,
	[thanhTien] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maGiaSanPham] ASC,
	[maHoaDon] ASC
)) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO

ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO

ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_GiaSanPham] FOREIGN KEY([maGiaSanPham])
REFERENCES [dbo].[GiaSanPham] ([maGiaSanPham])
GO

ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_GiaSanPham]
GO



CREATE TABLE [dbo].[PhieuDatTruoc](
	[maPhieuDatTruoc] [nchar](20) NOT NULL,
	[ngayDat] [date] NOT NULL,
	[maBan] [nchar](10) NOT NULL,
	[maKhachHang] [nchar](10) NULL,
 CONSTRAINT [PK_ChiTietPhieuDatTruoc] PRIMARY KEY CLUSTERED 
(
	[maPhieuDatTruoc] ASC
)) ON [PRIMARY]
GO

ALTER TABLE [dbo].[PhieuDatTruoc]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatTruoc_BanAn] FOREIGN KEY([maBan])
REFERENCES [dbo].[BanAn] ([maBan])
GO

ALTER TABLE [dbo].[PhieuDatTruoc] CHECK CONSTRAINT [FK_PhieuDatTruoc_BanAn]
GO

ALTER TABLE [dbo].[PhieuDatTruoc]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatTruoc_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO

ALTER TABLE [dbo].[PhieuDatTruoc] CHECK CONSTRAINT [FK_PhieuDatTruoc_KhachHang]
GO

CREATE TABLE [dbo].[ChiTietPhieuDatTruoc](
	[maGiaSanPham] [nchar](10) NOT NULL,
	[maPhieuDatTruoc] [nchar](20) NOT NULL,
	[SoLuong] [int] NOT NULL,
 CONSTRAINT [PK_ChiTietPhieuDatTruoc_1] PRIMARY KEY CLUSTERED 
(
	[maGiaSanPham] ASC,
	[maPhieuDatTruoc] ASC
)) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ChiTietPhieuDatTruoc]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuDatTruoc_GiaSanPham] FOREIGN KEY([maGiaSanPham])
REFERENCES [dbo].[GiaSanPham] ([maGiaSanPham])
GO

ALTER TABLE [dbo].[ChiTietPhieuDatTruoc] CHECK CONSTRAINT [FK_ChiTietPhieuDatTruoc_GiaSanPham]
GO

ALTER TABLE [dbo].[ChiTietPhieuDatTruoc]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuDatTruoc_PhieuDatTruoc] FOREIGN KEY([maPhieuDatTruoc])
REFERENCES [dbo].[PhieuDatTruoc] ([maPhieuDatTruoc])
GO

ALTER TABLE [dbo].[ChiTietPhieuDatTruoc] CHECK CONSTRAINT [FK_ChiTietPhieuDatTruoc_PhieuDatTruoc]
GO


--INSERT
INSERT INTO KhuVuc (maKhuVuc, tenKhuVuc) VALUES ('KV00001', N'Khu Vực 1')
INSERT INTO KhuVuc (maKhuVuc, tenKhuVuc) VALUES ('KV00002', N'Khu Vực 2')
INSERT INTO KhuVuc (maKhuVuc, tenKhuVuc) VALUES ('KV00003', N'Khu Vực 3')
INSERT INTO KhuVuc (maKhuVuc, tenKhuVuc) VALUES ('KV00004', N'Khu Vực 4')

INSERT INTO [dbo].[Phong] (maPhong, tenPhong, sucChua, maKhuVuc) VALUES ('P00001    ', 'VIP1', 30, 'KV00001   ');INSERT INTO [dbo].[Phong] (maPhong, tenPhong, sucChua, maKhuVuc) VALUES ('P00002    ', 'VIP2', 40, 'KV00002   ');INSERT INTO [dbo].[Phong] (maPhong, tenPhong, sucChua, maKhuVuc) VALUES ('P00003    ', 'VIP3', 25, 'KV00003   ');INSERT INTO [dbo].[Phong] (maPhong, tenPhong, sucChua, maKhuVuc) VALUES ('P00004    ', 'VIP4', 15, 'KV00004   ');INSERT INTO [dbo].[Phong] (maPhong, tenPhong, sucChua, maKhuVuc) VALUES ('P00005    ', 'VIP5', 30, 'KV00001   ');

INSERT INTO [dbo].[DonViTinh] (maDonVi, tenDonVi) VALUES ('DV00001', 'Ly');INSERT INTO [dbo].[DonViTinh] (maDonVi, tenDonVi) VALUES ('DV00002', 'Thùng');INSERT INTO [dbo].[DonViTinh] (maDonVi, tenDonVi) VALUES ('DV00003', 'Lon');INSERT INTO [dbo].[DonViTinh] (maDonVi, tenDonVi) VALUES ('DV00004', 'Kg');INSERT INTO [dbo].[DonViTinh] (maDonVi, tenDonVi) VALUES ('DV00005', 'Đĩa');INSERT INTO [dbo].[DonViTinh] (maDonVi, tenDonVi) VALUES ('DV00006', 'Cái');INSERT INTO [dbo].[DonViTinh] (maDonVi, tenDonVi) VALUES ('DV00007', 'Phần');INSERT INTO [dbo].[DonViTinh] (maDonVi, tenDonVi) VALUES ('DV00008', 'Con');INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00001   ', 'Lẩu Bò', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00002   ', 'Lẩu Cá', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00003   ', 'Ghẹ Hấp', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00004   ', 'Mực Hấp', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00005   ', 'Ngao Biển Hấp', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00006   ', 'Tôm Nướng', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00007   ', 'Súp Cua', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00008   ', 'Súp Óc Heo', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00009   ', 'Súp Bắp Cua', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00010   ', 'Gỏi Bò Bóp Thấu', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00011   ', 'Gỏi Cá Mú', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00012   ', 'Xôi Bồ Câu Pháp', 1);INSERT INTO [dbo].[SanPham] (maSanPham, tenSanPham, trangThai) VALUES ('SP00013   ', 'Vịt Cỏ Nướng Lu Sa Tế', 1);