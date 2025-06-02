package management;

import datastructures.lists.CustomArrayList;
import library.Book;
import library.Member;
import library.Transaction;

import java.util.Date;

public class TransactionManager {
    private CustomArrayList<Transaction> transactionList;

    public TransactionManager() {
        transactionList = new CustomArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {

        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type
        );

        transactionList.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        try {
            return transactionList.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
