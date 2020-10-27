import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Invoker c = new Invoker();
        StringBuilder sb = new StringBuilder();
        while (input.hasNextLine()) {
            String s = input.nextLine();
            if(s.length() == 0) continue;
            if(s.charAt(0) == 'A') {
                String word = getWord(s);
                c.append(new AddFooterCommand(word), sb);
            }
            if(s.charAt(0) == 'a') {
                String word = getWord(s);
                c.append(new AddHeaderCommand(word), sb);
            }
            if(s.charAt(0) == 'D') {
                c.append(new DeleteFooterCommand(Integer.parseInt(s.split(" ")[1])), sb);
            }
            if(s.charAt(0) == 'd') {
                c.append(new DeleteHeaderCommand(Integer.parseInt(s.split(" ")[1])), sb);
            }

            if(s.charAt(0) == 'u') {
                c.undo(sb);
            }
            if(s.charAt(0) == 'r') {
                c.redo(sb);
            }
            if(s.charAt(0) == 'm') {
                String[] arr = s.split(" ");
                c.addMacro(arr[2], Integer.parseInt(arr[1]));
            }
            if(s.charAt(0) == '$') {
                String name = s.substring(1);
                c.append(c.getMacro(name), sb);
            }
            if(s.charAt(0) == 'l') {
                c.printRecent(Integer.parseInt(s.split(" ")[1]));
            }
            if(s.charAt(0) == 's') {
                System.out.println("\"" + sb.toString() + "\"");
            }
        }
    }

    private static String getWord(String s) {
        int index = s.indexOf(' ');
        int last = s.lastIndexOf("\"");
        return s.substring(index + 2, last);
    }
}
