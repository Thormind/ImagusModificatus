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
 Nom du fichier: 				  ImageSerializer.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package models.serialization;


import models.ImageProperties;
import models.Perspective;

import javax.imageio.ImageIO;
import java.io.*;

/**
 * Represents an object which handles I/O of images.
 * @author Daniel Lanthier
 * @version 1.0
 * @since 1.0
 */
public class ImageSerializer {

    private ImageSerializer(){}

    /**
     * Writes an Image object to file for later use.
     * @param p Image Perspective to be saved
     * @throws IOException if the file does not exist
     */
    public static void writeImagePerspective(Perspective p, File filePath) throws IOException {
        //Writers
        filePath.createNewFile();
        FileOutputStream fileOut = new FileOutputStream(filePath, false);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(p);

        objectOut.close();
        fileOut.close();
    }

    /**
     * Reads a .png or .ser file into the program.
     * @param filePath FilePath to image to be read
     * @return Instance object constructed from file
     * @throws IOException if @filePath does not exist
     */
    public static void readImage(File filePath, Perspective p) throws IOException, ClassNotFoundException {
        switch(getExtension(filePath)) {
            case PNG -> readPNGImage(filePath, p);
            case SER -> readSERImage(filePath, p);
        }
    }

    /**
     * Reads a .png file into the program.
     * @param filePath FilePath to image to be read
     * @return Instance object constructed from file
     * @throws IOException if @filePath does not exist
     */
    private static void readPNGImage(File filePath, Perspective p) throws IOException {
        p.setImage(ImageIO.read(filePath));
        p.setProperties(new ImageProperties());
    }

    /**
     * Reads a .ser file into the program.
     * @param filePath FilePath to image to be read
     * @return Instance object constructed from file
     * @throws IOException if @filePath does not exist
     * @throws ClassNotFoundException if the object cannot be reconstructed
     */
    private static void readSERImage(File filePath, Perspective p) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filePath);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        Perspective backup = (Perspective) objectIn.readObject();

        p.setImage(backup.getImage());
        p.setProperties(backup.getProperties());
    }

    /**
     * Gets the file extension of a given file.
     * @param file File to get the extension of
     * @return The extension of the file as an enum of accepted extensions
     */
    private static FileExtension getExtension(File file) {
        return FileExtension.valueOf(file.getPath().split("\\.")[1].toUpperCase());
    }
}
