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
 Nom du fichier: 				    ImagePanel.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package views;

import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import models.Perspective;

/**
 * Represents a still-view of an image.
 * @author Charles-Antoine Barriere
 * @version 1.0
 * @since 1.0
 */
public class ImagePanel extends JPanel implements PropertyChangeListener {
	//Fields
	Perspective perspective;

	/**
	 * Create an ImagePanel and add a listener on the perspective parameter.
	 * @param perspective the perspective displayed in the perspective panel. Will display the image without modifications
	 */
	public ImagePanel(Perspective perspective) {
		this.perspective = perspective;
		perspective.addObserver(this);
		setBounds(10, 11, 245, 244);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	}

	/**
	 * Action triggered by the change in the model.
	 * @param evt event triggered by the modification in the model
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("Perspective") && evt.getNewValue() == "new") {
			repaint();
		}
	}

	/**
	 * Called on repaint, specifies how to redraw the original image from the model.
	 * @param g graphical context of the panel
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (perspective.getImage() != null) {
			Image img = perspective.getImage().getScaledInstance(getWidth(), getWidth(), Image.SCALE_SMOOTH);
			g.drawImage(img, 0, 0, this); // see javadoc for more info on the parameters
		}
	}
}
