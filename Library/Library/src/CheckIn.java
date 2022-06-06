import javax.swing.*;

public class CheckIn 
{
	private JFrame frmCheckIn;

	/**
	 * Create the application.
	 */
	public CheckIn() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmCheckIn = new JFrame();
		frmCheckIn.setTitle("Check In");
		frmCheckIn.setBounds(100, 100, 450, 300);
		frmCheckIn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCheckIn.setResizable(false);
		frmCheckIn.setVisible(true);
	}

}
