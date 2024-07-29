import java.util.HashSet;
import java.util.Set;


/**
 * Unique Email Addresses
 * https://leetcode.com/explore/interview/card/google/67/sql-2/3044/
 */
public class NumUniqueEmails {
    public static void main(String[] args) {
        // test input
        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        System.out.printf("\nNumber of unique emails: %d\n", linearIteration(emails));
    }

    /**
     * Approach 1: Linear Iteration
     *
     * Complexity Analysis
     *
     * Let N be the number of the emails and M be the average length of an email.
     *
     * Time Complexity: O(N⋅M)
     * In the worst case, we iterate over all the characters of each of the emails given.
     * If we have N emails and each email has M characters in it.
     * Then complexity is of order (Number of emails) * (Number of characters in average email) = N*M.
     *
     * Space Complexity: O(N⋅M)
     * In the worst case, when all emails are unique, we will store every email address given to us in the hash set.
     * @param emails - array of input emails
     * @return number of unique recipients
     */
    private static int linearIteration(String[] emails) {
        // has set to store all the unique emails
        Set<String> uniqueEmails = new HashSet<>();

        // this output is for debug purposes only
        System.out.println("Logs:");

        // iterate over all emails
        for (String email : emails) {
            StringBuilder cleanMail = new StringBuilder();

            // iterate over each character in email
            for (int i = 0; i < email.length(); ++i) {
                char c = email.charAt(i);

                // stop adding characters to localName
                if (c == '+' || c == '@') {
                    break;
                }

                // add this character if not '.'
                if (c != '.') {
                    cleanMail.append(c);
                }
            }

            // compute domain name (substring from end to '@')
            StringBuilder domainName = new StringBuilder();

            for (int i = email.length() - 1; i >= 0; --i) {
                char c = email.charAt(i);
                domainName.append(c);
                if(c == '@') {
                    break;
                }
            }

            domainName.reverse();
            cleanMail.append(domainName);
            System.out.printf("%s -> %s\n", email, cleanMail);
            uniqueEmails.add(cleanMail.toString());
        }

        return uniqueEmails.size();
    }
}