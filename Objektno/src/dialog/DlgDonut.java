package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private boolean commited;
	private Donut donut = new Donut();
	private JTextField textField_2;
	private JTextField textField_3;
	

	public DlgDonut() {
		setBounds(100, 100, 450, 280);
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
			JLabel lblDonut = new JLabel("Donut");
			lblDonut.setFont(new Font("Tahoma", Font.PLAIN, 17));
			GridBagConstraints gbc_lblDonut = new GridBagConstraints();
			gbc_lblDonut.insets = new Insets(0, 0, 5, 0);
			gbc_lblDonut.gridx = 2;
			gbc_lblDonut.gridy = 0;
			contentPanel.add(lblDonut, gbc_lblDonut);
		}
		{
			JLabel x = new JLabel("Center X (px):");
			GridBagConstraints gbc_x = new GridBagConstraints();
			gbc_x.anchor = GridBagConstraints.EAST;
			gbc_x.insets = new Insets(0, 0, 5, 5);
			gbc_x.gridx = 1;
			gbc_x.gridy = 2;
			contentPanel.add(x, gbc_x);
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
			JLabel y = new JLabel("Center Y (px):");
			GridBagConstraints gbc_y = new GridBagConstraints();
			gbc_y.anchor = GridBagConstraints.EAST;
			gbc_y.insets = new Insets(0, 0, 5, 5);
			gbc_y.gridx = 1;
			gbc_y.gridy = 3;
			contentPanel.add(y, gbc_y);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 2;
			gbc_textField_1.gridy = 3;
			contentPanel.add(textField_1, gbc_textField_1);
		}
		{
			JLabel radius = new JLabel("Outer radius (px):");
			GridBagConstraints gbc_radius = new GridBagConstraints();
			gbc_radius.anchor = GridBagConstraints.EAST;
			gbc_radius.insets = new Insets(0, 0, 5, 5);
			gbc_radius.gridx = 1;
			gbc_radius.gridy = 4;
			contentPanel.add(radius, gbc_radius);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 2;
			gbc_textField_2.gridy = 4;
			contentPanel.add(textField_2, gbc_textField_2);
		}
		{
			JLabel innerR = new JLabel("Inner Radius (px):");
			GridBagConstraints gbc_innerR = new GridBagConstraints();
			gbc_innerR.anchor = GridBagConstraints.EAST;
			gbc_innerR.insets = new Insets(0, 0, 0, 5);
			gbc_innerR.gridx = 1;
			gbc_innerR.gridy = 5;
			contentPanel.add(innerR, gbc_innerR);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_3.gridx = 2;
			gbc_textField_3.gridy = 5;
			contentPanel.add(textField_3, gbc_textField_3);
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

	

	public Donut getDonut() {
		return donut;
	}



	public void setDonut(Donut donut) {
		this.donut = donut;
	}



	public boolean isCommited() {
		return commited;
	}



	public void setCommited(boolean commited) {
		this.commited = commited;
	}



	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
