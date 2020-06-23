package club.banyuan.June22.Practice.Firm;

public class Commission extends Hourly {
    private double totalSales;//总销售额
    private double commissionRate;//佣金率

    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double commissionRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate;
    }

    public void addSales(double totalSales) {
        this.totalSales += totalSales;
    }

    public double pay() {
        double payment = super.pay() + (totalSales * commissionRate);
        totalSales=0;
        return payment;
    }

    public String toString(){
        String result=super.toString();
        result+="\n总销售额："+totalSales;
        return result;
    }
}
