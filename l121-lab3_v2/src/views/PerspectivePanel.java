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
 Nom du fichier: 			      PerspectivePanel.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package views;

import java.awt.*;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import controls.actions.TranslateAction;
import models.ImageProperties;
import models.Perspective;

/**
 * Represents a dynamic view of a changing image.
 * @author Charles-Antoine Barriere
 * @version 1.0
 * @since 1.0
 */
public class PerspectivePanel extends JPanel implements PropertyChangeListener{

	//Fields
	private final Perspective perspective;

	/**
	 * Creates a panel to show the modifications on the image in the perspective.
	 * @param perspective the perspective containing the image and modifications to display
	 * @param t The action to call when the mouse launches an event in the panel
	 * @param mwl the action to call when the mouse wheel launches an action in the panel
	 */
	public PerspectivePanel(Perspective perspective, TranslateAction t, MouseWheelListener mwl) {
		this.perspective = perspective;
		perspective.addObserver(this);
		setBounds(265, 11, 709, 759);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		addMouseListener(t);
		addMouseMotionListener(t);
		addMouseWheelListener(mwl);
	}

	/**
	 * Called on repaint, specifies how to redraw the image perspective from the model.
	 * @param g graphical context of the panel
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = perspective.getImage();
		ImageProperties properties = perspective.getProperties();
		if (img != null) {
			int width = getWidth();
			int height = getHeight();
			double zoom = perspective.getProperties().getZoom();
			int x = properties.getPosition().x;
			int y = properties.getPosition().y;

			Graphics2D g2 = (Graphics2D) g;
			g2.translate(width/2, height/2);
			g2.scale(zoom, zoom);
			g2.translate(-width/2, -height/2);
			img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			g2.drawImage(img, x, y, this);
		}
	}

	/**
	 * Action triggered by the change in the model.
	 * @param evt event triggered by the modification in the model
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName() == "Perspective") {
			repaint();
		}
	}
}
