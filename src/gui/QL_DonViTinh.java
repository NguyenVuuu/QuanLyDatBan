package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import custom_gui.Button;
import custom_gui.Table;
import custom_gui.TextField;
import dao.DAO_DonViTinh;
import entity.DonViTinh;
import entity.KhuVuc;

public class QL_DonViTinh extends JPanel implements ActionListener, MouseListener{
	private TextField txtMaDVT;
	private JButton btnTaoMa;
	private TextField txtTenDVT;
	private Button btnThem;
	private Button btnSua;
	private Button btnXoaTrang;
	private Button btnTaiLai;
	private DAO_DonViTinh daoDVT = new DAO_DonViTinh();
	private DefaultTableModel modelDVT;
	private Table tblDVT;
	private ArrayList<DonViTinh> dsDVT;

	public QL_DonViTinh() {
		setLayout(null);
		
		JPanel pnlDVT = new JPanel();
		pnlDVT.setBounds(0, 0, 1095, 763);
		add(pnlDVT);
		pnlDVT.setLayout(null);
		
		JPanel pnlthongTinDVT = new JPanel();
		pnlthongTinDVT.setBounds(0, 0, 600, 200);
		pnlthongTinDVT.setBackground(new Color(255, 255, 255));
		pnlthongTinDVT.setLayout(null);
		pnlDVT.add(pnlthongTinDVT);
		
		JPanel pnlTieuDeTT = new JPanel();
		pnlTieuDeTT.setBounds(0, 0, 600, 50);
		pnlTieuDeTT.setBackground(new Color(0,129,167));
		pnlthongTinDVT.add(pnlTieuDeTT);
		
		JLabel lblTieuDeTT = new JLabel("THÔNG TIN ĐƠN VỊ TÍNH");
		lblTieuDeTT.setForeground(new Color(255, 255, 255));
		lblTieuDeTT.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeTT.add(lblTieuDeTT);
		
		JLabel lblMaDVT = new JLabel("Mã Đơn Vị");
		lblMaDVT.setFont(new Font("Segoe UI", 1, 15));
		lblMaDVT.setForeground(new Color(108, 91, 123));
		lblMaDVT.setBounds(50, 70, 150, 40);
		pnlthongTinDVT.add(lblMaDVT);
		
		txtMaDVT = new TextField();
		txtMaDVT.setEditable(false);
		txtMaDVT.setBounds(210, 70, 190, 40);
		pnlthongTinDVT.add(txtMaDVT);
		
		btnTaoMa = new JButton("Tạo Mã");
		btnTaoMa.setBounds(410, 70, 100, 40);
		btnTaoMa.setFont(new Font("Segoe UI", 1, 15));
		btnTaoMa.setBackground(new Color(108, 91, 123));
		btnTaoMa.setForeground(new Color(255, 255, 255));
		pnlthongTinDVT.add(btnTaoMa);
		
		
		JLabel lblTenDVT = new JLabel("Tên Đơn Vị");
		lblTenDVT.setFont(new Font("Segoe UI", 1, 15));
		lblTenDVT.setForeground(new Color(108, 91, 123));
		lblTenDVT.setBounds(50, 130, 150, 40);
		pnlthongTinDVT.add(lblTenDVT);
		
		txtTenDVT = new TextField();
		txtTenDVT.setBounds(210, 130, 300, 40);
		pnlthongTinDVT.add(txtTenDVT);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBounds(610, 0, 485, 200);
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setLayout(null);
		pnlDVT.add(pnlChucNang);
		
		JPanel pnlTieuDeCN = new JPanel();
		pnlTieuDeCN.setBounds(0, 0, 485, 50);
		pnlTieuDeCN.setBackground(new Color(0,129,167));
		pnlChucNang.add(pnlTieuDeCN);
		
		JLabel lblTieuDeCN = new JLabel("CHỨC NĂNG");
		lblTieuDeCN.setForeground(new Color(255, 255, 255));
		lblTieuDeCN.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeCN.add(lblTieuDeCN);
		
		btnThem = new Button();
		btnThem.setText("THÊM ĐƠN VỊ");
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
		
		JScrollPane tltDVT = new JScrollPane();
		tltDVT.setBounds(0, 210, 1095, 553);
		String[] header = {"Mã Đơn Vị", "Tên Đơn Vị"};
		modelDVT = new DefaultTableModel(header, 0);
		tblDVT = new Table();
		tblDVT.setModel(modelDVT);
		tltDVT.setViewportView(tblDVT);
		pnlDVT.add(tltDVT);
		
		dsDVT = daoDVT.layDSDonViTinh();
		for(DonViTinh dvt : dsDVT) {
			Object[] newRow = {dvt.getMaDonVi(), dvt.getTenDonVi()};
			modelDVT.addRow(newRow);
		}
		
		btnTaoMa.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTaiLai.addActionListener(this);
		tblDVT.addMouseListener(this);
	}

	public String taoMa() {
		String uuid = UUID.randomUUID().toString();
	    return "DVT" + uuid.replace("-", "").substring(0, 7).toUpperCase();
	}
	
	public boolean validData() {
		String maDVT = txtMaDVT.getText().trim();
		String tenDVT = txtTenDVT.getText().trim();
		
		if(maDVT.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhấn nút tạo mã");
			return false;
		}
		
		if(tenDVT.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên đơn vị");
			return false;
		} else if(!tenDVT.matches("[\\p{L}\\p{N}\\s]+")) {
			JOptionPane.showMessageDialog(this, "Tên đơn vị không chứa ký tự đặc biệt");
			txtTenDVT.requestFocus();
			return false;
		}
		
		return true;
	}
	
	public void lamMoiThongTin() {
		txtMaDVT.setText("");
		txtTenDVT.setText("");
		modelDVT.setRowCount(0);
		dsDVT = daoDVT.layDSDonViTinh();
		for(DonViTinh dvt : dsDVT) {
			Object[] newRow = {dvt.getMaDonVi(), dvt.getTenDonVi()};
			modelDVT.addRow(newRow);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblDVT.getSelectedRow();
		txtMaDVT.setText(modelDVT.getValueAt(row, 0).toString());
		txtTenDVT.setText(modelDVT.getValueAt(row, 1).toString());
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
			txtMaDVT.setText(taoMa());
		}
		
		if(obj.equals(btnThem)) {
			if(validData()) {
				String maDVT = txtMaDVT.getText();
				String tenDVT = txtTenDVT.getText();
				
				if(tblDVT.getSelectedRow() != -1) {
					JOptionPane.showMessageDialog(this, "Đang trong chế độ sửa không được phép thêm");
				} else {
					DonViTinh dvt = new DonViTinh(maDVT, tenDVT);
					if(daoDVT.themDonViTinh(dvt)) {
						lamMoiThongTin();
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại - Mã đơn vị đã tồn tại");
					}
				}
			}
		}
		
		if(obj.equals(btnSua)) {
			int row = tblDVT.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn cần sửa");
			} else {
				if(validData()) {
					String maDVT = txtMaDVT.getText();
					String tenKV = txtTenDVT.getText();
					
					DonViTinh dvt = new DonViTinh(maDVT, tenKV);
					if(daoDVT.suaDonViTinh(dvt)) {
						lamMoiThongTin();
						JOptionPane.showMessageDialog(this, "Sửa thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Sửa thất bại");
					}
				}
			}
		}
		
		if(obj.equals(btnXoaTrang)) {
			txtMaDVT.setText("");
			txtTenDVT.setText("");
		}
		
		if(obj.equals(btnTaiLai)) {
			lamMoiThongTin();
		}
	}
}
