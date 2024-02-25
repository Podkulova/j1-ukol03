package cz.czechitas.ukol3;

public class HlavniProgramUkol2 {
    public static void main(String[] args) {
        Pocitac pocitac = new Pocitac(1000);

        // Zobrazím počáteční svat počítače
        System.out.println("Počáteční stav Pc: ");
        System.out.println(pocitac);
        System.out.println("________________________________");

        //Zapnu Pc
        pocitac.zapniSe();
        System.out.println("________________________________");

        // Vytvořím soubor a různých velokostech
        pocitac.vytvorSouborOVelikosti(400);
        pocitac.vytvorSouborOVelikosti(700); // vychodí chybu = součet není 1000

        System.out.println("________________________________");
        System.out.println("Stav po vytvoření souboru: ");
        System.out.println(pocitac);
        System.out.println("________________________________");

        // Mazání souboru
        pocitac.vymazSouboryOVelikosti(100);
        pocitac.vymazSouboryOVelikosti(50); // využité místo 950

        System.out.println("Stav po vytvoření souboru: ");
        System.out.println(pocitac);
        System.out.println("________________________________");

        // Vypneme Pc
        pocitac.vypniSe();
        System.out.println("________________________________");

        // Zkusím vytvořit soubor, když je pc vypnuté
        pocitac.vytvorSouborOVelikosti(400); // vyhodí chybu



    }


}
