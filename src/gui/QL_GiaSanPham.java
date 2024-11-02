package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import custom_gui.Button;
import custom_gui.ScrollBarCustom;
import custom_gui.Table;
import custom_gui.TextField;
import dao.DAO_DonViTinh;
import dao.DAO_GiaSanPham;
import dao.DAO_SanPham;
import entity.DonViTinh;
import entity.GiaSanPham;
import entity.KhuVuc;
import entity.Phong;
import entity.SanPham;

public class QL_GiaSanPham extends JPanel implements ActionListener, MouseListener{
	private TextField txtMaGia;
	private JButton btnTaoMa;
	private JComboBox cmbTenSP;
	private TextField txtGia;
	private Button btnThem;
	private Button btnSua;
	private Button btnXoa;
	private Button btnTaiLai;
	private JComboBox cmbDV;
	private JButton btnChonAnh;
	private DAO_DonViTinh daoDVT = new DAO_DonViTinh();
	private ArrayList<DonViTinh> dsDVT;
	private DAO_SanPham daoSP = new DAO_SanPham();
	private ArrayList<SanPham> dsSP;
	private DAO_GiaSanPham daoGSP = new DAO_GiaSanPham();
	private ArrayList<GiaSanPham> dsGSP;
	private DefaultTableModel modelGSP;
	private Table tblGSP;
	private JFileChooser file;
	private File f;
	private String p;
	private JLabel lblAnhSP;
	private ImageIcon myImage;
	private double donGia;

