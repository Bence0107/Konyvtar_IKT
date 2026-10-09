public class Konyv {
    String cim;
    String szerzo;
    String mufaj;
    int kiadas_eve;
    boolean kolcsonzheto;

    public Konyv(String cim, String szerzo, String mufaj, int kiadas_eve, boolean kolcsonzheto) {
        this.cim = cim;
        this.szerzo = szerzo;
        this.mufaj = mufaj;
        this.kiadas_eve = kiadas_eve;
        this.kolcsonzheto = kolcsonzheto;
    }

    @Override
    public String toString() {
        return "{Cím: " + cim + " | Szerző: " + szerzo + " | Műfaj: " + mufaj + " | Kiadás éve: " + kiadas_eve + " | " + (kolcsonzheto ? "Kölcsönözhető}" : "Nem kölcsönözhető}");
    }
}