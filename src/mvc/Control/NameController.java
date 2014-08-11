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

package mvc.Control;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import mvc.Model.NameModel;
import mvc.View.NameView;


public class NameController {
	private NameModel model;
	
	public void setModel(NameModel model) {
		this.model = model;
	}
	public void resetForm(NameView view){
		String firstName = view.getTextFieldFirstName().getText();
		String middleName = view.getTextFieldMiddleName().getText();
		String lastName = view.getTextFieldLastName().getText();
		
		if(firstName.equals("") && middleName.equals("") && lastName.equals("")){
			
		}else
			model.resetForm();
	}
	public void submitForm(NameView view){
		String firstName = view.getTextFieldFirstName().getText();
		String middleName = view.getTextFieldMiddleName().getText();
		String lastName = view.getTextFieldLastName().getText();
		
		if(firstName.trim().equals(""))
			JOptionPane.showMessageDialog(view, "Firstname is empty");
		else if(middleName.trim().equals(""))
			JOptionPane.showMessageDialog(view, "Middlename is empty");
		else if(lastName.trim().equals(""))
			JOptionPane.showMessageDialog(view, "Lastname is empty");
			
		else
			model.submitForm();
	}

    public void submitForm(ActionListener aThis) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
