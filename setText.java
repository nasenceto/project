package salesData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class setText extends  ConnectDb {
	private PreparedStatement pst;

	private JFrame frame;
	private JTextField nameF;
	private JTextField product;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setText window = new setText();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public setText() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 638, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_34636014225908");
		panel.setLayout(null);
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql=" insert into data(name)values(?)";
				
				try {
					pst=conn.prepareStatement(sql);
				} catch (SQLException e) {
					System.out.println("Error: ");
					e.printStackTrace();
				}
				try {
					pst.setString(1, nameF.getText());
					pst.execute();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
				
			}
		});
		save.setBounds(412, 155, 89, 23);
		panel.add(save);
		
		nameF = new JTextField();
		nameF.setBounds(261, 156, 130, 20);
		panel.add(nameF);
		nameF.setColumns(10);
		
		product = new JTextField();
		product.setBounds(261, 190, 130, 20);
		panel.add(product);
		product.setColumns(10);
	}
}
