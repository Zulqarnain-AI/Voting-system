
import java.util.ArrayList;

class Registration {
    static ArrayList<Voter> voters = new ArrayList<>();
    static ArrayList<Candidate> candidates = new ArrayList<>();

    public static boolean addVoter(String id, String name,String area) {
        for (Voter voter : voters) {
            if (voter.id.equals(id)) return false;
        }
        voters.add(new Voter(id, name,area));
        return true;
    }

    public static boolean addCandidate(String id, String name) {
        for (Candidate candidate : candidates) {
            if (candidate.id.equals(id)) return false;
        }
        candidates.add(new Candidate(id, name));
        return true;
    }
}

