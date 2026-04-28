public class Main {

```
public static void main(String[] args) {

    System.out.println("=== Tests PorteMonnaie ===\n");

    PorteMonnaie pm1 = new PorteMonnaie();
    PorteMonnaie pm2 = new PorteMonnaie(152);
    PorteMonnaie pm3 = new PorteMonnaie(-50);
    PorteMonnaie pm4 = new PorteMonnaie(pm2);

    System.out.println("pm1 (défaut) : " + pm1.getSomme() + " €");
    System.out.println("pm2 (152€)   :\n" + pm2);
    System.out.println("pm3 (négatif) : " + pm3.getSomme() + " €");
    System.out.println("pm4 (copie pm2) : " + pm4.getSomme() + " €");

    System.out.println("\npm2.equals(pm4) : " + pm2.equals(pm4));
    System.out.println("pm1.equals(pm2) : " + pm1.equals(pm2));

    System.out.println("\n-- Ajout de 30 € à pm1 : " + pm1.ajouter(30));
    System.out.println("pm1 après ajout : " + pm1.getSomme() + " €");
    System.out.println("Retrait de 100 € de pm1 (impossible) : " + pm1.retirer(100));
    System.out.println("Retrait de 20 € de pm1 : " + pm1.retirer(20));
    System.out.println("pm1 après retrait : " + pm1.getSomme() + " €");
    System.out.println("Retrait négatif (-5) : " + pm1.retirer(-5));

    System.out.println("\n=== Tests Personne ===\n");

    Personne remi  = new Personne('M', "Rémi",  "Synave", "26/11/1988", 152);
    Personne alice = new Personne('F', "Alice", "Dupont", "01/03/1995", 50);
    Personne bob   = new Personne('M', "Bob",   "Martin", "15/07/1990", 0);

    System.out.println(remi);
    System.out.println();
    System.out.println(alice);
    System.out.println();
    System.out.println(bob);

    Personne defaut = new Personne();
    System.out.println("\nPersonne par défaut : " + defaut.getNom());

    Personne remiCopie = new Personne(remi);
    System.out.println("\nCopie de Rémi : " + remiCopie.getPrenom() + " " + remiCopie.getNom());
    System.out.println("remi.equals(remiCopie) : " + remi.equals(remiCopie));
    System.out.println("remi.equals(alice) : " + remi.equals(alice));

    System.out.println("\n-- Rémi donne 30 € à Alice --");
    System.out.println("Opération réussie : " + remi.donneA(alice, 30));
    System.out.println(remi);
    System.out.println();
    System.out.println(alice);

    System.out.println("\n-- Bob essaie de donner 20 € à Alice (solde nul) --");
    System.out.println("Opération réussie : " + bob.donneA(alice, 20));

    System.out.println("\n-- Alice reçoit 10 € de Rémi --");
    System.out.println("Opération réussie : " + alice.recoitDe(remi, 10));
    System.out.println(alice);
    System.out.println();
    System.out.println(remi);

    System.out.println("\n-- Genre invalide → remplacé par 'M' --");
    Personne gen = new Personne('X', "Test", "Genre", "01/01/2000", 10);
    System.out.println("Genre : " + gen.getGenre());
}
```

}
