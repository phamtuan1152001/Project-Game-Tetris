package gameTetris;

import java.awt.Color;

public abstract class Figure {
	
	protected static final Color COL_I = Color.RED;
	protected static final Color COL_T = Color.BLUE;
	protected static final Color COL_O = Color.CYAN;
	protected static final Color COL_L = Color.YELLOW;
	protected static final Color COL_J = Color.pink;
	protected static final Color COL_S = Color.orange;
	protected static final Color COL_Z = Color.GREEN;
	public int []X;
	public int []Y;
	public int rotati=0;
	public abstract void rotation();
	public abstract int get_rotati();
}
