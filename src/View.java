

/*
 * author: Nazli Karalar
 */

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class View {
	public static JCheckBox boxes[];

	public static void createFrame() {
		JFrame frame = new JFrame("Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setLayout(new GridLayout(1, 2));
		JPanel panel1 = new JPanel(); // for checkboxes
		JPanel panel2 = new JPanel(); // for textField and label
		frame.add(panel1);
		frame.add(panel2);

		createPanel1Feature(panel1);

		JPanel subPanel1 = new JPanel(); // for check button, it will be deleted
		subPanel1.setLayout(null);
		// button will be deleted
		JButton checkButton = new JButton("Check");
		checkButton.setSize(90, 40);
		subPanel1.add(checkButton);
		panel1.add(subPanel1);

		panel2.setLayout(new GridLayout(2, 1));
		createPanel2Feature(panel2);

		// It will be deleted, every checkBox will have actionListener
		checkButton.addActionListener(new CheckBoxController());

		frame.setVisible(true);

	}

	private static void createPanel2Feature(JPanel panel2) {
		JLabel label = new JLabel("news");
		JTextArea textField = new JTextArea();
		panel2.add(label);
		panel2.add(textField);
	}

	private static void createPanel1Feature(JPanel panel1) {
		panel1.setLayout(new GridLayout(7, 1));
		boxes = new JCheckBox[5];
		for (int i = 1; i < boxes.length + 1; i++) {
			boxes[i - 1] = new JCheckBox("Msg" + i, true);
			panel1.add(boxes[i - 1]);
		}
	}

}
