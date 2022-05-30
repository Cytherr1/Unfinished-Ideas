import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class adminlogin extends JFrame implements MouseListener {
	
	JLabel aName = new JLabel("Username");
	JLabel aPass = new JLabel("Password");
	JLabel empty = new JLabel();
	JTextField anText = new JTextField();
	JPasswordField apText = new JPasswordField();
	JButton login = new JButton("Login");
	JButton cancel = new JButton("Cancel");
	
	adminpanel apnl = new adminpanel();

	static ArrayList<admin> admins = new ArrayList<admin>();
	
	public adminlogin() {
		//Admin Login Screen
		setPreferredSize(new Dimension(400, 150));
		setMinimumSize(new Dimension(400, 150));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Administrator Login");
		setLayout(new GridLayout(3, 2));
		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();
		pnl1.setLayout(new GridBagLayout());
		pnl2.setLayout(new GridBagLayout());
		pnl1.add(login);
		pnl2.add(cancel);
		add(aName);
		add(anText);
		add(aPass);
		add(apText);
		add(pnl1);
		add(pnl2);
		cancel.addMouseListener(this);
		login.addMouseListener(this);
		
	}

	public static void main(String[] args) {
		
		//default admin
		admin defaultadmin = new admin("admin", "admin");
		admins.add(defaultadmin);
		
	}
	
	public void clear() {
		anText.setText("");
		apText.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == cancel) {
			dispose();
		}
		else if (e.getSource() == login) {
			String myPass = String.valueOf(apText.getPassword());
			for (admin admin : admins) {
				if (anText.getText().equals(admin.getUsername()) && myPass.equals(admin.getPass())) {
					apnl.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong username or password!\nPlease Try again.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
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
