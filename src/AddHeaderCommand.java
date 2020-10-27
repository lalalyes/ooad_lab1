public class AddHeaderCommand implements Command {
    private String add;

    AddHeaderCommand(String add) {
        this.add = add;
    }

    @Override
    public void execute(StringBuilder sb) {
        sb.insert(0, add);
    }

    @Override
    public void cancel(StringBuilder sb) {
        sb.delete(0, add.length());
    }

    @Override
    public void print() {
        System.out.println("a " + "\"" +add + "\"");
    }
}
