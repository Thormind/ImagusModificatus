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
 Nom du fichier: 				    TranslateAction.java
 Date cree: 								2021-03-13
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package controls.actions;


import java.awt.*;
import java.awt.event.*;

import controls.AvailableCommands;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Represents the action of translating an image
 * in a given direction.
 * @author Charles-Antoine Barriere
 * @version 1.0
 * @since 1.0
 */
public class TranslateAction extends Action implements MouseListener, MouseMotionListener, ChangeListener {

	//Constants
	private final int X_SHIFT_AMOUNT = 10;
	private final int Y_SHIFT_AMOUNT = 10;

	//Fields
	private float shiftSpeedModifier = .25f;
	private int xShift;
	private int yShift;
	private int initialX;
	private int initialY;
	private boolean dragging = false;

	public TranslateAction()
	{
		super(AvailableCommands.TRANSLATE);
	}

	/**
	 * Returns the amount by which
	 * the x coordinate is shifted.
 	 * @return Amount to shift x by
	 */
	public int getXshift() {
		return xShift;
	}

	/**
	 * Returns the amount by which
	 * the y coordinate is shifted.
	 * @return Amount to shift y by
	 */
	public int getYShift() {
		return yShift;
	}

	/**
	 * Callback for when a translate action is performed.
	 * @param e Description of the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Unused
	}

	/**
	 * Callback for when the mouse click is detected.
	 * @param e Description of the mouse event
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		//Unused
	}

	/**
	 * Callback for when the mouse is first pressed.
	 * @param e Description of the mouse event
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		dragging = true;
		initialX = e.getX();
		initialY = e.getY();
	}

	/**
	 * Callback for when the mouse button is released.
	 * @param e Description of the mouse event
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		dragging = false;
	}

	/**
	 * Callback for when the mouse
	 * enters the given component.
	 * @param e Description of the mouse event
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		//Unused
	}

	/**
	 * Callback for when the mouse
	 * exits the given component.
	 * @param e Description of the mouse event
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		//Unused
	}

	/**
	 * Callback for every time the mouse is dragged
	 * inside the given component.
	 * @param e Description of the mouse event
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		int xDiff = Math.abs(initialX - p.x);
		int yDiff = Math.abs(initialY - p.y);
		if (xDiff > yDiff) {
			if (initialX < e.getX()) {
				xShift += X_SHIFT_AMOUNT * shiftSpeedModifier;
			}	else {
				xShift -= X_SHIFT_AMOUNT * shiftSpeedModifier;
			}
		}	else {
			if (initialY < e.getY()) {
				yShift += Y_SHIFT_AMOUNT * shiftSpeedModifier;
			}	else {
				yShift -= Y_SHIFT_AMOUNT * shiftSpeedModifier;
			}
		}
		if (dragging)	{
			execute();
		}
	}

	/**
	 * Callback for every time the mouse is moved
	 * inside the given component.
	 * @param e Description of the mouse event
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		//Unused
	}

	/**
	 * Callback for every time the state
	 * of the given component is changed.
	 * @param e Description of the change event
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		var slider = (JSlider) e.getSource();
		
		if (slider.getValueIsAdjusting()) {
			shiftSpeedModifier = slider.getValue() * 0.1f;
		}
	}
}
