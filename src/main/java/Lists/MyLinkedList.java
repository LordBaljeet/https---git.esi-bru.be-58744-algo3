package Lists;

public class MyLinkedList {

    private static int size;

    private static MyNode firstNode;

    private static MyNode lastNode;

    public MyLinkedList() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {

        MyNode node = firstNode;

        for (int i = 0; i < size; i++) {
            if (node.getValue() == o) {
                return true;
            }
            if (node != lastNode) node = node.getNext();
        }
        return false;
    }
    public boolean add(Object o) {

        MyNode node;

        if(firstNode == null) {
            node = new MyNode(null, o, null);
            firstNode = node;
        }
        else {
            node = new MyNode(lastNode, o, null);
            lastNode.setNext(node);
        }
        lastNode = node;

        size++;

        return true;
    }
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        }

        MyNode node = firstNode;
        for (int i = 0; i < size; i++) {
            if(node.getValue() == o) {
                MyNode previousNode = node.getPrevious();
                MyNode nextNode = node.getNext();
                previousNode.setNext(nextNode);
                nextNode.setPrevious(previousNode);
                node = null;
                return true;
            }
            if (node != lastNode) node = node.getNext();
        }
        size--;
        return true;
    }

    public MyNode get(int index) {

        if(index >= size || index < 0) {
            throw new IllegalArgumentException("Index out of range" + index);
        }

        MyNode node = firstNode;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public MyNode set(int index, Object element) {

        if(index >= size || index < 0) {
            throw new IllegalArgumentException("Index out of range" + index);
        }

        MyNode node = get(index);
        node.setValue(element);

        return node;
    }

    public void add(int index, Object element) {

        if(index >= size || index < 0) {
            throw new IllegalArgumentException("Index out of range" + index);
        }

        MyNode oldNode = get(index);
        MyNode newNode = new MyNode(oldNode.getPrevious(), element, oldNode);
        oldNode.getPrevious().setNext(newNode);
        oldNode.setPrevious(newNode);

        size++;

    }

    public Object remove(int index) {

        if(index >= size || index < 0) {
            throw new IllegalArgumentException("Index out of range" + index);
        }

        MyNode node = firstNode;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        MyNode nodeCopy = node;

        node = null;

        size--;

        return nodeCopy;
    }

    public int indexOf(Object o) {
        if (!contains(o)) {
            throw new IllegalArgumentException("no such element in the list!");
        }

        MyNode node = firstNode;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if(node.getValue() == o) {
                index = i;
                break;
            }
            if (node != lastNode) node = node.getNext();
        }
        return index;
    }

}
