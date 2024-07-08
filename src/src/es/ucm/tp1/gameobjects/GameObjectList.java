package es.ucm.tp1.gameobjects;

import java.util.ArrayList;
import java.util.List;
import es.ucm.tp1.gameobjects.GameObject;

public class GameObjectList {
	private List<GameObject> objectList;
	public GameObjectList() {
		objectList= new ArrayList<GameObject>();
	}
	
	
	public GameObject getObjectInPosition(int x, int y) {
		for (int i = 0; i < objectList.size(); i++) {
			if ((objectList.get(i).getX() == x) && (objectList.get(i).getY() == y)) {
				return objectList.get(i);
			}
		}
		return null;
	}
	public void update() {
		for(GameObject go :objectList) {
			go.update();
		}
		removeDeadObjects();
	}
	public String serializePosition() {
		String s="";
		for (GameObject object : objectList){
			s+=object.serialize();
		}
		return s;
	}
	

	
	public void removeDeadObjects() {
		List<GameObject> aux = new ArrayList<GameObject>();
		for (GameObject object : objectList) {
			if (!object.isAlive) {
				object.onDelete();
			}
			else {
				aux.add(object);
			}
		}
		objectList = aux;
	}
	public void add(GameObject object) {
		objectList.add(object);
	}

	public String posicionToString(int row, int col) {
		String objects="";
		for(GameObject go: objectList) {
			if(row== go.getX() && col+ go.game.getPlayer().getY()== go.getY()) {
				objects=objects+go.toString()+" ";
				
			}
			
	}
		return objects;
	}
	
	public String serializePosition(int row, int col) {
		String objects="";
		for(GameObject go: objectList) {
			if(row== go.getX() && col== go.getY()) {
				objects+=(go.serialize()+"\n");
			}
		}
		return objects;
	}


	public void remove(GameObject obj) {
		// TODO Auto-generated method stub
		objectList.remove(obj);
	}


	public void clear() {
		// TODO Auto-generated method stub
		objectList.clear();
	}


	public void clearColumn(int lc) {
		// TODO Auto-generated method stub
		
		 List<GameObject> indexList=new ArrayList<GameObject>();
		// TODO Auto-generated method stub
		
	for(GameObject go :objectList) {
		
			if(go.getY()==lc) {
			indexList.add(go);
			}
	}
	
	for(GameObject go :indexList) {
		this.remove(go);
	}

	}
}

