import java.util.ArrayList;
import java.util.HashMap;

class Invoker {

    private ArrayList<Command> commands;
    private int current;
    private HashMap<String, MacroCommand> macros;
    Invoker() {
        commands=new ArrayList<>();
        current = 0;
        macros = new HashMap<>();
    }

    void addMacro(String name, int num) {
        ArrayList<Command> list = new ArrayList<>();
        for(int i = Math.max(0, current - num); i < current; i++) {
            list.add(commands.get(i));
        }
        macros.put(name, new MacroCommand(list, name));
    }

    MacroCommand getMacro(String name) {
        return macros.get(name);
    }

    void printRecent(int num) {
        for(int i = 1; i <= num; i++) {
            int val = current - i;
            if(val < 0) break;
            System.out.print(i + " ");
            commands.get(val).print();
        }
    }

    private void execute(StringBuilder sb) {
        int size = commands.size();
        if(current >= size) return;
        Command c = commands.get(current);
        current++;
        c.execute(sb);
    }

    void append(Command c, StringBuilder sb) {
        if (current == commands.size()) {
            commands.add(c);
            execute(sb);
        }else {
            for(int i = commands.size() - 1; i >= current; i--) {
                commands.remove(i);
            }
            commands.add(c);
            execute(sb);
        }
        System.out.println("\"" + sb.toString() + "\"");
    }

    private void cancel(StringBuilder sb) {
        if (current == 0) return;
        current--;
        commands.get(current).cancel(sb);
    }

    void undo(StringBuilder sb){
        cancel(sb);
        System.out.println("\"" + sb.toString() + "\"");
    }

    void redo(StringBuilder sb){
        execute(sb);
        System.out.println("\"" + sb.toString() + "\"");
    }

}