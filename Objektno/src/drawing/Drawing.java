package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.LineString;
import geometry.Point;
import geometry.Rectangle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Drawing extends JFrame{

	private JPanel contentPane;
	private PnlDrawing panel = new PnlDrawing();
	private JToggleButton point, line, rectangle, circle, donut;
	private int brojac = 0;
	private Point broj;
	
	public Drawing() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel up = new JPanel();
		contentPane.add(up, BorderLayout.NORTH);
		JPanel down = new JPanel();
		contentPane.add(down, BorderLayout.SOUTH);
		contentPane.add(panel, BorderLayout.CENTER);
		
		point = new JToggleButton("Point");
		down.add(point);
		
		line = new JToggleButton("Line");
		down.add(line);
		
		rectangle = new JToggleButton("Rectangle");
		down.add(rectangle);
		
		circle = new JToggleButton("Circle");
		down.add(circle);
		
		donut = new JToggleButton("Donut");
		down.add(donut);
		
		panel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(point.isSelected()) {
					Point p1 = new Point(e.getX(), e.getY());
					panel.getShapes().add(p1);
					repaint();
				}
				if(line.isSelected()) {
					brojac++;
					if(brojac < 2) {
						broj = new Point(e.getX(),e.getY());
						panel.getShapes().add(broj);
						repaint();
					}else {
						Point p2 = new Point(e.getX(),e.getY());
						Line l1 = new Line(broj,p2, true);
						panel.getShapes().remove(broj);
						panel.getShapes().add(l1);
						repaint();
						brojac = 0;
					}
				}else if(rectangle.isSelected()) {
					Rectangle r1 = new Rectangle(new Point(e.getX(), e.getY()), 50, 20);
					panel.getShapes().add(r1);
					repaint();
				}else if(circle.isSelected()) {
					Circle c1 = new Circle(new Point(e.getX(),e.getY()), 20);
					panel.getShapes().add(c1);
					repaint();
				}else if(donut.isSelected()) {
					Donut d1 = new Donut(new Point(e.getX(),e.getY()), 20, 10);
					panel.getShapes().add(d1);
					repaint();
				}
			}
		});
		
	}
	
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing frame = new Drawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
