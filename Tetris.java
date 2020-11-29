package gameTetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class Tetris extends JFrame immplements KeyListener{
  JMenuBar mainmenu = new JMenuBar();
	JPanel menuPanel = new JPanel();
  protected JPanel game = new JPanel();
	protected JPanel left = new JPanel();
	protected JPanel right = new JPanel();
	protected JPanel [][] cells;
	protected JPanel [][] cells2;
	protected JPanel [][] cell;
	protected JPanel [][] cellr;
 	protected JPanel all = new JPanel(new BorderLayout());
	protected JLabel [] picture;
	protected JPanel [] text;
	protected JLabel diem, level;
	protected long d=0;
	protected int demI=0;
	protected int demT=0;
	protected int demO=0;
	protected int demL=0;
	protected int demJ=0;
	protected int demS=0;
	protected int demZ=0;
	boolean perfect = false;
	boolean pause=false;
	boolean help = true;
	boolean newg = true;
	protected int lv=1200;
	protected int cap;
	protected JPanel FP;
	protected JPanel chuatunghinh;
	protected Color curClo;
        Figure Fi;
	public int vitri=0;
	public int k=-1;
	int []a = new int[4];
	int []b = new int [4];
	Random R = new Random();
	public int l= R.nextInt(7);
	FigureI I = new FigureI();
	FigureT T = new FigureT();
	FigureO O = new FigureO();
	FigureL L = new FigureL();
	FigureJ J = new FigureJ();
	FigureS S = new FigureS();
	FigureZ Z = new FigureZ();
	public Color A = new Color(43,43,43);
	public Color B = new Color(49,49,49);
	private static JMenuBar menuBar = new  JMenuBar();
	private static JMenu menuTetris = new JMenu();
	private static JMenu menuHelp = new JMenu();
	private static JMenuItem ItemRestart = new JMenuItem();
	private static JMenuItem ItemPause = new JMenuItem();
	private static JMenuItem ItemHiscore = new JMenuItem();
	public static JMenuItem ItemExit = new JMenuItem();
	private static JMenuItem ItemJetrishelp = new JMenuItem();
	private static JMenuItem ItemAbout = new JMenuItem();
	private static JMenuItem ItemNew = new JMenuItem();
	private static JButton jnewgame = new JButton();
	private static JButton jpause = new JButton();
	private static JButton jhiscore = new JButton();
	private static JButton jrestart = new JButton();
	private static JButton jexit = new JButton();
  
  public Tetris(){
	  super("TETRIS GAME");
	  LashGame sg = new LashGame();
	  addKeyListener(this);
	  setIconImage(LoadImage("mtetris.png"));
	  
	  InitMenu();
	  setJMenubar(menuBar);
	  
	  game=Playgame();
	  all.add(game,BorderLayout.CENTER);
	  
	  Left=SetLeftGame();
	  right=SetRightGame();
	  all.add(left,BorderLayout.WEST);
	  all.add(right,BorderLayout.EAST);
	  add(all);
	  pack();
	  
	  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
	  setLocation(screen.width/2 - getWidth()/2, screen.height/2 - getHeight()/2);
	  this.setResizalbe(True);
	  this.setVisible(True);
	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void InitMenu(){
	  MenuHandler Mh = new MenuHandler();
	  ImageIcon newgame = new ImageIcon("iconimage.png");
	  ImageIcon restart = new ImageIcon("mrestart.png");
	  ImageIcon pause = new ImageIcon("mpause.png");
	  ImageIcon hiscore = new ImageIcon("mhiscore.png");
	  ImageIcon exit = new ImageIcon("mexit.png");
	  
	  menuTetris = new Jmenu("Option");
	  menuTetris.setMnemonic('J');
	  
	  ItemNew = new	JmenuItem("New Game",newgame);
	  ItemNew.setMnemonic('N');
	  ItemNew.addActionListener(Mh);
	  
	  ItemRestart = new JMenuItem("Restart",restart);
	  ItemRestart.setMnemonic('R');
	  ItemRestart.addActionListener(Mh);
	  
	  ItemPause = new JMenuItem("Pause",pause);
	  ItemPause.setMnemonic('P');
	  ItemPause.addActionListener(Mh);
	  
	  ItemHiscore = new JMenuItem("Hiscore",hiscore);
	  ItemHiscore.setMnemonic('C');
	  ItemHiscore.addActionListener(Mh);
	  
	  ItemExit = new JMenuItem("Exit",exit);
	  ItemExit.setMnemonic('E');
	  ItemExit.addActionListener(Mh);
	  
	  menuTetris.add(ItemNew);
	  menuTetris.add(ItemRestart);
	  menuTetris.add(ItemPause);
	  menuTetris.add(ItemHiscore);
	  menuTetris.add(ItemExit);
	  
	  menuBar.add(menuTetris);
	  
  }
      public Jpanel Playgaame(){
          JPanel center = new JPanel(new GridLayout(20,10));
	  center.setPreferredSize(new Dimension(10*24,20*24));
	  cells = new JPanel[20][10];
	  for(int i = 0; i < 20; i++){
		  for(int j = 0; j < 10; j++){
			  cell[i][j]= new JPanel();
			  if((i%2==0 && j%2==0)||(i%2!=0 && j%2!=0))
				  cell[i][j].setBackgroud(A);
			  else
				  cell[i][j].setBackground(B);
			  cell[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			  center.add(cells[i][j]);
		  }
	  }
      return center;
      }
	public JPanel SetLeftgame(){
		JPanel l = new JPanel();
		BoxLayout rl = new BoxLayout(l,BoxLayout.Y_AXIS);
		l.setLayout(rl);
		l.setBorder(new EtchedBorder());
		JPanel JP = new JPanel();
		JP.setLayout(new BoxLayout(JP, BoxLayout(JP,BoxLayout.LINE_AXIS);
		JP.add(new JLabel("Static"));
		l.add(Box.createRigidArea(new Dimension(0,10));
		l.add(JP);
		l.add(Box.createRigidArea(new Dimension(0,10));
		Dimension d = new Dimension(4*12,4*12);
		picture = new JLabel[7];
		for(int k=0; k<7; k++){
			cell= new JPanel[4][4];
			chuatunghinh = new JPanel();
			FP = new JPanel();
			FP.setLayout(new BoxLayout(FP, BoxLayout.LINE_AXIS));
			chuatunghinh.setLayout(new GridLayout(4,4));
			chuatunghinh.setMinimumsize(d);
			chuatunghinh.setPreferredSize(d);
			chuatunghinh.setMaximumSize(d);
			for(int i=0; i<4; i++){
				for(int j=0; j<4; J++){
					cell[i][j] = new JPanel();
					cell[i][j].setBackground(null);
					chuatunghinh.add(cell[i][j]);
				}
			}
			int h=k+1;
			switch(h){
				case 1:{
					FigureI fi = new FigureI();
					for(int i=0; i<4; i++){
						cell[ft.arrX[i]][ft.arrY[i]].setBackground(ft.COL_I);
						cell[ft.arrX[i]][ft.arrY[i]].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
					}
				}break;
				case 2: FigureT ft = new FigureT();{
					for(int i = 0; i<4; i++){
						cell[ft.arrX[i]][ft.arrY[i]].setBackground(ft.COL_T);
						cell(ft.arrX[i]][ft.arrY[i]].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
				        }
	                        }break;
					
			
					       
				     
