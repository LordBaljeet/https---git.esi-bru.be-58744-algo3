package Lists;

public class MyLinkedList<E> {
    private static int size;

    private static MyNode firstNode;

    private static MyNode lastNode;

    public MyLinkedList() {
    }

    public int size() {
        return size;
    }

    public void add(E value) {
        firstNode = new MyNode(null, value, firstNode);
        size++;
    }

    public boolean contains(E value) {

        if (firstNode == null) {
            return false;
        }
        MyNode currentNode = firstNode;

        do {
            if (currentNode.getValue().equals(value)) {

                return true;
            }

            currentNode = currentNode.getNext();

        } while (currentNode != null && currentNode.getNext() != null);

        return false;
    }

    public MyNode getNode(E value) {

        if (firstNode == null) {
            return null;
        }

        MyNode currentNode = firstNode;

        do {
            if (currentNode.getValue().equals(value)) {

                return currentNode;
            }

            currentNode = currentNode.getNext();

        } while (currentNode != null && currentNode.getNext() != null);

        return null;
    }

    public boolean deleteFirstOccurrence(E value) {

        MyNode targetNode = getNode(value);

        if (targetNode != null) {

            if (targetNode == lastNode) {
                MyNode previousNode = targetNode.getPrevious();
                previousNode.setNext(null);
                lastNode = previousNode;
                return true;
            } else if (targetNode == firstNode) {
                MyNode nextNode = targetNode.getNext();
                nextNode.setPrevious(null);
                firstNode = nextNode;
                return true;
            } else {
                MyNode nextNode = targetNode.getNext();
                MyNode previousNode = targetNode.getPrevious();
                previousNode.setNext(nextNode);
                nextNode.setPrevious(previousNode);
                return true;
            }
        }
        return false;
    }

    public int deleteAllOccurrences(E value) {

        int count = 0;
        int prevCount = 0;

        do {
            prevCount = count;

            if (deleteFirstOccurrence(value)) {
                count++;
            }

        } while (count > prevCount);

        return count;
    }

    public void deleteMostOccurrence() {

        int[] tab = new int[10];

        MyNode currentNode = firstNode;

        for (int i = 0; i < size - 1; i++) {
            tab[(int) currentNode.getValue()] = (int) currentNode.getValue();
            currentNode = currentNode.getNext();
        }

        int mostOccurrence = 0;
        for (int value :
                tab) {
            if (value >= mostOccurrence) {
                mostOccurrence = value;
            }
        }
//        deleteAllOccurrences(mostOccurrence);
    }
}
