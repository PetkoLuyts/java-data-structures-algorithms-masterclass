package stack_and_queue.animal_shelter;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String name() {
        return "Cat: " + name;
    }
}
