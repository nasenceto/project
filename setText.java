package salesData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class setText extends  ConnectDb {
	private PreparedStatement pst;

	private JFrame frame;
	private JTextField nameF;
	private JDateChooser dateChooser;
	

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
				String sql=" insert into person(name,date)values(?,?)";
				
				try {
					pst=conn.prepareStatement(sql);
				} catch (SQLException e) {
					System.out.println("Error: ");
					e.printStackTrace();
				}
				try {
					pst.setString(1, nameF.getText());
					String dateFormat=date();
					pst.setString(2, dateFormat);
					System.out.println(dateFormat);
					
					
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
				
				
			JOptionPane.showMessageDialog(frame, "Successfully saved.");
				
			}
		});
		save.setBounds(412, 155, 89, 23);
		panel.add(save);
		
		nameF = new JTextField();
		nameF.setBounds(261, 156, 130, 20);
		panel.add(nameF);
		nameF.setColumns(10);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(261, 187, 87, 20);
		panel.add(dateChooser);
		
	}
	public String date() {
		DateFormat df= new SimpleDateFormat("yyy-MM-dd");
		String date=df.format(dateChooser.getDate());
		return date;
	}
}
