/******************************************************
 Cours:   									    LOG121
 Session: 									     H2021
 Groupe:  									        04
 Projet:								Laboratoire #3


 Etudiant(e)s:

 Charles-Antoine Barriere:	BARC03119501
 Daniel Lanthier:					  LAND18099908
 Frederic Belanger:				  BELF31018006
 Maxim Luchianciuc:				  LUCM29089801

 Professeur : 							Simon Pichette
 Nom du fichier: 					  SaveAction.java
 Date cree: 								2021-03-13
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package controls.actions;

import controls.AvailableCommands;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Represents the action of saving a file to disk.
 * @author Daniel Lanthier
 * @version 1.0
 * @since 1.0
 */
public class SaveAction extends Action implements ActionListener
{
	//Fields
	private File filePath;

	public SaveAction() {
		super(AvailableCommands.SAVE);
	}

	/**
	 * Gets the path to the selected file.
	 * @return A file constructed from the file path.
	 */
	public File getFilePath() {
		return filePath;
	}

	/**
	 * Callback for when a save action is performed.
	 * @param e Description of the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(selectSaveFile()) execute();
	}

	/**
	 * Allows the user to select where to save the file.
	 * @return true if a file was saved, false otherwise
	 */
	private boolean selectSaveFile() {
		JFileChooser jfc = new JFileChooser();
		jfc.addChoosableFileFilter(new FileNameExtensionFilter("Saved Perspectives", "ser"));
		jfc.setAcceptAllFileFilterUsed(false);
		int returnValue = jfc.showSaveDialog(null);
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			filePath = jfc.getSelectedFile();
			if(!filePath.getPath().endsWith(".ser")) filePath = new File(filePath.getPath() + ".ser");
			return true;
		}
		return false;
	}
}
