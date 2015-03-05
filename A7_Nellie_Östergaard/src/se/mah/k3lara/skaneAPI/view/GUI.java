
package se.mah.k3lara.skaneAPI.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

@SuppressWarnings("serial")

public class GUI extends JFrame {
private JPanel contentPane;

@SuppressWarnings("unused")

private ThreadSearch t;


JLabel labelTitle = new JLabel("UB\u00C5TSHALLEN");
JLabel lblLinje = new JLabel("Linje");
JLabel lblNewLabel = new JLabel("Destination");
JLabel lblNewLabel_1 = new JLabel("Avg\u00E5r");



JLabel labelLine1 = new JLabel("");
JLabel labelLine2 = new JLabel("");
JLabel labelLine3 = new JLabel("");
JLabel labelLine4 = new JLabel("");



JLabel labelDestination1 = new JLabel("");
JLabel labelDestination2 = new JLabel("");
JLabel labelDestination3 = new JLabel("");
JLabel labelDestination4 = new JLabel("");


JLabel labelTime1 = new JLabel("");
JLabel labelTime2 = new JLabel("");
JLabel labelTime3 = new JLabel("");
JLabel labelTime4 = new JLabel("");


JLabel labelLate1 = new JLabel("");
JLabel labelLate2 = new JLabel("");
JLabel labelLate3 = new JLabel("");
JLabel labelLate4 = new JLabel("");


/**

* Launch the application.

*/

public static void main(String[] args) {

EventQueue.invokeLater(new Runnable() {

public void run() {

try {

GUI frame = new GUI();

frame.setVisible(true);

} catch (Exception e) {

e.printStackTrace();

}

}

});

}



/**

* Create the frame.

*/

public GUI() {

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 444, 284);
contentPane = new JPanel();
contentPane.setBackground(Color.BLACK);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
labelTitle.setBounds(67, 11, 282, 23);


labelTitle.setForeground(Color.WHITE);
labelTitle.setFont(new Font("DialogInput", Font.BOLD, 26));
labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
contentPane.add(labelTitle);
lblLinje.setBounds(10, 57, 46, 14);
lblLinje.setFont(new Font("DialogInput", Font.PLAIN, 14));


lblLinje.setForeground(Color.WHITE);
contentPane.add(lblLinje);
lblNewLabel.setBounds(88, 57, 93, 14);
lblNewLabel.setFont(new Font("DialogInput", Font.PLAIN, 14));


lblNewLabel.setForeground(Color.WHITE);
contentPane.add(lblNewLabel);
lblNewLabel_1.setBounds(337, 57, 59, 14);
lblNewLabel_1.setFont(new Font("DialogInput", Font.PLAIN, 14));


lblNewLabel_1.setForeground(Color.WHITE);
contentPane.add(lblNewLabel_1);
labelLine1.setBounds(12, 95, 66, 14);

labelLine1.setForeground(Color.ORANGE);
contentPane.add(labelLine1);
labelLine2.setBounds(12, 132, 66, 14);


labelLine2.setForeground(Color.ORANGE);
contentPane.add(labelLine2);
labelLine3.setBounds(12, 167, 66, 14);

labelLine3.setForeground(Color.ORANGE);
contentPane.add(labelLine3);
labelLine4.setBounds(12, 201, 66, 14);


labelLine4.setForeground(Color.ORANGE);
contentPane.add(labelLine4);
labelDestination1.setBounds(88, 95, 169, 14);

labelDestination1.setForeground(Color.ORANGE);
contentPane.add(labelDestination1);
labelDestination2.setBounds(88, 132, 161, 14);


labelDestination2.setForeground(Color.ORANGE);
contentPane.add(labelDestination2);
labelDestination3.setBounds(88, 167, 181, 14);


labelDestination3.setForeground(Color.ORANGE);
contentPane.add(labelDestination3);
labelDestination4.setBounds(88, 201, 169, 14);


labelDestination4.setForeground(Color.ORANGE);
contentPane.add(labelDestination4);
labelTime1.setBounds(343, 95, 76, 14);



labelTime1.setForeground(Color.ORANGE);
contentPane.add(labelTime1);
labelTime2.setBounds(343, 132, 76, 14);


labelTime2.setForeground(Color.ORANGE);
contentPane.add(labelTime2);
labelTime3.setBounds(343, 167, 76, 14);



labelTime3.setForeground(Color.ORANGE);
contentPane.add(labelTime3);
labelTime4.setBounds(343, 201, 76, 14);


labelTime4.setForeground(Color.ORANGE);
contentPane.add(labelTime4);
labelLate1.setBounds(290, 95, 14, 14);
labelLate1.setForeground(Color.ORANGE);
contentPane.add(labelLate1);
labelLate2.setBounds(290, 132, 14, 14);
labelLate2.setForeground(Color.ORANGE);

contentPane.add(labelLate2);
labelLate3.setBounds(286, 167, 14, 14);
labelLate3.setForeground(Color.ORANGE);
contentPane.add(labelLate3);
labelLate4.setBounds(290, 201, 14, 14);
labelLate4.setForeground(Color.ORANGE);
contentPane.add(labelLate4);


JLabel lblSen = new JLabel("Sen.");
lblSen.setBounds(282, 58, 33, 14);
lblSen.setFont(new Font("DialogInput", Font.PLAIN, 11));
lblSen.setForeground(Color.WHITE);
contentPane.add(lblSen);


UpdateLabels();

Thread t = new ThreadSearch(this);
t.start();

System.out.println("thread");

}


