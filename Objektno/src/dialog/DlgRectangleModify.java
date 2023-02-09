package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangleModify extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField heightField;
	protected JTextField widthField;
	protected JTextField upperLeftXField;
	protected JTextField upperLeftYField;
	protected boolean commited;
	

	public DlgRectangleModify() {
		setBounds(100, 100, 450, 280);
		setModal(true);
		setTitle("Rectangle Modify");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblRectangle = new JLabel("Rectangle Modify");
			lblRectangle.setFont(new Font("Tahoma", Font.PLAIN, 17));
			GridBagConstraints gbc_lblRectangle = new GridBagConstraints();
			gbc_lblRectangle.insets = new Insets(0, 0, 5, 0);
			gbc_lblRectangle.gridx = 2;
			gbc_lblRectangle.gridy = 0;
			contentPanel.add(lblRectangle, gbc_lblRectangle);
		}
		{
			JLabel height = new JLabel("Height (px):");
			GridBagConstraints gbc_height = new GridBagConstraints();
			gbc_height.anchor = GridBagConstraints.EAST;
			gbc_height.insets = new Insets(0, 0, 5, 5);
			gbc_height.gridx = 1;
			gbc_height.gridy = 2;
			contentPanel.add(height, gbc_height);
		}
		{
			heightField = new JTextField();
			GridBagConstraints gbc_heightField = new GridBagConstraints();
			gbc_heightField.insets = new Insets(0, 0, 5, 0);
			gbc_heightField.fill = GridBagConstraints.HORIZONTAL;
			gbc_heightField.gridx = 2;
			gbc_heightField.gridy = 2;
			contentPanel.add(heightField, gbc_heightField);
			heightField.setColumns(10);
		}
		{
			JLabel width = new JLabel("Width (px):");
			GridBagConstraints gbc_width = new GridBagConstraints();
			gbc_width.anchor = GridBagConstraints.EAST;
			gbc_width.insets = new Insets(0, 0, 5, 5);
			gbc_width.gridx = 1;
			gbc_width.gridy = 3;
			contentPanel.add(width, gbc_width);
		}
		{
			widthField = new JTextField();
			widthField.setColumns(10);
			GridBagConstraints gbc_widthField = new GridBagConstraints();
			gbc_widthField.insets = new Insets(0, 0, 5, 0);
			gbc_widthField.fill = GridBagConstraints.HORIZONTAL;
			gbc_widthField.gridx = 2;
			gbc_widthField.gridy = 3;
			contentPanel.add(widthField, gbc_widthField);
		}
		{
			JLabel lblUpperleftXpx = new JLabel("UpperLeft X (px):");
			GridBagConstraints gbc_lblUpperleftXpx = new GridBagConstraints();
			gbc_lblUpperleftXpx.anchor = GridBagConstraints.EAST;
			gbc_lblUpperleftXpx.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperleftXpx.gridx = 1;
			gbc_lblUpperleftXpx.gridy = 4;
			contentPanel.add(lblUpperleftXpx, gbc_lblUpperleftXpx);
		}
		{
			upperLeftXField = new JTextField();
			upperLeftXField.setColumns(10);
			GridBagConstraints gbc_upperLeftXField = new GridBagConstraints();
			gbc_upperLeftXField.insets = new Insets(0, 0, 5, 0);
			gbc_upperLeftXField.fill = GridBagConstraints.HORIZONTAL;
			gbc_upperLeftXField.gridx = 2;
			gbc_upperLeftXField.gridy = 4;
			contentPanel.add(upperLeftXField, gbc_upperLeftXField);
		}
		{
			JLabel lblUpperleftYpx = new JLabel("UpperLeft Y (px):");
			GridBagConstraints gbc_lblUpperleftYpx = new GridBagConstraints();
			gbc_lblUpperleftYpx.anchor = GridBagConstraints.EAST;
			gbc_lblUpperleftYpx.insets = new Insets(0, 0, 0, 5);
			gbc_lblUpperleftYpx.gridx = 1;
			gbc_lblUpperleftYpx.gridy = 5;
			contentPanel.add(lblUpperleftYpx, gbc_lblUpperleftYpx);
		}
		{
			upperLeftYField = new JTextField();
			upperLeftYField.setColumns(10);
			GridBagConstraints gbc_upperLeftYField = new GridBagConstraints();
			gbc_upperLeftYField.fill = GridBagConstraints.HORIZONTAL;
			gbc_upperLeftYField.gridx = 2;
			gbc_upperLeftYField.gridy = 5;
			contentPanel.add(upperLeftYField, gbc_upperLeftYField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setCommited(true);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setCommited(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getHeightField() {
		return heightField;
	}

	public JTextField getWidthField() {
		return widthField;
	}

	public boolean isCommited() {
		return commited;
	}

	public void setCommited(boolean commited) {
		this.commited = commited;
	}
	
	public JTextField getUpperLeftXField() {
		return upperLeftXField;
	}
	public JTextField getUpperLeftYField() {
		return upperLeftYField;
	}

	public static void main(String[] args) {
		try {
			DlgRectangleModify dialog = new DlgRectangleModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
