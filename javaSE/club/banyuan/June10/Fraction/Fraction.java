package club.banyuan.June10.Fraction;

class Fraction{
    int num; //定义分子
    int den; //定义分母

    double toDouble(){
        return (double)num/den;
    }

    Fraction plus(Fraction r){
        Fraction p = new Fraction();
        p.den = den * r.den;
        p.num = num * r.den + den * r.num;
        return p;
    }

    Fraction multiply(Fraction r){
        Fraction m = new Fraction();
        m.den = den * r.den;
        m.num = num * r.num;
        return m;
    }

    void print(){
        if (num == den) {
            System.out.println(num);
        }else if (num > den) {
            System.out.println(num + "/" + den);
        }else{
            for (int i = num ;i > 0 ;i-- ) {
                if (num % i == 0 && den % i == 0) {
                    System.out.println(num/i + "/" + den/i);
                    break;
                }
            }
        }
    }
}

class Test{
    public static void main(String[] args) {
        Fraction fra = new Fraction();
        fra.num = 8;
        fra.den = 10;
        System.out.println(fra.toDouble());
        fra.print();
    }
}
