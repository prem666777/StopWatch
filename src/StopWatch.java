import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;


public class StopWatch implements ActionListener{
    //GlobalVariables
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

    Timer timer = new Timer(1000,new ActionListener() {

        public void actionPerformed(ActionEvent e){

            elapsedTime+=1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;

            seconds_string = String.format("%02d",seconds);
            minutes_string = String.format("%02d",minutes);
            hours_string = String.format("%02d",hours);

            timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);


        }

    });


    StopWatch(){

        //timeLabel
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timeLabel.setBounds(100,100,200,100);
        timeLabel.setFont(new Font("Verdama",Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);


        //Buttons
        startButton.setBounds(100,200,100,50);
        startButton.setFont(new Font("Ink Free",Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        
        resetButton.setBounds(200,200,100,50);
        resetButton.setFont(new Font("Ink Free",Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        //frame Setup
        frame.add(timeLabel);
        frame.add(resetButton);
        frame.add(startButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==startButton) {
            //run timer if not started, stop timer if started 
            if (started) {
                stop();
                started = false;
            }else if(!started){
                started = true;
                start();
    
            }
        }

        if (e.getSource()==resetButton) {
            started = false;
            reset();
            
        }

    }

    void start(){
        timer.start();
        startButton.setText("Stop");
    }
    void stop(){
        timer.stop();
        startButton.setText("Start");


    }
    void reset(){
        startButton.setText("Start");
        timer.stop();

        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;

        seconds_string = String.format("%02d",seconds);
        minutes_string = String.format("%02d",minutes);
        hours_string = String.format("%02d",hours);
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);

        
    }
}
