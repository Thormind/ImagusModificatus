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
 Nom du fichier: 				    Perspective.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package models;


import controls.CommandManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;

/**
 * Represents an image perspective, which can be modified.
 * @author Daniel Lanthier
 * @version 1.0
 * @since 1.0
 */
public class Perspective implements Serializable {

	//Fields
	private ImageProperties properties;
	private transient BufferedImage image;
	private transient PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public Perspective() {
		this.properties = new ImageProperties();
	}

	/**
	 * Method to customize writing of this object to file.
	 * @param obj Writer object
	 * @throws IOException when writing to file is not possible
	 */
	@Serial
	private void writeObject(ObjectOutputStream obj) throws IOException {
		obj.defaultWriteObject();
		ImageIO.write(image, "png", obj);
	}

	/**
	 * Method to customize reading of an object from file.
	 * @param obj Reader object
	 * @throws IOException when reading from file is not possible
	 * @throws ClassNotFoundException when creating an object of this type is not possible
	 */
	@Serial
	private void readObject(ObjectInputStream obj) throws IOException, ClassNotFoundException {
		obj.defaultReadObject();
		image = ImageIO.read(obj);
	}

	/**
	 * Increases or decreases image's zoom factor.
	 * @param zoomFactor Percent amount to modify
	 */
	public void modifyZoom(double zoomFactor) {
		this.properties.addToZoom(zoomFactor);
		updatePerspective(null);
	}

	/**
	 * Sets the image's zoom to a given value.
	 * @param zoom Zoom percentage to set to
	 */
	public void setZoom(double zoom) {
		this.properties.setZoom(zoom);
		updatePerspective(null);
	}

	/**
	 * Increments or decrements this image's position values.
	 * @param xShift Amount to shift x by
	 * @param yShift Amount to shift y by
	 */
	public void modifyPosition(int xShift, int yShift) {
		this.properties.addToPos(xShift, yShift);
		updatePerspective(null);
	}

	/**
	 * Sets the image's position to a given point.
	 * @param pos Point to set as images origin
	 */
	public void setPosition(Point pos) {
		this.properties.setPosition(pos);
		updatePerspective(null);
	}

	/**
	 * Sets the image for this perspective
	 * @param _image Image to be set
	 */
	public void setImage(BufferedImage _image) {
		this.image = _image;
		updatePerspective("new");
		CommandManager.getInstance().resetStacks();
	}

	/**
	 * Returns this perspective's image
	 * @return Image to be returned
	 */
	public BufferedImage getImage()
	{
		return this.image;
	}

	/**
	 * Sets this image's properties.
	 * (Used for copy/paste)
	 * @param _imageProperties new zoom/shift settings
	 */
	public void setProperties(ImageProperties _imageProperties) {
		this.properties = _imageProperties;
		updatePerspective(null);
	}

	/**
	 * Returns this image's properties.
	 * (Used for copy/paste)
	 * @return this image's properties
	 */
	public ImageProperties getProperties()
	{
		return this.properties;
	}

	/**
	 * Adds an observer to be notified when this
	 * instance's properties are modified.
	 * @param listener Object to observe this instance.
	 */
	public void addObserver(PropertyChangeListener listener)
	{
		pcs.addPropertyChangeListener("Perspective", listener);
	}

	/**
	 * Notify observers.
	 * @param str Updated value
	 */
	private void updatePerspective(String str)
	{
			pcs.firePropertyChange("Perspective", null, str);
	}
}