	public QL_GiaSanPham() {
		setLayout(null);
		
		JPanel pnlGSP = new JPanel();
		pnlGSP.setBounds(0, 0, 1095, 763);
		add(pnlGSP);
		pnlGSP.setLayout(null);
		
		JPanel pnlthongTinGSP = new JPanel();
		pnlthongTinGSP.setBounds(0, 0, 800, 300);
		pnlthongTinGSP.setBackground(new Color(255, 255, 255));
		pnlthongTinGSP.setLayout(null);
		pnlGSP.add(pnlthongTinGSP);
		
		JPanel pnlTieuDeTT = new JPanel();
		pnlTieuDeTT.setBounds(0, 0, 800, 50);
		pnlTieuDeTT.setBackground(new Color(0,129,167));
		pnlthongTinGSP.add(pnlTieuDeTT);
		
		JLabel lblTieuDeTT = new JLabel("THÔNG TIN GIÁ SẢN PHẨM");
		lblTieuDeTT.setForeground(new Color(255, 255, 255));
		lblTieuDeTT.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeTT.add(lblTieuDeTT);
		
		lblAnhSP = new JLabel("");
		lblAnhSP.setBackground(new Color(0,129,167));
		lblAnhSP.setBounds(50, 80, 130, 150);
		lblAnhSP.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/image/noproduct.jpeg")).getImage().getScaledInstance(lblAnhSP.getWidth(), lblAnhSP.getHeight(), Image.SCALE_DEFAULT)));
		pnlthongTinGSP.add(lblAnhSP);
		
		btnChonAnh = new JButton("Chọn Ảnh");
		btnChonAnh.setBounds(65, 240, 100, 40);
		btnChonAnh.setFont(new Font("Segoe UI", 1, 15));
		btnChonAnh.setBackground(new Color(108, 91, 123));
		btnChonAnh.setForeground(new Color(255, 255, 255));
		pnlthongTinGSP.add(btnChonAnh);
		
		JLabel lblMaGia = new JLabel("Mã Giá");
		lblMaGia.setFont(new Font("Segoe UI", 1, 15));
		lblMaGia.setForeground(new Color(108, 91, 123));
		lblMaGia.setBounds(250, 70, 150, 40);
		pnlthongTinGSP.add(lblMaGia);
		
		txtMaGia = new TextField();
		txtMaGia.setEditable(false);
		txtMaGia.setBounds(410, 70, 190, 40);
		pnlthongTinGSP.add(txtMaGia);
		
		btnTaoMa = new JButton("Tạo Mã");
		btnTaoMa.setBounds(610, 70, 100, 40);
		btnTaoMa.setFont(new Font("Segoe UI", 1, 15));
		btnTaoMa.setBackground(new Color(108, 91, 123));
		btnTaoMa.setForeground(new Color(255, 255, 255));
		pnlthongTinGSP.add(btnTaoMa);
		
		JLabel lblTenSP = new JLabel("Sản Phẩm");
		lblTenSP.setFont(new Font("Segoe UI", 1, 15));
		lblTenSP.setForeground(new Color(108, 91, 123));
		lblTenSP.setBounds(250, 130, 150, 40);
		pnlthongTinGSP.add(lblTenSP);
		
		cmbTenSP = new JComboBox<>();
		cmbTenSP.addItem("");
		cmbTenSP.setBounds(410, 130, 300, 40);
		pnlthongTinGSP.add(cmbTenSP);
		
		dsSP = daoSP.layDSSanPhamKinhDoanh();
		for(SanPham sp : dsSP) {
			cmbTenSP.addItem(sp.getTenSanPham());
		}
		
		JLabel lblDV = new JLabel("Đơn Vị");
		lblDV.setFont(new Font("Segoe UI", 1, 15));
		lblDV.setForeground(new Color(108, 91, 123));
		lblDV.setBounds(250, 190, 150, 40);
		pnlthongTinGSP.add(lblDV);
		
		cmbDV = new JComboBox<>();
		cmbDV.addItem("");
		cmbDV.setBounds(410, 190, 300, 40);
		pnlthongTinGSP.add(cmbDV);
		
		dsDVT = daoDVT.layDSDonViTinh();
		for(DonViTinh dvt : dsDVT) {
			cmbDV.addItem(dvt.getTenDonVi());
		}
		
		JLabel lblGia = new JLabel("Đơn Giá");
		lblGia.setFont(new Font("Segoe UI", 1, 15));
		lblGia.setForeground(new Color(108, 91, 123));
		lblGia.setBounds(250, 250, 150, 40);
		pnlthongTinGSP.add(lblGia);
		
		txtGia = new TextField();
		txtGia.setBounds(410, 250, 300, 40);
		pnlthongTinGSP.add(txtGia);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBounds(810, 0, 285, 300);
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setLayout(null);
		pnlGSP.add(pnlChucNang);
		
		JPanel pnlTieuDeCN = new JPanel();
		pnlTieuDeCN.setBounds(0, 0, 285, 50);
		pnlTieuDeCN.setBackground(new Color(0,129,167));
		pnlChucNang.add(pnlTieuDeCN);
		
		JLabel lblTieuDeCN = new JLabel("CHỨC NĂNG");
		lblTieuDeCN.setForeground(new Color(255, 255, 255));
		lblTieuDeCN.setFont(new Font("Segoe UI", 1, 15));
		pnlTieuDeCN.add(lblTieuDeCN);
		
		btnThem = new Button();
		btnThem.setText("THÊM GIÁ SP");
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
		btnXoa.setText("XÓA GIÁ SP");
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
		
		JScrollPane tltGSP = new JScrollPane();
		tltGSP.setVerticalScrollBar(new ScrollBarCustom());
		tltGSP.setBounds(0, 310, 1095, 453);
		String[] header = {"Mã Giá", "Tên Sản Phẩm", "Đơn Vị Tính", "Đơn Giá"};
		modelGSP = new DefaultTableModel(header, 0);
		tblGSP = new Table();
		tblGSP.setModel(modelGSP);
		tltGSP.setViewportView(tblGSP);
		pnlGSP.add(tltGSP);
		
		dsGSP = daoGSP.layDSGiaSP();
		for(GiaSanPham gsp : dsGSP) {
			String tensp = getTenSP(gsp.getSanPham().getMaSanPham());
			String tendv = getTenDV(gsp.getDonVi().getMaDonVi());
			DecimalFormat df = new DecimalFormat("#,###");
			
			modelGSP.addRow(new Object[] {gsp.getMaGiaSanPham(), tensp, tendv, df.format(gsp.getDonGia())});
		}
		
		btnChonAnh.addActionListener(this);
		btnTaoMa.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTaiLai.addActionListener(this);
		
		tblGSP.addMouseListener(this);

	}
	
