import java.util.* ;
import java.io.*; 
import java.math.BigInteger;
public class Solution 
{
    public static int compareVersions(String a, String b) 
    {
        String[] versionA = a.split("\\.");
        String[] versionB = b.split("\\.");

        int maxLength = Math.max(versionA.length, versionB.length);

        for (int i = 0; i < maxLength; i++) {
            BigInteger numA = (i < versionA.length) ? new BigInteger(versionA[i]) : BigInteger.ZERO;
            BigInteger numB = (i < versionB.length) ? new BigInteger(versionB[i]) : BigInteger.ZERO;

            int comparison = numA.compareTo(numB);
            if (comparison != 0) {
                return comparison;
            }
        }

        return 0;
    }
}
