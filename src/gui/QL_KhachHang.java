package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import custom_gui.Button;
import custom_gui.ScrollBarCustom;
import custom_gui.Table;
import custom_gui.TextField;
import dao.DAO_KhachHang;
import entity.KhachHang;

public class QL_KhachHang extends JPanel implements ActionListener, MouseListener {

	private Button btnThem;
	private Button btnSua;
	private Button btnXoa;
	private Button btnTaiLai;
	private TextField txtMaKH;
	private TextField txtTenKH;
	private TextField txtSDT;
	private JDateChooser txtNgayThamGia;
	private JButton btnTaoMa;
	private DefaultTableModel modelKH;
	private Table tblKH;

	public QL_KhachHang() {
		setLayout(null);

		JPanel pnlKH = new JPanel();
		pnlKH.setBounds(0, 0, 1095, 763);
		add(pnlKH);
		pnlKH.setLayout(null);

		JPanel pnlthongTinKH = new JPanel();
		pnlthongTinKH.setBounds(0, 0, 800, 300);
		pnlthongTinKH.setBackground(new Color(255, 255, 255));
		pnlthongTinKH.setLayout(null);
		pnlKH.add(pnlthongTinKH);

		JPanel pnlTieuDeTT = new JPanel();
		pnlTieuDeTT.setBounds(0, 0, 800, 50);
		pnlTieuDeTT.setBackground(new Color(238, 77, 45));
		pnlthongTinKH.add(pnlTieuDeTT);

		JLabel lblTieuDeTT = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblTieuDeTT.setForeground(new Color(255, 255, 255));
		lblTieuDeTT.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeTT.add(lblTieuDeTT);

		JLabel lblMaKH = new JLabel("Mã Khách Hàng");
		lblMaKH.setFont(new Font("Segoe UI", 1, 15));
		lblMaKH.setForeground(new Color(108, 91, 123));
		lblMaKH.setBounds(50, 70, 150, 40);
		pnlthongTinKH.add(lblMaKH);

		txtMaKH = new TextField();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(210, 70, 390, 40);
		pnlthongTinKH.add(txtMaKH);

		btnTaoMa = new JButton("Tạo Mã");
		btnTaoMa.setBounds(610, 70, 100, 40);
		btnTaoMa.setFont(new Font("Segoe UI", 1, 15));
		btnTaoMa.setBackground(new Color(108, 91, 123));
		btnTaoMa.setForeground(new Color(255, 255, 255));
		pnlthongTinKH.add(btnTaoMa);

		JLabel lblTenKH = new JLabel("Tên Khách Hàng");
		lblTenKH.setFont(new Font("Segoe UI", 1, 15));
		lblTenKH.setForeground(new Color(108, 91, 123));
		lblTenKH.setBounds(50, 130, 150, 40);
		pnlthongTinKH.add(lblTenKH);

		txtTenKH = new TextField();
		txtTenKH.setBounds(210, 130, 500, 40);
		pnlthongTinKH.add(txtTenKH);

		JLabel lblSDT = new JLabel("Số Điện Thoại");
		lblSDT.setFont(new Font("Segoe UI", 1, 15));
		lblSDT.setForeground(new Color(108, 91, 123));
		lblSDT.setBounds(50, 190, 150, 40);
		pnlthongTinKH.add(lblSDT);

		txtSDT = new TextField();
		txtSDT.setBounds(210, 190, 500, 40);
		pnlthongTinKH.add(txtSDT);

		JLabel lblNgayThamGia = new JLabel("Ngày Tham Gia");
		lblNgayThamGia.setFont(new Font("Segoe UI", 1, 15));
		lblNgayThamGia.setForeground(new Color(108, 91, 123));
		lblNgayThamGia.setBounds(50, 250, 150, 40);
		pnlthongTinKH.add(lblNgayThamGia);

		txtNgayThamGia = new JDateChooser();
		txtNgayThamGia.setLocale(new Locale("vi", "VN"));
		txtNgayThamGia.setBounds(210, 250, 500, 40);
		pnlthongTinKH.add(txtNgayThamGia);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBounds(810, 0, 285, 300);
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setLayout(null);
		pnlKH.add(pnlChucNang);

		JPanel pnlTieuDeCN = new JPanel();
		pnlTieuDeCN.setBounds(0, 0, 285, 50);
		pnlTieuDeCN.setBackground(new Color(238, 77, 45));
		pnlChucNang.add(pnlTieuDeCN);

		JLabel lblTieuDeCN = new JLabel("CHỨC NĂNG");
		lblTieuDeCN.setForeground(new Color(255, 255, 255));
		lblTieuDeCN.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeCN.add(lblTieuDeCN);

		btnThem = new Button();
		btnThem.setText("THÊM KHÁCH HÀNG");
		btnThem.setFont(new Font("Segoe UI", 1, 15));
		btnThem.setBounds(55, 70, 170, 30);
		btnThem.setBackground(new Color(220, 62, 55));
		btnThem.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnThem);

