import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    Scanner input = new Scanner(System.in);
    int row;
    int column;
    int x, y;
    String[][] myArray;
    int mineCount;
    int tempMineCount;

    //kullanıcıdan board boyutları alındı.
    public int[][] MineSweeperCreate() {
        Scanner input = new Scanner(System.in);
        System.out.println("Board Boyutunun satır sınırını belirleyiniz : ");
        row = input.nextInt();
        System.out.println("Board Boyutunun sütun sınırını belirleyiniz : ");
        column = input.nextInt();
        // Kullanıcıdan alınan değerler ile dizi tanımlandı.
        myArray = new String[row][column];

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = "*";
            }
        }
        for (String[] a : myArray) {
            for (String b : a) {
                System.out.print(b);
            }
            System.out.println();
        }

        // Board içindeki bomba sayısı hesaplandı.
        mineCount = ((row * column) / 4);
        tempMineCount = mineCount;

        int[][] myCounterArray = new int[row][column]; //// Bomba sayısını ve yerini tutacak ikinci bir dizi tanımlandı.
        //Değeri hesaplanan bombalar rastgele yerleştirildi.
        // Fakat bomba sayısı= elemansayisi/4 koşulunu sağlayabilmek için random değerin aynı olmaması gerekliliği sağlandı.

        for (int i = 0; i < myCounterArray.length; i++) {
            for (int j = 0; j < myCounterArray[i].length; j++) {
                myCounterArray[i][j] = 0;
            }
        }

        Random rnd = new Random();
        while (tempMineCount != 0) {
            int randomRow = rnd.nextInt(row);
            int randomColumn = rnd.nextInt(column);
            if (myCounterArray[randomRow][randomColumn] != 1) {
                myCounterArray[randomRow][randomColumn] = 1;
                tempMineCount--;
            }
        }

        for (int[] a : myCounterArray) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }

        return myCounterArray;
    }

    public boolean değerler() {
        boolean resultRow = false;
        boolean resultColumn = false;
        while (resultRow != true) {

            System.out.print("Satır Giriniz : ");
            x = input.nextInt();
            if (x > row || x < 0) {
                resultRow = false;
                System.out.print("Geçersiz değer girildi.");

            } else {
                resultRow = true;
            }
        }

        while (resultColumn != true) {
            System.out.print("Sütun Giriniz : ");
            y = input.nextInt();
            if (y > column || y < 0) {
                resultColumn = false;
                System.out.print("Geçersiz değer girildi.");
            } else {
                resultColumn = true;
            }

        }

        return true;
    }

    public boolean checkMain(int[][] mainlar) {
        int sayac = 0;
        if (mainlar[x][y] == 1) {
            System.out.println("Game Over!! ===========================");
            return true;
        } else {
            if (x + 1 < row && mainlar[x + 1][y] == 1) {
                sayac++;

            }
            if (x - 1 >= 0 && mainlar[x - 1][y] == 1) {
                sayac++;

            }
            if (y + 1 < column && mainlar[x][y + 1] == 1) {
                sayac++;


            }
            if (y - 1 >= 0 && mainlar[x][y - 1] == 1) {
                sayac++;

            }
            if (x - 1 >= 0 && y - 1 >= 0 && mainlar[x - 1][y - 1] == 1) {
                sayac++;

            }
            if (x + 1 < row && y + 1 < column && mainlar[x + 1][y + 1] == 1) {
                sayac++;

            }
            if (x - 1 >= 0 && y + 1 < column && mainlar[x - 1][y + 1] == 1) {
                sayac++;

            }
            if (x + 1 < row && y - 1 >= 0 && mainlar[x + 1][y - 1] == 1) {
                sayac++;

            }

            System.out.println("---------------------------------------------");
            System.out.println(sayac);
            myArray[x][y] = String.valueOf(sayac);
            for (String[] a : myArray) {
                for (String b : a) {
                    System.out.print(b);
                }
                System.out.println();
            }
            int tireCount = 0;
            for (int i = 0; i < myArray.length; i++) {
                for (int j = 0; j < myArray[i].length; j++) {
                    if (myArray[i][j] == "*") {
                        tireCount++;

                    }
                }
            }

            if (tireCount == mineCount) {
                System.out.println("---------------------------------------------");
                System.out.println("Oyunu Kazandınız !");
                return true;
            }


        }
        return false;
    }
}






