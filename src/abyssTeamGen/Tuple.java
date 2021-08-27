package abyssTeamGen;

public class Tuple<E>{
    private E one;
    private E two;

    public Tuple(E one, E two) {
        this.one = one;
        this.two = two;
    }

    public E getOne() {
        return one;
    }
    public E getTwo() {
        return two;
    }

    public void setOne(E one) {
        this.one = one;
    }
    public void setTwo(E two) {
        this.two = two;
    }

    public String toString(){
        return "(" + one.toString() + ", " + two.toString() + ")";
    }

    public boolean equals(Object o){
        Tuple<E> other = (Tuple<E>)o;
        if(this.one.equals(other.one) && this.two.equals(other.two)) {
            return true;
        }
        else {
            return false;
        }
    }
}
