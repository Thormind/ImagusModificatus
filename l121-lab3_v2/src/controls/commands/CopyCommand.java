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
 Nom du fichier: 				    CopyCommand.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package controls.commands;

import models.CopyBuffer;
import models.ImageProperties;
import models.Perspective;

/**
 * Represents an executable copy command.
 * @author Maxim Luchianciuc
 * @version 1.0
 * @since 1.0
 */
public class CopyCommand extends BaseCommand {

	//Fields
	private final CopyBuffer clipboard;

	public CopyCommand(Perspective perspective) {
		super(perspective);
		clipboard = CopyBuffer.getInstance();
	}

	/**
	 * Executable command method for copy.
	 */
	@Override
	public void execute() {
		ImageProperties ref = perspective.getProperties();
		ImageProperties copy = new ImageProperties();
		copy.setPosition(ref.getPosition());
		copy.setZoom(ref.getZoom());
		clipboard.setBufferedProperties(copy);
	}

}





