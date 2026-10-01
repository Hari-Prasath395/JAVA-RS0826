package ProgramsBySN;

public class ReverseString {

    public static String reverseString(String str) {

        if(str==null|| str.length()==0){
            return null;
        }

       char[] characters = str.toCharArray();
        int startIndex = 0;
        int endIndex = str.length()-1;

        while(startIndex<endIndex){
            char temp = characters[startIndex];

            // Trace current pointers
            System.out.println("startIndex: " + startIndex + " ('" + characters[startIndex] + "'), " +
                    "endIndex: " + endIndex + " ('" + characters[endIndex] + "')");

            characters[startIndex] = characters[endIndex];


            characters[endIndex] =temp;

            startIndex++;
            endIndex--;

        }

        return new String(characters);


    }

    public static void main(String[] args) {
        reverseString("Automation Testi");

    }
}
