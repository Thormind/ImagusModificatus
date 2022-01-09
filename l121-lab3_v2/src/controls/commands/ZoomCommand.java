/******************************************************
 Cours:   									    LOG121
 Session: 									     H2021
 Groupe:  									        04
 Projet:								Laboratoire #3


 Etudiant(e)s:

 Charles-Antoine Barriere:	    BARC03119501
 Daniel Lanthier:					      LAND18099908
 Frederic Belanger:				      BELF31018006
 Maxim Luchianciuc:				      LUCM29089801

 Professeur : 									Simon Pichette
 Nom du fichier: 				     		ZoomCommand.java
 Date cree: 										2021-03-13
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
 * Represents an executable zoom command.
 * @author Daniel Lanthier
 * @version 1.0
 * @since 1.0
 */
public class ZoomCommand extends UndoableCommand {

	//Constants
	private final double MIN_ZOOM_FACTOR = 1.0;
	private final double MAX_ZOOM_FACTOR = 5.0;

	//Fields
	private double magnitudeShift;
	private final double zoom;

	public ZoomCommand(Perspective perspective, double _magnitudeShift, double _zoom) {
		super(perspective);
		this.magnitudeShift = _magnitudeShift;
		this.zoom = _zoom;
	}

	/**
	 * Executable command method for zoom.
	 */
	@Override
	public void execute() {
		if(magnitudeShift + zoom >= MIN_ZOOM_FACTOR && magnitudeShift + zoom <= MAX_ZOOM_FACTOR) {
			perspective.setZoom(magnitudeShift+zoom);
			CommandManager.getInstance().pushToUndoStack(this);
		}
		
	}

	/**
	 * Executable undo of zoom command.
	 */
	@Override
	public void undo() {
		perspective.modifyZoom(-magnitudeShift);
		CommandManager.getInstance().pushToRedoStack(this);
	}
}
