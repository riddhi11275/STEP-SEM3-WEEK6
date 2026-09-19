package q4;

class GymMember {

    int sessionsAttended;

    GymMember() {
        sessionsAttended = 0;
    }

    void attendSession() {
        sessionsAttended++;
    }

    int getSessionsAttended() {
        return sessionsAttended;
    }

    void displayInfo() {
        System.out.print(
                "Standard | Sessions: "
                        + sessionsAttended
        );
    }
}


class PremiumMember extends GymMember {

    String trainerName;

    PremiumMember(String trainerName) {
        super();
        this.trainerName = trainerName;
    }

    @Override
    void displayInfo() {
        System.out.print(
                "Premium | Trainer: "
                        + trainerName
                        + " | Sessions: "
                        + sessionsAttended
        );
    }
}


public class Q4Attendance {

    static String batchPrint(GymMember[] members) {

        StringBuilder result = new StringBuilder();

        for (GymMember member : members) {

            member.displayInfo();

            if (member instanceof PremiumMember) {

                PremiumMember premium =
                        (PremiumMember) member;

                result.append(" [Trainer via downcast: ")
                        .append(premium.trainerName)
                        .append("]");
            }

            result.append(" | ");
        }

        return result.toString();
    }


    public static void main(String[] args) {

        GymMember standard =
                new GymMember();

        PremiumMember premium =
                new PremiumMember("Coach Riya");

        GymMember[] members = {
                standard,
                premium
        };

        String announcement =
                batchPrint(members);

        System.out.println();
        System.out.println(announcement);
    }
}
