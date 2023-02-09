package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircleModify extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField radius;
	private boolean commited;
	private JTextField fieldCenterX;
	private JTextField fieldCenterY;
	

	public DlgCircleModify() {
		setBounds(100, 100, 406, 236);
		setModal(true);
		setTitle("Circle Modify");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCircle = new JLabel("Circle Modify");
			lblCircle.setFont(new Font("Tahoma", Font.PLAIN, 17));
			GridBagConstraints gbc_lblCircle = new GridBagConstraints();
			gbc_lblCircle.insets = new Insets(0, 0, 5, 0);
			gbc_lblCircle.gridx = 2;
			gbc_lblCircle.gridy = 0;
			contentPanel.add(lblCircle, gbc_lblCircle);
		}
		{
			JLabel radius = new JLabel("Radius (px):");
			GridBagConstraints gbc_radius = new GridBagConstraints();
			gbc_radius.anchor = GridBagConstraints.EAST;
			gbc_radius.insets = new Insets(0, 0, 5, 5);
			gbc_radius.gridx = 1;
			gbc_radius.gridy = 1;
			contentPanel.add(radius, gbc_radius);
		}
		{
			radius = new JTextField();
			radius.setColumns(10);
			GridBagConstraints gbc_radius = new GridBagConstraints();
			gbc_radius.insets = new Insets(0, 0, 5, 0);
			gbc_radius.fill = GridBagConstraints.HORIZONTAL;
			gbc_radius.gridx = 2;
			gbc_radius.gridy = 1;
			contentPanel.add(radius, gbc_radius);
		}
		{
			JLabel lblCenterX = new JLabel("Center X (px):");
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.anchor = GridBagConstraints.EAST;
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.gridx = 1;
			gbc_lblCenterX.gridy = 2;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
		}
		{
			fieldCenterX = new JTextField();
			fieldCenterX.setColumns(10);
			GridBagConstraints gbc_fieldCenterX = new GridBagConstraints();
			gbc_fieldCenterX.insets = new Insets(0, 0, 5, 0);
			gbc_fieldCenterX.fill = GridBagConstraints.HORIZONTAL;
			gbc_fieldCenterX.gridx = 2;
			gbc_fieldCenterX.gridy = 2;
			contentPanel.add(fieldCenterX, gbc_fieldCenterX);
		}
		{
			JLabel lblCenterYpx = new JLabel("Center Y (px):");
			GridBagConstraints gbc_lblCenterYpx = new GridBagConstraints();
			gbc_lblCenterYpx.anchor = GridBagConstraints.EAST;
			gbc_lblCenterYpx.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterYpx.gridx = 1;
			gbc_lblCenterYpx.gridy = 3;
			contentPanel.add(lblCenterYpx, gbc_lblCenterYpx);
		}
		{
			fieldCenterY = new JTextField();
			fieldCenterY.setColumns(10);
			GridBagConstraints gbc_fieldCenterY = new GridBagConstraints();
			gbc_fieldCenterY.insets = new Insets(0, 0, 5, 0);
			gbc_fieldCenterY.fill = GridBagConstraints.HORIZONTAL;
			gbc_fieldCenterY.gridx = 2;
			gbc_fieldCenterY.gridy = 3;
			contentPanel.add(fieldCenterY, gbc_fieldCenterY);
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
	
	
	public JTextField getFieldCenterX() {
		return fieldCenterX;
	}
	
	public JTextField getFieldCenterY() {
		return fieldCenterY;
	}

	public JTextField getRadius() {
		return radius;
	}


	public boolean isCommited() {
		return commited;
	}
	
	public void setCommited(boolean commited) {
		this.commited = commited;
	}

	public static void main(String[] args) {
		try {
			DlgCircleModify dialog = new DlgCircleModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
