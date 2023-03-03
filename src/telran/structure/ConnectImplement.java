package telran.structure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class ConnectImplement implements ConnectionsPool {

		private static final Integer NUMBER_OF_MAX_CONNNECTIONS = 5;
		private LinkedHashMap <Integer, Connection> connections = new LinkedHashMap<>();
		private Integer maxOfConnect;
		private Integer lastConnect;
		
		public Integer getMaxOfConnect() {
			return maxOfConnect;
		}

		public void setMaxOfConnect(Integer maxOfConnect) {
			this.maxOfConnect = maxOfConnect;
		}

		public Integer getLastConnect() {
			return lastConnect;
		}

		public void setLastConnect(Integer lastConnect) {
			this.lastConnect = lastConnect;
		}
		
		public ConnectImplement(Integer maxOfConnect) {
			super();
			this.maxOfConnect = maxOfConnect;
		}
		
		public ConnectImplement() {
			this(NUMBER_OF_MAX_CONNNECTIONS);
		}
		

	@Override
	public boolean addConnection(Connection connection) {
		boolean res = false;
		if (connections.containsKey(connection.getId()) == false) {
			if (connections.isEmpty() == false) {
				if (connections.size() == maxOfConnect) {
					connections.remove(lastConnect);
					changeOrder();
			}
			} else {
					lastConnect = connection.getId();
					}
			connections.put(connection.getId(), connection);
			res = true;
		} 
			return res;
	}

	private void changeOrder() {
		Set<Integer> set = connections.keySet();
		Iterator<Integer> it = set.iterator();
		lastConnect = it.next();
		}

	@Override
	public Connection getConnection(int id) {
		Connection res = connections.get(id);
			connections.remove(id);
			addConnection(res);
			changeOrder();
			return res;
	}

}
