package es.ucm.tp1.gameobjects;

import es.ucm.tp1.logic.Game;

		public class SuperCoin extends Coin{
		
		private static int gameCoinsCount;
		public static final Object INFO = "[SUPERCOIN] gives 1000 coins";
		public static boolean hasSuperCoin=false;

		public SuperCoin(Game game, int row, int col) {
			super(game,row,col);
			symbol= "$";
			
			
		}
	

	
		
	

		public void setAlive(boolean isAlive) {
			this.isAlive = isAlive;
		}

		public boolean GetisAlive() {
			return isAlive;
		}

		@Override
		public boolean doCollision() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean receiveCollision(Player player) {
			// TODO Auto-generated method stub
			
			game.incrementCoins(1000);
			onDelete();
			return true;
		}

		@Override
		public void onEnter() {
			// TODO Auto-generated method stub
			hasSuperCoin=true;
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub
		}

		@Override
		public void onDelete() {
		hasSuperCoin=false;
		}

	
		




		public static boolean hasSuperCoin() {
			// TODO Auto-generated method stub
			return hasSuperCoin;
		}
		
	}



