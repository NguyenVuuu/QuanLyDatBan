package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import custom_gui.Button;
import custom_gui.TextField;

public class DangNhap extends JFrame{
	private TextField txtTK;
	private TextField txtMK;
	private Button btnDN;

	public DangNhap() {
		setSize(550, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel pnlDangNhap = new JPanel();
		pnlDangNhap.setBackground(new Color(255, 255, 255));
		pnlDangNhap.setLayout(null);
		add(pnlDangNhap);
		
		JLabel lblDN = new JLabel("ĐĂNG NHẬP");
		lblDN.setBounds(150, 20, 250, 40);
		lblDN.setFont(new Font("Arial", 1, 40));
		lblDN.setForeground(new Color(248, 134, 1));
		pnlDangNhap.add(lblDN);
		
		txtTK = new TextField();
		txtTK.setBounds(90, 90, 375, 40);
		pnlDangNhap.add(txtTK);
		
		txtMK = new TextField();
		txtMK.setBounds(90, 150, 375, 40);
		pnlDangNhap.add(txtMK);
		
		btnDN = new Button();
		btnDN.setBounds(150, 230, 250, 30);
		btnDN.setText("ĐĂNG NHẬP");
		btnDN.setFont(new Font("Arial", 1, 15));
		btnDN.setBackground(new Color(248, 134, 1));
		btnDN.setForeground(new Color(255, 255, 255));
		pnlDangNhap.add(btnDN);
		
	}
}
