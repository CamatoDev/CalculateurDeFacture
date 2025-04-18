package fenetre_calcule;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateurDeFacture extends JFrame implements ActionListener{

    // D�claration des composants graphiques
    private JTextField produitField, prixField, quantiteField;
    private JTable tableau;
    private DefaultTableModel model;
    JButton calculerButton;
    JButton ajouterButton;
    JButton payerButton;

    // Constructeur de la classe
    public CalculateurDeFacture() {
        // Configuration de la fen�tre principale
        setTitle("Calculateur de Facture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel pour saisir les produits, prix et quantit�
        JPanel saisiePanel = new JPanel(new GridLayout(4, 2));

        // Ajout des champs et des libell�s � saisiePanel
        saisiePanel.add(new JLabel("Produit:"));
        produitField = new JTextField();
        saisiePanel.add(produitField);

        saisiePanel.add(new JLabel("Prix:"));
        prixField = new JTextField();
        saisiePanel.add(prixField);

        saisiePanel.add(new JLabel("Quantit�:"));
        quantiteField = new JTextField();
        saisiePanel.add(quantiteField);

        // Bouton pour ajouter un produit
        ajouterButton = new JButton("Ajouter");
        ajouterButton.addActionListener(this);
            
        saisiePanel.add(ajouterButton);

        add(saisiePanel, BorderLayout.NORTH);

        // Tableau pour afficher les produits
        model = new DefaultTableModel();
        model.addColumn("Produit");
        model.addColumn("Prix");
        model.addColumn("Quantit�");
        model.addColumn("Montant Total");

        tableau = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableau);
        add(scrollPane, BorderLayout.CENTER);

        // Bouton pour calculer la facture
        calculerButton = new JButton("Calculer");
        calculerButton.addActionListener(this);
        
        add(calculerButton, BorderLayout.SOUTH);
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ajouterButton) {
			ajouterProduit();
		}
		if(e.getSource()==calculerButton) {
			afficherResultats();
		}
		if(e.getSource()==payerButton) {
			confirmerPaiement();
		}
	}
            

    // M�thode pour ajouter un produit au tableau
    private void ajouterProduit() {
    	String produit = produitField.getText();
        String prixText = prixField.getText();
        String quantiteText = quantiteField.getText();

        // V�rifier si tous les champs sont remplis
        if (produit.isEmpty() || prixText.isEmpty() || quantiteText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Champs manquants", JOptionPane.WARNING_MESSAGE);
            return; // Ne pas ajouter le produit si tous les champs ne sont pas remplis
        }

        try {
            double prix = Double.parseDouble(prixText);
            double quantite = Double.parseDouble(quantiteText);

            double montantTotal = prix * quantite;

            model.addRow(new Object[]{produit, prix, quantite, montantTotal});

            // Effacement des champs de saisie
            produitField.setText("");
            prixField.setText("");
            quantiteField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer des valeurs num�riques valides pour le prix et la quantit�.", "Format incorrect", JOptionPane.ERROR_MESSAGE);
        }
    }

    // M�thode pour afficher les r�sultats de la facture dans une nouvelle fen�tre
    private void afficherResultats() {
        // Cr�ation d'une nouvelle fen�tre
        JFrame resultatFrame = new JFrame("R�sultats de la Facture");
        resultatFrame.setSize(300, 200);
        setLocationRelativeTo(null);
        resultatFrame.setLayout(new BorderLayout());
        
        double montantTotalFacture = 0;

        // Calcul du montant total de la facture et construction du texte � afficher
        StringBuilder resultatText = new StringBuilder("R�capitulatif de la facture :\n");
        for (int row = 0; row < model.getRowCount(); row++) {
            String produit = (String) model.getValueAt(row, 0);
            double montantTotal = (double) model.getValueAt(row, 3);

            resultatText.append(String.format("%s: %.2f FCFA\n", produit, montantTotal));
            montantTotalFacture += montantTotal;
        }

        resultatText.append(String.format("\nMontant total de la facture: %.2f FCFA", montantTotalFacture));

        // Ajout d'une zone de texte � la fen�tre et affichage de la fen�tre
        JTextArea resultatArea = new JTextArea();
        resultatArea.setEditable(false);
        resultatArea.append(resultatText.toString());

        resultatFrame.add(resultatArea, BorderLayout.CENTER);
        
     // Ajout du bouton "Payer"
        payerButton = new JButton("Payer");
        payerButton.addActionListener(this);
        resultatFrame.add(payerButton, BorderLayout.SOUTH);
        
        resultatFrame.setVisible(true);
    }
    
 // Nouvelle m�thode pour confirmer le paiement
    private void confirmerPaiement() {
        int choix = JOptionPane.showConfirmDialog(this,
                "Confirmez-vous votre commande et souhaitez-vous proc�der au paiement?",
                "Confirmation de commande", JOptionPane.YES_NO_OPTION);

        if (choix == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Commande confirm�e. La livraison sera effectu�e.");
        } else {
            JOptionPane.showMessageDialog(this, "Commande non confirm�e. Aucun paiement effectu�.");
        }
    }
}

