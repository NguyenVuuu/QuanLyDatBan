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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import custom_gui.Button;
import custom_gui.Table;
import custom_gui.TextField;
import dao.DAO_KhuVuc;
import entity.KhuVuc;

public class QL_KhuVuc extends JPanel implements ActionListener, MouseListener{
	private JButton btnTaoMa;
	private TextField txtMaKV;
	private TextField txtTenKV;
	private Button btnThem;
	private Button btnSua;
	private Button btnXoa;
	private Button btnTaiLai;
	private DAO_KhuVuc daoKV = new DAO_KhuVuc();
	private DefaultTableModel modelKV;
	private Table tblKV;
	private ArrayList<KhuVuc> dsKv;

	public QL_KhuVuc() {
		setLayout(null);
		
		JPanel pnlKV = new JPanel();
		pnlKV.setBounds(0, 0, 1095, 763);
		add(pnlKV);
		pnlKV.setLayout(null);
		
		JPanel pnlthongTinKV = new JPanel();
		pnlthongTinKV.setBounds(0, 0, 600, 200);
		pnlthongTinKV.setBackground(new Color(255, 255, 255));
		pnlthongTinKV.setLayout(null);
		pnlKV.add(pnlthongTinKV);
		
		JPanel pnlTieuDeTT = new JPanel();
		pnlTieuDeTT.setBounds(0, 0, 600, 50);
		pnlTieuDeTT.setBackground(new Color(0,129,167));
		pnlthongTinKV.add(pnlTieuDeTT);
		
		JLabel lblTieuDeTT = new JLabel("THÔNG TIN KHU VỰC");
		lblTieuDeTT.setForeground(new Color(255, 255, 255));
		lblTieuDeTT.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeTT.add(lblTieuDeTT);
		
		JLabel lblMaDVT = new JLabel("Mã Khu Vực");
		lblMaDVT.setFont(new Font("Segoe UI", 1, 15));
		lblMaDVT.setForeground(new Color(108, 91, 123));
		lblMaDVT.setBounds(50, 70, 150, 40);
		pnlthongTinKV.add(lblMaDVT);
		
		txtMaKV = new TextField();
		txtMaKV.setEditable(false);
		txtMaKV.setBounds(210, 70, 190, 40);
		pnlthongTinKV.add(txtMaKV);
		
		btnTaoMa = new JButton("Tạo Mã");
		btnTaoMa.setBounds(410, 70, 100, 40);
		btnTaoMa.setFont(new Font("Segoe UI", 1, 15));
		btnTaoMa.setBackground(new Color(108, 91, 123));
		btnTaoMa.setForeground(new Color(255, 255, 255));
		pnlthongTinKV.add(btnTaoMa);
		
		
		JLabel lblTenKV = new JLabel("Tên Khu Vực");
		lblTenKV.setFont(new Font("Segoe UI", 1, 15));
		lblTenKV.setForeground(new Color(108, 91, 123));
		lblTenKV.setBounds(50, 130, 150, 40);
		pnlthongTinKV.add(lblTenKV);
		
		txtTenKV = new TextField();
		txtTenKV.setBounds(210, 130, 300, 40);
		pnlthongTinKV.add(txtTenKV);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBounds(610, 0, 485, 200);
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setLayout(null);
		pnlKV.add(pnlChucNang);
		
		JPanel pnlTieuDeCN = new JPanel();
		pnlTieuDeCN.setBounds(0, 0, 485, 50);
		pnlTieuDeCN.setBackground(new Color(0,129,167));
		pnlChucNang.add(pnlTieuDeCN);
		
		JLabel lblTieuDeCN = new JLabel("CHỨC NĂNG");
		lblTieuDeCN.setForeground(new Color(255, 255, 255));
		lblTieuDeCN.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeCN.add(lblTieuDeCN);
		
		btnThem = new Button();
		btnThem.setText("THÊM KHU VỰC");
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
		
		btnXoa = new Button();
		btnXoa.setText("XÓA KHU VỰC");
		btnXoa.setFont(new Font("Segoe UI", 1, 15));
		btnXoa.setBounds(55, 130, 170, 30);
		btnXoa.setBackground(new Color(108, 91, 123));
		btnXoa.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnXoa);
		
