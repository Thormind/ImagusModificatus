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
 Nom du fichier: 				    Command.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Ajoute l'entete de fichier (et2)
 *******************************************************/

package controls.commands;

/**
 * An interface that must be implemented by all the commands of this program.
 * @author Frederic Belanger
 * @version 1.0
 * @since 1.0
 */
public interface Command {

	/**
	 * Calls the execution of the command. 
	 */
	public void execute();
}
