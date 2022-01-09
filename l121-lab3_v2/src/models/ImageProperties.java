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
 Nom du fichier: 				    ImageProperties.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package models;

import java.awt.*;
import java.io.Serializable;

/**
 * Represents properties of an image.
 * @author Daniel Lanthier
 * @version 1.0
 * @since 1.0
 */
public class ImageProperties implements Serializable {

    //Private fields
    private double zoom;
    private Point position;

    public ImageProperties() {
        this.position = new Point();
        this.zoom = 1.0;
    }

    /**
     * Returns the current zoom factor
     * @return value of zoom
     */
    public double getZoom() {
        return zoom;
    }

    /**
     * Sets the zoom to a specified amount.
     * @param _zoom Amount to set zoom to
     */
    public void setZoom(double _zoom) {
        this.zoom = _zoom;
    }

    /**
     * Increases or decreases the zoom factor.
     * @param factor Amount to modify factor by
     */
    public void addToZoom(double factor) {
        this.zoom += factor;
    }

    /**
     * Returns the current position
     * @return position Point
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Sets the position to a specified point.
     * @param pos Point to set as position
     */
    public void setPosition(Point pos) {
        this.position = pos;
    }

    /**
     * Translates this position.
     * @param xShift Amount to translate x by (dx)
     * @param yShift Amount to translate y by (dy)
     */
    public void addToPos(int xShift, int yShift) {
        position.translate(xShift, yShift);
    }


}
