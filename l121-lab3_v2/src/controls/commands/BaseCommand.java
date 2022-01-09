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
 Nom du fichier: 				    BaseCommand.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Ajoute l'entete de fichier (et2)
 *******************************************************/

package controls.commands;

import models.Perspective;

/**
 * An abstraction of all the commands a user can do with this program.
 * Contains the perspective to be modified by most commands.
 * @author Frederic Belanger
 * @version 1.0
 * @since 1.0
 */
public abstract class BaseCommand implements Command{
	//Fields
	protected final Perspective perspective;

	/**
	 * Super class constructor
	 * @param perspective Reference to perspective to modify.
	 */
	public BaseCommand(Perspective perspective) {
		this.perspective = perspective;
	}
}
