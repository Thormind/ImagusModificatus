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
 Nom du fichier: 				    CommandFactory.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Ajoute l'entete de fichier (et2)
 *******************************************************/

package controls;

import controls.actions.Action;
import controls.actions.CopyAction;
import controls.actions.LoadAction;
import controls.actions.PasteAction;
import controls.actions.RedoAction;
import controls.actions.SaveAction;
import controls.actions.TranslateAction;
import controls.actions.UndoAction;
import controls.actions.ZoomAction;
import controls.commands.Command;
import controls.commands.CopyCommand;
import controls.commands.LoadCommand;
import controls.commands.PasteCommand;
import controls.commands.RedoCommand;
import controls.commands.SaveCommand;
import controls.commands.TranslateCommand;
import controls.commands.UndoCommand;
import controls.commands.ZoomCommand;
import models.Perspective;

/**
 * A static class that creates a command based on the corresponding action.
 * @author  Frederic Belanger
 * @version 1.0
 * @since 1.0
 */
public class CommandFactory {
	// Fields
	private static Perspective perspective;

	/**
	 * Private constructor so the class can not be instantiated.
	 */
	private CommandFactory() {}

	/**
	 * Sets the perspective that will be modified by the commands.
	 * @param aPerspective the perspective to set
	 */
	public static void setPerspective(Perspective aPerspective) {perspective = aPerspective; }

	/**
	 * Creates a Command from the corresponding Action.
	 * @param anAction the Action from which to create the Command
	 * @return the created Command
	 */
	public static Command createCommand(Action anAction) {
		return switch (anAction.getActionName()) {
			case ZOOM -> createZoomCommand((ZoomAction) anAction);
			case TRANSLATE -> createTranslateCommand((TranslateAction) anAction);
			case SAVE -> createSaveCommand((SaveAction) anAction);
			case LOAD -> createLoadCommand((LoadAction) anAction);
			case COPY -> createCopyCommand();
			case PASTE -> createPasteCommand((PasteAction) anAction);
			case UNDO -> createUndoCommand();
			case REDO -> createRedoCommand();
		};
	}

	/**
	 * Creates a zoom command from a zoom action.
	 * @param action the zoom action from which to create the zoom command
	 * @return the created zoom command
	 */
	private static Command createZoomCommand(ZoomAction action) {
		return new ZoomCommand(perspective, action.getMagnitudeShift(),perspective.getProperties().getZoom());
	}

	/**
	 * Creates a translate command from a translate action.
	 * @param action the translate action from which to create the translate command
	 * @return the created translate command
	 */
	private static Command createTranslateCommand(TranslateAction action) {
		return new TranslateCommand(perspective, action.getXshift(), action.getYShift());
	}

	/**
	 * Creates a save command from a save action.
	 * @param action the save action from which to create the save command
	 * @return the created save command
	 */
	private static Command createSaveCommand(SaveAction action) {
		return new SaveCommand(perspective, action.getFilePath());
	}

	/**
	 * Creates a load command from a load action.
	 * @param action the load action from which to create the load command
	 * @return the created load command
	 */
	private static Command createLoadCommand(LoadAction action) {
		return new LoadCommand(perspective, action.getFilePath());
	}

	/**
	 * Creates a copy command from a copy action.
	 * @return the created copy command
	 */
	private static Command createCopyCommand() {
		return new CopyCommand(perspective);
	}

	/**
	 * Creates a paste command from a paste action.
	 * @param action the paste action from which to create the paste command
	 * @return the created paste command
	 */
	private static Command createPasteCommand(PasteAction action) {
		return new PasteCommand(perspective, action.getOption());
	}

	/**
	 * Creates a undo command from an undo action.
	 * @return the created undo command
	 */
	private static Command createUndoCommand() {
		return new UndoCommand(perspective);
	}

	/**
	 * Creates a redo command from a redo action.
	 * @return the created redo command
	 */
	private static Command createRedoCommand() {
		return new RedoCommand(perspective);
	}
}
