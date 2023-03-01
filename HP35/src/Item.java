import java.util.concurrent.RecursiveTask;

public class Item {
    private ItemType type;
    private int value = 0;

    public Item(int value, ItemType type)
    {
        this.type = type;
        this.value = value;
    }

    public int value()
    {
        return value;
    }

    public ItemType Type()
    {
        return type;
    }
}

