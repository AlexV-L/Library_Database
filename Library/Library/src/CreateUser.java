import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateUser
{
	private JFrame frmCreateUser;
	private JTextField textFieldFName;
	private JTextField textFieldLName;
	private JTextField textFieldSSN;
	private JTextField textFieldAddress;
	private JTextField textFieldCity;
	private JTextField textFieldState;
	private JTextField textFieldPhone;
	private String[] userInfo;	
	
	//Variables used for DB connection and interaction
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	/**
	 * Create the application.
	 */
	public CreateUser() 
	{
		conn = DbConn.ConnectDB();
		userInfo = new String[7];
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmCreateUser = new JFrame();
		frmCreateUser.setTitle("Create User");
		frmCreateUser.setBounds(100, 100, 465, 357);
		frmCreateUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCreateUser.setResizable(false);
		frmCreateUser.getContentPane().setLayout(null);
		
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(36, 24, 83, 14);
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		frmCreateUser.getContentPane().add(lblFirstName);
		
		textFieldFName = new JTextField();
		textFieldFName.setBounds(129, 21, 207, 20);
		frmCreateUser.getContentPane().add(textFieldFName);
		textFieldFName.setColumns(10);		
		
		
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(30, 60, 89, 14);
		frmCreateUser.getContentPane().add(lblLastName);		
		
		textFieldLName = new JTextField();
		textFieldLName.setBounds(129, 57, 207, 20);
		frmCreateUser.getContentPane().add(textFieldLName);
		textFieldLName.setColumns(10);
		frmCreateUser.setVisible(true);
		
		
		
		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSsn.setBounds(36, 97, 83, 14);
		frmCreateUser.getContentPane().add(lblSsn);
		
		textFieldSSN = new JTextField();
		textFieldSSN.setBounds(129, 94, 207, 20);
		frmCreateUser.getContentPane().add(textFieldSSN);
		textFieldSSN.setColumns(10);
		
		
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(60, 132, 59, 14);
		frmCreateUser.getContentPane().add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(129, 129, 207, 20);
		frmCreateUser.getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(60, 170, 59, 14);
		frmCreateUser.getContentPane().add(lblCity);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(129, 167, 207, 20);
		frmCreateUser.getContentPane().add(textFieldCity);
		textFieldCity.setColumns(10);
		
		
		
		JLabel lblState = new JLabel("State:");
		lblState.setHorizontalAlignment(SwingConstants.RIGHT);
		lblState.setBounds(60, 201, 59, 14);
		frmCreateUser.getContentPane().add(lblState);
		
		textFieldState = new JTextField();
		textFieldState.setBounds(129, 198, 34, 20);
		frmCreateUser.getContentPane().add(textFieldState);
		textFieldState.setColumns(10);
		
		
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(36, 237, 83, 14);
		frmCreateUser.getContentPane().add(lblPhone);		
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(129, 234, 207, 20);
		frmCreateUser.getContentPane().add(textFieldPhone);
		textFieldPhone.setColumns(10);
		

		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(populateArr())
				{
					/*
					String borrowers = "INSERT INTO BORROWERS(ssn, bname_id, address_id, phone) VALUES (?, ?, ?, ?)";
					try 
					{
						pst = conn.prepareStatement(borrowers);
						pst.setString(1, textFieldSSN.getText());
					}
					catch(Exception e)
					{
					
					}
				
				
				
				
				
					String address = "INSERT INTO ADDRESSES(address_id, address, city, state_ab) VALUES (?, ?, ?, ?)";
					*/
					System.out.println("Correct");
				}
			}
		});
		btnEnter.setBounds(182, 279, 89, 23);
		frmCreateUser.getContentPane().add(btnEnter);
	}
	
	private boolean populateArr()
	{
		boolean valid = true;		
		userInfo[0] = textFieldFName.getText();
		userInfo[1] = textFieldLName.getText();
		userInfo[2] = textFieldSSN.getText();
		userInfo[3] = textFieldAddress.getText();
		userInfo[4] = textFieldCity.getText();
		userInfo[5] = textFieldState.getText();
		userInfo[6] = textFieldPhone.getText();
		
		try
		{
			Integer.parseInt(userInfo[2]);
			
			if(userInfo[2].length() != 9)
			{
				valid = false;
				new ErrorMsg("Incorrect SSN length");
			}
		}
		catch(Exception e)
		{
			valid = false;
			new ErrorMsg("SSN contains invalid characters");
		}

		
		
		return valid;
		
		
	}
	
	private void testSSN(String ssn)
	{
		
	}
	
}
