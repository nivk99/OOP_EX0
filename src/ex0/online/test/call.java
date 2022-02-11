package ex0.online.test;

import ex0.CallForElevator;

/**\
 * This is an auxiliary class just for testing!!!
 */
public class call implements CallForElevator {
    private int src;
    private int dest;
    private int type;

    public call(int src,int dest,int type ){
        this.src=src;
        this.dest=dest;
        this.type=type;
    }


    @Override
    public int getState() {
        return 0;
    }

    @Override
    public double getTime(int state) {
        return 0;
    }

    @Override
    public int getSrc() {
        return src;
    }

    @Override
    public int getDest() {
        return dest;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public int allocatedTo() {
        return 0;
    }
}
