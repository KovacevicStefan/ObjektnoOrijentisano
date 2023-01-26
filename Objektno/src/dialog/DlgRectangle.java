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

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private boolean commited;
	private Rectangle rectangle = new Rectangle();
	

	public DlgRectangle() {
		setBounds(100, 100, 450, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblRectangle = new JLabel("Rectangle");
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
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 2;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel width = new JLabel("Width (px):");
			GridBagConstraints gbc_width = new GridBagConstraints();
			gbc_width.anchor = GridBagConstraints.EAST;
			gbc_width.insets = new Insets(0, 0, 0, 5);
			gbc_width.gridx = 1;
			gbc_width.gridy = 3;
			contentPanel.add(width, gbc_width);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 2;
			gbc_textField_1.gridy = 3;
			contentPanel.add(textField_1, gbc_textField_1);
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
	
	
	
	public Rectangle getRectangle() {
		return rectangle;
	}



	public void setRectangle(Rectangle r) {
		this.rectangle = r;
	}



	public boolean isCommited() {
		return commited;
	}



	public void setCommited(boolean commited) {
		this.commited = commited;
	}



	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
