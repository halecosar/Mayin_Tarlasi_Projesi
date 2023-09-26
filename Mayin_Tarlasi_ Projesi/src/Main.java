import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean state = false;
        //kullanıcıdan bilgi alma metodu çağırıldı.
        MineSweeper mineSweeper = new MineSweeper();
        mineSweeper.UserInfo();

        //bombaların oluşturulduğu ve kulanıcıdan alınan bilgilere göre board'u oluşturan metod çağırıldı.
        mineSweeper.CreateBoard();

        //bombaların tutulduğu diziyi çağıran meod tanımlandı.
        mineSweeper.RandomBombCreater();
        //oyunun kazanılma/kaybedilmesi için döngü yazıldı.
        while (state != true) {
            mineSweeper.SetInput();
            state = mineSweeper.CheckBomb();
        }


    }
}