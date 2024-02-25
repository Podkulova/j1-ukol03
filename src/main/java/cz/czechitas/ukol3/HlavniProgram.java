package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
            Pocitac dasinPocitac = new Pocitac(1000);
            System.out.println(dasinPocitac.toString());
            dasinPocitac.zapniSe();      // Vypíše chybu, protože počítač v tuto chvíli nemá všechny povinné součásti.

            Procesor dasinProcesor = new Procesor();

            dasinProcesor.setRychlost(3_200_000_000L);
            dasinProcesor.setVyrobce("Apple");

            Pamet dasinaPamet = new Pamet();
            dasinaPamet.setKapacita(68_719_476_736L);

            Disk dasinDisk = new Disk();
            dasinDisk.setKapacita(274_877_906_944L);

            dasinPocitac.setCpu(dasinProcesor);
            dasinPocitac.setRam(dasinaPamet);
            dasinPocitac.setPevnyDisk(dasinDisk);

            System.out.println(dasinPocitac.toString());

            dasinPocitac.zapniSe();
            dasinPocitac.zapniSe();      // Vypíše chybu, protože počítač už běží
            System.out.println(dasinPocitac.toString());
            dasinPocitac.vypniSe();

            dasinPocitac.vypniSe();      // Nevypíše chybu, ale nic neprovede, protože počítač už je vypnutý
        }
    }

