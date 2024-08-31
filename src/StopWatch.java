import java.awt.event.*;
import java.lang.*;
import javax.swing.*;


public class StopWatch implements ActionListener{

    JFrame frame = new JFrame("Stopwatch");
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;

    String seconds_string = String.format("%02d",seconds);
    String minutes_string = String.format("%02d",minutes);
    String hours_string = String.format("%02d",hours);

    boolean started = false;

    StopWatch(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    void start(){

    }
    void stop(){

    }
    void reset(){

    }
}
