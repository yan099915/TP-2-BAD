import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {
    private static JLabel rLabel = new JLabel("Masukan Nilai Jari-Jari");
    private static JLabel tLabel = new JLabel("Masukan Nilai Tinggi");
    private static JTextField r = new JTextField();
    private static JTextField t = new JTextField();
    private static JLabel hasil = new JLabel();
    private static JLabel hasilLabel = new JLabel("Volume Tabung adalah : ");
    private static JButton tombolHitung = new JButton("Hitung");
    public static void main(String[] args) throws Exception {
        App window = new App();
        window.setSize(500,500);
        window.setVisible(true);
        window.setTitle("TP-2 Yan Septyadi (Hitung Volume Tabung)");

        // form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1,5,10));
        formPanel.add(rLabel);
        formPanel.add(r);
        formPanel.add(tLabel);
        formPanel.add(t);

        // panel hasil perhitungan
        JPanel hasilPanel = new JPanel();
        hasilPanel.setLayout(new GridLayout(1, 1,0,0));
        hasilPanel.add(hasilLabel);
        hasilPanel.add(hasil);

        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1,5,5));
        buttonPanel.add(tombolHitung);

        // main panel
        window.setLayout(new BorderLayout());
        window.setBackground(new Color(128,128,255));
        window.add(formPanel, BorderLayout.NORTH);
        window.add(hasilPanel, BorderLayout.CENTER);
        window.add(buttonPanel, BorderLayout.SOUTH);
        window.pack();

        tombolHitung.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buttonClick(e);
            }
        });

        //  adding exit function
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void buttonClick(ActionEvent e){
        // do mathematical logic
        try {
            Double jari = Double.parseDouble(r.getText());
            Double tinggi = Double.parseDouble(t.getText());
            Double perhitungan = (3.14 * jari * jari) * tinggi;
        
            if(jari < 0 || tinggi < 0){
                throw new ArithmeticException();
            } else  if (jari < 0 && tinggi < 0){

            }else {
                hasil.setText(" " + perhitungan);
            }

        } catch (NumberFormatException ex1) {
            JOptionPane.showMessageDialog(null, ex1, "Error!", JOptionPane.WARNING_MESSAGE);
        } catch (ArithmeticException ex2) {
            JOptionPane.showMessageDialog(null, "The input value can not be less than zero", "Error!", JOptionPane.WARNING_MESSAGE);
        }



        
    }
}
