package fenetre_calcule;

import javax.swing.SwingUtilities;

public class Lancer {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculateurDeFacture().setVisible(true);
            }
        });
    }
}
