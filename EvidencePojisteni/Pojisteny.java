
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Pojisteny {

    private Databaze databaze;
  
    private Scanner sc = new Scanner(System.in, "Windows-1250");

    public Pojisteny() {
        databaze = new Databaze();
    }

    public void vypsatZaznamy() {
        ArrayList<Zaznam> zaznamy = databaze.vratZaznamy();
        for (Zaznam z : zaznamy) {
            System.out.println(z);
        }
    }

    public void vyhledatZaznamy() {
        // Od uživatele zde získáme informace

        System.out.println("Zadej jméno pojištěného:");
        String jmeno = sc.nextLine();

        System.out.println("Zadej příjmení pojištěného:");
        String prijmeni = sc.nextLine();


        for (Zaznam polozkaDatabaze:databaze.vratZaznamy()){

            if (jmeno.equals(polozkaDatabaze.getJmeno()) && prijmeni.equals(polozkaDatabaze.getPrijmeni())) {
                System.out.println(polozkaDatabaze);
            }

        }

    }
    public void pridejZaznam() {

        // získávání informací od uživatele
        System.out.println("Zadej jméno pojištěného:");
        String jmeno = sc.nextLine();

        System.out.println("Zadej příjmení pojištěného:");
        String prijmeni = sc.nextLine();

        System.out.println("Zadej telefonní kontakt:");
        String cislo = sc.nextLine();

        System.out.println("Zadej věk:");
        Integer vek = Integer.parseInt(sc.nextLine());

        
        databaze.pridejZaznam(jmeno, prijmeni, cislo, vek);

        System.out.println("Data uložena. Pokračuj libovolnou klávesou...");
    }



}


