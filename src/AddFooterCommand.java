public class AddFooterCommand implements Command {
    private String add;

    AddFooterCommand(String add) {
        this.add = add;
    }

    @Override
    public void execute(StringBuilder sb) {
        sb.append(add);
    }

    @Override
    public void cancel(StringBuilder sb) {
        sb.delete(sb.length() - add.length(), sb.length());
    }

    @Override
    public void print() {
        System.out.println("A " + "\"" +add + "\"");
    }
}
