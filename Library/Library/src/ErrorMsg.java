import java.awt.*;
import javax.swing.*;

public class ErrorMsg 
{
	private JFrame frmError;

	/**
	 * Create the application.
	 * @param message error message to be displayed
	 */
	public ErrorMsg(String message) 
	{
		initialize(message);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String message) 
	{
		frmError = new JFrame();
		frmError.setTitle("Error");
		frmError.setAlwaysOnTop(true);
		frmError.setResizable(false);
		frmError.setBounds(100, 100, 270, 190);
		frmError.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//error message
		JLabel lblNewLabel = new JLabel(message);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmError.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		frmError.setVisible(true);
	}
}
