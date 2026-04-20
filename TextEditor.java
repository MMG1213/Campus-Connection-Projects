import java.util.*;

class TextEditor {
    static Stack<String> undo = new Stack<>();
    static Stack<String> redo = new Stack<>();
    static String text = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add 2.Undo 3.Redo 4.Show 5.Exit");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) {
                undo.push(text);
                text += sc.nextLine();
                redo.clear();
            } else if (ch == 2) {
                if (!undo.isEmpty()) {
                    redo.push(text);
                    text = undo.pop();
                }
            } else if (ch == 3) {
                if (!redo.isEmpty()) {
                    undo.push(text);
                    text = redo.pop();
                }
            } else if (ch == 4) {
                System.out.println(text);
            } else break;
        }
    }
}
