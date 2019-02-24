package heroRepository;

import java.util.ArrayList;

public class HeroRepository {
	ArrayList<Hero> data;

	public HeroRepository() {
		this.data = new ArrayList<>();
	}

	public void add(Hero entity) {
		this.data.add(entity);
	}

	public void remove(String name) {
		Hero heroToRemove = this.data.get(0);

		boolean found = false;

		for (Hero hero : this.data) {
			if (hero.getName().equals(name)) {
				heroToRemove = hero;
				found = true;
			}
		}

		if (found) {
			this.data.remove(heroToRemove);
		}
	}

	public Hero getHeroWithHighestStrength() {
		int maxCount = Integer.MIN_VALUE;
		Hero biggestHero = this.data.get(0);

		for (Hero hero : this.data) {
			int currentCount = hero.getItem().getStrength();
			if (currentCount > maxCount) {
				maxCount = currentCount;
				biggestHero = hero;
			}
		}

		return biggestHero;
	}

	public Hero getHeroWithHighestAgility() {
		int maxCount = Integer.MIN_VALUE;
		Hero biggestHero = this.data.get(0);

		for (Hero hero : this.data) {
			int currentCount = hero.getItem().getAgility();
			if (currentCount > maxCount) {
				maxCount = currentCount;
				biggestHero = hero;
			}
		}

		return biggestHero;
	}

	public Hero getHeroWithHighestIntelligence() {
		int maxCount = Integer.MIN_VALUE;
		Hero biggestHero = this.data.get(0);

		for (Hero hero : this.data) {
			int currentCount = hero.getItem().getIntelligence();
			if (currentCount > maxCount) {
				maxCount = currentCount;
				biggestHero = hero;
			}
		}

		return biggestHero;
	}

	public int getCount() {
		return this.data.size();
	}

	@Override
	public String toString() {
		String sb = "";
		for (Hero hero : this.data) {
			sb += hero;
			sb += System.getProperty("line.separator");
		}

		return sb;
	}
}
