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
 Nom du fichier: 				    UndoCommand.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package controls.commands;

import controls.CommandManager;
import models.Perspective;

/**
 * A command that asks the command manager to undo the last command
 * that can be undone.
 * @author Frederic
 * @version 1.0
 * @since 1.0
 */
public class UndoCommand extends BaseCommand{

	public UndoCommand(Perspective perspective) {
		super(perspective);
	}

	/**
	 * Asks the command manager to undo the last command
	 * that can be undone.
	 */
	@Override
	public void execute() {
		CommandManager.getInstance().undo();
	}

}