		btnSua = new Button();
		btnSua.setText("SỬA THÔNG TIN");
		btnSua.setFont(new Font("Segoe UI", 1, 15));
		btnSua.setBounds(55, 120, 170, 30);
		btnSua.setBackground(new Color(108, 91, 123));
		btnSua.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnSua);

		btnXoa = new Button();
		btnXoa.setText("XÓA KHÁCH HÀNG");
		btnXoa.setFont(new Font("Segoe UI", 1, 15));
		btnXoa.setBounds(55, 170, 170, 30);
		btnXoa.setBackground(new Color(108, 91, 123));
		btnXoa.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnXoa);

		btnTaiLai = new Button();
		btnTaiLai.setText("TẢI LẠI");
		btnTaiLai.setFont(new Font("Segoe UI", 1, 15));
		btnTaiLai.setBounds(55, 220, 170, 30);
		btnTaiLai.setBackground(new Color(238, 77, 45));
		btnTaiLai.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnTaiLai);

		JScrollPane tltKH = new JScrollPane();
		tltKH.setVerticalScrollBar(new ScrollBarCustom());
		tltKH.setBounds(0, 310, 1095, 453);
		String[] header = { "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Ngày Tham Gia", "Điểm Tích Lũy" };
		modelKH = new DefaultTableModel(header, 0);
		tblKH = new Table();
		tblKH.setModel(modelKH);
		tltKH.setViewportView(tblKH);
		pnlKH.add(tltKH);

		btnTaoMa.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTaiLai.addActionListener(this);
		tblKH.addMouseListener(this);

		// modelKH.addRow(new Object[]{"KH001", "Nguyễn Thị Hương", "0987654321",
		// "2024-05-01", 100});
		// modelKH.addRow(new Object[]{"KH002", "Trần Văn Nam", "0123456789",
		// "2024-05-02", 150});
		// modelKH.addRow(new Object[]{"KH003", "Phạm Minh Tuấn", "0932145678",
		// "2024-05-03", 200});
