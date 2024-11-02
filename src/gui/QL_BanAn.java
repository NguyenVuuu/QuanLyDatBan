package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import custom_gui.Button;
import custom_gui.Table;
import custom_gui.TextField;

public class QL_BanAn extends JPanel implements ActionListener {
	private TextField txtMaBan;
	private JButton btnTaoMa;
	private TextField txtTenBan;
	private TextField txtSoChoNgoi;
	private JComboBox cmbViTri;
	private Button btnThem;
	private Button btnSua;
	private Button btnXoa;
	private Button btnTaiLai;
	private TextField txtTrangThai;

	public QL_BanAn() {
		setLayout(null);

		JPanel pnlBan = new JPanel();
		pnlBan.setBounds(0, 0, 1095, 763);
		add(pnlBan);
		pnlBan.setLayout(null);

		JPanel pnlthongTinBan = new JPanel();
		pnlthongTinBan.setBounds(0, 0, 800, 360);
		pnlthongTinBan.setBackground(new Color(255, 255, 255));
		pnlthongTinBan.setLayout(null);
		pnlBan.add(pnlthongTinBan);

		JPanel pnlTieuDeTT = new JPanel();
		pnlTieuDeTT.setBounds(0, 0, 800, 50);
		pnlTieuDeTT.setBackground(new Color(0, 129, 167));
		pnlthongTinBan.add(pnlTieuDeTT);

		JLabel lblTieuDeTT = new JLabel("THÔNG TIN BÀN ĂN");
		lblTieuDeTT.setForeground(new Color(255, 255, 255));
		lblTieuDeTT.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeTT.add(lblTieuDeTT);

		JLabel lblMaBan = new JLabel("Mã Bàn");
		lblMaBan.setFont(new Font("Segoe UI", 1, 15));
		lblMaBan.setForeground(new Color(108, 91, 123));
		lblMaBan.setBounds(50, 70, 150, 40);
		pnlthongTinBan.add(lblMaBan);

		txtMaBan = new TextField();
		txtMaBan.setEditable(false);
		txtMaBan.setBounds(210, 70, 390, 40);
		pnlthongTinBan.add(txtMaBan);

		btnTaoMa = new JButton("Tạo Mã");
		btnTaoMa.setBounds(610, 70, 100, 40);
		btnTaoMa.setFont(new Font("Segoe UI", 1, 15));
		btnTaoMa.setBackground(new Color(108, 91, 123));
		btnTaoMa.setForeground(new Color(255, 255, 255));
		pnlthongTinBan.add(btnTaoMa);

		JLabel lblTenBan = new JLabel("Tên Bàn");
		lblTenBan.setFont(new Font("Segoe UI", 1, 15));
		lblTenBan.setForeground(new Color(108, 91, 123));
		lblTenBan.setBounds(50, 130, 150, 40);
		pnlthongTinBan.add(lblTenBan);

		txtTenBan = new TextField();
		txtTenBan.setBounds(210, 130, 500, 40);
		pnlthongTinBan.add(txtTenBan);

		JLabel lblSoChoNgoi = new JLabel("Số Chỗ Ngồi");
		lblSoChoNgoi.setFont(new Font("Segoe UI", 1, 15));
		lblSoChoNgoi.setForeground(new Color(108, 91, 123));
		lblSoChoNgoi.setBounds(50, 190, 150, 40);
		pnlthongTinBan.add(lblSoChoNgoi);

		txtSoChoNgoi = new TextField();
		txtSoChoNgoi.setBounds(210, 190, 500, 40);
		pnlthongTinBan.add(txtSoChoNgoi);

		JLabel lblViTri = new JLabel("Vị Trí");
		lblViTri.setFont(new Font("Segoe UI", 1, 15));
		lblViTri.setForeground(new Color(108, 91, 123));
		lblViTri.setBounds(50, 250, 150, 40);
		pnlthongTinBan.add(lblViTri);

		cmbViTri = new JComboBox<>();
		cmbViTri.setBounds(210, 250, 500, 40);
		pnlthongTinBan.add(cmbViTri);

		JLabel lblTrangThai = new JLabel("Trạng Thái");
		lblTrangThai.setFont(new Font("Segoe UI", 1, 15));
		lblTrangThai.setForeground(new Color(108, 91, 123));
		lblTrangThai.setBounds(50, 310, 150, 40);
		pnlthongTinBan.add(lblTrangThai);

		txtTrangThai = new TextField();
		txtTrangThai.setEditable(false);
		txtTrangThai.setBounds(210, 310, 500, 40);
		pnlthongTinBan.add(txtTrangThai);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBounds(810, 0, 285, 360);
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setLayout(null);
		pnlBan.add(pnlChucNang);

		JPanel pnlTieuDeCN = new JPanel();
		pnlTieuDeCN.setBounds(0, 0, 285, 50);
		pnlTieuDeCN.setBackground(new Color(0, 129, 167));
		pnlChucNang.add(pnlTieuDeCN);

		JLabel lblTieuDeCN = new JLabel("CHỨC NĂNG");
		lblTieuDeCN.setForeground(new Color(255, 255, 255));
		lblTieuDeCN.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeCN.add(lblTieuDeCN);

		btnThem = new Button();
		btnThem.setText("THÊM BÀN");
		btnThem.setFont(new Font("Segoe UI", 1, 15));
		btnThem.setBounds(55, 90, 170, 30);
		btnThem.setBackground(new Color(108, 91, 123));
		btnThem.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnThem);

		btnSua = new Button();
		btnSua.setText("SỬA THÔNG TIN");
		btnSua.setFont(new Font("Segoe UI", 1, 15));
		btnSua.setBounds(55, 150, 170, 30);
		btnSua.setBackground(new Color(108, 91, 123));
		btnSua.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnSua);

		btnXoa = new Button();
		btnXoa.setText("XÓA BÀN");
		btnXoa.setFont(new Font("Segoe UI", 1, 15));
		btnXoa.setBounds(55, 210, 170, 30);
		btnXoa.setBackground(new Color(108, 91, 123));
		btnXoa.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnXoa);

		btnTaiLai = new Button();
		btnTaiLai.setText("TẢI LẠI");
		btnTaiLai.setFont(new Font("Segoe UI", 1, 15));
		btnTaiLai.setBounds(55, 270, 170, 30);
		btnTaiLai.setBackground(new Color(108, 91, 123));
		btnTaiLai.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnTaiLai);

		JScrollPane tltBan = new JScrollPane();
		tltBan.setBounds(0, 370, 1095, 393);
		String[] header = { "Mã Bàn", "Tên Bàn", "Số Chỗ Ngồi", "Vị Trí", "Trạng Thái" };
		DefaultTableModel modelBan = new DefaultTableModel(header, 0);
		Table tblBan = new Table();
		tblBan.setModel(modelBan);
		tltBan.setViewportView(tblBan);
		pnlBan.add(tltBan);

		btnTaoMa.addActionListener(this);
	}

	public String taoMa() {
		String uuid = UUID.randomUUID().toString();
		return "B" + uuid.replace("-", "").substring(0, 7).toUpperCase();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnTaoMa)) {
			txtMaBan.setText(taoMa());
		}
	}
}
