package td2.morpion;

public class IA extends Joueur {
    private static final int MAX = 1000;
    private static final int MIN = -1000;
    private final int niveau;
    Coup prochainCoup = null;

    public IA(Type x, Grille grille, int niveau) {
        super(x, grille);
        this.niveau = niveau;
    }

    @Override
    public Coup prochainCoup() {
        max(niveau);
        return prochainCoup;
    }

    protected int evaluer() {
        if (grille.finie()) {
            if (grille.gagnant() != null) {
                return grille.gagnant() == type ? MAX : MIN;
            }
        }
        return 0;
    }

    private int max(int profondeur) {
        if (profondeur == 0) {
            prochainCoup = null;
            return evaluer();
        }
        final var coups = grille.coupsPossibles(type);
        if (coups.isEmpty()) {
            prochainCoup = null;
            return evaluer();
        }
        int scoreMax = MIN - 1;
        Coup prochain = null;
        for (Coup coup : coups) {
            grille.remplir(coup);
            int score = min(profondeur - 1);
            //System.out.printf("on teste le coup %s=> score%d%n",coup,score);
            if (score > scoreMax) {
                scoreMax = score;
                prochain = coup;
            }
            grille.annuler(coup);
        }
        prochainCoup = prochain;
        //System.out.printf("profondeur:%d on va jouer le coup %s=> score%d%n",profondeur,prochain,scoreMax);
        return scoreMax;
    }

    private int min(int profondeur) {
        if (profondeur == 0) {
            prochainCoup = null;
            return evaluer();
        }
        final var coups = grille.coupsPossibles(type.adversaire());
        if (coups.isEmpty()) {
            prochainCoup = null;
            return evaluer();
        }
        int scoreMin = MAX + 1;
        Coup prochain = null;
        for (Coup coup : coups) {
            grille.remplir(coup);
            int score = max(profondeur - 1);
            if (score < scoreMin) {
                scoreMin = score;
                prochain = coup;
            }
            grille.annuler(coup);
        }
        prochainCoup = prochain;
        return scoreMin;
    }
}
