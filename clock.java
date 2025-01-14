import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

class gui {
    
    JLabel label = new JLabel();
    JFrame frame = new JFrame();
    SimpleDateFormat format = new SimpleDateFormat();

    public void DateFormat() {
        format = new SimpleDateFormat("HH:mm:ss");
    }
    
    public void updateTime() {
        String time = format.format(new Date());
        label.setText(time); 
    }

    public void actionListener() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
    }

    public gui() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,150);
        frame.setTitle("Digital Clock");
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(67,67,73));
        frame.setResizable(false);
        frame.setVisible(true);
        
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Helvetica", Font.BOLD, 36));
        label.setBackground(Color.decode("#232a31"));
        label.setForeground(Color.WHITE);
        label.setOpaque(true);


        frame.add(label, BorderLayout.CENTER);

        actionListener();
        DateFormat();

}
}
class clock {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new gui();
            }
        });
    }
}
