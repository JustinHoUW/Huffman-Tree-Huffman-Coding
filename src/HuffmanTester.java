/*
   TCSS 342
   Author: Raghavi Sakpal
   Tester File for HuffmanTree
*/
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class HuffmanTester {
    public static void main(String[] args) {
        // String to be encoded
        String test1 = "eeyjjjj";
        String test2 = "Eerie eyes seen near lake";
        String test3 = "BACADAEAFABBAAAGAH";
        String test4 = "May the Force be with you !";
        String test5 = "Veni, vidi, vici.";

        try {
            // Let's test for all test Strings
            testingRoutine(test1);
            testingRoutine(test2);
            testingRoutine(test3);
            testingRoutine(test4);
            testingRoutine(test5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
       Method: To perform all operations from building frequency table to encoding
 string
       Parameter: String
       Return: void
    */
    public static void testingRoutine(String test) throws Exception {
        // HashTables store frequence and encoded bits
        HashMap<Character, Integer> freqTbl = new HashMap<Character, Integer>();
        // HashMap to store frequencies
        HashMap<Character, String> encodedBitsQTbl = new HashMap<Character,
                String>();      // HashMap to store encoded bits using Queue
        HashMap<Character, String> encodedBitsPQTbl = new HashMap<Character,
                String>();     // HashMap to store encoded bits using PriorityQueue
        // These are your data structures from Assignment 1b & 2a
        Queue<TreeNode> q = new Queue<TreeNode>();                                 //
        // Queue to build the HuffmanTree
        PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>(freqTbl.size()
                + 1);  // PriorityQueue to build the HuffmanTree

        // Step1: Build Frequency Table
        frequencyTable(test, freqTbl);
        System.out.println(freqTbl);
        // Step 2: Build HuffmanTree and encode bits using Queue & PriorityQueue
        encodeHuffmanTree(q, freqTbl, encodedBitsQTbl);
        encodeHuffmanTree(pq, freqTbl, encodedBitsPQTbl);
        System.out.println(encodedBitsQTbl);
        System.out.println(encodedBitsPQTbl);
        // Step 3: Encode the test string using Queue & PriorityQueue based HuffmanTree
        String encodedStrQ = encode(test, encodedBitsQTbl);
        String encodedStrPQ = encode(test, encodedBitsPQTbl);
        // Step 4: Print the output to the output.txt file
        printOutput(test, encodedStrQ, encodedStrPQ);
    }

    /*
       Method: Build Frequency Table
       Parameter: String
       Return: void
    */
    public static void frequencyTable(String test, HashMap<Character, Integer>
            freqTbl) {
        // Loop through the String and count the frquencies of each character
        for (int i = 0; i < test.length(); i++) {
            // Check if character key exists then update the frequency count
            if (freqTbl.containsKey(test.charAt(i))) {
                freqTbl.put(test.charAt(i), freqTbl.get(test.charAt(i)) + 1);
            } else { // Create a new entry and assign the count to be 1
                freqTbl.put(test.charAt(i), 1);
            }
        }
    }

    /*
       Method: To Build the Huffman Tree using Queue and perform traversal to encode
 bits
       Parameter: Queue<TreeNode>, HashMap<Character,Integer>,
 HashMap<Character,String>
       Return: void
    */
    public static void encodeHuffmanTree(Queue<TreeNode> q,
                                         HashMap<Character, Integer> freqTbl, HashMap<Character, String> encodTbl) throws Exception {
        TreeNode rootQtree = BuildHuffmanTree.buildTreeQueue(freqTbl, q);
        BuildHuffmanTree.encodeTraversal(rootQtree, "", encodTbl);
    }

    /*

    /*
       Method: To Build the Huffman Tree using PriorityQueue and perform traversal
 to encode bits
       Parameter: PriorityQueue<TreeNode>, HashMap<Character,Integer>,
 HashMap<Character,String>
       Return: void
    */
    public static void encodeHuffmanTree(PriorityQueue<TreeNode> pq,
                                         HashMap<Character, Integer> freqTbl, HashMap<Character, String> encodTbl) throws Exception {
        TreeNode rootPQTree = BuildHuffmanTree.buildTreePQ(freqTbl, pq);
        BuildHuffmanTree.encodeTraversal(rootPQTree, "", encodTbl);
    }

    /*
       TO DO
       Method: Encode the test string using Queue & PriorityQueue based HuffmanTree
       Parameter: String, HashMap<Character,String>
       Return: String
    */
    public static String encode(String test, HashMap<Character, String> encodTbl) {
        String myString = ""; // Add onto string then return it
        // Convert  the  test  string  into  encoded  bits by traversing through the String
        for (int i = 0; i < test.length(); i++) {
            myString += encodTbl.get(test.charAt(i));
        }
        return myString;
    }

    /*
       TO DO
       Method: Write your output to the output.txt file
       Parameter: String, String, String
       Return: void
    */
    public static void printOutput(String test, String encodedStrQ, String
            encodedStrPQ) {

        double uncompressedBits = 0;
        for (int i = 0; i < test.length(); i++) {
            uncompressedBits += 8;

        }

        // Count the number of compressed Bits from encoded String of Queue
        int compressedBitsQueue = 0;
        for (int i = 0; i < encodedStrQ.length(); i++) {
            compressedBitsQueue++;
        }

        int compressedBitsPQ = 0;
        for (int i = 0; i < encodedStrPQ.length(); i++) {
            compressedBitsPQ++;
        }


            try {
                // Append to file not override
                PrintWriter out = new PrintWriter(new FileWriter("Output.txt",true));
                // Follow Format
                // [Test String] [Total # of uncompressed bits (8-bits per character)]
                out.print(("[" + test + "]" + " " + "[" + uncompressedBits + "] \n"));


                // Follow Format
                // [Encoded  Bitstream  using  HuffmanTree_Q:  compressed
                // bits] [Total # of compressed bits] [Space Saving(%):?]
                out.print("[Encoded  Bitstream  using  HuffmanTree_Q: " + encodedStrQ + "] " + "[" + compressedBitsQueue + "] "
                        // Space Saving = 1 - compressed bits/ uncompressed bits
                        + "[Space Saving(%):" + (double) (Math.round(((1 - compressedBitsQueue / uncompressedBits) * 100) * 100.0) / 100.0) + "] + \n");

                // Follow Format
                // [Encoded  Bitstream  using  HuffmanTree_PQ:  compressed
                // bits] [Total # of compressed bits] [Space Saving(%):?]
                out.print(("[Encoded  Bitstream  using HuffmanTree_PQ: " + encodedStrPQ + "] " + "[" + compressedBitsPQ + "] "
                        // Space Saving = 1 - compressed bits/ uncompressed bits
                        + "[Space Saving(%):" + (double) (Math.round(((1 - compressedBitsPQ / uncompressedBits) * 100) * 100.0) / 100.0) + "] + \n"));

                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

