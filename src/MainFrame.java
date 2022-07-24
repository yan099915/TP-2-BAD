import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.*;

public class MainFrame extends JFrame implements MouseListener, MouseMotionListener {
    JLabel label;
    private static JLabel pointerPosition = new JLabel("Outside the circle");
    Shape oval;
    Shape rectangle = new Rectangle2D.Float(10, 120, 100, 60);
    JPanel panel1 = new JPanel();

    public void initialize(Data data) {
        oval = new Ellipse2D.Float(data.xValue, data.yValue, data.diameterValue, data.diameterValue);
        panel1.add(pointerPosition);
        pointerPosition.setForeground(Color.white);
        setTitle("Pointer Position Checker");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        add(panel1, BorderLayout.SOUTH);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.blue);
        g2.draw(oval);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        if (oval.contains(e.getX(), e.getY())) {
            // mouse is inside the ellipse
            panel1.setBackground(Color.blue);
            pointerPosition.setText("Inside the circle");
            System.out.println("enter");
        } else {
            panel1.setBackground(Color.red);
            pointerPosition.setText("Outside the circle");
            System.out.println("exit");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
