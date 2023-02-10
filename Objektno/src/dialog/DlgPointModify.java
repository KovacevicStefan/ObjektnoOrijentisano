package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPointModify extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField xField;
	private JTextField yField;
	private boolean commited;
	private Point point;
	

	public DlgPointModify() {
		setBounds(100, 100, 450, 280);
		setModal(true);
		setTitle("Point Modify");
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
			JLabel lblPoint = new JLabel("Point Modify");
			lblPoint.setFont(new Font("Tahoma", Font.PLAIN, 17));
			GridBagConstraints gbc_lblPoint = new GridBagConstraints();
			gbc_lblPoint.insets = new Insets(0, 0, 5, 0);
			gbc_lblPoint.gridx = 2;
			gbc_lblPoint.gridy = 0;
			contentPanel.add(lblPoint, gbc_lblPoint);
		}
		{
			JLabel x = new JLabel("X (px):");
			GridBagConstraints gbc_x = new GridBagConstraints();
			gbc_x.anchor = GridBagConstraints.EAST;
			gbc_x.insets = new Insets(0, 0, 5, 5);
			gbc_x.gridx = 1;
			gbc_x.gridy = 1;
			contentPanel.add(x, gbc_x);
		}
		{
			xField = new JTextField();
			GridBagConstraints gbc_xField = new GridBagConstraints();
			gbc_xField.insets = new Insets(0, 0, 5, 0);
			gbc_xField.fill = GridBagConstraints.HORIZONTAL;
			gbc_xField.gridx = 2;
			gbc_xField.gridy = 1;
			contentPanel.add(xField, gbc_xField);
			xField.setColumns(10);
		}
		{
			JLabel y = new JLabel("Y (px):");
			GridBagConstraints gbc_y = new GridBagConstraints();
			gbc_y.anchor = GridBagConstraints.EAST;
			gbc_y.insets = new Insets(0, 0, 5, 5);
			gbc_y.gridx = 1;
			gbc_y.gridy = 2;
			contentPanel.add(y, gbc_y);
		}
		{
			yField = new JTextField();
			yField.setColumns(10);
			GridBagConstraints gbc_yField = new GridBagConstraints();
			gbc_yField.insets = new Insets(0, 0, 5, 0);
			gbc_yField.fill = GridBagConstraints.HORIZONTAL;
			gbc_yField.gridx = 2;
			gbc_yField.gridy = 2;
			contentPanel.add(yField, gbc_yField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!xField.getText().isEmpty() && !yField.getText().isEmpty()) {
							if(xField.getText().matches("^[1-9]\\d*$") && yField.getText().matches("^[1-9]\\d*$")) {
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
	
	

	public JTextField getxField() {
		return xField;
	}



	public JTextField getyField() {
		return yField;
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



	public static void main(String[] args) {
		try {
			DlgPointModify dialog = new DlgPointModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
