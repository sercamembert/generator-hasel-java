import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class generator {
    static String[] smallLeters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
            "r", "s", "t", "u", "v", "w", "y", "z" };
    static String[] bigLetters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "Y", "Z" };
    static String[] specialChars = { "!", "@", "#", "$", "%", "^", "&", "*" };
    static String[] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

    public static void main(String[] args) {
        int m2 = Integer.parseInt(JOptionPane.showInputDialog("1-Generuje haslo, 2-Generuje pin"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("Ile znaków ma mieć hasło?"));
        if (m2 == 1) {
            if (m < 4) {
                System.out.println("Haslo musi miec co najmniej 4 znaki");
            } else {
                haslo(m);
            }

        } else if (m2 == 2) {
            if (m < 4) {
                System.out.println("Haslo musi miec co najmniej 4 znaki");
            } else {
                pin(m);
            }
        } else {
            System.out.println("Wybierz 1 albo 2");
        }
    }

    public static String generate(int liczbaZnakow) {
        int lottery;
        String password = "";
        int whichBox;
        Random rand = new Random();
        for (int i = 0; i < liczbaZnakow; i++) {
            whichBox = rand.nextInt(4);
            switch (whichBox) {
                case 0:
                    lottery = rand.nextInt(25);
                    password += smallLeters[lottery];
                    break;
                case 1:
                    lottery = rand.nextInt(25);
                    password += bigLetters[lottery];
                    break;
                case 2:
                    lottery = rand.nextInt(8);
                    password += specialChars[lottery];
                    break;
                case 3:
                    lottery = rand.nextInt(10);
                    password += numbers[lottery];
                    break;
            }
        }
        return password;

    }

    public static void pin(int liczba_znakow) {
        Random rand = new Random();
        String pin = "";
        for (int i = 0; i < liczba_znakow; i++) {
            int temp = rand.nextInt(10);
            String str = String.valueOf(temp);
            pin += str;
        }
        pin2(pin);
    }

    public static void pin2(String cos) {
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        JTextArea ta = new JTextArea(1, 1);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        ta.setCaretPosition(0);
        ta.setEditable(false);
        ta.setText("         Wygenerowane hasło to:               " + "       " + cos);
        JOptionPane.showMessageDialog(frame, new JScrollPane(ta), "Hasło", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void haslo(int liczba) {
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        int s = 0;
        int b = 0;
        int sp = 0;
        int n = 0;
        JTextArea ta = new JTextArea(1, 1);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        ta.setCaretPosition(0);
        ta.setEditable(false);
        do {
            s = 0;
            b = 0;
            sp = 0;
            n = 0;
            String pass = generate(liczba);
            for (String x : smallLeters) {
                if (pass.contains(x)) {
                    s++;
                }
            }
            for (String x : bigLetters) {
                if (pass.contains(x)) {
                    b++;
                }
            }
            for (String x : specialChars) {
                if (pass.contains(x)) {
                    sp++;
                }
            }
            for (String x : numbers) {
                if (pass.contains(x)) {
                    n++;
                }
            }
            ta.setText("         Wygenerowane hasło to:               " + "       " + pass);
        } while (s == 0 || b == 0 || sp == 0 || n == 0);
        JOptionPane.showMessageDialog(frame, new JScrollPane(ta), "Hasło", JOptionPane.INFORMATION_MESSAGE);
    }
}