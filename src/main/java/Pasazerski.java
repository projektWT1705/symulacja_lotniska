import java.util.Scanner;

public class Pasazerski extends Samolot {

    private int iloscPasazerow;
    private int iloscPasazerowPoklad;

    //konstruktor
    public Pasazerski(String nazwa)
    {
        super(nazwa, 1, 1000);           // wywołanie konstruktora z klasy nadrzędnej
        iloscPasazerow = 120;               // domyślna wartość dla każdego samolotu
        setCzasZaladunku(5);             // domyślna wartość dla każdego samolotu
        setCzasTankowania(3);            // domyślna wartość dla każdego samolotu
        setCzasRozladunku(4);             // domyslna wartosc dla kazdego samolotu
        iloscPasazerowPoklad = 0;
    }

    // konstruktor inicjalizuje nasz obiekt innym obiektem
    public Pasazerski(Pasazerski obj)
    {
        super(obj.getnazwa(), 1, 1000);
        iloscPasazerow = 120;
        setCzasZaladunku(5);
        setCzasTankowania(3);
        setCzasRozladunku(4);
        iloscPasazerowPoklad = obj.ileMiejscPoklad();
    }

    @Override
    public int ileMiejscPoklad()
    {
        return iloscPasazerowPoklad;
    }

    @Override
    public int ileMiejsc()
    {
        return iloscPasazerow;
    }


    Scanner in = new Scanner(System.in);

    @Override
    public void dodajLadunek() throws Exception
    {
        System.out.println("Podaj liczbe osob ktore maja wejsc na poklad");
        int osoby = Menu.wczytajOpcje();
        while (osoby < 0)
        {
            System.out.println("Nie mozna podac ujemnej wartosci. Sprobuj ponownie: ");
            osoby = Menu.wczytajOpcje();
        }
        if(osoby + iloscPasazerowPoklad > iloscPasazerow)  // jesli liczba bedzie przekraczac liczbe dostepnych miejsc
        {
            System.out.println("Tyle osob nie zmiesci sie w samolocie");
            System.out.println("Liczba osob oddelegowanych: " + (osoby - (iloscPasazerow - iloscPasazerowPoklad)));
            iloscPasazerowPoklad = iloscPasazerow;
            System.out.println("Liczba osob na pokladzie: " + iloscPasazerowPoklad);
        }
        else
        {
            System.out.println("Wejscie pasazerow na poklad: ");
            Menu.odliczanie(podajCzasZaladunku());
            System.out.println("Wejscie na poklad pasazerow zakonczone pomyslnie. ");
            iloscPasazerowPoklad += osoby;
            System.out.println("Obecna liczba pasazrow na pokladzie: " + iloscPasazerowPoklad);
        }
    }

    @Override
    public void rozladuj() {
        if (iloscPasazerowPoklad == 0)
            System.out.println("Samolot jest pusty, nie mozna go rozladowac");
        else {
            System.out.println("Liczba osob wysiadajacych z samolotu: " + iloscPasazerowPoklad);
            System.out.println("Rozladunek:");
            Menu.odliczanie(podajCzasRozladunku());
            iloscPasazerowPoklad = 0;
            System.out.println("Wyjscie ludzi z samolotu pomyslne");
        }
    }
}
