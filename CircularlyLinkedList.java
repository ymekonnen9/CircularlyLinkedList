public class CircularlyLinkedList<T>{
    public static class Node<T>{
        private T element;
        Node<T> next;
        
        public Node(T t){
            this.element = t;
        }

        public T getElement(){return this.element;}
        public Node<T> getNext(){return this.next;}
        public void setNext(Node<T> n){this.next = n;}
    }

    private Node<T> tail;
    private Node<T> head;
    private int size =0;

    public CircularlyLinkedList(){}
    public boolean isEmpty(){return(size==0);}

    public void addFirst(T t){
        Node<T> newHead = new Node<>(t);
        if(isEmpty()){
            newHead.setNext(head);
            head = newHead;
            tail = newHead;
            size++;
        }else{
            newHead.setNext(head);
            head = newHead;
            tail.setNext(newHead);
            size++;
        }
    }

    public void addLast(T t){
        if(isEmpty()){
            addFirst(t);
        }else{
            Node<T> newNode = new Node<>(t);
            tail.setNext(newNode);
            tail = newNode;
            newNode.setNext(head);
            size++;
        }
    }

    public T removeFirst() throws IllegalAccessException{
        if(isEmpty()){
            throw new IllegalAccessError("There's no node at this place");
        }else{
            T t = head.getElement();
            tail.setNext(head.getNext());
            head = head.getNext();
            size--;
            return t;
        }
    }

    public T removeLast () throws IllegalAccessException{
        if(isEmpty()){
            throw new IllegalAccessException("There's no node at this position");
        }else{
            T t = tail.getElement();
            Node<T> temp = head;
            for(int i= 1;i<size-1; i++){
                temp = temp.getNext();
            }
            temp.setNext(head);
            tail =temp;
            size--;
            return t;

        }
    }

    public void insertAtIndex(T t, int index){
        if(isEmpty()){
            addFirst(t);
        }else{
            Node<T> temp = head;
            Node<T> newNode = new Node<>(t);
            for(int i=1; i<index-1;i++){
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            size++;
        }
    }

    public T removeAtIndex(int index) throws IllegalAccessException{
        if(isEmpty()){
            throw new IllegalAccessException("The Circularly Linked list is empty");
        }else{
            Node<T> temp = head;
            for(int i = 1; i < index-1; i++){
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            size--;
            return temp.getNext().getElement();
        }
    }

    public void printCircularlyLinkedList(){
        Node<T> temp = head;
        if(isEmpty()){
            System.out.println("NOthing is in here");
        }

        for(int i=1; i<=size; i ++){
            System.out.println(temp.getElement());
            temp= temp.getNext();
        }
    }
}