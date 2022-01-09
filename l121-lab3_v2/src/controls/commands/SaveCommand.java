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
 Nom du fichier: 				    SaveCommand.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package controls.commands;

import models.Perspective;
import models.serialization.ImageSerializer;

import java.io.File;
import java.io.IOException;

/**
 * Represents an executable, reusable command to save a perspective.
 * @author Daniel Lanthier
 * @version 1.0
 * @since 1.0
 */
public class SaveCommand extends BaseCommand {

	//Fields
	private File filePath;

	public SaveCommand(Perspective _perspective, File _filePath) {
		super(_perspective);
		this.filePath = _filePath;
	}

	/**
	 * Executes the logic for saving a perspective.
	 */
	@Override
	public void execute() {
		try {
			ImageSerializer.writeImagePerspective(perspective, filePath);
		} catch(IOException io) {
			io.printStackTrace();
		}

	}

}
