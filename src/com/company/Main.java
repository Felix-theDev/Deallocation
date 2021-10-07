package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int [] memoryAddress ={4075, 5225, 6785, 7560, 7580,7600, 10250, 15125};
        int [] blockSize = {100, 5, 600, 20, 20, 205, 4050, 230};
        Scanner input = new Scanner(System.in);
        MyObject values = new MyObject();

        for (int i = 0; i < blockSize.length; i++) {
            values.setObjects(memoryAddress[i], blockSize[i]);
        }

        values.printAllocation();
        System.out.println("Input the memory address of the block to deallocate ");
        int address = input.nextInt();
        values.removeBlock(address);
        System.out.println("\nAfter deallocation, the memory address and their block sizes are displayed below");
        values.printAllocation();


    }
}
