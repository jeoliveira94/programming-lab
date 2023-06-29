package beans;

public class Lion {
    private String name;

    public Lion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lion{" +
                "name='" + name + '\'' +
                '}';
    }
}
