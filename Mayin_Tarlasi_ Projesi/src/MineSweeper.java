import java.util.Random;
import java.util.Scanner;

public class MineSweeper { //işlemlerin yapılacağı sınıf tanımlandı.
    Scanner input = new Scanner(System.in);
    int row; //kullanıcıdan alınacak board boyutunun satır değişkeni tanımlandı.
    int column; //kullanıcıdan alınacak board boyutunun sütun değişkeni tanımlandı.
    int userSelectRow, userSelectColumn; // kullanıcının oyun esnasında gireceği satır ve sütun değikenleri tanımlandı.
    String[][] originalArray;
    int[][] bombedArray;
    int bombCount;
    int tempbombCount;

    public void UserInfo() {
        Scanner scan = new Scanner(System.in);
        String name;
        String surname;
        System.out.println("*****MAYIN*****TARLASI*****");
        System.out.print("Lütfen isminizi giriniz : ");
        name = scan.nextLine();
        System.out.print("Lütfen soyisminizi giriniz : ");
        surname = scan.nextLine();

        System.out.println("Sayın " + name + " " + surname + " Mayın Tarlası Oyununa Hoşgeldiniz!");
        System.out.println("================================");
    }

    //kullanıcıdan board boyutları alındı.
    public void CreateBoard() {
        Scanner input = new Scanner(System.in);
        System.out.println("Board Boyutunun satır sınırını belirleyiniz : ");
        row = input.nextInt();
        System.out.println("Board Boyutunun sütun sınırını belirleyiniz : ");
        column = input.nextInt();
        // Kullanıcıdan alınan değerler ile dizi tanımlandı.
        originalArray = new String[row][column];

        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[i].length; j++) {
                originalArray[i][j] = "*";
            }
        }

        for (String[] a : originalArray) {
            for (String b : a) {
                System.out.print(b);
            }
            System.out.println();
        }

    }

    public void RandomBombCreater() {
        // Board içindeki bomba sayısı hesaplandı.
        bombCount = ((row * column) / 4);
        tempbombCount = bombCount;

        bombedArray = new int[row][column]; //// Bomba sayısını ve yerini tutacak ikinci bir dizi tanımlandı.
        //Değeri hesaplanan bombalar rastgele yerleştirildi.
        // Fakat bomba sayısı= elemansayisi/4 koşulunu sağlayabilmek için random değerin aynı olmaması gerekliliği sağlandı.

        for (int i = 0; i < bombedArray.length; i++) {
            for (int j = 0; j < bombedArray[i].length; j++) {
                bombedArray[i][j] = 0;
            }
        }

        Random rnd = new Random();
        while (tempbombCount != 0) {
            int randomRow = rnd.nextInt(row);
            int randomColumn = rnd.nextInt(column);
            if (bombedArray[randomRow][randomColumn] != 1) {
                bombedArray[randomRow][randomColumn] = 1;
                tempbombCount--;
            }
        }

        //bombalarının nereye yerleştiğini görmek istersek burayı çalıştırabiliriz.
        /*
        for (int[] a : bombedArray) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        } */
    }
    //Kullanıcıdan alınan satır ve sütun değerleri board sınırlarına uygun mu kontrol metodu tanımlandı.
    public boolean SetInput() {
        boolean resultRow = false;

        boolean resultColumn = false;
        while (resultRow != true) {

            System.out.print("Satır Giriniz : ");
            userSelectRow = input.nextInt();

            if (userSelectRow >= row || userSelectRow < 0) {
                resultRow = false;
                System.out.print("Geçersiz satır değeri girdiniz.");

            } else {
                resultRow = true;
            }
        }


        while (resultColumn != true) {
            System.out.print("Sütun Giriniz : ");
            userSelectColumn = input.nextInt();

            if (userSelectColumn >= column || userSelectColumn < 0) {
                resultColumn = false;
                System.out.print("Geçersiz sütun değeri girdiniz.");
            } else {
                resultColumn = true;
            }

        }


        return true;
    }
    // Kullancının verdiği koordinatın sağ-sol-üst-alt ve çaprazlarında bomba var mı kontrolünü yapan metod tanımlandı.
    public boolean CheckBomb() {
        int counter = 0;
        if (bombedArray[userSelectRow][userSelectColumn] == 1) {
            System.out.println("Mayına Bastınız, Game Over :( ===========================");
            return true;
        } else {
            if (userSelectRow + 1 < row && bombedArray[userSelectRow + 1][userSelectColumn] == 1) {
                counter++;

            }
            if (userSelectRow - 1 >= 0 && bombedArray[userSelectRow - 1][userSelectColumn] == 1) {
                counter++;

            }
            if (userSelectColumn + 1 < column && bombedArray[userSelectRow][userSelectColumn + 1] == 1) {
                counter++;


            }
            if (userSelectColumn - 1 >= 0 && bombedArray[userSelectRow][userSelectColumn - 1] == 1) {
                counter++;

            }
            if (userSelectRow - 1 >= 0 && userSelectColumn - 1 >= 0 && bombedArray[userSelectRow - 1][userSelectColumn - 1] == 1) {
                counter++;

            }
            if (userSelectRow + 1 < row && userSelectColumn + 1 < column && bombedArray[userSelectRow + 1][userSelectColumn + 1] == 1) {
                counter++;

            }
            if (userSelectRow - 1 >= 0 && userSelectColumn + 1 < column && bombedArray[userSelectRow - 1][userSelectColumn + 1] == 1) {
                counter++;

            }
            if (userSelectRow + 1 < row && userSelectColumn - 1 >= 0 && bombedArray[userSelectRow + 1][userSelectColumn - 1] == 1) {
                counter++;

            }

            System.out.println("---------------------------------------------");
            System.out.println(counter);
            originalArray[userSelectRow][userSelectColumn] = String.valueOf(counter);
            for (String[] a : originalArray) {
                for (String b : a) {
                    System.out.print(b);
                }
                System.out.println();
            }

            int starCounter = 0;
            for (int i = 0; i < originalArray.length; i++) {
                for (int j = 0; j < originalArray[i].length; j++) {
                    if (originalArray[i][j] == "*") {
                        starCounter++;

                    }
                }
            }

            if (starCounter == bombCount) {
                System.out.println("---------------------------------------------");
                System.out.println("Tebrikler Oyunu Kazandınız !");
                return true;
            }


        }

        return false;
    }
}






