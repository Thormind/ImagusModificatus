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
 Nom du fichier: 				    CommandManager.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete les methodes undo() et redo() (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package controls;

import java.util.Stack;

import controls.actions.Action;
import controls.commands.Command;
import controls.commands.UndoableCommand;

/**
 * A singleton that manages all commands in the program.
 * Asks the factory to create a command from an action. Keeps and manages the
 * undo/redo list. 
 * @author  Frederic Belanger
 * @version 1.0
 * @since 1.0
 */
public class CommandManager {
	//Fields
	private static CommandManager singleInstance = null;

	//Stacks
	private static Stack<UndoableCommand> undoStack;
	private static Stack<UndoableCommand> redoStack;

	/**
	 * Private constructor so the class can not be instantiated.
	 */
	private CommandManager() {}

	/**
	 * Returns the single instance of this class. 
	 * Creates a new instance if it was not already created.  
	 * @return the single instance of this class
	 */
	public static CommandManager getInstance() {
		if (singleInstance == null) {
			singleInstance = new CommandManager();
			undoStack = new Stack<>();
			redoStack = new Stack<>();
		}

		return singleInstance;
	}

	/**
	 * Asks the command factory to create a command from an action and then executes it.
	 * @param anAction action triggered by the user
	 */
	public void execute(Action anAction) {
		Command command = CommandFactory.createCommand(anAction);
		command.execute();
	}

	/**
	 * Undo the first command of the undo stack.
	 */
	public void undo() {
		if(undoStack.size() > 0) {
			undoStack.pop().undo();
		}
	}

	/**
	 * Redo the first command of the redo stack.
	 */
	public void redo() {
		if(redoStack.size() > 0) {
			redoStack.pop().redo();
		}
	}

	/**
	 * Pushes a command to the undo stack.
	 * @param aCommand the command to push
	 */
	public void pushToUndoStack(UndoableCommand aCommand) {
		undoStack.push(aCommand);
	}

	/**
	 * Pushes a command to the redo stack.
	 * @param aCommand the command to push
	 */
	public void pushToRedoStack(UndoableCommand aCommand) {
		redoStack.push(aCommand);
	}

	/**
	 * Resets the undo and redo stack of commands.
	 */
	public void resetStacks(){
		undoStack.clear();
		redoStack.clear();
	}
}
