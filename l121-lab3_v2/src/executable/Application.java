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
 Nom du fichier: 				    Application.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package executable;

import controls.CommandFactory;
import models.Perspective;
import views.MainWindow;

/**
 * Driver class to launch program.
 * @author  Frederic Belanger
 * @version 1.0
 * @since 1.0
 */
public class Application {
	/**
	 * Main method to launch program.
	 * @param args Arguments needed to launch program
	 */
	public static void main(String[] args) {
		Perspective perspective = new Perspective();
		CommandFactory.setPerspective(perspective);
		MainWindow mainWindow = new MainWindow("Imagus Modificatus",perspective);
		
	}
}
