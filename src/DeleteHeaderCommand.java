import java.util.ArrayList;

public class DeleteHeaderCommand implements Command {
    private int len;
    private ArrayList<String> headers;

    DeleteHeaderCommand(int len) {
        this.len = len;
        this.headers = new ArrayList<>();
    }

    @Override
    public void execute(StringBuilder sb) {
        if(len < sb.length()) {
            headers.add(sb.substring(0, len));
            sb.delete(0, len);
        }else {
            headers.add(sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override
    public void cancel(StringBuilder sb) {
        sb.insert(0, headers.remove(headers.size() - 1));
    }

    @Override
    public void print() {
        System.out.println("d " + len);
    }
}
