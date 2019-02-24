package heroRepository;

public class Hero {
	String name;
	int level;
	Item item;

	public Hero(String name, int level, Item item) {
		this.name = name;
		this.level = level;
		this.item = item;
	}

	public String getName() {
		return this.name;
	}

	public int getLevel() {
		return this.level;
	}

	public Item getItem() {
		return this.item;
	}

	@Override
	public String toString() {
		return String.format("Hero: %s – %d%n", this.getName(), this.getLevel()) + this.item;
	}
}