	public ImageIcon mySetIcon(String m, byte[] image) {
		if(m!=null) {
			myImage = new ImageIcon(m);
		}else {
			myImage = new ImageIcon(image);
		}
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(lblAnhSP.getWidth(), lblAnhSP.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		return i;
	}

	public boolean checkImageExists(String imageName) {
		File imageFile = new File("src/image/" + imageName); // Đường dẫn tới thư mục chứa hình ảnh
		return imageFile.exists(); // Kiểm tra xem tệp hình ảnh có tồn tại không
	}
	
	public String taoMa() {
		String uuid = UUID.randomUUID().toString();
	    return "GSP" + uuid.replace("-", "").substring(0, 7).toUpperCase();
	}
	
	public boolean validData() {
	    String ma = txtMaGia.getText().trim();
	    String tenSP = cmbTenSP.getSelectedItem().toString().trim();
	    String tenDV = cmbDV.getSelectedItem().toString().trim();
	    String donGiaStr = txtGia.getText().trim();
	    double donGia = 0;

	    // Kiểm tra các trường rỗng
	    if(ma.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhấn nút tạo mã");
	        return false;
	    } 
	    if(tenSP.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm");
	        return false;
	    } 
	    if (tenDV.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn vị");
	        return false;
	    } 
	    if(donGiaStr.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng điền đơn giá");
	        txtGia.requestFocus();
	        return false;
	    }
	    // Kiểm tra định dạng số của đơn giá
	    if(!donGiaStr.matches("\\d+(\\.\\d+)?")) {
	        JOptionPane.showMessageDialog(this, "Giá chỉ được chứa ký tự số và dấu chấm thập phân");
	        txtGia.requestFocus();
	        return false;
	    }
	    try {
	        donGia = Double.parseDouble(donGiaStr);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Đơn giá không hợp lệ");
	        txtGia.requestFocus();
	        return false;
	    }
	    // Kiểm tra giá trị của đơn giá
	    if(!(donGia > 0)) {
	        JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 0");
	        txtGia.requestFocus();
	        return false;
	    }
	    String anhSanPham = (String) lblAnhSP.getClientProperty("imageName");
	    if(anhSanPham == null) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh sản phẩm");
	        return false;
	    }

	    return true;
	}
	
	public String getMaSP(String ten) {
		String maSP = daoSP.layMaSP(ten);
		return maSP;
	}
	
	public String getTenSP(String ma) {
		String tenKV = daoSP.layTenSP(ma);
		return tenKV;
	}
	
	public String getMaDV(String ten) {
		String maDV = daoDVT.layMaDVT(ten);;
		return maDV;
	}
	
	public String getTenDV(String ma) {
		String tenDV = daoDVT.layTenDVT(ma);
		return tenDV;
	}
	
	public void layThongTin(String maGia) {
		dsGSP = daoGSP.layDSGiaSP();
		for(GiaSanPham gsp : dsGSP) {
			if(gsp.getMaGiaSanPham().equals(maGia)) {
				txtMaGia.setText(gsp.getMaGiaSanPham());
				cmbTenSP.setSelectedItem(getTenSP(gsp.getSanPham().getMaSanPham()));
				cmbDV.setSelectedItem(getTenDV(gsp.getDonVi().getMaDonVi()));
				txtGia.setText(Double.toString(gsp.getDonGia()));
				ImageIcon imgicon = new ImageIcon(QL_GiaSanPham.class.getResource("/image/" + gsp.getAnhSanPham().trim()));
				Image img1 = imgicon.getImage();
				Image img2 = img1.getScaledInstance(lblAnhSP.getWidth(), lblAnhSP.getHeight(), Image.SCALE_SMOOTH);
				imgicon = new ImageIcon(img2);
				lblAnhSP.setIcon(imgicon);
				lblAnhSP.putClientProperty("imageName", gsp.getAnhSanPham());
			}
		}
	}
	
