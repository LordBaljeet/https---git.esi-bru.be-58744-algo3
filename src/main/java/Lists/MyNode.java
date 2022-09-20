package Lists;

public class MyNode<E> {

    public MyNode previous;

    public MyNode next;

    private E value;

    public MyNode(MyNode previous, E value, MyNode next) {
        this.previous = previous;
        this.next = next;
        this.value = value;
    }

    public MyNode getPrevious() {
        
        return previous;
    }

    public void setPrevious(MyNode previous) {
        this.previous = previous;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
    
}
