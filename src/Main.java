import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = null;
        ArrayList<Konyv> konyvek = new ArrayList<>();

        try {
            scanner = new Scanner(new File("./src/konyvek.txt"));
            scanner.nextLine();
            while (scanner.hasNext()){
                String sor = scanner.nextLine();
                String[] data = sor.split(";");
                konyvek.add(new Konyv(data[0], data[1], data[2], Integer.parseInt(data[3]), Boolean.parseBoolean(data[4])));
            }

            System.out.println("------------------------------------------");
            System.out.println("|        Könyvtár kezelő rendszer        |");
            System.out.println("------------------------------------------");

            Scanner scanner1 = new Scanner(System.in);
            while (true) {
                System.out.println("----------------------------------");
                System.out.println("| a) Összes könyv kilistázása    |");
                System.out.println("| b) Kölcsönözhető könyvek       |");
                System.out.println("| c) Keresés műfaj szerint       |");
                System.out.println("| d) 2000 utáni könyvek          |");
                System.out.println("| e) Kilépés                     |");
                System.out.println("----------------------------------");
                System.out.print("Választás betűjele: ");
                String valasztas = scanner1.nextLine();

                if (valasztas.toLowerCase().equals("a")) {
                    konyvek.stream().forEach(konyv -> System.out.println(konyv));
                }

                else if (valasztas.toLowerCase().equals("b")) {
                    konyvek.stream().filter(konyv -> konyv.kolcsonzheto).forEach(konyv -> System.out.println(konyv));
                }

                else if (valasztas.toLowerCase().equals("c")) {
                    System.out.print("Adj meg egy műfajt: ");
                    String mufaj = scanner1.nextLine().toLowerCase();
                    konyvek.stream().filter(konyv -> konyv.mufaj.toLowerCase().equals(mufaj) || konyv.mufaj.toLowerCase().contains(mufaj)).forEach(konyv -> System.out.println(konyv));
                    int db = (int) konyvek.stream().filter(konyv -> konyv.mufaj.toLowerCase().equals(mufaj) || konyv.mufaj.toLowerCase().contains(mufaj)).count();
                    if (db == 0) System.out.println("Nincs ilyen műfajú könyv a rendszerben.");
                }

                else if (valasztas.toLowerCase().equals("d")) {
                    konyvek.stream().filter(konyv -> konyv.kiadas_eve > 2000).forEach(konyv -> System.out.println(konyv));
                    int db1 = (int) konyvek.stream().filter(konyv -> konyv.kiadas_eve > 2000).count();
                    if (db1 == 0) System.out.println("Nincs 2000 utáni könyv a rendszerben.");
                }

                else if (valasztas.toLowerCase().equals("e")) {
                    System.out.println("Sikeres kilépés a programból.");
                    break;
                }

                else {
                    System.out.println("Hiba -> Nincs ilyen lehetőség / választás. Próbáld újra.");
                }
            }
            scanner1.close();

        } catch (FileNotFoundException e) {
            System.out.println("Hiba -> A fájl nem található.");
        } finally {
            if (scanner != null) scanner.close();
        }

    }
}