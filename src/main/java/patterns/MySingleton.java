package patterns;

public class MySingleton {

	private MySingleton instance = null;

	private MySingleton(){
	}

	synchronized public MySingleton getInstance() {
		if(instance == null) {
			instance = new MySingleton();
		}
		return instance;
	}

	public MySingleton getInstanceOtherWay() {
		if (instance == null) {
			//synchronized block to remove overhead
			synchronized (MySingleton.class) {
				if(instance==null) {
					instance = new MySingleton();
				}
			}
		}
		return instance;
	}
}
