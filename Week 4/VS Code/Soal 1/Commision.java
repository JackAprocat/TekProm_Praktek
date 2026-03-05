
public class Commision extends Hourly {

    private double totalSales;
    private double commisionRate;

    public Commision(String eName, String eAddress, String ePhone, String sosSecNumber, double rate, double commRate) {
        super(eName, eAddress, ePhone, sosSecNumber, rate);
        this.commisionRate = commRate;
        this.totalSales = 0;
    }

    public void addSales(double totalSales) {
        this.totalSales += totalSales;
    }

    // pay = hourly pay + commision, then reset totalRate
    public double pay() {
        double payment = super.pay() + (totalSales * commisionRate);
        totalSales = 0;
        return payment;
    }

    // toString: parent info + total sales
    public String toString() {
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        return result;
    }

}
