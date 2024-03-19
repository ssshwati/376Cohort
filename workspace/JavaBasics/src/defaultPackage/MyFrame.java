package defaultPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	private JLabel fnameLabel;
	private JLabel lnameLabel;
	private JTextField fnameText;
	private JTextField lnameText;
	private JButton addButton;
	
	public MyFrame()
	{
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(400, 600);
		this.setTitle("Employee Management System");
			
		fnameLabel = new JLabel("First Name : ");
		fnameLabel.setBounds(20, 20, 100, 50);
		this.add(fnameLabel);
		
		fnameText = new JTextField(30);
		fnameText.setBounds(120, 35, 100, 20);
		this.add(fnameText);
			
		lnameLabel = new JLabel("Last Name : ");
		lnameLabel.setBounds(20, 60, 100, 50);
		this.add(lnameLabel);
		
		lnameText = new JTextField(30);
		lnameText.setBounds(120, 70, 100, 20);
		this.add(lnameText);
		
		addButton = new JButton("Add");
		addButton.setBounds(20, 150, 70, 25);
		this.add(addButton);
		addButton.addActionListener(new MyActionListener(this) );
	}
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
	
	class MyActionListener implements ActionListener{
		MyFrame mf;
		public MyActionListener(MyFrame mf) {
			this.mf = mf;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("button clicked");
			System.out.println(mf.fnameText.getText());
		}
		
	}
}
