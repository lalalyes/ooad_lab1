import java.util.ArrayList;

public class MacroCommand implements Command {
    private ArrayList<Command> commands;
    private String name;

    MacroCommand(ArrayList<Command> commands, String name) {
        this.commands = commands;
        this.name = name;
    }

    @Override
    public void execute(StringBuilder sb) {
        for (Command c : commands) {
            c.execute(sb);
        }
    }

    @Override
    public void cancel(StringBuilder sb) {
        for(int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).cancel(sb);
            //System.out.println("undo:" + sb.toString());
        }
    }

    @Override
    public void print() {
        System.out.println(name);
    }
}
