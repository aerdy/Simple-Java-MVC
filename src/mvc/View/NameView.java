/*
 *  Copyright 2009 Eko Kurniawan Khannedy.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
 
package mvc.View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import mvc.Control.NameController;
import mvc.Model.NameModel;
import mvc.Model.event.NameListener;

public class NameView extends JPanel implements NameListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8348206426627842174L;
	private NameModel model;
	private NameController controller;
	
	private JTextField textFieldFirstName;
	private JTextField textFieldMiddleName;
	private JTextField textFieldLastName;

	public JTextField getTextFieldFirstName() {
		return textFieldFirstName;
	}

	public JTextField getTextFieldMiddleName() {
		return textFieldMiddleName;
	}

	public JTextField getTextFieldLastName() {
		return textFieldLastName;
	}

	/**
	 * Create the panel.
	 */
	public NameView() {
		
		controller = new NameController();
		model = new NameModel();
		model.setNameListener(this);
		controller.setModel(model);
		
		setLayout(null);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(32, 85, 57, 14);
		add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(31, 29, 58, 14);
		add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name :");
		lblMiddleName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMiddleName.setBounds(17, 57, 72, 14);
		add(lblMiddleName);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(99, 26, 136, 20);
		add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldMiddleName = new JTextField();
		textFieldMiddleName.setBounds(99, 54, 136, 20);
		add(textFieldMiddleName);
		textFieldMiddleName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setText("");
		textFieldLastName.setBounds(99, 82, 136, 20);
		add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
            private NameView view;
			public void actionPerformed(ActionEvent e) {
				controller.resetForm(view);
			}
		});
		btnReset.setBounds(163, 131, 72, 23);
		add(btnReset);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.submitForm(this);
			}
		});
		btnSubmit.setBounds(80, 131, 72, 23);
		add(btnSubmit);

	}

	@Override
	public void onChange(NameModel model) {
		textFieldFirstName.setText(model.getFirstName());
		textFieldMiddleName.setText(model.getMiddleName());
		textFieldLastName.setText(model.getLastName());		
	}
}
