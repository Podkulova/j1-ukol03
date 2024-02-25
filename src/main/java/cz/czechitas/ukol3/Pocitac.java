package cz.czechitas.ukol3;

public class Pocitac {
    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

    private long vyuziteMisto;
    private long kapacita;
    private Disk druhyDisk;

    /* Do třídy Pocitac naprogamujte tři metody: */
    public boolean jeZapnuty(){
        return jeZapnuty;
    }
    // Počítač není možno zapnout dvakrát. Při takovém pokusu vypište chybovou hlášku.
    public void zapniSe(){
        Procesor procesor = new Procesor();
        Pamet pamet = new Pamet();
        Disk disk = new Disk();

        if (procesor != null && pamet != null && disk != null) {
                if (!jeZapnuty) {
                    jeZapnuty = true;
                    System.out.println("Počítač se zapnul.");
                } else {
                    System.err.println("Chybová hláška: Počítač již je zapnutý.");
                }
            } else {
            System.err.println("Chybová hláška: Některá část počítače chybí (procesor, paměť nebo disk). Počítač nelze zapnout.");
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
    /* Konstruktor */
    public Pocitac(long kapacita) {
        this.kapacita = kapacita;
        this.vyuziteMisto = 0;
        this.jeZapnuty = false;
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
    public void vytvorSouborOVelikosti(long velikost){
        if (!jeZapnuty) {
            System.err.println("Počítač není zapnutý");
        }

        Procesor procesor = new Procesor();
        Pamet pamet = new Pamet();
        Disk disk = new Disk();
        if (procesor == null || pamet == null || disk == null || druhyDisk == null) {
            System.out.println("Chybová hláška: Počítač nemá všechny potřebné součásti.");
        }

        if (vyuziteMisto + velikost > kapacita) {
            System.err.println("Nový soubor se na disk nevejde.");
        }

        vyuziteMisto += velikost;
        System.out.println("Soubor vytvořen, využité místo: " + vyuziteMisto);

    }

    public void vymazSouboryOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("Počítač není zapnutý");
        }


        vyuziteMisto -= velikost;
        if (vyuziteMisto < 0) {
            vyuziteMisto = 0;
            System.out.println("Soubory smazány, vyzitéMísto: " + vyuziteMisto);
        }
    }

    // Metoda pro získání informace o stavu počítače
    @Override
    public String toString() {
        return "Stav počítače: " + (jeZapnuty ? "zapnutý" : "vypnutý") + ", vyuziteMisto: " + vyuziteMisto;

    }
}
