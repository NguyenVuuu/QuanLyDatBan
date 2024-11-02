package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import custom_gui.Button;
import custom_gui.ScrollBarCustom;
import custom_gui.Table;
import custom_gui.TextField;
import dao.DAO_SanPham;
import entity.KhuVuc;
import entity.Phong;
import entity.SanPham;

public class QL_SanPham extends JPanel implements ActionListener, MouseListener{
	private TextField txtMaSP;
	private JButton btnTaoMa;
	private TextField txtTenSP;
	private Button btnThem;
	private Button btnSua;
	private Button btnTaiLai;
	private JComboBox cmbTrangThai;
	private DefaultTableModel modelSP;
	private Table tblSP;
	private Button btnXoaTrang;
	private DAO_SanPham daoSP = new DAO_SanPham();
	private ArrayList<SanPham> dsSP;

	public QL_SanPham() {
		setLayout(null);
		
		JPanel pnlSP = new JPanel();
		pnlSP.setBounds(0, 0, 1095, 763);
		add(pnlSP);
		pnlSP.setLayout(null);
		
		JPanel pnlthongTinSP = new JPanel();
		pnlthongTinSP.setBounds(0, 0, 600, 250);
		
		pnlthongTinSP.setBackground(new Color(255, 255, 255));
		pnlthongTinSP.setLayout(null);
		pnlSP.add(pnlthongTinSP);
		
		JPanel pnlTieuDeTT = new JPanel();
		pnlTieuDeTT.setBounds(0, 0, 600, 50);
		pnlTieuDeTT.setBackground(new Color(0,129,167));
		pnlthongTinSP.add(pnlTieuDeTT);
		
		JLabel lblTieuDeTT = new JLabel("THÔNG TIN SẢN PHẨM");
		lblTieuDeTT.setForeground(new Color(255, 255, 255));
		lblTieuDeTT.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeTT.add(lblTieuDeTT);
		
		JLabel lblMaSP = new JLabel("Mã Sản Phẩm");
		lblMaSP.setFont(new Font("Segoe UI", 1, 15));
		lblMaSP.setForeground(new Color(108, 91, 123));
		lblMaSP.setBounds(50, 70, 150, 40);
		pnlthongTinSP.add(lblMaSP);
		
		txtMaSP = new TextField();
		txtMaSP.setEditable(false);
		txtMaSP.setBounds(210, 70, 190, 40);
		pnlthongTinSP.add(txtMaSP);
		
		btnTaoMa = new JButton("Tạo Mã");
		btnTaoMa.setBounds(410, 70, 100, 40);
		btnTaoMa.setFont(new Font("Segoe UI", 1, 15));
		btnTaoMa.setBackground(new Color(108, 91, 123));
		btnTaoMa.setForeground(new Color(255, 255, 255));
		pnlthongTinSP.add(btnTaoMa);
		
		
		JLabel lblTenDVT = new JLabel("Tên Sản Phẩm");
		lblTenDVT.setFont(new Font("Segoe UI", 1, 15));
		lblTenDVT.setForeground(new Color(108, 91, 123));
		lblTenDVT.setBounds(50, 130, 150, 40);
		pnlthongTinSP.add(lblTenDVT);
		
		txtTenSP = new TextField();
		txtTenSP.setBounds(210, 130, 300, 40);
		pnlthongTinSP.add(txtTenSP);
		
		JLabel lblTrangThai = new JLabel("Trạng Thái");
		lblTrangThai.setFont(new Font("Segoe UI", 1, 15));
		lblTrangThai.setForeground(new Color(108, 91, 123));
		lblTrangThai.setBounds(50, 190, 150, 40);
		pnlthongTinSP.add(lblTrangThai);
		
		cmbTrangThai = new JComboBox<>();
		cmbTrangThai.addItem("Đang Kinh Doanh");
		cmbTrangThai.addItem("Ngưng Kinh Doanh");
		cmbTrangThai.setBounds(210, 190, 300, 40);
		pnlthongTinSP.add(cmbTrangThai);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBounds(610, 0, 485, 250);
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setLayout(null);
		pnlSP.add(pnlChucNang);
		
		JPanel pnlTieuDeCN = new JPanel();
		pnlTieuDeCN.setBounds(0, 0, 485, 50);
		pnlTieuDeCN.setBackground(new Color(0,129,167));
		pnlChucNang.add(pnlTieuDeCN);
		
		JLabel lblTieuDeCN = new JLabel("CHỨC NĂNG");
		lblTieuDeCN.setForeground(new Color(255, 255, 255));
		lblTieuDeCN.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeCN.add(lblTieuDeCN);
		
		btnThem = new Button();
		btnThem.setText("THÊM SẢN PHẨM");
		btnThem.setFont(new Font("Segoe UI", 1, 15));
		btnThem.setBounds(55, 100, 170, 30);
		btnThem.setBackground(new Color(108, 91, 123));
		btnThem.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnThem);
		
