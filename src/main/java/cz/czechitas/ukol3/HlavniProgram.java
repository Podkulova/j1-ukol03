package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Disk;
import cz.czechitas.ukol3.model.Pamet;
import cz.czechitas.ukol3.model.Pocitac;
import cz.czechitas.ukol3.model.Procesor;

public class HlavniProgram {
    public static void main(String[] args) {
        Pocitac dasinPocitac = new Pocitac();

        System.out.println(dasinPocitac.toString());
        dasinPocitac.zapniSe();      // Vypíše chybu, protože počítač v tuto chvíli nemá všechny povinné součásti.
        System.out.println(dasinPocitac);


        Procesor dasinProcesor = new Procesor();

        dasinProcesor.setRychlost(3_200_000_000L);
        dasinProcesor.setVyrobce("Apple");

        Pamet dasinaPamet = new Pamet();
        dasinaPamet.setKapacita(68_719_476_736L);

        Disk dasinDisk = new Disk();
        dasinDisk.setKapacita(1000L);

        dasinPocitac.setCpu(dasinProcesor);
        dasinPocitac.zapniSe();
        System.out.println(dasinPocitac);

        dasinPocitac.setRam(dasinaPamet);
        System.out.println("Pokouším se zapnout PC bez disku");
        dasinPocitac.zapniSe();
        System.out.println(dasinPocitac);

        dasinPocitac.setPevnyDisk(dasinDisk);
        dasinPocitac.zapniSe();
        System.out.println(dasinPocitac);

        // Zobrazím počáteční svat počítače
        System.out.println("Počáteční stav Pc: ");
        System.out.println(dasinPocitac);
        System.out.println("________________________________");

        //Zapnu Pc
        dasinPocitac.zapniSe(); //chyba již je zapnutý
        System.out.println(dasinPocitac);
        System.out.println("________________________________");

        // Vytvořím soubor a různých velokostech
        dasinPocitac.vytvorSouborOVelikosti(400);
        System.out.println(dasinPocitac);

        dasinPocitac.vytvorSouborOVelikosti(700); // vychodí chybu = součet není 1000
        System.out.println(dasinPocitac);

        dasinPocitac.vytvorSouborOVelikosti(600);

        System.out.println("________________________________");
        System.out.println("Stav po vytvoření souboru: ");
        System.out.println(dasinPocitac);
        System.out.println("________________________________");

        // Mazání souboru
        dasinPocitac.vymazSouboryOVelikosti(100);
        dasinPocitac.vymazSouboryOVelikosti(50); // využité místo 850

        System.out.println("Stav po vytvoření souboru: ");
        System.out.println(dasinPocitac);
        System.out.println("________________________________");

        dasinPocitac.vymazSouboryOVelikosti(900); //chyba
        System.out.println(dasinPocitac);

        dasinPocitac.vymazSouboryOVelikosti(850);
        System.out.println(dasinPocitac);

        // Vypneme Pc
        dasinPocitac.vypniSe();
        System.out.println("________________________________");

        // Zkusím vytvořit soubor, když je pc vypnuté
        dasinPocitac.vytvorSouborOVelikosti(400); // vyhodí chybu

        dasinPocitac.vymazSouboryOVelikosti(850); //chyba
    }


}
