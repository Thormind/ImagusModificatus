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
 Nom du fichier: 				    ZoomAction.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package controls.actions;


import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import controls.AvailableCommands;
/**
 * Represents the action of zooming in and out of a perspective.
 * @author Daniel Lanthier
 * @version 1.0
 * @since 1.0
 */
public class ZoomAction extends Action implements MouseWheelListener {
	//Fields
	private double magnitudeShift;

	public ZoomAction() {
		super(AvailableCommands.ZOOM);
	}

	/**
	 * Returns the magnitude by which this
	 * perspective is modified.
	 * @return Shift in magnitude to be applied
	 */
	public double getMagnitudeShift() { return magnitudeShift; }

	/**
	 * Callback for when the mouse wheel is used.
	 * @param e Description of the mouse wheel event
	 */
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		magnitudeShift = -e.getWheelRotation()/10.0;
		execute();
	}

	/**
	 * Callback for when a zoom action is performed.
	 * @param e Description of the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Unused
	}
}
