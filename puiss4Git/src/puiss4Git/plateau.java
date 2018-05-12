package puiss4Git;
public class plateau {
	static int[][] grille ;
	public plateau()
	{
		this.grille = new int[6][7];
	}
	//initialisation de la grille
	public static void initialise()
	{
		int i=0,j=0;
		for(i = 0; i<grille.length;++i)
		{
			for(j=0;j< grille[i].length;++j) {
				grille [i][j] = 0;
				
			}
		}
	}
	
	//affichage de la grille
	public static void affiche()
	{
		int i=0,j=0;
		int[] num= {1,2,3,4,5,6,7};
		for(i = 0; i<grille.length;++i)
		{
			for(j=0;j< grille[i].length;++j) {
				System.out.print( grille [i][j] +"|");
				
			}
			System.out.println("");
		}
		
		
		for(i = 0; i<num.length;++i)
		{
			System.out.print(num[i] + "=");
		}
		System.out.println("");
			
	}

	
	static boolean joue(int[][] grille , int colonne , int couleur)
	{
		// parcourir la colonne choisi 
		int ligne = grille.length - 1;
		
		boolean pleine = false;
		while ( (!pleine ) && grille[ligne][colonne] != jeu.VIDE) {
			if(ligne == 0) { pleine = true;}
			else {
			--ligne;}
		}
		//
		// on remplit la case vide trouver;
		if(!pleine) {
		grille[ligne][colonne] = couleur;
		return true;
		}else {
			return false;
		}
			
	}

	//méthode compte 

	static int compte(int[][] grille, int ligneDepart , int colonneDepart,int dirLigne,int dirColonne)
	{
		int compteur = 0;
		int ligne = ligneDepart;
		int colonne = colonneDepart;
		
		 while(grille[ligne][colonne] == grille[ligneDepart][colonneDepart]  && ligne>= 0 && ligne < grille.length && colonne >= 0 && colonne <grille[ligne].length  ) {
			compteur = compteur + 1;
			System.out.println("grille.length ="+ grille.length +" ligne = "+ligne+" colonne ="+colonne + " compteur = "+compteur+" ligne depart ="+ligneDepart+" colonneDepart = "+colonneDepart +" grille[ligne][colonne] ="+grille[ligne][colonne]);
			if(compteur == 4 ) {return compteur;}
			else {
			 ligne = ligne + dirLigne;
			 colonne = colonne + dirColonne;
			}
		 }
		 return compteur;
		 
	}
	//gagne = estceGagne(grille , couleurJoueur );
	static boolean estCeGagne(int[][] grille , int couleurJoueur)
	{
		for (int ligne = 0; ligne< grille.length;++ligne)
			for(int colonne = 0;colonne < grille[ligne].length;++colonne)
			{
				int couleurCase = grille[ligne][colonne];
				if (couleurCase == couleurJoueur)
				{
					if (
							//vers le haut et la droite :
							(ligne >= 3 && colonne <= grille[ligne].length-4 &&					
							compte(grille,ligne,colonne,-1,+1)>=4)||
							
							//horizentalement
							(colonne <= grille[ligne].length-4 &&
							compte(grille,ligne,colonne,0,+1)>=4)||
							
							//vers le bas et la droite
							(ligne<= grille.length-4 && colonne <= grille[ligne].length -4 &&
							compte(grille,ligne,colonne,+1,+1)>=4)||
							
							//verticalemnt , vers le bas 
							(ligne <= grille.length-4  &&
							compte(grille,ligne,colonne,+1,0)>=4))
						{
							return true;
						}
				}
			}
		return false ;
		}

				
		

}
