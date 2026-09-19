package q3;

class GymMember {

    private String memberId;
    private int monthlyFee;

    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;

    public GymMember(String memberId, int monthlyFee) {

        if (memberId == null || memberId.trim().isEmpty()
                || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException(
                    "Monthly fee must be positive");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    protected void chargeLateFee(int amount) {

        lateFeeHistory[lateFeeCount] = amount;
        lateFeeCount++;
    }

    public int[] getLateFeeHistory() {

        int[] copy = new int[lateFeeCount];

        for (int i = 0; i < lateFeeCount; i++) {
            copy[i] = lateFeeHistory[i];
        }

        return copy;
    }

    public int getTotalLateFees() {

        int total = 0;

        for (int i = 0; i < lateFeeCount; i++) {
            total = total + lateFeeHistory[i];
        }

        return total;
    }
}


class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee,
                         String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {

        super.chargeLateFee(amount / 2);
    }
}


public class Q3LateFee {

    public static void main(String[] args) {

        PremiumMember member =
                new PremiumMember(
                        "MEM5",
                        2000,
                        "Coach Riya"
                );

        member.chargeLateFee(200);

        System.out.println(
                "Total Late Fees: "
                        + member.getTotalLateFees()
        );

        int[] history = member.getLateFeeHistory();

        history[0] = 999;

        System.out.println(
                "Fee History: "
                        + member.getLateFeeHistory()[0]
        );
    }
}