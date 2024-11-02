package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.UUID;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import custom_gui.Button;
import custom_gui.ScrollBarCustom;
import custom_gui.Table;
import custom_gui.TextField;

public class QL_NhanVien extends JPanel implements ActionListener {
	private TextField txtMaNV;
	private JButton btnTaoMa;
	private TextField txtTenNV;
	private TextField txtSDT;
	private JDateChooser txtNgayVaoLam;
	private Button btnThem;
	private Button btnSua;
	private Button btnXoaTrang;
	private Button btnTaiLai;
	private TextField txtTaiKhoan;
	private TextField txtMatKhau;
	private TextField txtDiaChi;
	private JComboBox cmbChucVu;
	private JComboBox cmbTrangThai;

	public QL_NhanVien() {
		setLayout(null);
		

		JPanel pnlNV = new JPanel();
		pnlNV.setBounds(0, 0, 1095, 763);
		add(pnlNV);
		pnlNV.setLayout(null);

		JPanel pnlthongTinNV = new JPanel();
		pnlthongTinNV.setBounds(0, 0, 1095, 250);
		pnlthongTinNV.setBackground(new Color(255, 255, 255));
		pnlthongTinNV.setLayout(null);
		pnlNV.add(pnlthongTinNV);

		JPanel pnlTieuDeTT = new JPanel();
		pnlTieuDeTT.setBounds(0, 0, 1095, 50);
		pnlTieuDeTT.setBackground(new Color(0, 129, 167));
		pnlthongTinNV.add(pnlTieuDeTT);

		JLabel lblTieuDeTT = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTieuDeTT.setForeground(new Color(255, 255, 255));
		lblTieuDeTT.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeTT.add(lblTieuDeTT);

		JLabel lblMaKH = new JLabel("Mã Nhân Viên");
		lblMaKH.setFont(new Font("Segoe UI", 1, 15));
		lblMaKH.setForeground(new Color(108, 91, 123));
		lblMaKH.setBounds(25, 70, 150, 40);
		pnlthongTinNV.add(lblMaKH);

		txtMaNV = new TextField();
		txtMaNV.setEditable(false);
		txtMaNV.setBounds(185, 70, 237, 40);
		pnlthongTinNV.add(txtMaNV);

		btnTaoMa = new JButton("Tạo Mã");
		btnTaoMa.setBounds(427, 70, 100, 40);
		btnTaoMa.setFont(new Font("Segoe UI", 1, 15));
		btnTaoMa.setBackground(new Color(108, 91, 123));
		btnTaoMa.setForeground(new Color(255, 255, 255));
		pnlthongTinNV.add(btnTaoMa);

		JLabel lblTenNV = new JLabel("Tên Nhân Viên");
		lblTenNV.setFont(new Font("Segoe UI", 1, 15));
		lblTenNV.setForeground(new Color(108, 91, 123));
		lblTenNV.setBounds(25, 130, 150, 40);
		pnlthongTinNV.add(lblTenNV);

		txtTenNV = new TextField();
		txtTenNV.setBounds(185, 130, 337, 40);
		pnlthongTinNV.add(txtTenNV);

		JLabel lblSDT = new JLabel("Số Điện Thoại");
		lblSDT.setFont(new Font("Segoe UI", 1, 15));
		lblSDT.setForeground(new Color(108, 91, 123));
		lblSDT.setBounds(25, 190, 150, 40);
		pnlthongTinNV.add(lblSDT);

		txtSDT = new TextField();
		txtSDT.setBounds(185, 190, 337, 40);
		pnlthongTinNV.add(txtSDT);

//		JLabel lblDiaChi = new JLabel("Địa Chỉ Nhân Viên");
//		lblDiaChi.setFont(new Font("Segoe UI", 1, 15));
//		lblDiaChi.setForeground(new Color(108, 91, 123));
//		lblDiaChi.setBounds(562, 70, 150, 40);
//		pnlthongTinNV.add(lblDiaChi);
//		
//		txtDiaChi = new TextField();
//		txtDiaChi.setBounds(722, 70, 337, 40);
//		pnlthongTinNV.add(txtDiaChi);

		JLabel lblNgayVaoLam = new JLabel("Ngày Vào Làm");
		lblNgayVaoLam.setFont(new Font("Segoe UI", 1, 15));
		lblNgayVaoLam.setForeground(new Color(108, 91, 123));
		lblNgayVaoLam.setBounds(562, 70, 150, 40);
		pnlthongTinNV.add(lblNgayVaoLam);

		txtNgayVaoLam = new JDateChooser();
		txtNgayVaoLam.setLocale(new Locale("vi", "VN"));
		txtNgayVaoLam.setBounds(722, 70, 337, 40);
		pnlthongTinNV.add(txtNgayVaoLam);

		JLabel lblTrangThai = new JLabel("Trạng Thái");
		lblTrangThai.setFont(new Font("Segoe UI", 1, 15));
		lblTrangThai.setForeground(new Color(108, 91, 123));
		lblTrangThai.setBounds(562, 139, 150, 40);
		pnlthongTinNV.add(lblTrangThai);

		cmbTrangThai = new JComboBox<>();
		cmbTrangThai.addItem("Đang Làm");
		cmbTrangThai.addItem("Nghỉ Làm");
		cmbTrangThai.setBounds(722, 130, 337, 40);
		pnlthongTinNV.add(cmbTrangThai);

		JLabel lblChucVu = new JLabel("Chức Vụ");
		lblChucVu.setFont(new Font("Segoe UI", 1, 15));
		lblChucVu.setForeground(new Color(108, 91, 123));
		lblChucVu.setBounds(562, 190, 150, 40);
		pnlthongTinNV.add(lblChucVu);

		cmbChucVu = new JComboBox<>();
		cmbChucVu.addItem("Nhân Viên");
		cmbChucVu.addItem("Người Quản Lý");
		cmbChucVu.setBounds(722, 190, 337, 40);
		pnlthongTinNV.add(cmbChucVu);

		JPanel pnlthongTinTK = new JPanel();
		pnlthongTinTK.setBounds(0, 260, 600, 200);
		pnlthongTinTK.setBackground(new Color(255, 255, 255));
		pnlthongTinTK.setLayout(null);
		pnlNV.add(pnlthongTinTK);

		JPanel pnlTieuDeTTTK = new JPanel();
		pnlTieuDeTTTK.setBounds(0, 0, 600, 50);
		pnlTieuDeTTTK.setBackground(new Color(0, 129, 167));
		pnlthongTinTK.add(pnlTieuDeTTTK);

		JLabel lblTieuDeTTTK = new JLabel("THÔNG TIN TÀI KHOẢN");
		lblTieuDeTTTK.setForeground(new Color(255, 255, 255));
		lblTieuDeTTTK.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeTTTK.add(lblTieuDeTTTK);

		JLabel lblTaiKhoan = new JLabel("Tài Khoản");
		lblTaiKhoan.setFont(new Font("Segoe UI", 1, 15));
		lblTaiKhoan.setForeground(new Color(108, 91, 123));
		lblTaiKhoan.setBounds(50, 70, 150, 40);
		pnlthongTinTK.add(lblTaiKhoan);

		txtTaiKhoan = new TextField();
		txtTaiKhoan.setEditable(false);
		txtTaiKhoan.setBounds(210, 70, 300, 40);
		pnlthongTinTK.add(txtTaiKhoan);

		JLabel lblMatKhau = new JLabel("Mật Khẩu");
		lblMatKhau.setFont(new Font("Segoe UI", 1, 15));
		lblMatKhau.setForeground(new Color(108, 91, 123));
		lblMatKhau.setBounds(50, 130, 150, 40);
		pnlthongTinTK.add(lblMatKhau);

		txtMatKhau = new TextField();
		txtMatKhau.setBounds(210, 130, 300, 40);
		pnlthongTinTK.add(txtMatKhau);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBounds(610, 260, 485, 200);
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setLayout(null);
		pnlNV.add(pnlChucNang);

		JPanel pnlTieuDeCN = new JPanel();
		pnlTieuDeCN.setBounds(0, 0, 485, 50);
		pnlTieuDeCN.setBackground(new Color(0, 129, 167));
		pnlChucNang.add(pnlTieuDeCN);

		JLabel lblTieuDeCN = new JLabel("CHỨC NĂNG");
		lblTieuDeCN.setForeground(new Color(255, 255, 255));
		lblTieuDeCN.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeCN.add(lblTieuDeCN);

		btnThem = new Button();
		btnThem.setText("THÊM NHÂN VIÊN");
		btnThem.setFont(new Font("Segoe UI", 1, 15));
		btnThem.setBounds(55, 70, 170, 30);
		btnThem.setBackground(new Color(108, 91, 123));
		btnThem.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnThem);

