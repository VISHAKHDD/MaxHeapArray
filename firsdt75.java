import java.util.*;

class MaxHeapArray{

    int arr[] = new int[10];
    int size = 0;

    int getParentIndex(int i) {
        return (i-1)/2;
    }

    int getLeftChildIndex(int i) {
        return (2*i+1);
    }

    int getRigthChildIndex(int i) {
        return (2*i+2);
    }
    
    boolean hasParent() {
        //if(getParentIndex(i)<0) return false;
        //return true;
        return getParentIndex(i)>=0;
    }

    boolean hasLeftChild() {
        return getLeftChildIndex(i)<size;
    }

    boolean hasRigthChild() {
        return getRigthChildIndex(i)<size;
    }

    int parent(int i) {
        return arr[getParentIndex(i)];
    }

    int leftChild(int i) {
        return arr[getLeftChildIndex(i)];
    }

    int rightChild(int i) {
        return arr[getRigthChildIndex(i)];
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size<=0; //or size==0;
    }

    int peek() {
        return arr[0];
    }
    
    void insert(int val)
    {
        arr[size] = val;
        size++;
        HeapifyUp();
    }

    void HeapifyUp() {
        int i = size-1;
        while(hasParent(i) && parent(i)<arr[i]) {
            swap();
            i=getParentIndex(i);
        }
    }

    void swap(int a, int b) {
        int t=0;
        t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }

    void print() {
        for(int i=0;i<size;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    int poll() {
        int val=arr[0];
        arr[0]=arr[size-1];
        size--;
        HeapifyUp();
        return val;
    }

    void HeapifyDown() {
        int i=0;
        while(hasLeftChild(i)) {
            int greaterChildIndex=getLeftChildIndex(i);
            if(hasRigthChild(i) && rightChild(i)>leftChild(i)) {
                greaterChildIndex=getRigthChildIndex(i);
            }
            if(arr[i]<arr[greaterChildIndex]){
                swap(i.greaterChildIndex);
            }
            else {
                break;
            }
        }
    }

    void sort() {
        while(size!=1) {
            int temp=arr[0];
            arr[0]=arr[size-1];
            arr[size-1]=temp;
            size--;
            HeapifyDown();
        }
    }

}

public class first75 {
    public static void main(String args[]) {
        MaxHeapArray h = new MaxHeapArray();
        h.insert(10);
        h.insert(5);
        h.insert(3);
        h.insert(2);
        h.insert(7);
        h.print();
        h.print();
        h.poll();
        h.print();
    }
}
