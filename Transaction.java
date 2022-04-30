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
public interface Transaction {
    
    int getTransactionId();

    String getFirstName();

    String getLastName();

    String getDescription();

    void computeHash(int id, String firstName, String lastName);

    
}
