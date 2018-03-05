/**
 * Registre Marin contenant une table de hachage de Marins
 */
package org.moussa.serie03.exo8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Moussa KONATE
 */
public class RegistreMarin {

	//Table de hachage
	private Map<Integer, List<Marin>> map =  new HashMap<Integer, List<Marin>>();
	//private Set<Integer> keys = map.keySet();
	

	public void addMap(Marin marin) {
		Integer key = marin.getDecennie(marin.getAnnee());
		//if(map.get(key) == null)
			//marins.add(marin);
		List<Marin> marins = new ArrayList<Marin>();
		if(!map.containsKey(key)) {
			marins.add(marin);
			map.put(key, marins);
		}
		else{
			marins=map.get(key);
			marins.add(marin);
			map.put(key, marins);
		}	
	}
	
	public List<Marin> get(int decennie) {
		return map.get(decennie);
	}
	
	public int count(int decennie) {
		return map.get(decennie).size();
	}
	
	public int count() {
		return map.size();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegistreMarin [map=" + map + "]";
	}

}
