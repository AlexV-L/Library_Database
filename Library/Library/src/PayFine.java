import javax.swing.*;

public class PayFine 
{
	private JFrame frmPayFine;

	/**
	 * Create the application.
	 */
	public PayFine() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmPayFine = new JFrame();
		frmPayFine.setTitle("Pay Fine");
		frmPayFine.setBounds(100, 100, 450, 300);
		frmPayFine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPayFine.setResizable(false);
		frmPayFine.setVisible(true);
	}

}
