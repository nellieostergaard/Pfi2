import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;


public class AnimalsGUI extends JFrame {
	
	Animal myAnimals;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalsGUI frame = new AnimalsGUI();
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
	public AnimalsGUI() {
		
		ArrayList<Animal> myAnimals = new ArrayList<Animal>();
	
		Cat cat = new Cat("lt. Felis catus, ", 66, 9);
		cat.setFriendlyName("Maja, ");
		Cat cat2 = new Cat ("lt. Felis catus, ", 70, 7);
		cat2.setFriendlyName("Moa, ");
		Snake snake = new Snake("lt. Anguis, ", false);
		snake.setFriendlyName("Martin, ");
		Snake snake2 = new Snake("lt. Anguis, ", true);
		snake2.setFriendlyName("Gustav, ");
		
		
		myAnimals.add(new Dog("Bosse", "lt. Canis lupus domesticus", 45, true));
		myAnimals.add(cat);
		myAnimals.add(snake);
		myAnimals.add(snake2);
		myAnimals.add(cat2);
		myAnimals.add(new Dog("Kalle", "lt. Canis lupus domesticus", 50, true));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 34, 434, 216);
		contentPane.add(textArea);
		
		for (int i = 0; i< myAnimals.size(); i++){
			textArea.append(myAnimals.get(i).getInfo() + "\n");
		}

		
		JLabel lblAnimalList = new JLabel("Animal List");
		lblAnimalList.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblAnimalList.setBounds(10, 11, 105, 14);
		contentPane.add(lblAnimalList);
	}
}
