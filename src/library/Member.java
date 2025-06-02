package library;

import datastructures.stacks.CustomStack;

public class Member {
    private String memberId;
    private String name;
    CustomStack<Transaction> membersTransactions;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        membersTransactions = new CustomStack<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        if (transaction == null)
            throw new IllegalArgumentException();

        membersTransactions.add(transaction);
    }

    public Transaction getLastTransaction() {
        return membersTransactions.peek();
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
