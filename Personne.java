import java.util.GregorianCalendar;
import java.util.Calendar;

public class Personne {

private char genre;
private String prenom;
private String nom;
private GregorianCalendar dateNaissance;
private PorteMonnaie porteMonnaie;

public Personne() {
    this.genre         = 'M';
    this.prenom        = "Prénom";
    this.nom           = "Nom";
    this.dateNaissance = new GregorianCalendar(2000, 0, 1);
    this.porteMonnaie  = new PorteMonnaie();
}

public Personne(char genre, String prenom, String nom, String date, int somme) {
    this.genre = (genre == 'M' || genre == 'F') ? genre : 'M';
    this.prenom = (prenom != null) ? prenom : "";
    this.nom    = (nom    != null) ? nom    : "";

    String[] parties = date.split("/");
    int jour  = Integer.parseInt(parties[0]);
    int mois  = Integer.parseInt(parties[1]) - 1;
    int annee = Integer.parseInt(parties[2]);
    this.dateNaissance = new GregorianCalendar(annee, mois, jour);

    this.porteMonnaie = new PorteMonnaie(somme);
}

public Personne(Personne autre) {
    this.genre  = autre.genre;
    this.prenom = autre.prenom;
    this.nom    = autre.nom;

    int jour  = autre.dateNaissance.get(Calendar.DATE);
    int mois  = autre.dateNaissance.get(Calendar.MONTH);
    int annee = autre.dateNaissance.get(Calendar.YEAR);
    this.dateNaissance = new GregorianCalendar(annee, mois, jour);

    this.porteMonnaie = new PorteMonnaie(autre.porteMonnaie);
}

public char getGenre()                    { return genre; }
public String getPrenom()                 { return prenom; }
public String getNom()                    { return nom; }
public GregorianCalendar getDateNaissance() { return dateNaissance; }
public PorteMonnaie getPorteMonnaie()     { return porteMonnaie; }

public void setGenre(char genre) {
    if (genre == 'M' || genre == 'F') this.genre = genre;
}
public void setPrenom(String prenom)  { if (prenom != null) this.prenom = prenom; }
public void setNom(String nom)        { if (nom    != null) this.nom    = nom;    }
public void setDateNaissance(GregorianCalendar d) { if (d != null) this.dateNaissance = d; }
public void setPorteMonnaie(PorteMonnaie pm)      { if (pm != null) this.porteMonnaie = pm; }

@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Personne)) return false;
    Personne autre = (Personne) obj;
    return this.genre  == autre.genre
        && this.prenom.equals(autre.prenom)
        && this.nom.equals(autre.nom)
        && this.dateNaissance.equals(autre.dateNaissance)
        && this.porteMonnaie.equals(autre.porteMonnaie);
}

@Override
public String toString() {
    String civilite = (genre == 'F') ? "Mme" : "Mr";
    String neeOuNe  = (genre == 'F') ? "née" : "né";

    String[] moisNoms = {"janv.", "févr.", "mars", "avr.", "mai", "juin",
                         "juil.", "août", "sept.", "oct.", "nov.", "déc."};
    int jour  = dateNaissance.get(Calendar.DATE);
    int mois  = dateNaissance.get(Calendar.MONTH);
    int annee = dateNaissance.get(Calendar.YEAR);

    String dateStr = jour + " " + moisNoms[mois] + " " + annee;

    return civilite + " " + prenom + " " + nom
         + ", " + neeOuNe + " le " + dateStr
         + ", possède :\n" + porteMonnaie.toString();
}

public boolean donneA(Personne p, int argent) {
    if (p == null || argent <= 0) return false;
    if (this.porteMonnaie.retirer(argent)) {
        p.porteMonnaie.ajouter(argent);
        return true;
    }
    return false;
}

public boolean recoitDe(Personne p, int argent) {
    if (p == null || argent <= 0) return false;
    return p.donneA(this, argent);
}
```

}
