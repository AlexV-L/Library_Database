import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener
{
	private JFrame mainFrame;
	private JPanel mainPanel;
	
	//Assigned to each different button
	private enum Actions
	{
		SEARCH,
		CREATE_USER,
		CHECK_IN,
		PAY_FINE
	}
	
	/**
	 * Constructor
	 */
	public GUI() 
	{
		mainFrame = new JFrame();
		mainPanel = new JPanel();

		setupPanel();
		setupFrame(mainFrame, mainPanel, "Library Database", JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Sets up details of a JPanel
	 */
	private void setupPanel()
	{	
		//Creates buttons
		setupButtons();
	
		//Panel layout setup
		mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 75, 50, 75));//top, left, bot, right from center
		mainPanel.setLayout(new GridLayout(2, 2, 50, 50)); //rows, cols, hgap, vgap
	}
	
	/**
	 * Creates all buttons on the main menu
	 */
	private void setupButtons()
	{
		//Search/Checkout Button
		JButton searchBtn = new JButton("<html>Search/<br>Checkout<html>");
	    searchBtn.setActionCommand(Actions.SEARCH.name());
	    searchBtn.addActionListener(this);
		mainPanel.add(searchBtn);
	    
		//Create User Button
		JButton createUserBtn = new JButton("Create User");
		createUserBtn.setActionCommand(Actions.CREATE_USER.name());
		createUserBtn.addActionListener(this);
		mainPanel.add(createUserBtn);
		
		//Check in Book Button
		JButton checkInBtn = new JButton("Check In");
		checkInBtn.setActionCommand(Actions.CHECK_IN.name());
		checkInBtn.addActionListener(this);
		mainPanel.add(checkInBtn);
		
		//Pay Fine button
		JButton fineBtn = new JButton("Pay Fine");
		fineBtn.setActionCommand(Actions.PAY_FINE.name());
		fineBtn.addActionListener(this);
		mainPanel.add(fineBtn);
		
		//Set size of all button
		searchBtn.setPreferredSize(new Dimension(125,75));
	}
	
	/**
	 * Sets up details of a JFrame
	 * @param frame frame to be setup
	 * @param panel panel to be added to frame
	 * @param title title of the frame
	 * @param closeOP constant which states what will happen on hitting the X button
	 */
	private void setupFrame(JFrame frame, JPanel panel, String title, int closeOP)
	{
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(closeOP);
		frame.setTitle(title);
		frame.pack();	
		frame.setResizable(false);
		frame.setVisible(true);	
	}
	
	/**
	 * Determines what happens after a button is clicked
	 * @param e the action that occurred
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{		
		//Search and Checkout Operation
		if(e.getActionCommand() == Actions.SEARCH.name())
		{	
			new Search();
		}
		
		//Create User Operation
		else if(e.getActionCommand() == Actions.CREATE_USER.name())
		{
			new CreateUser();
		}
		
		//Check In Operation
		else if(e.getActionCommand() == Actions.CHECK_IN.name())
		{
			new CheckIn();
		}
		
		//Pay Fine Operation
		else if(e.getActionCommand() == Actions.PAY_FINE.name())
		{
			new PayFine();
		}	
	}	
}
