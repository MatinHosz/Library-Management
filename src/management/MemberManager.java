package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    CustomHashMap<String, Member> idToMembersMap;

    public MemberManager() {
        idToMembersMap = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        if (member == null)
            throw new IllegalArgumentException();
        idToMembersMap.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        return idToMembersMap.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        if (!idToMembersMap.containsKey(memberId)) {
            System.out.println("Member with memberID: " + memberId + " not found!");
            return;
        }
        if (transaction == null)
            throw new IllegalArgumentException();

        Member targerMember = idToMembersMap.get(memberId);
        targerMember.addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        if (!idToMembersMap.containsKey(memberId)) {
            System.out.println("Member with memberID: " + memberId + " not found!");
            return null;
        }

        Member targetMember = idToMembersMap.get(memberId);
        return targetMember.getLastTransaction();
    }
}
