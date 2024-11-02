package custom_gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import custom_gui.EventMenuSelected;
import custom_gui.EventShowPopupMenu;
import custom_gui.ScrollBarCustom;

import custom_gui.EventMenu;
import custom_gui.MenuAnimation;
import custom_gui.MenuItem;

import custom_gui.ModelMenu;

import net.miginfocom.swing.MigLayout;

public class Menu extends JPanel {
	private final MigLayout layout;
	private EventMenuSelected event;
	private EventShowPopupMenu eventShowPopup;
	private boolean enableMenu = true;
	private boolean showMenu = true;

	public boolean isShowMenu() {
		return showMenu;
	}

	public void addEvent(EventMenuSelected event) {
		this.event = event;
	}

	public void setEnableMenu(boolean enableMenu) {
		this.enableMenu = enableMenu;
	}

	public void setShowMenu(boolean showMenu) {
		this.showMenu = showMenu;
	}

	public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
		this.eventShowPopup = eventShowPopup;
	}

	public Menu() {
		initComponents();
		setOpaque(false);
		sp.getViewport().setOpaque(false);
		sp.setVerticalScrollBar(new ScrollBarCustom());
		layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
		panel.setLayout(layout);
	}

	public void initMenuItem() {
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/system.png")), "Hệ Thống"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/category.png")), "Danh Mục", "Khách Hàng",
				"Nhân Viên", "Sản Phẩm", "Đơn Vị Tính", "Giá Sản Phẩm", "Bàn", "Khu Vực", "Phòng"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/handle.16.png")), "Xử Lý", "Đặt Bàn",
				"Gọi Món", "Đặt Bàn Trước", "Lập Hóa Đơn"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/find.png")), "Tìm Kiếm", "Khách Hàng",
				"Nhân Viên", "Sản Phẩm", "Đơn Vị Tính", "Giá Sản Phẩm", "Bàn", "Phòng", "Khu Vực", "Hóa Đơn"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/static.png")), "Thống Kê",
				"Thống Kê Doanh Thu", "Thống Kê Sản Phẩm"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/logout.png")), "Đăng Xuất"));

	}

	private void addMenu(ModelMenu menu) {
		panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
	}

	private EventMenu getEventMenu() {
		return new EventMenu() {
			@Override
			public boolean menuPressed(Component com, boolean open) {
				if (enableMenu) {
					if (isShowMenu()) {
						if (open) {
							new MenuAnimation(layout, com).openMenu();
						} else {
							new MenuAnimation(layout, com).closeMenu();
						}
						return true;
					} else {
						eventShowPopup.showPopup(com);
					}
				}
				return false;
			}
		};
	}

	private void initComponents() {

		sp = new JScrollPane();
		panel = new JPanel();
		profile1 = new custom_gui.Profile();

		sp.setBorder(null);
		sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setViewportBorder(null);

		panel.setOpaque(false);

		javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
		panel.setLayout(panelLayout);
		panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 312, Short.MAX_VALUE));
		panelLayout.setVerticalGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 523, Short.MAX_VALUE));

		sp.setViewportView(panel);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
				.addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)));
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, new Color(245,64,42), getWidth(), 0, new Color(255,101,53));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(grphcs);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel panel;
	private Profile profile1;
	private javax.swing.JScrollPane sp;
	// End of variables declaration//GEN-END:variables
}
