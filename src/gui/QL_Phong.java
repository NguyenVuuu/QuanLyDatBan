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

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import custom_gui.Button;
import custom_gui.ScrollBarCustom;
import custom_gui.Table;
import custom_gui.TextField;
import dao.DAO_KhuVuc;
import dao.DAO_Phong;
import entity.DonViTinh;
import entity.KhuVuc;
import entity.Phong;

public class QL_Phong extends JPanel implements ActionListener, MouseListener{
	private JButton btnTaoMa;
	private TextField txtMaPhong;
	private TextField txtTenPhong;
	private TextField txtSucChua;
	private JComboBox cmbKhuVuc;
	private Button btnThem;
	private Button btnSua;
	private Button btnXoa;
	private Button btnTaiLai;
	private DAO_KhuVuc daoKV = new DAO_KhuVuc();
	private DAO_Phong daoPhong = new DAO_Phong();
	private ArrayList<KhuVuc> dsKV;
	private ArrayList<Phong> dsPhong;
	private DefaultTableModel modelPhong;
	private Table tblPhong;

	public QL_Phong() {
		setLayout(null);
		
		JPanel pnlPhong = new JPanel();
		pnlPhong.setBounds(0, 0, 1095, 763);
		add(pnlPhong);
		pnlPhong.setLayout(null);
		
		JPanel pnlthongTinPhong = new JPanel();
		pnlthongTinPhong.setBounds(0, 0, 800, 300);
		pnlthongTinPhong.setBackground(new Color(255, 255, 255));
		pnlthongTinPhong.setLayout(null);
		pnlPhong.add(pnlthongTinPhong);
		
		JPanel pnlTieuDeTT = new JPanel();
		pnlTieuDeTT.setBounds(0, 0, 800, 50);
		pnlTieuDeTT.setBackground(new Color(0,129,167));
		pnlthongTinPhong.add(pnlTieuDeTT);
		
		JLabel lblTieuDeTT = new JLabel("THÔNG TIN PHÒNG");
		lblTieuDeTT.setForeground(new Color(255, 255, 255));
		lblTieuDeTT.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeTT.add(lblTieuDeTT);
		
		JLabel lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Segoe UI", 1, 15));
		lblMaPhong.setForeground(new Color(108, 91, 123));
		lblMaPhong.setBounds(50, 70, 150, 40);
		pnlthongTinPhong.add(lblMaPhong);
		
		txtMaPhong = new TextField();
		txtMaPhong.setEditable(false);
		txtMaPhong.setBounds(210, 70, 390, 40);
		pnlthongTinPhong.add(txtMaPhong);
		
		btnTaoMa = new JButton("Tạo Mã");
		btnTaoMa.setBounds(610, 70, 100, 40);
		btnTaoMa.setFont(new Font("Segoe UI", 1, 15));
		btnTaoMa.setBackground(new Color(108, 91, 123));
		btnTaoMa.setForeground(new Color(255, 255, 255));
		pnlthongTinPhong.add(btnTaoMa);
		
		
		JLabel lblTenPhong = new JLabel("Tên Phòng");
		lblTenPhong.setFont(new Font("Segoe UI", 1, 15));
		lblTenPhong.setForeground(new Color(108, 91, 123));
		lblTenPhong.setBounds(50, 130, 150, 40);
		pnlthongTinPhong.add(lblTenPhong);
		
		txtTenPhong = new TextField();
		txtTenPhong.setBounds(210, 130, 500, 40);
		pnlthongTinPhong.add(txtTenPhong);
		
		JLabel lblSucChua = new JLabel("Sức Chứa");
		lblSucChua.setFont(new Font("Segoe UI", 1, 15));
		lblSucChua.setForeground(new Color(108, 91, 123));
		lblSucChua.setBounds(50, 190, 150, 40);
		pnlthongTinPhong.add(lblSucChua);
		
		txtSucChua = new TextField();
		txtSucChua.setBounds(210, 190, 500, 40);
		pnlthongTinPhong.add(txtSucChua);
		
		JLabel lblKhuVuc = new JLabel("Khu Vực");
		lblKhuVuc.setFont(new Font("Segoe UI", 1, 15));
		lblKhuVuc.setForeground(new Color(108, 91, 123));
		lblKhuVuc.setBounds(50, 250, 150, 40);
		pnlthongTinPhong.add(lblKhuVuc);
		
		cmbKhuVuc = new JComboBox<>();
		cmbKhuVuc.addItem("");
		cmbKhuVuc.setBounds(210, 250, 500, 40);
		pnlthongTinPhong.add(cmbKhuVuc);
		
		dsKV = daoKV.layDSKhuVuc();
		for(KhuVuc kv : dsKV) {
			cmbKhuVuc.addItem(kv.getTenKhuVuc());
		}
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBounds(810, 0, 285, 300);
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setLayout(null);
		pnlPhong.add(pnlChucNang);
		
		JPanel pnlTieuDeCN = new JPanel();
		pnlTieuDeCN.setBounds(0, 0, 285, 50);
		pnlTieuDeCN.setBackground(new Color(0,129,167));
		pnlChucNang.add(pnlTieuDeCN);
		
		JLabel lblTieuDeCN = new JLabel("CHỨC NĂNG");
		lblTieuDeCN.setForeground(new Color(255, 255, 255));
		lblTieuDeCN.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeCN.add(lblTieuDeCN);
		
		btnThem = new Button();
		btnThem.setText("THÊM PHÒNG");
		btnThem.setFont(new Font("Segoe UI", 1, 15));
		btnThem.setBounds(55, 70, 170, 30);
		btnThem.setBackground(new Color(108, 91, 123));
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
		btnXoa.setText("XÓA PHÒNG");
		btnXoa.setFont(new Font("Segoe UI", 1, 15));
		btnXoa.setBounds(55, 170, 170, 30);
		btnXoa.setBackground(new Color(108, 91, 123));
		btnXoa.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnXoa);
		
