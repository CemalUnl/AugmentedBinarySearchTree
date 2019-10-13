/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.Random;

public class BinarySearchTreeMain {

    private final static int SIZE = 100;

    public static void main(String[] args) {
        BinarySearchTree instance = new BinarySearchTree();
        Random generator = new Random();
        System.out.println("-- -- -- Binary Search Tree -- -- -- --");
        
        long startTime = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
           instance.insert(generator.nextInt(2000));
            
        }
        long endTime = System.nanoTime();
        
       
        System.out.println("Inorder BST");
        instance.printInorder();   
        System.out.println("All items were inserted.");
        System.out.println("The time elapsed for the insertion of all items is " + (endTime - startTime) + " nanoseconds ");
        System.out.println("The result of GETSUMSMALLER for the item is " + instance.sumSmaller(1000));
        System.out.println("The maximum value of all items is " + instance.findMaximum());
        System.out.println("The minimum value of all items is " + instance.findMinimum());
        long sumTime = System.nanoTime();
        System.out.println("The summation of all items is " + instance.allSum(instance.root));
        long endsumTime = System.nanoTime();
        System.out.println("The time elapsed for GETSUM is " + (endsumTime - sumTime) + " nanoseconds");
        

        //---------------------------------------------------------------------------------------------
         BinarySearchTree instance2 = new BinarySearchTree();
        System.out.println("-- -- -- Augmented Binary Search Tree -- -- -- -- " );
        
        long augstartTime = System.nanoTime();
        for (int i = 0; i < SIZE ; i++) {
            instance2.root=instance2.inserted(instance2.root,generator.nextInt(2000));
            
        }
        long augendTime = System.nanoTime();
        
        System.out.println("Inorder BST");
        instance2.printInorder();   
        System.out.println("All items were inserted.");
        System.out.println("The time elapsed for the insertion of all items is " + (augendTime - augstartTime) + " nanoseconds ");
        System.out.println("The result of GETSUMSMALLER for the item is " + instance2.sumSmaller(1000));
        System.out.println("The maximum value of all items is " + instance2.findMaximum());
        System.out.println("The minimum value of all items is " + instance2.findMinimum());
        long augsumTime = System.nanoTime();
        System.out.println("The summation of all items is " + instance2.allSum(instance2.root));
        long augendsumTime = System.nanoTime();
        System.out.println("The time elapsed for GETSUM is " + (augendsumTime - augsumTime) + " nanoseconds");
        
    }

}
