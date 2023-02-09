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
	private JTextField outR;
	private JTextField inR;
	private boolean commited;
	

	public DlgDonut() {
		setBounds(100, 100, 450, 280);
		setModal(true);
		setTitle("Donut");
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
			JLabel radius = new JLabel("Outer radius (px):");
			GridBagConstraints gbc_radius = new GridBagConstraints();
			gbc_radius.anchor = GridBagConstraints.EAST;
			gbc_radius.insets = new Insets(0, 0, 5, 5);
			gbc_radius.gridx = 1;
			gbc_radius.gridy = 2;
			contentPanel.add(radius, gbc_radius);
		}
		{
			outR = new JTextField();
			GridBagConstraints gbc_outR = new GridBagConstraints();
			gbc_outR.insets = new Insets(0, 0, 5, 0);
			gbc_outR.fill = GridBagConstraints.HORIZONTAL;
			gbc_outR.gridx = 2;
			gbc_outR.gridy = 2;
			contentPanel.add(outR, gbc_outR);
			outR.setColumns(10);
		}
		{
			JLabel innerR = new JLabel("Inner Radius (px):");
			GridBagConstraints gbc_innerR = new GridBagConstraints();
			gbc_innerR.anchor = GridBagConstraints.EAST;
			gbc_innerR.insets = new Insets(0, 0, 5, 5);
			gbc_innerR.gridx = 1;
			gbc_innerR.gridy = 3;
			contentPanel.add(innerR, gbc_innerR);
		}
		{
			inR = new JTextField();
			inR.setColumns(10);
			GridBagConstraints gbc_inR = new GridBagConstraints();
			gbc_inR.insets = new Insets(0, 0, 5, 0);
			gbc_inR.fill = GridBagConstraints.HORIZONTAL;
			gbc_inR.gridx = 2;
			gbc_inR.gridy = 3;
			contentPanel.add(inR, gbc_inR);
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
	
	

	public JTextField getOutR() {
		return outR;
	}


	public JTextField getInR() {
		return inR;
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
