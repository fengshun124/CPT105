/*
Lab Exercise #5.2 Check if the string matches the membership ID pattern
 */
public class CheckMembership {
    public static void main(String[] args) {
        System.out.println(checkMembership("A-123-456-23A"));
        System.out.println(checkMembership("A-187-267-111"));
        System.out.println(checkMembership("c-542-223-11G"));
        System.out.println(checkMembership("A-187-267+111"));
        System.out.println(checkMembership("A-187-11G"));
        System.out.println(checkMembership("E-123-456-23A"));
        System.out.println(checkMembership("b-555-88-123T"));
    }

    public static boolean checkMembership(String membershipId) {
        // if the length is exactly 13 characters
        if (membershipId.length() != 13) {
            return false;
        }

        // if the format is 4 blocks separated by hyphens
        String[] blocks = membershipId.split("-");
        if (blocks.length != 4) {
            return false;
        }

        // check the first block (1 character between A and D, case-insensitive)
        String firstBlock = blocks[0];
        if (firstBlock.length() != 1 || !firstBlock.matches("[A-Da-d]")) {
            return false;
        }

        // check the second block (must be 3 digits)
        String secondBlock = blocks[1];
        if (secondBlock.length() != 3 || !secondBlock.matches("\\d{3}")) {
            return false;
        }

        // check the third block (must be 3 digits)
        String thirdBlock = blocks[2];
        if (thirdBlock.length() != 3 || !thirdBlock.matches("\\d{3}")) {
            return false;
        }

        // check the fourth block (must be 2 digits followed by a letter between A and T)
        String fourthBlock = blocks[3];
        return fourthBlock.length() == 3 && fourthBlock.matches("\\d{2}[A-Ta-t]");

        // If all checks pass, the membership ID is valid
    }
}
