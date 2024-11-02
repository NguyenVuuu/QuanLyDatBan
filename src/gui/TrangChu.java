package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TrangChu extends JPanel{
	private JLabel lblMain;

	public TrangChu() {
		setLayout(null);
		
		// TODO Auto-generated constructor stub
		lblMain = new JLabel();
		lblMain.setBounds(0, 0, 1095, 763);
		lblMain.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/image/mot.jpg")).getImage().getScaledInstance(lblMain.getWidth(), lblMain.getHeight(), Image.SCALE_DEFAULT)));
		add(lblMain);
	}
}
