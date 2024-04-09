package cz.czechitas.ukol3.model;

public class Pocitac {
    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

    /* Do třídy Pocitac naprogamujte tři metody: */
    public boolean jeZapnuty() {
        return jeZapnuty;
    }

    // Počítač není možno zapnout dvakrát. Při takovém pokusu vypište chybovou hlášku.
    public void zapniSe() {

        if (cpu != null && ram != null && pevnyDisk != null) {
            if (!jeZapnuty) {
                jeZapnuty = true;
                System.out.println("Počítač se zapnul.");
            } else {
                System.out.println("Chybová hláška: Počítač již je zapnutý.");
            }
        } else {
            System.out.println("Chybová hláška: Některá část počítače chybí (procesor, paměť nebo disk). Počítač nelze zapnout.");
        }
    }

    // Počítač je možno vypnout vícekrát,
    // ale opakované volání metody vypniSe() se ignoruje
    // (ani se nevypíše žádná hláška).
    public void vypniSe() {
        if (jeZapnuty) {
            jeZapnuty = false;
            System.out.println("Počítač se vypl.");
        }
    }
    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    /*********************************** Část 2 ***********************************/
    public void vytvorSouborOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.out.println("Chybová hláška: Počítač není zapnutý");
            return;
        }

        if (cpu == null || ram == null || pevnyDisk == null) {
            System.out.println("Chybová hláška: Počítač nemá všechny potřebné součásti.");
            return;
        }

        long vyuziteMisto = pevnyDisk.getVyuziteMisto();

        if (vyuziteMisto + velikost > pevnyDisk.getKapacita()) {
            System.out.println("Chybová hláška: Nový soubor se na disk nevejde.");
            return;
        }

        pevnyDisk.setVyuziteMisto(vyuziteMisto + velikost);
        System.out.println("Soubor vytvořen, využité místo: " + pevnyDisk.getVyuziteMisto());
    }

    public void vymazSouboryOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.out.println("Chybová hláška: Počítač není zapnutý");
            return;
        }

        if (cpu == null || ram == null || pevnyDisk == null) {
            System.out.println("Chybová hláška: Počítač nemá všechny potřebné součásti.");
            return;
        }

        if (pevnyDisk.getVyuziteMisto() - velikost < 0) {
            System.out.println("Chyba: pokoušíte se smazat větší soubor než je možné");
            return;
        }

        pevnyDisk.setKapacita(pevnyDisk.getKapacita() - velikost);
    }

    @Override
    public String toString() {
        return "Pocitac{" +
                "jeZapnuty=" + jeZapnuty +
                ", cpu=" + cpu +
                ", ram=" + ram +
                ", pevnyDisk=" + pevnyDisk +
                '}';
    }
}
