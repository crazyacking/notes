import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main1{
    public static void main(String[] args){
        LinkedList<Integer> linkedList=new LinkedList<Integer>();
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(0,2);
        linkedList.addFirst(1);
        linkedList.addLast(7);
//        linkedList.clear();
//        System.out.println("size="+linkedList.size());
//        if(linkedList.contains(8)){
//            System.out.println("Yes");
//        }
//
//        int si=linkedList.size();
//        for(int i=0;i<si;++i){
//            System.out.print(linkedList.get(i)+" ");
//        }
//        System.out.println();
//        System.out.println(linkedList.indexOf(7));
//        Iterator iterator=linkedList.iterator();
//        while(iterator.hasNext()){
//            System.out.print(iterator.next()+" ");
//        }
//        ListIterator<Integer> listIterator=linkedList.listIterator(1);
//        while(listIterator.hasNext()){
//            System.out.print(listIterator.next()+" ");
//        }
//        linkedList.offer(8);
//        System.out.println(linkedList.peek());
//        System.out.println(linkedList.poll());
//        System.out.println(linkedList.remove(1));
        Iterator<Integer> iterator=linkedList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
    }
}