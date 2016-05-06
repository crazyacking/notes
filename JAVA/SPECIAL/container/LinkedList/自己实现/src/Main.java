class LinkNode<T>{
    public LinkNode(){
        this.next=null;
        this.previous=null;
        this.obj=null;
    }

    public LinkNode(T obj){
        this.next=null;
        this.previous=null;
        this.obj=obj;
    }

    public LinkNode(LinkNode<T> next,LinkNode<T> previous,T obj){
        this.next=next;
        this.previous=previous;
        this.obj=obj;
    }

    // Data
    public LinkNode<T> next;
    public LinkNode<T> previous;
    public T obj;

    // delete node
    public void remove(){
        next.previous=previous;
        previous.next=next;
    }

    // modify node
    public void set(T t){
        obj=t;
    }

    // toString
    public String toString(){
        return obj.toString();
    }
}

class LinkList<T>{
    LinkNode<T> head=new LinkNode<>();
    int size;
    public LinkList(){
        head.next=head;
        head.previous=head;
        size=0;
    }

    public LinkNode<T> getFirst(){
        return head;
    }

    public LinkNode<T> getLast(){
        LinkNode<T> node=head.previous;
        if(node==head)
            return null;
        return node;
    }

    public LinkNode<T> addFirst(T element){
        return addAfter(element,head);
    }

    public LinkNode<T> addAfter(T element,LinkNode<T> node){
        LinkNode<T> newNode=new LinkNode<T>(node.next,node,element);
        newNode.previous.next=newNode;
        newNode.next.previous=newNode;
        ++size;
        return newNode;
    }
    public LinkNode<T> addLast(T e){
        return addAfter(e,head.previous);
    }

    public String toString() {
        String tempStr = "[";
        LinkNode<T> temp = head.next;
        while (temp != head) {
            tempStr += " " + temp;
            temp = temp.next;
        }
        return tempStr + " ]";
    }
}

public class Main{
    public static void main(String[]args){
        LinkList<Integer> a=new LinkList<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        System.out.println(a.toString());

    }
}