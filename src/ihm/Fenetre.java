package ihm;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Fenetre extends JFrame {
	
	JMenuBar menuBar = new JMenuBar();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Fenetre() {

		//menu Create
		JMenu menuCreate = new JMenu("Create");
		menuBar.add(menuCreate);
		ImageIcon iconCreate1 = createImageIcon("/ressource/add_black.png", null);
		
		JMenuItem menuItemAvion = new JMenuItem("Nouvel Avion", iconCreate1);
		ActionListener a = null;
		menuItemAvion.addActionListener(a);
		menuCreate.add(menuItemAvion);
		JMenuItem menuItemPilote = new JMenuItem("Nouveau Pilote", iconCreate1);
		menuCreate.add(menuItemPilote);
		JMenuItem menuItemVol = new JMenuItem("Nouveau Vol", iconCreate1);
		menuCreate.add(menuItemVol);

		//menu Delete
		JMenu menu2 = new JMenu("Delete");
		menuBar.add(menu2);
		ImageIcon iconCreate2 = createImageIcon("/ressource/delete_black.png", null);
		menu2.add(new JMenuItem("Supprimer un  Avion", iconCreate2));
		menu2.add(new JMenuItem("Supprimer un  Pilote", iconCreate2));
		menu2.add(new JMenuItem("Supprimer un  Vol", iconCreate2));

		//menu Update
		JMenu menu3 = new JMenu("Update");
		menuBar.add(menu3);
		ImageIcon iconCreate3 = createImageIcon("/ressource/description_black.png", null);
		menu3.add(new JMenuItem("Modifier un  Avion", iconCreate3));
		menu3.add(new JMenuItem("Modifier un  Pilote", iconCreate3));
		menu3.add(new JMenuItem("Modifier un  Vol", iconCreate3));

		//menu Find
		JMenu menu4 = new JMenu("Find");
		menuBar.add(menu4);
		ImageIcon iconCreate4 = createImageIcon("/ressource/search_black.png", null);
		menu4.add(new JMenuItem("Trouver un  Avion", iconCreate4));
		menu4.add(new JMenuItem("Trouver un  Pilote", iconCreate4));
		menu4.add(new JMenuItem("Trouver un  Vol", iconCreate4));
		this.setJMenuBar(menuBar);

		//Parametre de la fenetre
		this.setTitle("Gestion de BD aeronautique");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}

	private ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

}