public void UpdateLabels(){

Lines lines = Parser.getStationResults(new Station("80046"));

labelLine1.setText(lines.getLines().get(0).getLine());
labelLine2.setText(lines.getLines().get(1).getLine());
labelLine3.setText(lines.getLines().get(2).getLine());
labelLine4.setText(lines.getLines().get(3).getLine());


labelDestination1.setText(lines.getLines().get(0).getDestination());
labelDestination2.setText(lines.getLines().get(1).getDestination());
labelDestination3.setText(lines.getLines().get(2).getDestination());
labelDestination4.setText(lines.getLines().get(3).getDestination());

labelTime1.setText(FixThatClock(lines.getLines().get(0).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(0).getDepTime().get(Calendar.MINUTE)));
labelTime2.setText(FixThatClock(lines.getLines().get(1).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(1).getDepTime().get(Calendar.MINUTE)));
labelTime3.setText(FixThatClock(lines.getLines().get(2).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(2).getDepTime().get(Calendar.MINUTE)));
labelTime4.setText(FixThatClock(lines.getLines().get(3).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(3).getDepTime().get(Calendar.MINUTE)));

labelLate1.setText("");
labelLate2.setText("");
labelLate3.setText("");
labelLate4.setText("");


// Förseningar nedanför


try {

if (Integer.parseInt(lines.getLines().get(0).getDepTimeDeviation()) > 0){

labelLate1.setText("+" + lines.getLines().get(0).getDepTimeDeviation());

}

else{

labelLate1.setText("");

}

if (lines.getLines().get(0).getDepTimeDeviation() == null){

labelLate1.setText("");

}

} catch (NumberFormatException e) {

// TODO Auto-generated catch block

//e.printStackTrace();

System.out.println("late1 == null");

}

try {

if (Integer.parseInt(lines.getLines().get(1).getDepTimeDeviation()) > 0){

labelLate2.setText("+" + lines.getLines().get(1).getDepTimeDeviation());

}

else{

labelLate2.setText("");

}

if (lines.getLines().get(1).getDepTimeDeviation() == null){

labelLate2.setText("");

}

} catch (NumberFormatException e2) {

// TODO Auto-generated catch block

//e2.printStackTrace();

System.out.println("late2 == null");

}

try {

if (Integer.parseInt(lines.getLines().get(2).getDepTimeDeviation()) > 0){

labelLate3.setText("+" + lines.getLines().get(2).getDepTimeDeviation());

}

else{

labelLate3.setText("");

}

if (lines.getLines().get(2).getDepTimeDeviation() == null){

labelLate3.setText("");

}

} catch (NumberFormatException e1) {

// TODO Auto-generated catch block

//e1.printStackTrace();

System.out.println("late3 == null");

}

try {

if (Integer.parseInt(lines.getLines().get(3).getDepTimeDeviation()) > 0){

labelLate4.setText("+" + lines.getLines().get(3).getDepTimeDeviation());

}

else{

labelLate4.setText("");

}

if (lines.getLines().get(3).getDepTimeDeviation() == null){

labelLate4.setText("");

}

} catch (NumberFormatException e) {

// TODO Auto-generated catch block

//e.printStackTrace();

System.out.println("late4 == null");

}
}

public String FixThatClock(int time){

String zero = "";

if (time < 10) {

zero = "0";

}

String finalTimeString = zero + Integer.toString(time);

zero = "";

return finalTimeString;

}
}
