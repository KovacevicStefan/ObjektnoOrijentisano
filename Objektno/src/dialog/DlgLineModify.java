package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import geometry.Point;

public class DlgLineModify extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField spxField;
	private JTextField spyField;
	private boolean commited;
	private Point point;
	private JTextField epxField;
	private JTextField epyField;
	

	public DlgLineModify() {
		setBounds(100, 100, 450, 280);
		setModal(true);
		setTitle("Line Modify");
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
			JLabel lblLine = new JLabel("Line Modify");
			lblLine.setFont(new Font("Tahoma", Font.PLAIN, 17));
			GridBagConstraints gbc_lblLine = new GridBagConstraints();
			gbc_lblLine.insets = new Insets(0, 0, 5, 0);
			gbc_lblLine.gridx = 2;
			gbc_lblLine.gridy = 0;
			contentPanel.add(lblLine, gbc_lblLine);
		}
		{
			JLabel x = new JLabel("startPointX (px):");
			GridBagConstraints gbc_x = new GridBagConstraints();
			gbc_x.anchor = GridBagConstraints.EAST;
			gbc_x.insets = new Insets(0, 0, 5, 5);
			gbc_x.gridx = 1;
			gbc_x.gridy = 1;
			contentPanel.add(x, gbc_x);
		}
		{
			spxField = new JTextField();
			GridBagConstraints gbc_spxField = new GridBagConstraints();
			gbc_spxField.insets = new Insets(0, 0, 5, 0);
			gbc_spxField.fill = GridBagConstraints.HORIZONTAL;
			gbc_spxField.gridx = 2;
			gbc_spxField.gridy = 1;
			contentPanel.add(spxField, gbc_spxField);
			spxField.setColumns(10);
		}
		{
			JLabel y = new JLabel("startPointY (px):");
			GridBagConstraints gbc_y = new GridBagConstraints();
			gbc_y.anchor = GridBagConstraints.EAST;
			gbc_y.insets = new Insets(0, 0, 5, 5);
			gbc_y.gridx = 1;
			gbc_y.gridy = 2;
			contentPanel.add(y, gbc_y);
		}
		{
			spyField = new JTextField();
			spyField.setColumns(10);
			GridBagConstraints gbc_spyField = new GridBagConstraints();
			gbc_spyField.insets = new Insets(0, 0, 5, 0);
			gbc_spyField.fill = GridBagConstraints.HORIZONTAL;
			gbc_spyField.gridx = 2;
			gbc_spyField.gridy = 2;
			contentPanel.add(spyField, gbc_spyField);
		}
		{
			JLabel lblEndpointxpx = new JLabel("endPointX (px):");
			GridBagConstraints gbc_lblEndpointxpx = new GridBagConstraints();
			gbc_lblEndpointxpx.anchor = GridBagConstraints.EAST;
			gbc_lblEndpointxpx.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndpointxpx.gridx = 1;
			gbc_lblEndpointxpx.gridy = 3;
			contentPanel.add(lblEndpointxpx, gbc_lblEndpointxpx);
		}
		{
			epxField = new JTextField();
			epxField.setColumns(10);
			GridBagConstraints gbc_epxField = new GridBagConstraints();
			gbc_epxField.insets = new Insets(0, 0, 5, 0);
			gbc_epxField.fill = GridBagConstraints.HORIZONTAL;
			gbc_epxField.gridx = 2;
			gbc_epxField.gridy = 3;
			contentPanel.add(epxField, gbc_epxField);
		}
		{
			JLabel lblEndpointypx = new JLabel("endPointY (px):");
			GridBagConstraints gbc_lblEndpointypx = new GridBagConstraints();
			gbc_lblEndpointypx.anchor = GridBagConstraints.EAST;
			gbc_lblEndpointypx.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndpointypx.gridx = 1;
			gbc_lblEndpointypx.gridy = 4;
			contentPanel.add(lblEndpointypx, gbc_lblEndpointypx);
		}
		{
			epyField = new JTextField();
			epyField.setColumns(10);
			GridBagConstraints gbc_epyField = new GridBagConstraints();
			gbc_epyField.insets = new Insets(0, 0, 5, 0);
			gbc_epyField.fill = GridBagConstraints.HORIZONTAL;
			gbc_epyField.gridx = 2;
			gbc_epyField.gridy = 4;
			contentPanel.add(epyField, gbc_epyField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!epxField.getText().isEmpty() && !epyField.getText().isEmpty() && !spxField.getText().isEmpty() && !spyField.getText().isEmpty()) {
							if(epxField.getText().matches("^[1-9]\\d*$") && epyField.getText().matches("^[1-9]\\d*$") && spxField.getText().matches("^[1-9]\\d*$") 
								&& spyField.getText().matches("^[1-9]\\d*$")) {
								setCommited(true);
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "All values have to be positive!", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "You have to enter all values!", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
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


	public Point getPoint() {
		return point;
	}



	public void setPoint(Point point) {
		this.point = point;
	}



	public boolean isCommited() {
		return commited;
	}



	public void setCommited(boolean commited) {
		this.commited = commited;
	}



	public JTextField getSpxField() {
		return spxField;
	}
	public JTextField getSpyField() {
		return spyField;
	}
	public JTextField getEpxField() {
		return epxField;
	}
	public JTextField getEpyField() {
		return epyField;
	}
	
	public static void main(String[] args) {
		try {
			DlgLineModify dialog = new DlgLineModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
