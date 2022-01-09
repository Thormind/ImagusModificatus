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
 Nom du fichier: 				    UndoableCommand.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-22 Version initiale (et1)
 2021-03-22 Ajoute l'entete de fichier (et2)
 *******************************************************/

package controls.commands;

import models.Perspective;

/**
 * An abstraction of all the commands of this program that can be undone.
 * @author Frederic
 * @version 1.0
 * @since 1.0
 */
public abstract class UndoableCommand extends BaseCommand{

	public UndoableCommand(Perspective perspective) {
		super(perspective);
	}

	/**
	 * Defines what happens when this command is undone.
	 */
	public abstract void undo();

	/**
	 * Asks to "re-execute" this command.
	 */
	public void redo() {
		execute();
	}
}
