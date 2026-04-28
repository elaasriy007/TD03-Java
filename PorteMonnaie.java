public class PorteMonnaie {


private int somme;

public PorteMonnaie() {
    this.somme = 0;
}

public PorteMonnaie(int somme) {
    if (somme < 0) {
        this.somme = 0;
    } else {
        this.somme = somme;
    }
}

public PorteMonnaie(PorteMonnaie autre) {
    this.somme = autre.somme;
}

public int getSomme() {
    return somme;
}

public void setSomme(int somme) {
    if (somme >= 0) {
        this.somme = somme;
    }
}

@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof PorteMonnaie)) return false;
    PorteMonnaie autre = (PorteMonnaie) obj;
    return this.somme == autre.somme;
}

@Override
public String toString() {
    int billets = somme / 10;
    int pieces  = somme % 10;
    return billets + " billets de 10 euros\n" + pieces + " pièces de 1 euro";
}

public boolean ajouter(int argent) {
    if (argent <= 0) return false;
    this.somme += argent;
    return true;
}

public boolean retirer(int argent) {
    if (argent <= 0) return false;
    if (argent > this.somme) return false;
    this.somme -= argent;
    return true;
}


}