//		modelKH.addRow(new Object[]{"KH004", "Lê Thị Lan", "0867543219", "2024-05-04", 50});
//		modelKH.addRow(new Object[]{"KH005", "Hoàng Văn Hải", "0912345678", "2024-05-05", 300});
//		modelKH.addRow(new Object[]{"KH006", "Mai Thị Thanh", "0987654321", "2024-05-06", 120});
//		modelKH.addRow(new Object[]{"KH007", "Nguyễn Văn An", "0901234567", "2024-05-07", 250});
//		modelKH.addRow(new Object[]{"KH008", "Lê Thị Hoa", "0976543210", "2024-05-08", 80});
//		modelKH.addRow(new Object[]{"KH009", "Trần Văn Đức", "0897654321", "2024-05-09", 180});
//		modelKH.addRow(new Object[]{"KH010", "Hoàng Thị Ngọc", "0888765432", "2024-05-10", 210});
//		modelKH.addRow(new Object[]{"KH011", "Phạm Văn Tuấn", "0978654321", "2024-05-11", 70});
//		modelKH.addRow(new Object[]{"KH012", "Nguyễn Thị Minh", "0965432178", "2024-05-12", 220});
//		modelKH.addRow(new Object[]{"KH013", "Lê Văn Đạt", "0890987654", "2024-05-13", 130});
//		modelKH.addRow(new Object[]{"KH014", "Trần Thị Thu", "0932123456", "2024-05-14", 240});
//		modelKH.addRow(new Object[]{"KH015", "Phạm Văn Hùng", "0945678901", "2024-05-15", 160});
//		modelKH.addRow(new Object[]{"KH016", "Nguyễn Thị Hạnh", "0998765432", "2024-05-16", 190});
//		modelKH.addRow(new Object[]{"KH017", "Trần Văn Tâm", "0887654321", "2024-05-17", 110});
//		modelKH.addRow(new Object[]{"KH018", "Lê Thị Ngọc", "0977654321", "2024-05-18", 270});
//		modelKH.addRow(new Object[]{"KH019", "Phạm Văn Quân", "0901122334", "2024-05-19", 140});
//		modelKH.addRow(new Object[]{"KH020", "Nguyễn Thị Mai", "0987651234", "2024-05-20", 230});

	}

	private void themKhachHang() {
		String maKH = txtMaKH.getText().trim();
		String tenKH = txtTenKH.getText().trim();
		String sdt = txtSDT.getText().trim();
		LocalDate ngayThamGia = LocalDate.now(); // Hoặc lấy từ một trường nhập liệu

		if (maKH.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống");
			return;
		}

		KhachHang kh = new KhachHang(maKH, tenKH, sdt, ngayThamGia, 0);

		if (DAO_KhachHang.themKhachHang(kh)) {
			JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
			lamMoiThongTin(); // Cập nhật lại thông tin trên bảng
		} else {
			JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại");
		}
	}

	private void lamMoiThongTin() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtSDT.setText("");
		// Cập nhật lại bảng khách hàng
		modelKH.setRowCount(0);
		List<KhachHang> dsKH = DAO_KhachHang.layDSKhachHang(); // Giả sử bạn có phương thức này
		for (KhachHang kh : dsKH) {
			modelKH.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSoDienThoai(),
					kh.getNgayThamGia(), kh.getDiemTichLuy() });
		}
	}

	public void xoaKhachHang() {
		int row = tblKH.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần xóa");
		} else {
			String maKH = (String) modelKH.getValueAt(row, 0);
			int choice = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa khách hàng này?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (choice == JOptionPane.YES_OPTION) {
				KhachHang kh = new KhachHang(maKH);
				if (DAO_KhachHang.xoaKhachHang(kh)) {
					lamMoiThongTin();
					JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Không thể xóa");
				}
			}
		}
	}

	public String taoMa() {
		String uuid = UUID.randomUUID().toString();
		return "KH" + uuid.replace("-", "").substring(0, 3).toUpperCase();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnTaoMa)) {
			txtMaKH.setText(taoMa());
		} else if (obj.equals(btnThem)) {
			themKhachHang();
		} else if (obj.equals(btnSua)) {
			int row = tblKH.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần sửa");
			} else {
				String maKH = (String) modelKH.getValueAt(row, 0);
				String tenKH = txtTenKH.getText().trim();
				String sdt = txtSDT.getText().trim();
				LocalDate ngayThamGia = txtNgayThamGia.getDate().toInstant().atZone(ZoneId.systemDefault())
						.toLocalDate();

				KhachHang kh = new KhachHang(maKH, tenKH, sdt, ngayThamGia, 0);
				if (DAO_KhachHang.suaKhachHang(kh)) {
					lamMoiThongTin();
					JOptionPane.showMessageDialog(this, "Sửa thành công");
				} else {
					JOptionPane.showMessageDialog(this, "Sửa thất bại");
				}
			}
		} else if (obj.equals(btnXoa)) {
			xoaKhachHang();
		} else if (obj.equals(btnTaiLai)) {
			lamMoiThongTin();
		}
	}
}
