package gui;

import custom_gui.Menu;
import custom_gui.EventMenuSelected;
import custom_gui.EventShowPopupMenu;
import custom_gui.MainForm;
import custom_gui.MenuItem;
import custom_gui.PopupMenu;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.print.DocFlavor.URL;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import connectDB.ConnectDB;

public class Main extends javax.swing.JFrame {

	private MigLayout layout;
	private Menu menu;
	private MainForm main;
	private Animator animator;
	private JLayeredPane bg;

	public Main() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		initComponents();
		setResizable(false);
		init();

		java.net.URL url = Main.class.getResource("/icon/Ionic-Ionicons-Restaurant.48.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		this.setIconImage(img);
	}

	private void init() {
		layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
		bg.setLayout(layout);
		menu = new Menu();
		main = new MainForm();
		menu.addEvent(new EventMenuSelected() {
			@Override
			public void menuSelected(int menuIndex, int subMenuIndex) {
				System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
				if (menuIndex == 0) {
					if (subMenuIndex == 0) {
						main.showForm(new QL_KhachHang());
					} else if (subMenuIndex == 1) {
						main.showForm(new QL_NhanVien());
					} else if (subMenuIndex == 2) {
						main.showForm(new QL_SanPham());
					} else if (subMenuIndex == 3) {
						main.showForm(new QL_DonViTinh());
					} else if (subMenuIndex == 4) {
						main.showForm(new QL_GiaSanPham());
					} else if (subMenuIndex == 5) {
						main.showForm(new QL_BanAn());
					} else if (subMenuIndex == 6) {
						main.showForm(new QL_KhuVuc());
					} else if (subMenuIndex == 7) {
						main.showForm(new QL_Phong());
					}
				}
				if (menuIndex == 1) {
					if (subMenuIndex == 0) {
//						main.showForm(); show gd dat ban
					} else if (subMenuIndex == 1) {
						// show gd goi mon
					} else if (subMenuIndex == 2) {
						// show gd dat ban truoc
					} else if (subMenuIndex == 3) {
						// show gd lap hoa don
					}
				}
				if (menuIndex == 2) {
					if (subMenuIndex == 0) {
						main.showForm(new TimKhachHang());
					} else if (subMenuIndex == 1) {
					} else if (subMenuIndex == 2) {
					} else if (subMenuIndex == 3) {
					} else if (subMenuIndex == 4) {
					} else if (subMenuIndex == 5) {
					} else if (subMenuIndex == 6) {
					} else if (subMenuIndex == 7) {
					} else if (subMenuIndex == 8) {
					}
				}
				if (menuIndex == 3) {
					if (subMenuIndex == 0) {

					} else if (subMenuIndex == 1) {
					}
				}
				if (menuIndex == 4) {
					int checkLogOut = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không ?", " Xác nhận",
							JOptionPane.YES_NO_OPTION);
					if (checkLogOut == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Thoát thành công!!!");
						dispose();
						new DangNhap().setVisible(true);
					}
				}
			}
		});
		menu.addEventShowPopup(new EventShowPopupMenu() {
			@Override
			public void showPopup(Component com) {
				MenuItem item = (MenuItem) com;
				PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(),
						item.getMenu().getSubMenu());
				int x = Main.this.getX() + 52;
				int y = Main.this.getY() + com.getY() + 86;
				popup.setLocation(x, y);
				popup.setVisible(true);
			}
		});
		menu.initMenuItem();
		bg.add(menu, "w 230!, spany 2");
		bg.add(main, "w 100%, h 100%");
		TimingTarget target = new TimingTargetAdapter() {
			@Override
			public void timingEvent(float fraction) {
				double width;
				if (menu.isShowMenu()) {
					width = 60 + (170 * (1f - fraction));
				} else {
					width = 60 + (170 * fraction);
				}
				layout.setComponentConstraints(menu, "w " + width + "!, spany2");
				menu.revalidate();
			}

			@Override
			public void end() {
				menu.setShowMenu(!menu.isShowMenu());
				menu.setEnableMenu(true);
			}

		};
		animator = new Animator(500, target);
		animator.setResolution(0);
		animator.setDeceleration(0.5f);
		animator.setAcceleration(0.5f);

		main.showForm(new TrangChu());
	}

	private void initComponents() {

		bg = new javax.swing.JLayeredPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		bg.setBackground(new java.awt.Color(245, 245, 245));
		bg.setOpaque(true);

		javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
		bg.setLayout(bgLayout);
		bgLayout.setHorizontalGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
				1366, Short.MAX_VALUE));
		bgLayout.setVerticalGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 783,
				Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(bg));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(bg));

		pack();
		setLocationRelativeTo(null);
	}

	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
