import java.util.Arrays;

public class SimpleWarehouse {
/*
<modifier><type><name>
*/
    private int size;
    private int[] warehouse; // store ids

    public SimpleWarehouse(int size) {
        this.size = size;
        this.warehouse = new int[size];
    }

    public int getSize() {
        return size;
    }
    public int receive(int itemCode, int itemCount) {
        int numFilled = 0;
        for (int i = 0; i < warehouse.length; i++) {
            if(numFilled == itemCount) {
                break;
            }

            if(warehouse[i] == 0) {
                warehouse[i] = itemCode;
                numFilled++;
            } 
        }
        return itemCount - numFilled;
    }
    public int stock(int itemCode) {
        int stock = 0;
        for(int i = 0; i < warehouse.length; i++) {
            if(warehouse[i] == itemCode) {
                stock++;
            }
        }
        return stock;
    }
    public String toString() {
        return("SImpleWarehouse" + "[size = " + size + ",warehouse =" + Arrays.toString(warehouse) + "]");
    }
}
