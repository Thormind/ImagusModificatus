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
 Nom du fichier: 				    MainWindow.java
 Date cree: 								2021-03-13
 *******************************************************
 Historique des modifications
 *******************************************************
 2021-03-13 Version initiale (et1)
 2021-03-22 Complete le code (et2)
 2021-03-22 Ajoute l'entete de fichier (et3)
 *******************************************************/

package views;

import javax.swing.*;

import controls.actions.CopyAction;
import controls.actions.LoadAction;
import controls.actions.PasteAction;
import controls.actions.RedoAction;
import controls.actions.SaveAction;
import controls.actions.TranslateAction;
import controls.actions.UndoAction;
import controls.actions.ZoomAction;
import models.Perspective;

import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Main window used by the application.
 * @author Charles-Antoine Barriere
 * @version 1.0
 * @since 1.0
 */
public class MainWindow extends JFrame {
	
	// Fields
	private final String SHORTCUTS_TEXT="Shortcuts : \n" +
			"[CTRL] + S : Save \n" +
			"[CTRL] + Z : Undo \n" +
			"[CTRL] + Y : Redo \n" +
			"[CTRL] + C : Copy \n" +
			"[CTRL] + V : Paste \n" +
			"";
	
	private Perspective perspective;
	
	private ZoomAction zoomAction;
	private TranslateAction translateAction;
	private SaveAction saveAction;
	private LoadAction loadAction;
	private CopyAction copyAction;
	private PasteAction pasteAction;
	private RedoAction redoAction;
	private UndoAction undoAction;
	
	//Actions
	private JPanel mainPanel;
	private JPanel perspectivePanel;
	private JPanel thumbnail; 
	private JPanel buttonPanel;
	private JButton saveButton;
	private JButton loadButton;
	private JButton undoButton;
	private JButton redoButton;
	private JTextArea textArea;
	private JSlider sliderSpeedTranslation;
	private JLabel lblSpeedTranslation;

	/**
	 * Custom constructor to create the Jframe.
	 */
	public MainWindow(String title, Perspective perspective) {
		super(title);
		this.perspective = perspective;
		
		initializeWindow();
		initializeActions();
		initializeThumbnail();
		initializePerspectivePanel();
		initializeButtons();
		initializeTranslationSpeedSlider();
		initializeTextArea();
		initializeListeners();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	/**
	 * Initialises the speed slider for the translation of the image.
	 */
	private void initializeTranslationSpeedSlider()
	{
		lblSpeedTranslation = new JLabel();
		lblSpeedTranslation.setText("Translation speed");
		sliderSpeedTranslation = new JSlider(JSlider.HORIZONTAL,1,10,5);
		sliderSpeedTranslation.addChangeListener(translateAction);
		sliderSpeedTranslation.setMajorTickSpacing(1);
		sliderSpeedTranslation.setPaintTicks(true);
		buttonPanel.add(lblSpeedTranslation);
		buttonPanel.add(sliderSpeedTranslation);
	}
	/**
	 * Initialises the main window.
	 */
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 820);
		setResizable(false);
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
	}
	/**
	 * Initialises the thumbnail image on the MainWindow.
	 */
	private void initializeThumbnail() {
		thumbnail = new ImagePanel(perspective);
		mainPanel.add(thumbnail);
	}
	/**
	 * Initialises the perspective panel on the MainWindow.
	 */
	private void initializePerspectivePanel() {
		perspectivePanel = new PerspectivePanel(perspective, translateAction, zoomAction);
		mainPanel.add(perspectivePanel);
	}
	/**
	 * Initialises the load, save, undo, redo buttons.
	 */
	private void initializeButtons() {
		buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 528, 245, 242);
		mainPanel.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		saveButton = new JButton("Save");
		buttonPanel.add(saveButton);
		
		loadButton = new JButton("Load");
		buttonPanel.add(loadButton);
		
		undoButton = new JButton("Undo");
		buttonPanel.add(undoButton);
		
		redoButton = new JButton("Redo");
		buttonPanel.add(redoButton);
	}
	/**
	 * Initialises the shortcut text display.
	 */
	private void initializeTextArea() {
		textArea = new JTextArea();
		textArea.setBounds(10, 295, 245, 190);
		textArea.setText(SHORTCUTS_TEXT);
		textArea.setEditable(false);
		mainPanel.add(textArea);
		
	}
	/**
	 * Instantiates the actions to be called by events.
	 */
	private void initializeActions()
	{
		zoomAction = new ZoomAction();
		translateAction = new TranslateAction();
		saveAction = new SaveAction();
		loadAction = new LoadAction();
		copyAction = new CopyAction();
		pasteAction = new PasteAction();
		redoAction = new RedoAction();
		undoAction = new UndoAction();
	}
	/**
	 * Sets the listeners for the load, save, undo, redo actions.
	 */
	private void initializeListeners()
	{
		//Button Listeners
		loadButton.addActionListener(loadAction);
		saveButton.addActionListener(saveAction);
		undoButton.addActionListener(undoAction);
		redoButton.addActionListener(redoAction);

		//Key Bindings
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK, false), "save");
		getRootPane().getActionMap().put("save", saveAction);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK, false), "copy");
		getRootPane().getActionMap().put("copy", copyAction);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK, false), "paste");
		getRootPane().getActionMap().put("paste", pasteAction);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK, false), "undo");
		getRootPane().getActionMap().put("undo", undoAction);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Y,InputEvent.CTRL_DOWN_MASK, false), "redo");
		getRootPane().getActionMap().put("redo", redoAction);
	}
}
