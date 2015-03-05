import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;


public class HumansAndDogsGUI extends JFrame {
Human human;
private JPanel contentPane;
private JTextField textField;
private JTextField textField_1;
private JTextArea textArea;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
HumansAndDogsGUI frame = new HumansAndDogsGUI();
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
public HumansAndDogsGUI() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 450, 300);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

textField = new JTextField();
textField.setBounds(23, 24, 134, 28);
contentPane.add(textField);
textField.setColumns(10);

textField_1 = new JTextField();
textField_1.setBounds(23, 66, 134, 28);
contentPane.add(textField_1);
textField_1.setColumns(10);

final JTextArea textArea = new JTextArea();
textArea.setBounds(23, 147, 340, 46);
contentPane.add(textArea);

final JTextArea textArea_1 = new JTextArea();
textArea_1.setBounds(23, 226, 340, 46);
contentPane.add(textArea_1);


JButton btnNewButton = new JButton("New Human");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	
human = new Human(textField.getText());
textArea_1.setText(human.getError());

}
});
btnNewButton.setBounds(189, 25, 117, 29);
contentPane.add(btnNewButton);

JButton btnNewDog = new JButton("Buy Dog");
btnNewDog.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
if(human==null){
textArea_1.setText("Must have human owner"); // Visar felmeddelande i GUI:n om hunden ej har ägare
System.out.println("no owner"); // Visar meddelande i "console" att det fattas ägare

}else{
human.buyDog (new Dog (textField_1.getText())); // Om hunden har en ägare så skriva namnet ut i GUI:n
}

}
});
btnNewDog.setBounds(189, 65, 117, 29);
contentPane.add(btnNewDog);

// Förstår inte Print info funktionen, har jag lagt in den rätt? Hur ska den fungera?

JButton btnPrintInfo = new JButton("Print Info");
btnPrintInfo.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
if(human.getError()!=null){

System.out.println("error"); 

}else{
textArea.append(human.getInfo() + "\n");
}
}

});
btnPrintInfo.setBounds(189, 106, 117, 29);
contentPane.add(btnPrintInfo);



JLabel lblInfo = new JLabel("Info");
lblInfo.setBounds(23, 127, 61, 16);
contentPane.add(lblInfo);


JLabel lblErrorMessage = new JLabel("Error message");
lblErrorMessage.setBounds(23, 205, 89, 16);
contentPane.add(lblErrorMessage);
}
} 