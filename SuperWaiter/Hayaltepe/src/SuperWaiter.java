import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SuperWaiter extends JFrame implements MouseListener, KeyListener, ActionListener {

	JLabel welcome = new JLabel("Welcome to SuperWaiter!");
	JButton admingiris = new JButton("Administrator Login");
	JButton siparis = new JButton("Take Order");
	JButton cikis = new JButton("Exit");
	
	adminlogin al = new adminlogin();
	adminpanel apnl = new adminpanel();
	
	public SuperWaiter() {
		//Main page
		setPreferredSize(new Dimension(300, 400));
		setMinimumSize(new Dimension(300, 400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SuperWaiter v0.01");
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();
		JPanel pnl3 = new JPanel();
		JPanel pnl4 = new JPanel();
		pnl1.setLayout(new GridBagLayout());
		pnl2.setLayout(new GridBagLayout());
		pnl3.setLayout(new GridBagLayout());
		pnl4.setLayout(new GridBagLayout());
		pnl1.add(welcome);
		pnl2.add(admingiris);
		pnl3.add(siparis);
		pnl4.add(cikis);
		add(pnl1);
		add(pnl2);
		add(pnl3);
		add(pnl4);
		cikis.addMouseListener(this);
		admingiris.addMouseListener(this);
		//
	}
	
	public static void main(String[] args) {
		new SuperWaiter().setVisible(true);
		//default admin
		admin defaultadmin = new admin("admin", "admin");
		adminlogin.admins.add(defaultadmin);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Çýkýþ tuþu
		if (e.getSource() == cikis) {
			int a = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure?","Exit", JOptionPane.YES_NO_OPTION);
			if (a == JOptionPane.YES_OPTION) {
				dispose();
			}
			
		}
		else if (e.getSource() == admingiris) {
			al.clear();
			al.setVisible(true);
		}
		//Admin login
		else if (e.getSource() == al.login) {
			String myPass = String.valueOf(al.apText.getPassword());
			for (admin admin : adminlogin.admins) {
				if (al.anText.getText().equals(admin.getUsername()) && myPass.equals(admin.getPass())) {
					apnl.setVisible(true);
					al.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong username or password!\nPlease Try again.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if (e.getSource() == al.cancel) {
			al.dispose();
		}
		//
		
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

}