		btnSua = new Button();
		btnSua.setText("SỬA THÔNG TIN");
		btnSua.setFont(new Font("Segoe UI", 1, 15));
		btnSua.setBounds(255, 100, 170, 30);
		btnSua.setBackground(new Color(108, 91, 123));
		btnSua.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnSua);
		
		btnXoaTrang = new Button();
		btnXoaTrang.setText("XÓA TRẮNG");
		btnXoaTrang.setFont(new Font("Segoe UI", 1, 15));
		btnXoaTrang.setBounds(55, 160, 170, 30);
		btnXoaTrang.setBackground(new Color(108, 91, 123));
		btnXoaTrang.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnXoaTrang);
		
		btnTaiLai = new Button();
		btnTaiLai.setText("TẢI LẠI");
		btnTaiLai.setFont(new Font("Segoe UI", 1, 15));
		btnTaiLai.setBounds(255, 160, 170, 30);
		btnTaiLai.setBackground(new Color(108, 91, 123));
		btnTaiLai.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnTaiLai);
		
		JScrollPane tltSP = new JScrollPane();
		tltSP.setVerticalScrollBar(new ScrollBarCustom());
		tltSP.setBounds(0, 260, 1095, 503);
		String[] header = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Trạng Thái"};
		modelSP = new DefaultTableModel(header, 0);
		tblSP = new Table();
		tblSP.setModel(modelSP);
		tltSP.setViewportView(tblSP);
		pnlSP.add(tltSP);
		
		dsSP = daoSP.layDSSanPham();
		for(SanPham sp : dsSP) {
			String s = "";
			if(sp.isTrangThai() == true) {
				s = "Đang Kinh Doanh";
			} else {
				s = "Ngưng Kinh Doanh";
			}
			
			modelSP.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), s});
		}
		
		btnTaoMa.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		btnTaiLai.addActionListener(this);
		
		tblSP.addMouseListener(this);
		
		
	}
	
	public String taoMa() {
		String uuid = UUID.randomUUID().toString();
	    return "SP" + uuid.replace("-", "").substring(0, 7).toUpperCase();
	}
	
	public boolean validData() {
		String ma = txtMaSP.getText().trim();
		String ten = txtTenSP.getText().trim();
		String trangThai = cmbTrangThai.getSelectedItem().toString().trim();
		
		if(ma.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhấn nút tạo mã");
			return false;
		} else if(ten.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên sản phẩm");
			txtTenSP.requestFocus();
			return false;
		} else if(!ten.matches("[\\p{L}\\s]+")) {
			JOptionPane.showMessageDialog(this, "Tên sản phẩm chỉ chứa chữ");
			txtTenSP.requestFocus();
			return false;
		} 
		
		return true;
	}
	
	public void lamMoiThongTin() {
		txtMaSP.setText("");
		txtTenSP.setText("");
		cmbTrangThai.setSelectedIndex(0);
		
		modelSP.setRowCount(0);
		dsSP = daoSP.layDSSanPham();
		for(SanPham sp : dsSP) {
			String s = "";
			if(sp.isTrangThai() == true) {
				s = "Đang Kinh Doanh";
			} else {
				s = "Ngưng Kinh Doanh";
			}
			
			modelSP.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), s});
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblSP.getSelectedRow();
		txtMaSP.setText(modelSP.getValueAt(row, 0).toString());
		txtTenSP.setText(modelSP.getValueAt(row, 1).toString());
		cmbTrangThai.setSelectedItem(modelSP.getValueAt(row, 2).toString());
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
		
		if(obj.equals(btnTaoMa)) {
			txtMaSP.setText(taoMa());
		}
		
		if(obj.equals(btnThem)) {
			if(validData()) {
				String maSP = txtMaSP.getText().trim();
				String tenSP = txtTenSP.getText().trim();
				boolean trangThai = true;
				
								
				if(tblSP.getSelectedRow() != -1) {
					JOptionPane.showMessageDialog(this, "Đang trong chế độ sửa không được phép thêm");
				} else {
					SanPham sp = new SanPham(maSP, tenSP, trangThai);
					if(daoSP.themSP(sp)) {
						lamMoiThongTin();
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại - Mã phòng đã tồn tại");
					}
				}
			}
		}
		
		if(obj.equals(btnSua)) {
			int row = tblSP.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần sửa");
			} else {
				if(validData()) {
					String ma = txtMaSP.getText().trim();
					String ten = txtTenSP.getText().trim();
					boolean trangThai;
					
					if(cmbTrangThai.getSelectedItem().toString().equals("Đang Kinh Doanh")) {
						trangThai = true;
					} else {
						trangThai = false;
					}
					
					SanPham sp = new SanPham(ma, ten, trangThai);
					if(daoSP.suaSanPham(sp)) {
						lamMoiThongTin();
						JOptionPane.showMessageDialog(this, "Sửa thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Sửa thất bại");
					}
				}
			}
		}
		
		if(obj.equals(btnXoaTrang)) {
			txtMaSP.setText("");
			txtTenSP.setText("");
			cmbTrangThai.setSelectedIndex(0);
		}
		
		if(obj.equals(btnTaiLai)) {
			lamMoiThongTin();
		}
	}
}
