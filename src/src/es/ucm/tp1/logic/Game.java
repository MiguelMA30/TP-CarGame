package es.ucm.tp1.logic;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import es.ucm.tp1.control.Level;
import es.ucm.tp1.exceptions.CommandExecuteException;
import es.ucm.tp1.exceptions.InputOutputRecordException;
import es.ucm.tp1.gameobjects.GameObject;
import es.ucm.tp1.gameobjects.GameObjectList;
import es.ucm.tp1.gameobjects.Player;
import es.ucm.tp1.logic.GameObjectGenerator;
import es.ucm.tp1.view.Record;


public class Game {
	private long seed;
	private Level level;
	private boolean endGame;
	private int distanceX;
	private int distanceY;
	private Player player;
	private GameObjectList list;
	private Random rand;
	private long initialTime;
	private int cycles;
	private boolean testMode;
	private boolean exit;
	private Record record;
	public Game(Long seed, Level level) {
		this.endGame=false;
		this.seed = seed;
		this.level = level;
		this.exit=false;
			// TODO Auto-generated catch block
			
		reset(this.level,this.seed);

	}

	public void isTestActivated() {
		
		 this.testMode=true;
	}
	public boolean toggleTest() {
		if(this.level==level.TEST) {
			isTestActivated();
		}
		// TODO Auto-generated method stub
		return this.testMode ==true;

	}

	public void exitGame() {
		this.endGame=true;
		this.exit=true;
		
	}
	public boolean setUserExit() {
		return this.exit ==true;
	}

	public boolean getEndGame() {
		return this.endGame;
	}

	

	public String positionToString(int row, int col) {
		// TODO Auto-generated method stub¡
		String objects="";
		if (row == player.getX() && col + player.getY() == player.getY()) {
			
			objects+=player.toString()+" ";
		}
		if (col + player.getY() == level.getLength()) {
            return "¦";
		}
		objects+= list.posicionToString(row,col);
			
		
		return objects;
	
	}
	public String serializePosition(int row, int col) {
		String s = "";
		if(player.getX()==row && player.getY()==col) {
			s+=player.serialize()+"\n";
		}
		s+=list.serializePosition(row, col);
		return s;
	}


	public void goUp() {
		// TODO Auto-generated method stub
		player.goUp();
	}

	public void goDown() {
		// TODO Auto-generated method stub
		player.goDown();
	}

	public int getWidth() {
		return level.getWidth();
	}

	public void update() {
		// TODO Auto-generated method stub
	
		player.update();
		list.update();
		try {
			this.updateRecord();
		} catch (CommandExecuteException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido leer el récord");
		}
		GameObjectGenerator.generateRuntimeObjects(this);
		
		cycles += 1;
	}
	public int getRandomWidth() {
		// TODO Auto-generated method stub
		return (int) (rand.nextDouble() * level.getWidth());
	}
	public void reset(Level level, long seed) {
		
		this.endGame=false;
		this.seed = seed;
		this.level = level;
		this.exit=false;
		try {
			this.record= Record.load(level);
		} catch (CommandExecuteException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido leer bien el record");;
		}
		
		this.distanceX=0;
		this.distanceY=0;
		this.list = new GameObjectList();
		this.testMode = false;
		this.player = new Player(this, level.getWidth() / 2, 0);
		this.rand = new Random(seed);
		this.initialTime = System.currentTimeMillis();
		GameObjectGenerator.reset(level);

		GameObjectGenerator.generateGameObjects(this, level);
		
		
	this.cycles = 0;
	

	}
public void reset() {
		
		this.endGame=false;
	
		
		this.distanceX=0;
		this.distanceY=0;
		this.list = new GameObjectList();
		this.testMode = false;
		this.player = new Player(this, level.getWidth() / 2, 0);
		this.rand = new Random(seed);
		this.initialTime = System.currentTimeMillis();
		GameObjectGenerator.reset(level);

		GameObjectGenerator.generateGameObjects(this, level);
		
		
	this.cycles = 0;
	

	}
	

	public void tryToAddObject(GameObject object, double frequency) {
		if (rand.nextDouble() < frequency && objectPositionEmpty(object.getX(), object.getY()) ) {
			list.add(object);
			object.onEnter();

		}

	}
	public void finJuego() {
		if (playerIsCrashed()) {
			this.endGame = true;

		} else if (playerFinish()) {
			this.endGame = true;
		}
	}

	public boolean playerIsCrashed() {
		return player.getIsCrash();
	}

	public boolean playerFinish() {
		return player.getY() == this.level.getLength()+1;
	}

	public Level getLevel() {
		// TODO Auto-generated method stub
		return this.level;
	}

	public int getVisibility() {
		// TODO Auto-generated method stub
		return level.getVisibility();
	}

	public int distanceToGoal() {
		// TODO Auto-generated method stub
		return level.getLength()-player.getY();
	}

	public int playerCoins() {
		// TODO Auto-generated method stub
		return player.getCoins();
	}

	public int getCycle() {
		// TODO Auto-generated method stub
		return cycles;
	}

	public long elapsedTime() {
		// TODO Auto-generated method stub
		return (System.currentTimeMillis() - initialTime) ;
	}

	public boolean isNewRecord() {
		// TODO Auto-generated method stub
		return elapsedTime()<record.getCurrentRecord();
	}
	public long getRecord() {
		return record.getCurrentRecord();
	}

	

	public int getRoadLength() {
		// TODO Auto-generated method stub
		return level.getLength();
	}

	
	public boolean objectPositionEmpty(int x, int y) {
		return list.getObjectInPosition(x, y) == null;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void removeDead(GameObject obj) {
		list.remove(obj);
		
		
	}

	public void decrementCoins(int coins) {
	player.decrementCoins(coins);
	}
	public void incrementCoins(int coins) {
	player.incrementCoins(coins);
	}

	
	public boolean PositionValid(int x, int y) {
		return (x >= 0 && x < level.getLength()) && (y >= 0 && y < level.getWidth());
		
	}

	



	public boolean hasCoins(int cost) {
		// TODO Auto-generated method stub
		return player.getCoins()>=cost;
	}

	public void forceAddObject(GameObject o) {
		// TODO Auto-generated method stub
		list.add(o);
	}

	public void clear() {
		// TODO Auto-generated method stub
		
			
			list.clear();
		
	}
	public void setDistanceToGrenade(int x,int y) {
		this.distanceX=x;
		this.distanceY=y;
	}

	public int getDistanceX() {
		return distanceX;
	}

	public void updateRecord() throws CommandExecuteException {
		if(this.isNewRecord()) 
		record.save(level, this.elapsedTime());
	}

	public int getDistanceY() {
		return distanceY;
	}
	public int getCycles() {
		return this.cycles;
	}

	public void clearColumn(int lc) {
		
			list.clearColumn(lc);
	}
	public Collider getObjectInPosition(int x, int y) {
		// TODO Auto-generated method stub
		return list.getObjectInPosition(x, y);
	}
	public void serializePosition() {
		// TODO Auto-generated method stub
		
		player.serialize();
		list.serializePosition();
	}
	
}
