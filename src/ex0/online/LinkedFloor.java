package ex0.online;

import java.util.EmptyStackException;

/**This class is a linked list of floors for an elevator.
 * It is like a queue that can be entered by status (ascending or descending)
 * or removed from the list in advance.
 *This class is assisted by a Link class
 */

public class LinkedFloor {
    private Link head;//The first Link
    private int size;//How much space is there
     private int stop;//Auxiliary variable that saves the last deletion from the list

    /**
     * This function builds the linked list and initializes the variables
     */
    public LinkedFloor(){
        size=0;
        head=null;
        stop=Integer.MAX_VALUE;
    }

    /**
     * @return The last deleted entry
     */
    public int getStop() {
        if(stop!=Integer.MAX_VALUE)
        return stop;
        else
            return 0;
    }
    /**
     * This function gets the first value in the list.
     * If there is nothing he gets the last deleted organ
     * @return The first entry or the first deleted entry
     */

    public int getHead() {
        if (head!=null)
        return head.getData();
        else return getStop();
    }

    /**
     *This function returns how many variables there are in the linked list
     * @return Number of floors
     */
    public int getSize() {
        return size;
    }

    /**
     *Checks if the list is empty.
     * @return true or false
     */

    public boolean isEmpty(){
        return (size==0);
    }

    /**
     *This function inserts values into the linked list by status (up or down).
     *  It inserts the organs in a sorted order like a queue
     * @param floor What floor to put in
     * @param state Up or down mode
     */

    public void enqueue(int floor,int state) {
        if (head == null || size == 0) {//If the list is empty
            this.head = new Link(floor);
            size++;
            return;
        } else {
            Link temp1 = this.head;
            Link temp2 = this.head.getNext();
            if (state==1) {// If the elevator goes up
                //Checking where to put the value
                if (temp2 == null) {
                    if(temp1.getData()>floor){
                        Link k=new Link(floor,temp1);
                        this.head=k;
                        size++;
                        return;
                    }
                    else {
                        temp1.setNext(new Link(floor));
                        size++;
                        return;
                    }
                }
                if(temp2.getNext() == null){
                    if(temp2.getData()>floor){
                        Link k=new Link(floor,temp2);
                        temp1.setNext(k);
                        size++;
                        return;
                    }
                    else {
                        temp2.setNext(new Link(floor));
                        size++;
                        return;
                    }

                }
                while (temp2.getNext() != null) {//Goes through the organs in the array
                    if (temp2.getData() == floor)
                        return;
                    if (temp2.getData() > floor) {
                        Link k = new Link(floor, temp2);
                        temp1.setNext(k);
                        size++;
                        return;
                    }
                    temp2 = temp2.getNext();
                    temp1 = temp1.getNext();
                }
                temp2.setNext(new Link(floor));
                size++;
                return;

            } else {// If the elevator goes down
                //Checking where to put the value
                if (temp2 == null) {
                    if(temp1.getData()<floor){
                        Link k=new Link(floor,temp1);
                        this.head=k;
                        size++;
                        return;
                    }
                    else {
                        temp1.setNext(new Link(floor));
                        size++;
                        return;
                    }
                }
                if(temp2.getNext() == null){
                    if(temp2.getData()<floor){
                        Link k=new Link(floor,temp2);
                        temp1.setNext(k);
                        size++;
                        return;
                    }
                    else {
                        temp2.setNext(new Link(floor));
                        size++;
                        return;
                    }

                }
                while (temp2.getNext() != null) {//Goes through the organs in the array
                    if (temp2.getData() == floor)
                        return;
                    if (temp2.getData() < floor) {
                        Link k = new Link(floor, temp2);
                        temp1.setNext(k);
                        size++;
                        return;
                    }
                    temp2 = temp2.getNext();
                    temp1 = temp1.getNext();
                }
                temp2.setNext(new Link(floor));
                size++;
                return;
            }
        }
    }

    /**
     *This function removes the first member of the linked list as a queue.
     * @return The link she removed
     */
    public int dequeue(){
        if(size==0){//If there is nothing
            throw new EmptyStackException();
        }
        else {
            size--;
            int ans=this.head.getData();
            this.stop=ans;
            this.head=this.head.getNext();
            return ans;
        }

    }

    /**
     *This function returns a string of a linked list
     * @return A string of a linked list
     */
    public String toString(){
        String ans="";
        Link temp=head;
        while (temp.getNext()!=null){
            ans=ans+temp.getData()+" < ";
            temp=temp.getNext();
        }
        return ans+temp.getData();
    }
}
