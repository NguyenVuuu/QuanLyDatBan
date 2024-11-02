package custom_gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Profile extends JPanel{
	private JLabel lblHeader;
	
	public Profile() {
		setOpaque(false);
		// TODO Auto-generated constructor stub
		lblHeader = new JLabel();
		lblHeader.setFont(new Font("SVN-Break Brush", 1, 40)); // NOI18N
		lblHeader.setForeground(new Color(224, 224, 224));
		lblHeader.setIcon(new ImageIcon(getClass().getResource("/image/logo.png")));
//		lblHeader.setText(" Mango");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblHeader, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );
	}
}
