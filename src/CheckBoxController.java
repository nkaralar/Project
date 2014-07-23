/*
 * author: Nazli Karalar
 */

/**
 * This class checks if checkBoxes are selected
 * If boxes[1] is selected, then isSelected[1] will be true
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

public class CheckBoxController implements ActionListener {
	private JCheckBox boxes[];
	public boolean isSelected[];

	public CheckBoxController() {
		boxes = new JCheckBox[5];
		boxes = View.boxes;
	}

	public void actionPerformed(ActionEvent e) {
		// keeps if this box is selected
		isSelected = new boolean[5];
		for (int i = 0; i < boxes.length; i++) {
			isSelected[i] = boxes[i].isSelected();
		}

	}

	public boolean[] getIsSelected() {
		return isSelected;
	}

}
