public class AnagramsCheck {
    public static boolean isAnagram(String c, String d) {
        if (c.length() != d.length())
            return false;
            
        int count = 0;
    
        for(int i = 0; i < c.length(); i++) {
            count = count + c.charAt(i);
        }

        for(int i = 0; i < d.length(); i++) {
            count = count - d.charAt(i);
        }
        return (count == 0);
    }
    public static void main(String[] args) {
        String str1 = "vscode";
        String str2 = "svedoc";
    
        if (isAnagram(str1, str2))
            System.out.println("The two strings are anagram of each other");
        else
            System.out.println("The two strings are not anagram of each other");
    }
}