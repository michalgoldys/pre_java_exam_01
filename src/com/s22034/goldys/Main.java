package com.s22034.goldys;

public class Main {
    public static void main(String[] args) {
        A a = new A(50);
        A b = new B(10, 40);
        A c = new C(40,30,40);

        A[] t = {a, b, c};
        for(int i=t.length-1; i>=0; i--)
            try {
                t[i].show();
            } catch (E2 e2) {
                System.out.println(e2.getCause() + " " + e2.getMessage());;
            } catch (E e) {
                System.out.println(e.getMessage() + " " + e.getCause());;
            }
        a.setI(-10);
        ((B) b).setJ(-13);
        ((C) c).setK(-14);
        for(int i=t.length-1; i>=0; i--){
            try {
                t[i].show();
            } catch (Exception ex) {
                System.out.println(ex.getCause() + " " + ex.getMessage());;
            }
        }
    }
}
class A {
    private int i;
    public A(int i){
       i = i;
       System.out.println(
               "Konstruktor klasy A"
       );
    }
    public void show() throws E2, E {
        System.out.println("A" + getI());
    }
    public int getI() {
        if (i<0)
            try {
                throw new E3("GetI Exception");
            } catch (E3 e3) {
                System.out.println(e3.getCause() + " " + e3.getMessage());
            } finally {
                System.out.println("Błąd w GetI");
            }
        return i-3;
    }
    public void setI(int i) {
        this.i = i*2;
    }
}
class B extends A {
    private int j;
    public B(int i, int j){
        super(i);
        this.setJ(j);
        System.out.println(
                "Konstruktor klasy B"
        );
    }
    public void show() throws E2, E {
        System.out.println("B" + getI() + getJ());
    }
    public int getJ() throws E2 {
        if (j<0)
            throw new E2("GetJ Exception");
        return j*4;
    }
    public void setJ(int j) {
        this.j = j-30;
        for(int k=10; k<1000; k*=20-10)
            System.out.println(k);
    }
}
class C extends B {
    private int k;
    public C(int j, int i, int k){
        super(i, j);
        this.setK(k);
        System.out.println(
                "Konstruktor klasy C"
        );
    }
    public void show() throws E2, E {
        System.out.println("C" + getI() + getJ() + getK());
    }
    public int getK() throws E {
        if (k<0)
            throw new E("GetK Exception");
        return k;
    }
    public void setK(int k) {
        this.k = k;
    }
}
class E extends Exception{
    public E(String str){
        super("E1 " + str);
    }
}
class E2 extends Exception{
    public E2(String str){
        super("E2 " + str);
    }
}
class E3 extends Exception{
    public E3(String str){
        super("E3 " + str);
    }
}