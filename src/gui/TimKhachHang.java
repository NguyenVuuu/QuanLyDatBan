package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import dao.DAO_KhachHang;
import entity.KhachHang;

public class TimKhachHang extends JPanel implements ActionListener {
	private JTextField txtSDT;
	private JButton btnTimKiem;
	private DefaultTableModel modelKH;
	private JTable tblKH;
	private JButton btnTaiLai;

	public TimKhachHang() {
		setLayout(new BorderLayout());

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setLayout(new FlowLayout());

		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		txtSDT = new JTextField(15);
		btnTimKiem = new JButton("Tìm Kiếm");

		pnlTimKiem.add(lblSDT);
		pnlTimKiem.add(txtSDT);
		pnlTimKiem.add(btnTimKiem);

		add(pnlTimKiem, BorderLayout.NORTH);

		String[] header = { "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Ngày Tham Gia", "Điểm Tích Lũy" };
		modelKH = new DefaultTableModel(header, 0);
		tblKH = new JTable(modelKH);

		JScrollPane scrollPane = new JScrollPane(tblKH);
		add(scrollPane, BorderLayout.CENTER);

		btnTimKiem.addActionListener(this);
		btnTaiLai = new JButton("Tải Lại");
		pnlTimKiem.add(btnTaiLai);
		btnTaiLai.addActionListener(this);
		loadAllCustomers();
	}

	private void loadAllCustomers() {
		java.util.List<KhachHang> dsKH = DAO_KhachHang.layDSKhachHang(); // Assuming this method exists
		for (KhachHang kh : dsKH) {
			modelKH.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSoDienThoai(),
					kh.getNgayThamGia(), kh.getDiemTichLuy() });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTimKiem) {
			String sdt = txtSDT.getText().trim();
			if (sdt.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại để tìm kiếm");
				return;
			}

			modelKH.setRowCount(0); // Xóa dữ liệu cũ
			KhachHang kh = DAO_KhachHang.timKhachHangTheoSDT(sdt);
			if (kh != null) {
				modelKH.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSoDienThoai(),
						kh.getNgayThamGia(), kh.getDiemTichLuy() });
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng với số điện thoại này");
			}
		} else if (e.getSource() == btnTaiLai) {
			modelKH.setRowCount(0); // Clear existing data
			loadAllCustomers(); // Reload all customers
		}
	}
}