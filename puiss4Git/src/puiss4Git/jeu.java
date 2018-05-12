package puiss4Git;

import java.util.Scanner;

public class jeu {
	public final static int VIDE = 0;
	public final static int JAUNE = 1;
	public final static int ROUGE= 2;
	

	
	public static void run(plateau grillee)
	{
		
		 Scanner clavier = new Scanner(System.in);
		grillee.initialise();
		grillee.affiche();

		System.out.println("taille des ligne "+plateau.grille.length);
		int couleurJoueur= JAUNE;
		boolean valide,gagner;
		
		do {
		
			if(couleurJoueur == JAUNE) {
				System.out.println("Joueur J : entrez un numéro de colonne");
			}
			else  {
				System.out.println("Joueur R : entrez un numéro de colonne");
			}
			
			int colonne = clavier.nextInt();
			--colonne;
			
			 valide = grillee.joue(plateau.grille,colonne,couleurJoueur);
			if(!valide) {
				System.out.println("le coup n'est pas valide");
			}
			grillee.affiche();
			
		gagner = grillee.estCeGagne(plateau.grille , couleurJoueur);
			if(gagner)
			{
				System.out.println("bravo vous avez gagner "+ couleurJoueur);
			}
			
		
			if (couleurJoueur == JAUNE) {
				couleurJoueur = ROUGE;
			} else { 
				couleurJoueur = JAUNE;
			}
		
		} while (valide && !gagner);
		
		
		
			}
		
		
	}	

	
	