		btnTaiLai = new Button();
		btnTaiLai.setText("TẢI LẠI");
		btnTaiLai.setFont(new Font("Segoe UI", 1, 15));
		btnTaiLai.setBounds(255, 130, 170, 30);
		btnTaiLai.setBackground(new Color(108, 91, 123));
		btnTaiLai.setForeground(new Color(255, 255, 255));
		pnlChucNang.add(btnTaiLai);
		
		JScrollPane tltKV = new JScrollPane();
		tltKV.setBounds(0, 210, 1095, 553);
		String[] header = {"Mã Khu Vực", "Tên Khu Vực"};
		modelKV = new DefaultTableModel(header, 0);
		tblKV = new Table();
		tblKV.setModel(modelKV);
		tltKV.setViewportView(tblKV);
		pnlKV.add(tltKV);
		
		dsKv = daoKV.layDSKhuVuc();
		for(KhuVuc kv : dsKv) {
			Object[] newRow = {kv.getMaKhuVuc(), kv.getTenKhuVuc()};
			modelKV.addRow(newRow);
		}
		
		btnTaoMa.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTaiLai.addActionListener(this);
		tblKV.addMouseListener(this);
	}
	
	public String taoMa() {
		String uuid = UUID.randomUUID().toString();
	    return "KV" + uuid.replace("-", "").substring(0, 7).toUpperCase();
	}
	
	public boolean validData() {
		String maKV = txtMaKV.getText().trim();
		String tenKV = txtTenKV.getText().trim();
		
		if(maKV.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhấn nút tạo mã");
			return false;
		}
		
		if(tenKV.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên khu vực");
			return false;
		} else if(!tenKV.matches("[\\p{L}\\p{N}\\s]+")) {
			JOptionPane.showMessageDialog(this, "Tên khu vực không được chứa ký tự đặc biệt");
			txtTenKV.requestFocus();
			return false;
		}
		
		return true;
	}
	
	public void lamMoiThongTin() {
		txtMaKV.setText("");
		txtTenKV.setText("");
		modelKV.setRowCount(0);
		dsKv = daoKV.layDSKhuVuc();
		for(KhuVuc kv : dsKv) {
			Object[] newRow = {kv.getMaKhuVuc(), kv.getTenKhuVuc()};
			modelKV.addRow(newRow);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblKV.getSelectedRow();
		txtMaKV.setText(modelKV.getValueAt(row, 0).toString());
		txtTenKV.setText(modelKV.getValueAt(row, 1).toString());
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
			txtMaKV.setText(taoMa());
		}
		
		if(obj.equals(btnThem)) {
			if(validData()) {
				String maKV = txtMaKV.getText();
				String tenKV = txtTenKV.getText();
				
				if(tblKV.getSelectedRow() != -1) {
					JOptionPane.showMessageDialog(this, "Đang trong chế độ sửa không được phép thêm");
				} else {
					KhuVuc kv = new KhuVuc(maKV, tenKV);
					if(daoKV.addKhuVuc(kv)) {
						lamMoiThongTin();
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại - Mã khu vực đã tồn tại");
					}
				}
			}
		}
		
		if(obj.equals(btnSua)) {
			int row = tblKV.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn khu vực cần sửa");
			} else {
				if(validData()) {
					String maKV = txtMaKV.getText();
					String tenKV = txtTenKV.getText();
					
					KhuVuc kv = new KhuVuc(maKV, tenKV);
					if(daoKV.suaKhuVuc(kv)) {
						lamMoiThongTin();
						JOptionPane.showMessageDialog(this, "Sửa thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Sửa thất bại");
					}
				}
			}
			
		}
		
		if(obj.equals(btnXoa)) {
			int row = tblKV.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn khu vực cần xóa");
			} else {
				 String maKhuVuc = (String) modelKV.getValueAt(row, 0);
				 String tenKhuVuc = (String) modelKV.getValueAt(row, 1);
				 
				 KhuVuc kv = new KhuVuc(maKhuVuc, tenKhuVuc);
				
				int choice = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa khu vực này?", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if(choice== JOptionPane.YES_OPTION) {
					if(daoKV.xoaKhuVuc(kv)) {
						lamMoiThongTin();
		                JOptionPane.showMessageDialog(this, "Đã xóa khu vực");
					} else {
		                JOptionPane.showMessageDialog(this, "Không thể xóa khu vực");
		            }
				}
			}
		}
		
		if(obj.equals(btnTaiLai)) {
			lamMoiThongTin();
		}
		
	}
}
