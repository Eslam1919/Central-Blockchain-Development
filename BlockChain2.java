
package blockchain;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;

import java.util.ListIterator;

import java.util.Scanner;


public class BlockChain2 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("transactions"))) {

            Scanner sc = new Scanner(System.in);
            int transId = 0;

            String first = "";

            String last = "";

            List<Block> blocks = new ArrayList();

            String transactionId = br.readLine();

            String customerName = br.readLine();

            String description = br.readLine();

            Block block = null;

            while (transactionId != null && customerName != null && description != null) {
                transId = Integer.parseInt(transactionId);
                String[] name = customerName.split(" ");
                block = new Block(transId, name[0], name[1], description);

                transactionId = br.readLine();

                customerName = br.readLine();

                description = br.readLine();

                System.out.println(block.getTransactionId() + "--" + block.getFirstName() + "--" + block.getLastName() + "--" + block.getDescription());

                blocks.add(block);

            }

            System.out.println("Welcome to Block Chain!");

            System.out.println("Total Number of Blocks :" + block.getNumBlocks());

            System.out.println("Would you like to add another transaction(y/n)?:");

            String choice = sc.next();

            while (choice.equalsIgnoreCase("y")) {

                System.out.println("Enter the transaction Id:");

                transId = sc.nextInt();

                System.out.println("Enter the customer first name:");

                first = sc.next();

                System.out.println("Enter the customer last name:");

                last = sc.next();

                System.out.println("Enter transaction description");

                description = sc.next();

                block = new Block(transId, first, last, description);

                blocks.add(block);

                System.out.println("Total Number of Blocks :" + Block.getNumBlocks());

                System.out.println("Would you like to add another transaction(y/n)?:");

                choice = sc.next();

            }

            System.out.println("Total Number of Blocks :" + Block.getNumBlocks());

            System.out.println("nter the name of the output file:");

            String fileName = sc.next();

            PrintWriter pw = new PrintWriter(new FileWriter(fileName));

            Iterator itr = blocks.iterator();

            ListIterator litr = blocks.listIterator();

            litr.next();

            while (itr.hasNext()) {

                block = (Block) itr.next();

                pw.println("Id:" + block.getTransactionId());

                pw.println("Name:" + block.getFirstName() + " " + block.getLastName());

                pw.println("description:" + block.getDescription());

                pw.println("Time Stamp :" + block.getTimeStampMills());

                if (litr.hasNext()) {

                    Block block1 = (Block) litr.next();

                    block.computeHash(block1.getTransactionId(), block1.getFirstName(), block1.getLastName());

                    pw.println("Hash of the Next Block:" + block.getHashNextBlock());

                }

            }

            pw.println("Hash of the Next Block: 0");

            pw.flush();
        }

    }


    
    
}
