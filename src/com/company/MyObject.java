package com.company;
import java.util.*;

public class MyObject {
    private int memoryAddress;
    private int blockSize;
    private Map<Integer, Integer> stuffs = new HashMap();
    List list = new LinkedList();
    private int index= 0;

    public void setObjects( int memoryAddress, int blockSize){
        this.blockSize = blockSize;
        this.memoryAddress = memoryAddress;
        //Adds the memory address to a list and then to a Map using the memory size as key and block size as value
        //A list is used to be able to reference each memory address by a unique integer index
        list.add(index, memoryAddress);
        stuffs.put(memoryAddress, blockSize);
        index++;
    }

    //This method gets the memory size of the memory size that is passed in
    public String getAllocation(int i){
        int key = (Integer)list.get(i);
        return "Memory Address is " + key + " and it's size is " + stuffs.get(key);
    }
    public void removeBlock(int memoryAddress){
        int index;
        int totalBlock;
        for (int i = 0; i < list.size(); i++) {
            if((Integer)list.get(i) == memoryAddress) {
                index = i;
                // Total block is initially declared to be the size of the busy memory address
                totalBlock  = stuffs.get(memoryAddress);
                //Adds the block size of the previous and next memory address to the size of the total block
                totalBlock += stuffs.get(list.get(index -1));
                totalBlock += stuffs.get(list.get(index +1));
                System.out.println(totalBlock);
                //Change the block size of the previous memory address to the value of total block
                stuffs.put((Integer)list.get(index-1), totalBlock);
                //Removes the memory block of the busy and its next memory address from the list Map and them list
                stuffs.remove(list.get(index+1));
                stuffs.remove(list.get(index));
                list.remove(index+1);
                list.remove(index);

            }
        }

    }
    //Prints all the Memory Location with their respective Block sizes
    public void printAllocation(){
        System.out.println("Memory Location" + "\t\t\t"+ "Block Size");
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i) + "\t\t\t\t\t"+ stuffs.get(list.get(i)));
        }
    }


    public int getMemoryAddress() {
        return memoryAddress;
    }

    // Get the size of the
    public int getBlockSize() {
        return blockSize;
    }
    @Override
    public String toString(){
        return String.format("%s%d%s%d", "Memory Address is ", this.memoryAddress, "and the block size is ", this.getBlockSize());
    }

}
