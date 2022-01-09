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
 Nom du fichier: 				    CopyBuffer.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package models;

/**
 * Represents the buffer for copied and pasted ImageProperties, as a Singleton.
 * @author Maxim Luchianciuc
 * @version 1.0
 * @since 1.0
 */
public class CopyBuffer {
	//Fields
    private static CopyBuffer singleInstance = null;
    private ImageProperties bufferedProperties;

    private CopyBuffer(){}

    /**
     * Returns the sole instance of the CopyBuffer, creating it if needed
     * @return sole instance of CopyBuffer
     */
    public synchronized static CopyBuffer getInstance(){
        if(singleInstance == null)
        	singleInstance = new CopyBuffer();
        return singleInstance;
    }

    /**
     * Returns the last copied ImageProperties object
     * @return last copied properties
     */
    public ImageProperties getBufferedProperties() {
        return bufferedProperties;
    }

    /**
     * Sets the last copy of ImageProperties copied from a perspective
     * @param bufferedProperties last copied properties
     */
    public void setBufferedProperties(ImageProperties bufferedProperties) {
        this.bufferedProperties = bufferedProperties;
    }

}
