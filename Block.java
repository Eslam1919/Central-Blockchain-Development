/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

/**
 *
 * @author salkh
 */

import java.util.Date;

public class Block implements Transaction {

    private final int transactionId;

    private final String firstName;

    private final String lastName;

    private final String description;

    private final long timeStampMills;

    private long hashNextBlock;

    private static int numBlocks = 0;

    public Block(int id, String first, String last, String description) {

        transactionId = id;

        firstName = first;

        lastName = last;

        this.description = description;

        timeStampMills = new Date().getTime();

        numBlocks++;

    }

    public static int getNumBlocks() {

        return numBlocks;

    }

  

    @Override

    public int getTransactionId() {
        return transactionId;

    }

    @Override

    public String getFirstName() {

        return firstName;

    }

    @Override

    public String getLastName() {

        return lastName;

    }

    @Override

    public String getDescription() {

        return description;

    }

    @Override

    public void computeHash(int id, String firstName, String lastName) {

        String name = firstName + lastName;

        int sum = 0;

        for (int i = 0; i < name.length(); i++) {

            sum += name.charAt(i);

        }

        hashNextBlock = sum * 10000 + id;

    }

    public long getHashNextBlock() {

        return hashNextBlock;

    }

    public long getTimeStampMills() {

        return timeStampMills;

    }

    @Override

    public String toString() {

        return "\n";

    }


    
}
