import java.util.Arrays;

/* Hugo Siou CS 143 Warehouse Assignment Due 10/2/2026
- Class represents a warehouse with a given size, limit per item, and it's represented by an array of ints
- getters for size and getlimitperitem are implemented
- includes functionality to receive and ship items into/out of the warehouse
- helper stock method and tostring to format print statement
 */
public class Warehouse {
    private int size;
    private int[] warehouse; // store ids
    private int limitPerItem;

    // constructor inits size and limitPerItem based on parameters, and also inits a warehouse array of size filled with 0s
    public Warehouse(int size, int LimitPerItem) {
        this.size = size;
        this.warehouse = new int[size];
        this.limitPerItem = LimitPerItem;
    }
    // returns the total size of the warehouse
    public int getSize() {
        return size;
    }
    // returns the limit of an item in a given warehouse object
    public int getLimitPerItem() {
        return limitPerItem;
    }
    /* receive takes itemcount amount of item of itemcode, and fills the array with that item till its been fillled limitperitem times
    then, receive returns the difference between itemcount and itemfilled
     */
    public int receive(int itemCode, int itemCount) {
        int numFilled = 0;
        for (int i = 0; i < warehouse.length; i++) {
            if(numFilled == itemCount || numFilled + stock(itemCode) == limitPerItem) {
                break;
            }

            if(warehouse[i] == 0) {
                warehouse[i] = itemCode;
                numFilled++;
            }
        }
        return itemCount - numFilled;
    }
    // ship removes/ships out itemcount number of itemcode items, and returns the number of successfully sent out items
    public int ship(int itemCode, int itemCount) {
        int numOut = 0;
        for (int i = 0; i < warehouse.length; i++) {
            if(warehouse[i] == itemCode && numOut < itemCount) {
                numOut++;
                warehouse[i] = 0;
            }
        }
        return numOut;
    }
    // stock return num of itemcode items in warehouse array
    public int stock(int itemCode) {
        int stock = 0;
        for(int i = 0;i < warehouse.length; i++) {
            if(warehouse[i] == itemCode) {
                stock++;
            }
        }
        return stock;
    }
    // tostring formats the output when printing a warehouse object, returning the formmated string
    public String toString() {
        return("SimpleWarehouse" + "[size = " + size + ",warehouse =" + Arrays.toString(warehouse) + "]");
    }
}
