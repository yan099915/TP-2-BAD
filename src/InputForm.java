import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class InputForm extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    private static JLabel xLabel = new JLabel("Input X Position : ");
    private static JTextField x = new JTextField();
    private static JLabel yLabel = new JLabel("Input Y Position : ");
    private static JTextField y = new JTextField();
    private static JLabel diameterLabel = new JLabel("Input Diameter : ");
    private static JTextField diameter = new JTextField();

    public void initialize() {
        /*************** Form Panel ***************/
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(xLabel);
        formPanel.add(x);
        formPanel.add(yLabel);
        formPanel.add(y);
        formPanel.add(diameterLabel);
        formPanel.add(diameter);

        /*************** Buttons Panel ***************/
        JButton btnStart = new JButton("Start");
        btnStart.setFont(mainFont);
        btnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Data data = getAuthenticatedUser();
                MainFrame mainFrame = new MainFrame();
                mainFrame.initialize(data);
                dispose();
            }

        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(mainFont);
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
            }

        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnStart);
        buttonsPanel.add(btnCancel);

        /*************** Initialise the frame ***************/
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("TP-2 No.3 Yan Septyadi");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        // setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Data getAuthenticatedUser() {
        Data data = null;
        try {
            data = new Data();
            data.xValue = Float.parseFloat(x.getText());
            data.yValue = Float.parseFloat(y.getText());
            data.diameterValue = Float.parseFloat(diameter.getText());
        } catch (Exception ex1) {
            JOptionPane.showMessageDialog(null, ex1, "Error!", JOptionPane.WARNING_MESSAGE);
        }
        return data;
    }

    public static void main(String[] args) {
        try {

        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        InputForm loginForm = new InputForm();
        loginForm.initialize();
    }
}
