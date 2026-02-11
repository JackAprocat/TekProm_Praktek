import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args){
        
        Scanner inputuser = new Scanner(System.in);
        
        System.out.println("Masukkan jumlah angka yang ingin di input: ");

        int t = inputuser.nextInt();

        System.out.println("----------------------------");
        System.out.println("Masukkan angka: ");

        String[] kumpulanAngka = new String[t];

        for(int i = 0; i < t; i++){
            kumpulanAngka[i] = inputuser.next();
        }

        for(int i = 0; i < t; i++){
            String angkaMentahan = kumpulanAngka[i];

            try {
                long x = Long.parseLong(angkaMentahan);

                System.out.println(angkaMentahan + " can be fitted in:");

                if(x >= -128 && x <= 127)System.out.println("* byte");

                if(x >= -32768 && x <= 32767)System.out.println("* short");

                if(x >= -2147483648 && x <= 2147483647)System.out.println("*int");
                
                System.out.println("* long");

                System.out.println("-------------------------------------------");

            } catch (Exception e) {
                System.out.println(angkaMentahan + " can't be fitted anywhere.");
            }

            inputuser.close();
        }
    }    
    
}
