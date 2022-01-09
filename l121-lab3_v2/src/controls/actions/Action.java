/******************************************************
 Cours:   									    LOG121
 Session: 									     H2021
 Groupe:  									        04
 Projet:								Laboratoire #3


 Etudiant(e)s:

 Charles-Antoine Barriere: BARC03119501
 Daniel Lanthier:					 LAND18099908
 Frederic Belanger:				 BELF31018006
 Maxim Luchianciuc:				 LUCM29089801

 Professeur : 						 Simon Pichette
 Nom du fichier: 					 Action.java
 Date cree: 							 2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Ajoute l'entete de fichier (et2)
 *******************************************************/

package controls.actions;

import controls.AvailableCommands;
import controls.CommandManager;
import views.MainWindow;

import javax.swing.*;

/**
 * An abstraction of all the actions a user can perform with the program.
 *
 * @author Frederic Belanger
 * @version 1.0
 * @since 2021-03-13
 */
public abstract class Action extends AbstractAction {
	//Fields
	private final AvailableCommands ACTION_NAME;

	/**
	 * Super class constructor
	 * @param commandName Name of command to create.
	 */
	public Action(AvailableCommands commandName) {
		this.ACTION_NAME = commandName;
	}

	/**
	 * Asks the command manager to execute an action.
	 */
	protected void execute() {
		CommandManager.getInstance().execute(this);
	}

	/**
	 * Returns the name of the action (from the available commands enumeration).
	 * @return the name of the action
	 */
	public AvailableCommands getActionName() { return ACTION_NAME; }
}