		btnSua = new Button();
		btnSua.setText("SỬA THÔNG TIN");
		btnSua.setFont(new Font("Segoe UI", 1, 15));
		btnSua.setBounds(255, 70, 170, 30);
		btnSua.setBackground(new Color(108, 91, 123));
		btnSua.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnSua);

		btnXoaTrang = new Button();
		btnXoaTrang.setText("XÓA TRẮNG");
		btnXoaTrang.setFont(new Font("Segoe UI", 1, 15));
		btnXoaTrang.setBounds(55, 130, 170, 30);
		btnXoaTrang.setBackground(new Color(108, 91, 123));
		btnXoaTrang.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnXoaTrang);

		btnTaiLai = new Button();
		btnTaiLai.setText("TẢI LẠI");
		btnTaiLai.setFont(new Font("Segoe UI", 1, 15));
		btnTaiLai.setBounds(255, 130, 170, 30);
		btnTaiLai.setBackground(new Color(108, 91, 123));
		btnTaiLai.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnTaiLai);

		JScrollPane tltNV = new JScrollPane();
		tltNV.setVerticalScrollBar(new ScrollBarCustom());
		tltNV.setBounds(0, 470, 1095, 293);
		String[] header = { "Mã Nhân Viên", "Tên Nhân Viên", "Số Điện Thoại", "Ngày Vào Làm", "Trạng Thái", "Chức Vụ" };
		DefaultTableModel modelNV = new DefaultTableModel(header, 0);
		Table tblNV = new Table();
		tblNV.setModel(modelNV);
		tltNV.setViewportView(tblNV);
		pnlNV.add(tltNV);

		modelNV.addRow(new Object[] { "NV001", "Nguyễn Văn Anh", "0987654321", "2024-03-01", "Đang làm",
				"Nhân viên quản lý" });
		modelNV.addRow(new Object[] { "NV002", "Trần Thị Lan", "0123456789", "2024-02-02", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV003", "Phạm Văn Chung", "0932145678", "2022-05-03", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV004", "Lê Thị Hương", "0867543219", "2024-02-04", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV005", "Hoàng Văn Đức", "0912345678", "2024-01-05", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV006", "Mai Thị Trang", "0987654321", "2023-05-06", "Đang làm", "Nhân viên" });
		modelNV.addRow(
				new Object[] { "NV007", "Nguyễn Văn Bình", "0901234567", "2023-05-07", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV008", "Lê Thị Ngọc", "0976543210", "2023-05-08", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV009", "Trần Văn Hải", "0897654321", "2023-05-09", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV010", "Hoàng Thị Thu", "0888765432", "2023-05-10", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV011", "Phạm Văn Nam", "0978654321", "2023-05-11", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV012", "Nguyễn Thị Mai", "0965432178", "2023-05-12", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV013", "Lê Văn Hùng", "0890987654", "2023-05-13", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV014", "Trần Thị Huệ", "0932123456", "2023-05-14", "Đang làm", "Nhân viên" });
		modelNV.addRow(new Object[] { "NV015", "Phạm Văn Quân", "0945678901", "2023-05-15", "Đang làm", "Nhân viên" });

		btnTaoMa.addActionListener(this);
//		btnThem.addActionListener(this);
//		btnSua.addActionListener(this);
//		btnXoa.addActionListener(this);
//		btnTaiLai.addActionListener(this);
//		tblKH.addMouseListener(this);
	}

	public String taoMa() {
		String uuid = UUID.randomUUID().toString();
		return "NV" + uuid.replace("-", "").substring(0, 3).toUpperCase();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnTaoMa)) {
			txtMaNV.setText(taoMa());
		}
	}
}
