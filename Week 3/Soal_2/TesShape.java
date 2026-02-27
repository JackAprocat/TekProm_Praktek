package Soal_3;

public class TesShape {
    public static void main(String[] args){
        Shape s1 = new Shape();
        System.out.println("S1: " + s1.toString());

        Shape s2 = new Shape("red", false);
        System.out.println("S2: " + s2.toString());

        s1.setColor("yellow");
        s1.setFilled(true);

        System.out.println("S1 Warna Baru:" + s1.getColor());
        System.out.println("S1 apakah Filled? " + s1.isFilled());
        System.out.println("S1 setelah di set " + s1.toString());
    }
}
