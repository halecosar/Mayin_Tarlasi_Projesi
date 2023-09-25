import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String name;
        String surname;
        System.out.println("================================");
        System.out.print("Lütfen isminizi giriniz : ");
        name= scan.nextLine();
        System.out.print("Lütfen soyisminizi giriniz : ");
        surname= scan.nextLine();

        System.out.println("Sayın " + name + " " + surname + " Mayın Tarlası Oyununa Hoşgeldiniz!");
        System.out.println("================================");

        MineSweeper deger= new MineSweeper();
        int [][] mayinlar = deger.MineSweeperCreate();
        deger.değerler();
        deger.checkMain(mayinlar);



    }
}