		btnTaiLai = new Button();
		btnTaiLai.setText("TẢI LẠI");
		btnTaiLai.setFont(new Font("Segoe UI", 1, 15));
		btnTaiLai.setBounds(55, 220, 170, 30);
		btnTaiLai.setBackground(new Color(108, 91, 123));
		btnTaiLai.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnTaiLai);
		
		JScrollPane tltPhong = new JScrollPane();
		tltPhong.setVerticalScrollBar(new ScrollBarCustom());
		tltPhong.setBounds(0, 310, 1095, 453);
		String[] header = {"Mã Phòng", "Tên Phòng", "Sức Chứa", "Khu Vực"};
		modelPhong = new DefaultTableModel(header, 0);
		tblPhong = new Table();
		tblPhong.setModel(modelPhong);
		tltPhong.setViewportView(tblPhong);
		pnlPhong.add(tltPhong);
		
		dsPhong = daoPhong.layDSPhong();
		for(Phong p : dsPhong) {
			String tenKV = getTenKV(p.getKhuVuc().getMaKhuVuc());
			modelPhong.addRow(new Object[] {p.getMaPhong(), p.getTenPhong(), p.getSucChua(), tenKV});
		}
		
		btnTaoMa.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTaiLai.addActionListener(this);
		tblPhong.addMouseListener(this);
		
	}
	
	
	public String taoMa() {
		String uuid = UUID.randomUUID().toString();
	    return "P" + uuid.replace("-", "").substring(0, 7).toUpperCase();
	}
	
	public boolean validData() {
		String maPhong = txtMaPhong.getText().trim();
		String tenPhong = txtTenPhong.getText().trim();
		String sucChuaStr = txtSucChua.getText().trim();
		int sucChua = 0;
		String khuVuc = cmbKhuVuc.getSelectedItem().toString();
		
		
		
		if(maPhong.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhấn nút tạo mã");
			return false;
			
		} else if(tenPhong.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên phòng");
			txtTenPhong.requestFocus();
			return false;
		} else if (!tenPhong.matches("[\\p{L}\\p{N}\\s]+")) {
			JOptionPane.showMessageDialog(this, "Tên phòng không được chứa ký tự đặc biệt");
			txtTenPhong.requestFocus();
			return false;
		} else if(sucChuaStr.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền sức chứa");
			txtSucChua.requestFocus();
			return false;
		} else if(!sucChuaStr.matches("\\d+")) {
			JOptionPane.showMessageDialog(this, "Sức chứa phải là số");
			txtSucChua.requestFocus();
			return false;
		} 
		
		try {
			sucChua = Integer.parseInt(sucChuaStr);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(sucChua == 0) {
			JOptionPane.showMessageDialog(this, "Sức chứa phải lớn hơn 0");
			txtSucChua.requestFocus();
			return false;
		} else if(khuVuc.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn khu vực");
			return false;
		}
		
		return true;
	}
	
	public void lamMoiThongTin() {
		txtMaPhong.setText("");
		txtTenPhong.setText("");
		txtSucChua.setText("");
		cmbKhuVuc.setSelectedIndex(0);
		
		modelPhong.setRowCount(0);
		dsPhong = daoPhong.layDSPhong();
		for(Phong p : dsPhong) {
			String tenKV = getTenKV(p.getKhuVuc().getMaKhuVuc());
			modelPhong.addRow(new Object[] {p.getMaPhong(), p.getTenPhong(), p.getSucChua(), tenKV});
		}
	}
	
	public String getMaKV(String ten) {
		String maKV = daoKV.layMaKV(ten);
		
		System.out.println(maKV);
		
		return maKV;
	}
	
	public String getTenKV(String ma) {
		String tenKV = daoKV.layTenKV(ma);
		
		System.out.println(tenKV);
		
		return tenKV;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblPhong.getSelectedRow();
		txtMaPhong.setText(modelPhong.getValueAt(row, 0).toString());
		txtTenPhong.setText(modelPhong.getValueAt(row, 1).toString());
		txtSucChua.setText(modelPhong.getValueAt(row, 2).toString());
		cmbKhuVuc.setSelectedItem(modelPhong.getValueAt(row, 3).toString());
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
			txtMaPhong.setText(taoMa());
		}
		
		if(obj.equals(btnThem)) {
			if(validData()) {
				String maPhong = txtMaPhong.getText();
				String tenPhong = txtTenPhong.getText();
				int sucChua = Integer.parseInt(txtSucChua.getText());
				String tenKV = cmbKhuVuc.getSelectedItem().toString();
				
				KhuVuc kv = new KhuVuc();
				kv.setMaKhuVuc(getMaKV(tenKV));
				
				if(tblPhong.getSelectedRow() != -1) {
					JOptionPane.showMessageDialog(this, "Đang trong chế độ sửa không được phép thêm");
				} else {
					Phong p = new Phong(maPhong, tenPhong, sucChua, kv);
					if(daoPhong.themPhong(p)) {
						lamMoiThongTin();
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại - Mã phòng đã tồn tại");
					}
				}
			}
		}
		
		if(obj.equals(btnSua)) {
			int row = tblPhong.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần sửa");
			} else {
				if(validData()) {
					String maPhong = txtMaPhong.getText();
					String tenPhong = txtTenPhong.getText();
					int sucChua = Integer.parseInt(txtSucChua.getText());
					String tenKV = cmbKhuVuc.getSelectedItem().toString();
					
					KhuVuc kv = new KhuVuc();
					kv.setMaKhuVuc(getMaKV(tenKV));
					
					Phong p = new Phong(maPhong, tenPhong, sucChua, kv);
					if(daoPhong.suaPhong(p)) {
						lamMoiThongTin();
						JOptionPane.showMessageDialog(this, "Sửa thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Sửa thất bại");
					}
				}
			}
		}
		
		if(obj.equals(btnXoa)) {
			int row = tblPhong.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn khu vực cần xóa");
			} else {
				 String maPhong = (String) modelPhong.getValueAt(row, 0);

				 Phong p = new Phong(maPhong);
				
				int choice = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa phòng này?", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if(choice== JOptionPane.YES_OPTION) {
					if(daoPhong.xoaPhong(p)) {
						lamMoiThongTin();
		                JOptionPane.showMessageDialog(this, "Đã xóa phòng");
					} else {
		                JOptionPane.showMessageDialog(this, "Không thể xóa phòng");
		            }
				}
			}
		}
		
		if(obj.equals(btnTaiLai)) {
			lamMoiThongTin();
		}
	}
	
}
