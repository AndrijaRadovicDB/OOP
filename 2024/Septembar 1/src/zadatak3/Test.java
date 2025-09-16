package zadatak3;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Stablo<Student> studenti = new Stablo<>(new TreeSet<>());
        studenti.dodaj(new Student("Andrija", "Radovic", "mi23133"));
        studenti.dodaj(new Student("Lazar", "Jovanovic", "mi23034"));
        studenti.dodaj(new Student("Astro", "Osoba", "ai23076"));

        Student s1 = new Student("Andrija", "Radovic", "mi23133");
        if(studenti.pronadji(s1)) {
            System.out.println("Pronadjen!");
        }
        else {
            System.out.println("Nije pronadjen :(");
        }

        Student s2 = new Student("Andrej", "Radovanovic", "mi22321");
        if(studenti.pronadji(s2)) {
            System.out.println("Pronadjen!");
        }
        else {
            System.out.println("Nije pronadjen :(");
        }

        studenti.dodaj(s1);
        studenti.ispisiSortirano();
        studenti.dodaj(s2);
        studenti.ispisiSortirano();
    }
}
