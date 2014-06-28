package rltut;

public class FungusAi extends CreatureAi {
	private CreatureFactory factory;
	private int spreadcount;
	
	public FungusAi(Creature creature, CreatureFactory factory) {
		super(creature);
		this.factory = factory;
	}

	public void onUpdate(){
		if (spreadcount < 5 && Math.random() < 0.01)
			spread();
	}
	
	private void spread(){
		int x = creature.x + (int)(Math.random() * 11) - 5;
		int y = creature.y + (int)(Math.random() * 11) - 5;
		
		if (!creature.canEnter(x, y))
			return;
		
		creature.doAction("spawn a child");
		
		Creature child = factory.newFungus();
		child.x = x;
		child.y = y;
		spreadcount++;
	}
}
