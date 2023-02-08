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

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField radius;
	private boolean commited;
	

	public DlgCircle() {
		setBounds(100, 100, 406, 236);
		setModal(true);
		setTitle("Unos dimenzija");
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
			JLabel lblCircle = new JLabel("Circle");
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
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
