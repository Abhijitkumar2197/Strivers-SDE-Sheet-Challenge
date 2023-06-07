import java.util.*;

class Solution {

  public static String completeString(int n, String[] a) {
    HashSet<String> set = new HashSet<>();
    HashMap<String, Boolean> isprefix = new HashMap<>();
    for (int i = 0; i < n; i++) {
      set.add(a[i]);
    }
    String maxLength = "None";
    for (int i = 0; i < n; i++) {
      if (checker(set, isprefix, a[i])) {
        if (maxLength.equals("None") || maxLength.length() <= a[i].length()) {
          maxLength = a[i];
        }
      }
    }
    return maxLength;
  }

  public static boolean checker(HashSet<String> set, HashMap<String, Boolean> isprefix, String target) {
    if (target.length() == 0) {
      return true;
    }
    if (isprefix.containsKey(target)) {
      return isprefix.get(target);
    }
    if (!set.contains(target)) {
      isprefix.put(target, false);
      return false;
    }
    boolean check = checker(set, isprefix, target.substring(0, target.length() - 1));
    isprefix.put(target, check);
    return check;
  }
}
