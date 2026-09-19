package q5;

class GymMember {
    String memberId;
    int monthlyFee;
    int sessionsAttended;
    boolean feePaid;
    String membershipNumber;
    String referralCode;

    GymMember(String memberId, int monthlyFee, String membershipNumber) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.membershipNumber = membershipNumber;
        this.sessionsAttended = 0;
        this.feePaid = false;
    }

    void attendSession() {
        sessionsAttended++;
        System.out.println(memberId + " checked in.");
    }

    void payFee() {
        feePaid = true;
        System.out.println(memberId + " paid fee: " + monthlyFee);
    }

    void displayInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Membership Number: " + membershipNumber);
        System.out.println("Monthly Fee: " + monthlyFee);
        System.out.println("Sessions Attended: " + sessionsAttended);
        System.out.println("Fee Paid: " + feePaid);
    }
}

class PremiumMember extends GymMember {
    String trainerName;

    PremiumMember(String memberId, int monthlyFee,
                  String membershipNumber, String trainerName) {

        super(memberId, monthlyFee, membershipNumber);
        this.trainerName = trainerName;
    }

    void referMember(String referralCode) {
        this.referralCode = referralCode;
        System.out.println(memberId + " referred a new member.");
        System.out.println("Referral Code: " + referralCode);
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Trainer: " + trainerName);
    }
}

public class Q5Membership {

    public static void main(String[] args) {

        GymMember member1 =
                new GymMember("GM101", 1500, "MEM001");

        PremiumMember member2 =
                new PremiumMember("PM201", 2500,
                        "MEM002", "Coach Riya");

        System.out.println("----- MEMBER 1 -----");
        member1.displayInfo();

        System.out.println("\nPaying Fee:");
        member1.payFee();

        System.out.println("\nCheck-in:");
        member1.attendSession();

        System.out.println("\n----- PREMIUM MEMBER -----");
        member2.displayInfo();

        System.out.println("\nPaying Fee:");
        member2.payFee();

        System.out.println("\nCheck-in:");
        member2.attendSession();

        System.out.println("\nReferral:");
        member2.referMember("REF123");

        System.out.println("\n----- FINAL DETAILS -----");
        member1.displayInfo();

        System.out.println();

        member2.displayInfo();
    }
}