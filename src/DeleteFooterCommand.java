import java.util.ArrayList;

public class DeleteFooterCommand implements Command {
    private int len;
    private ArrayList<String> footers;

    DeleteFooterCommand(int len) {
        this.len = len;
        footers = new ArrayList<>();
    }

    @Override
    public void execute(StringBuilder sb) {
        if (len < sb.length()) {
            footers.add(sb.substring(sb.length() - len, sb.length()));
            sb.delete(sb.length() - len, sb.length());
        } else {
            footers.add(sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override
    public void cancel(StringBuilder sb) {
        sb.append(footers.remove(footers.size() - 1));
    }

    @Override
    public void print() {
        System.out.println("D " + len);
    }
}
