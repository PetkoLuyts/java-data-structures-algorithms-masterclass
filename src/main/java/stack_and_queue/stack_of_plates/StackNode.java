package stack_and_queue.stack_of_plates;

public class StackNode {
    public StackNode above;
    public StackNode below;
    public int value;

    public StackNode(int value) {
        this.value = value;
    }
}
