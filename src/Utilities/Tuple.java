package Utilities;

public class Tuple<E, T>{
    private E one;
    private T two;

    public Tuple(E one, T two) {
        this.one = one;
        this.two = two;
    }

    public E getOne() {
        return one;
    }
    public T getTwo() {
        return two;
    }

    public void setOne(E one) {
        this.one = one;
    }
    public void setTwo(T two) {
        this.two = two;
    }

    public String toString(){
        return "(" + one.toString() + ", " + two.toString() + ")";
    }

    public boolean equals(Object o){
        Tuple<E, T> other = (Tuple<E, T>)o;
        if(this.one.equals(other.one) && this.two.equals(other.two)) {
            return true;
        }
        else {
            return false;
        }
    }
}