	public void lamMoiThongTin() {
		txtMaGia.setText("");
		cmbTenSP.setSelectedIndex(0);
		cmbDV.setSelectedIndex(0);
		txtGia.setText("");
		lblAnhSP.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/image/noproduct.jpeg")).getImage().getScaledInstance(lblAnhSP.getWidth(), lblAnhSP.getHeight(), Image.SCALE_DEFAULT)));
		modelGSP.setRowCount(0);
		dsGSP = daoGSP.layDSGiaSP();
		for(GiaSanPham gsp : dsGSP) {
			String tensp = getTenSP(gsp.getSanPham().getMaSanPham());
			String tendv = getTenDV(gsp.getDonVi().getMaDonVi());
			DecimalFormat df = new DecimalFormat("#,###");
			
			modelGSP.addRow(new Object[] {gsp.getMaGiaSanPham(), tensp, tendv, df.format(gsp.getDonGia())});
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblGSP.getSelectedRow();
		
		String ma = modelGSP.getValueAt(row, 0).toString();
		layThongTin(ma);
		
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
		if(obj.equals(btnChonAnh)) {
			file = new JFileChooser();
			file.setCurrentDirectory(new File(System.getProperty("user.dir"), "src/image"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpg", "jpeg", "gif");
			file.addChoosableFileFilter(filter);
			int a = file.showSaveDialog(null);
			if(a==JFileChooser.APPROVE_OPTION) {
				f = file.getSelectedFile();
				p = f.getAbsolutePath();
				lblAnhSP.setIcon(mySetIcon(p, null));
				String tenFileAnh = f.getName();
				System.out.println(tenFileAnh);
				lblAnhSP.putClientProperty("imageName", tenFileAnh);
				
			}
		}
		
		if(obj.equals(btnTaoMa)) {
			txtMaGia.setText(taoMa());
		}
		
		if(obj.equals(btnThem)) {
			if(validData()) {
				String maGia = txtMaGia.getText().trim();
				String tenSP = cmbTenSP.getSelectedItem().toString();
				String tenDV = cmbDV.getSelectedItem().toString();
				double donGia = Double.parseDouble(txtGia.getText().trim());
				String anhSanPham = (String) lblAnhSP.getClientProperty("imageName");
				
				SanPham sp = new SanPham();
				sp.setMaSanPham(getMaSP(tenSP));
				
				DonViTinh dv = new DonViTinh();
				dv.setMaDonVi(getMaDV(tenDV));
				
				
				if(tblGSP.getSelectedRow() != -1) {
					JOptionPane.showMessageDialog(this, "Đang trong chế độ sửa không được phép thêm");
				} else {
					GiaSanPham gsp = new GiaSanPham(maGia, sp, dv, donGia, anhSanPham);
					if(daoGSP.themGSP(gsp)) {
						lamMoiThongTin();
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại - Mã giá đã tồn tại");
					}
				}
			}
		}
		
		if(obj.equals(btnSua)) {
			int row = tblGSP.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn giá sản phẩm cần sửa");
			} else {
				if(validData()) {
					String maGia = txtMaGia.getText().trim();
					String tenSP = cmbTenSP.getSelectedItem().toString();
					String tenDV = cmbDV.getSelectedItem().toString();
					double donGia = Double.parseDouble(txtGia.getText().trim());
					String anhSanPham = (String) lblAnhSP.getClientProperty("imageName");
					
					SanPham sp = new SanPham();
					sp.setMaSanPham(getMaSP(tenSP));
					
					DonViTinh dv = new DonViTinh();
					dv.setMaDonVi(getMaDV(tenDV));
					
					GiaSanPham gsp = new GiaSanPham(maGia, sp, dv, donGia, anhSanPham);
					if(daoGSP.suaGiaSanPham(gsp)) {
						lamMoiThongTin();
						JOptionPane.showMessageDialog(this, "Sửa thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Sửa thất bại");
					}
				}
			}
		}
		
		if(obj.equals(btnXoa)) {
			int row = tblGSP.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn giá cần xóa");
			} else {
				 String maGSP = (String) modelGSP.getValueAt(row, 0);
				
				 
				 GiaSanPham gsp = new GiaSanPham(maGSP);
				
				int choice = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa giá sản phẩm này?", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if(choice== JOptionPane.YES_OPTION) {
					if(daoGSP.xoaGiaSanPham(gsp)) {
						lamMoiThongTin();
		                JOptionPane.showMessageDialog(this, "Đã xóa");
					} else {
		                JOptionPane.showMessageDialog(this, "Không thể xóa");
		            }
				}
			}
		}
		
		if(obj.equals(btnTaiLai)) {
			lamMoiThongTin();
		}
	}
}
