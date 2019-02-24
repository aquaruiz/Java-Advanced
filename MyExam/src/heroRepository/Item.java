package heroRepository;

public class Item {
	int strength;
	int agility;
	int intelligence;

	public Item(int strength, int agility, int intelligence) {
		this.strength = strength;
		this.agility = agility;
		this.intelligence = intelligence;
	}

	public int getStrength() {
		return this.strength;
	}

	public int getAgility() {
		return this.agility;
	}

	public int getIntelligence() {
		return this.intelligence;
	}

	@Override
	public String toString() {
		return String.format("Item:%n" + "  * Strength: %d%n" + "  * Agility: %d%n" + "  * Intelligence: %d",
				this.getStrength(), this.getAgility(), this.getIntelligence());
	}
}
