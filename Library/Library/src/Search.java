import javax.swing.*;

public class Search
{
	private JFrame frmSearchcheckout;

	public Search() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{	
		frmSearchcheckout = new JFrame();
		frmSearchcheckout.setTitle("Search/Checkout");
		frmSearchcheckout.setBounds(100, 100, 450, 300);
		frmSearchcheckout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSearchcheckout.setResizable(false);
		frmSearchcheckout.setVisible(true);
	}

}
