/******************************************************
 Cours:   									LOG121
 Session: 									H2021
 Groupe:  									04
 Projet:										Laboratoire #3


 Etudiant(e)s:

 Charles-Antoine Barriere:	BARC03119501
 Daniel Lanthier:						LAND18099908
 Frederic Belanger:					BELF31018006
 Maxim Luchianciuc:					LUCM29089801

 Professeur : 							Simon Pichette
 Nom du fichier: 						AvailableCommands.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package controls.actions;

import controls.AvailableCommands;

import java.awt.event.ActionEvent;

/**
 * Represents the copy action triggered by the key shortcut
 * @author Maxim Luchianciuc
 * @version 1.0
 * @since 1.0
 */
public class CopyAction extends Action {
	public CopyAction() {
		super(AvailableCommands.COPY);
	}

	/**
	 * Callback for when a copy action is performed.
	 * @param e Description of the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		execute();
	}
}
