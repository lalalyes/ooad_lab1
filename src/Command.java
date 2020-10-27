public interface Command {
    void execute(StringBuilder sb);

    void cancel(StringBuilder sb);

    void print();
}
