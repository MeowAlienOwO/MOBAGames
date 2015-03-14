
package moba.gameobj.features;

import moba.gameobj.*;

/**
 * Game feature: Attackable
 * 
 * @author Zhang Huayan
 * @version 1.0 Able to perform attack.
 */

public interface Alive extends GameObject {

	public abstract void damage(int damage);

	public abstract void recover(int recover);

	public abstract boolean isAlive();

}
