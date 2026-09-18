class GymMember{
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;


    public GymMember(String memberId, int monthlyFee) {


        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }


        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("Monthly fee must be positive");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    // Return number of sessions attended
    public int getSessionsAttended() {
        return sessionsAttended;
    }


    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                // Constructor performs validation
                new GymMember(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }
}



class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {


        super(memberId, monthlyFee);

        this.trainerName = trainerName;
    }
}



      class Main {
    public static void main(String[] args) {


        try {
            GymMember g = new GymMember("GM1", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Construction rejected");
        }

        PremiumMember p = new PremiumMember("MEM01", 2000, "Coach Riya");

        p.attendSession();
        p.attendSession();

        System.out.println(p.getSessionsAttended());


        String[] members = {"MEM1", "GM1", "MEM2", " ", "MEM3"};

        System.out.println(GymMember.signUpBatch(members, 1000));
    }
}
