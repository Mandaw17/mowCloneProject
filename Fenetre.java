//package mowClone;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame{
	private JPanel p_nord,p_centre, p_sud; 
	private JTextArea tA,pP;
	private JMenuBar jmb;
	private JLabel l_Titre;
	public Fenetre() {
		this.setTitle("CI/UGB"); 
		this.setLayout(new BorderLayout());
		//this.setLayout(new BorderLayout());
		this.setSize(1000, 1000);
		p_nord = new JPanel();
		l_Titre = new JLabel("Formulaire d'authentification"); 
		l_Titre.setFont(new Font(null, Font.BOLD, 15)); 
		l_Titre.setForeground(Color.WHITE); 
		p_nord.setBackground(Color.darkGray); 
		p_nord.add(l_Titre); 
		this.add(p_nord, BorderLayout.NORTH);
		//p_nord.add(tA);
		jmb = new JMenuBar();
		jmb.setBackground(Color.GRAY);
		//jmb.setSize(5,100);
		JMenu fichier = new JMenu("Fichier");
		JMenu edit = new JMenu("Edit");
		JMenuItem nouveau = new JMenuItem("New");
		//JMenuItem newMenuItem = new JMenuItem("New");
      	nouveau.setMnemonic(KeyEvent.VK_N);
      	nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
      	nouveau.setActionCommand("New");
		JMenuItem enregistrer = new JMenuItem("Save");
		enregistrer.setMnemonic(KeyEvent.VK_S);
		enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
      	enregistrer.setActionCommand("Save");
		JMenuItem copier = new JMenuItem("Copy");
		copier.setMnemonic(KeyEvent.VK_C);
		copier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
		copier.setActionCommand("Copy");
		JMenuItem coller = new JMenuItem("Paste");
		coller.setMnemonic(KeyEvent.VK_V);
		coller.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
		coller.setActionCommand("Paste");

		MenuItemListener menuItemListener = new MenuItemListener();
		nouveau.addActionListener(menuItemListener);
		enregistrer.addActionListener(menuItemListener);
		copier.addActionListener(menuItemListener);
		coller.addActionListener(menuItemListener);
		fichier.add(nouveau);fichier.add(enregistrer);
		edit.add(copier);edit.add(coller);
		jmb.add(edit);
		jmb.add(fichier);
		this.setJMenuBar(jmb);
		
		p_centre=new JPanel(new GridLayout(1,1)); 
		tA = new JTextArea(30,30);
		pP = new JTextArea();
		//p_sud= new JPanel(); 
		//this.add(p_nord, BorderLayout.NORTH);
		p_centre.add(tA);
		this.add(p_centre,BorderLayout.CENTER);
		//this.add(p_sud,BorderLayout.SOUTH);
		this.setVisible(true);

	}
	


	class MenuItemListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {            
         //tA.setText(e.getActionCommand() + " JMenuItem clicked.");
         if (e.getActionCommand() == "New") {
         	Fenetre p = new Fenetre();
         }
         if (e.getActionCommand() == "Copy") {
         	pP.setText(tA.getSelectedText());
         }
         if (e.getActionCommand() == "Paste") {
         	tA.append(pP.getText());
         }
         if (e.getActionCommand() == "Save"){
         	
         }
      }    
   	}

	public static void main(String[] args) {
		Fenetre fen = new Fenetre();
	}
}

