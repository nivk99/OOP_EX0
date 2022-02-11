package ex0.online;

/**
 * This class creates the pointer in the memory of a linked list.
 * This class has the next organ on the list as well as its value.
 * It was written for LinkedFloor
 */
public class Link {
    private int data;// value
    private Link next;//next link

    /**
     *This function builds the class.
     * @param data = value
     */
    public Link(int data){
        this.data=data;
        next=null;
    }

    /**
     *This function builds the class.
     * @param data =value
     * @param next =Next memory
     */
    public Link (int data,Link next){
        this.data=data;
        this.next=next;
    }

    /**
     *This function returns the value
     * @return  value
     */
    public int getData() {
        return data;
    }

    /**
     * This function changes the value
     * @param data =  value
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * This function brings up the next organ in the related list
     * @return next link
     */

    public Link getNext() {
        return next;
    }

    /**
     * This function changes the pointer in the memory of the linked list
     * @param next=The next link
     */

    public void setNext(Link next) {
        this.next = next;
    }

    /**
     * This function brings up the string
     * @return A string of value in the linked list
     */
    public String toString(){
        return ""+data;
    }
}
