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
 Nom du fichier: 					  PasteAction.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package controls.actions;

import controls.AvailableCommands;
import controls.PasteOptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Represents the action of pasting
 * properties onto a perspective.
 * @author Maxim Luchianciuc
 * @version 1.0
 * @since 1.0
 */
public class PasteAction extends Action {
    
	//Fields
	private PasteOptions option;

   public PasteAction() {
     super(AvailableCommands.PASTE);
   }

  /**
   * Returns the selected paste option.
   * @return Option code
   */
	public PasteOptions getOption() {
		return option;
	}

  /**
   * Callback for when a paste action is performed.
   * @param e Description of the action event
   */
	@Override
  public void actionPerformed(ActionEvent e) {
      option = getSelection();

      if (option != PasteOptions.CANCELED_OPERATION)
          execute();
  }

  /**
   * Shows a dialog for the user to select
   * a paste option.
   * @return Selection code
   */
  private PasteOptions getSelection() {

    JPanel p = new JPanel();

    ButtonGroup bGroup = new ButtonGroup();
    JRadioButton s1 = new JRadioButton("All");
    JRadioButton s2 = new JRadioButton("Zoom Only");
    JRadioButton s3 = new JRadioButton("Translate Only");

    bGroup.add(s1);
    bGroup.add(s2);
    bGroup.add(s3);
    s1.setSelected(true);

    p.setLayout(new GridLayout(0, 1));
    p.add(new JLabel("Choose your paste option"));
    p.add(s1);
    p.add(s2);
    p.add(s3);

    int result = JOptionPane.showConfirmDialog(null, p, "PasteTypeSelection", JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
      if (s2.isSelected()) {
        return PasteOptions.PASTE_ZOOM_ONLY;
      } else if (s3.isSelected()) {
        return PasteOptions.PASTE_TRANSLATE_ONY;
      } else {
        return PasteOptions.PASTE_ALL;
      }
    } else {
      return PasteOptions.CANCELED_OPERATION;
    }
  }
}
