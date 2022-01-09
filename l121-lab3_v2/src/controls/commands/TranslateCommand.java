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
 Nom du fichier: 				    TranslateCommand.java
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

import java.awt.*;

/**
 * Represents an executable translate command.
 * @author Daniel Lanthier
 * @version 1.0
 * @since 1.0
 */
public class TranslateCommand extends UndoableCommand {

	//Fields
	private Point oldPoint;
	private Point newPoint;


	public TranslateCommand(Perspective perspective, int xShift, int yShift) {
		super(perspective);
		newPoint = new Point(xShift,yShift);
	}

	/**
	 * Executable command method for translate.
	 */
	@Override
	public void execute() {
		oldPoint = perspective.getProperties().getPosition();
		perspective.setPosition(newPoint);
		CommandManager.getInstance().pushToUndoStack(this);
	}

	/**
	 * Executable undo of translate command.
	 */
	@Override
	public void undo() {
		perspective.setPosition(oldPoint);
		CommandManager.getInstance().pushToRedoStack(this);
	}
}
