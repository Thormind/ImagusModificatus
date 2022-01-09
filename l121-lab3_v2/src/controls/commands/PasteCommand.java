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
 Nom du fichier: 				    PasteCommand.java
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
import controls.PasteOptions;
import models.CopyBuffer;
import models.ImageProperties;
import models.Perspective;

/**
 * Represents an executable paste command.
 * @author Maxim Luchianciuc
 * @version 1.0
 * @since 1.0
 */
public class PasteCommand extends UndoableCommand {

    //Fields
	  private PasteOptions option;
    private CopyBuffer clipboard;
    private ImageProperties undoCopy = new ImageProperties();

    public PasteCommand(Perspective perspective, PasteOptions option) {
        super(perspective);
        this.option = option;
        clipboard = CopyBuffer.getInstance();
    }

    /**
     * Executable command method for paste.
     */
    @Override
    public void execute() {
        //Backup current properties
        ImageProperties backupProperties = perspective.getProperties();
        undoCopy.setZoom(backupProperties.getZoom());
        undoCopy.setPosition(backupProperties.getPosition());

        //Extract new properties from clipboard
        ImageProperties paste = clipboard.getBufferedProperties();

        //Apply new properties to perpective
        applyProperties(paste);

        CommandManager.getInstance().pushToUndoStack(this);
    }

    /**
     * Executable undo of copy command.
     */
    @Override
    public void undo() {
        //Extract backup properties
        ImageProperties undoProperties = new ImageProperties();
        undoProperties.setPosition(undoCopy.getPosition());
        undoProperties.setZoom(undoCopy.getZoom());

        //Backup current properties
        ImageProperties currBackup = perspective.getProperties();
        undoCopy.setZoom(currBackup.getZoom());
        undoCopy.setPosition(currBackup.getPosition());

        //apply backup properties to perspective
        applyProperties(undoProperties);

        CommandManager.getInstance().pushToRedoStack(this);
    }

    /**
     * Applies given properties to the perspective,
     * according to selected paste option.
     * @param prop Properties to apply
     */
    private void applyProperties(ImageProperties prop) {
        switch (option) {
            case PASTE_ALL -> perspective.setProperties(prop);
            case PASTE_ZOOM_ONLY -> perspective.setZoom(prop.getZoom());
            case PASTE_TRANSLATE_ONY -> perspective.setPosition(prop.getPosition());
        }
    }

}
