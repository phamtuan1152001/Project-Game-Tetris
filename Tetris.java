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
				case 3:	FigureO fo = new Figureo();{
					for(int i = 0; i < 4; i++){
						cell[fo.arrX[i]][fo.arrY[i]].setbackground(fo.COL_L);
						cell[fo.arrX[i]][fo.arrY[i]].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
						}
					}break;
				case 4: FigureL fl = new FigureL();{
					for( int i = 0; i < 4; i++){
						cell[fl.arrX[i]][fl.arrY[i]].setbackground(fl.COL_L);
						cell[fl.arrX[i]][fl.arrY[i]].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
					}
				}break;
				case 5: FigureJ fj = new FigureJ();{
					for(int i=0;i<4;i++){
						cell[fj.arrX[i]][fj.arrY[i]].setBackground(fj.COL_J);
						cell[fj.arrX[i]][fj.arrY[i]].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
						}
				}break;
				case 6: FigureS fs = new FigureS();{
					for(int i=0;i<4;i++){
						cell[fs.arrX[i]][fs.arrY[i]].setBackground(fs.COL_S);
						cell[fs.arrX[i]][fs.arrY[i]].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
						}
				}break;
				case 7: FigureZ fz = new FigureZ();{
					for(int i=0;i<4;i++){
						cell[fz.arrX[i]][fz.arrY[i]].setBackground(fz.COL_Z);
						cell[fz.arrX[i]][fz.arrY[i]].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
						}
				}break;
			}
			FP.add(chuatunghinh);
			JLabel text = new JLabel(" X ");
			FP.add(text);
			
			picture[k] = new JLabel(" 0 ");
			picture[k].setForeground(color.BLUE);
			FP.add(picture[k]);
			l.add(FP);
			l.add(Box.createRigidArea(new Dimension(100, 15)));
		}			       
		l.setMinimumSize(new Dimension(150,0));
		l.setPreferredSize(new Dimension(150,0));
		l.setMaximumSize(new Dimension(150,0));
		return l;
	}
	public JPanel SetRightGame(){
		JPanel r new JPanel();
		r.setBorder(new EtchedBorder());
		BoxLayout lr = new BoxLayout(r, BoxLayout.Y_AXIS);
		r.setLayout(lr);
		
		JPanel sharp = new JPanel();
		
		Dimension d = new Diemension(100, 100);
		sharp.setLayout(new GridLayout(4, 4));
		sharp.setMaximumSize(d);
		sharp.setMinimumSize(d);
		sharp.setPreferredSize(d);
		cellr = new JPanel[4][4];
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				cellr[i][j] = new JPanel();
				sharp.add(cellr[i][j]);
			}
		}
		
		JLabel nextSharp = new JLabel("Next Shape            ");
		nextSharp.setForeground(Color.BLACK);
		r.add(nextSharp);
		r.add(sharp);
		r,add(Box.createRigidAre(new Dimension(0, 50)));
		JPanel score = new JPanel(new FlowLayout());
		JLabel textscore = new JLabel("Score : ");
		textscore.setForeground(Color.BLACK);
		score = new JLabel (" 0 ");
		score.setForeground(Color.RED);
		
		JPanel LV = new JPanel(new FlowLayout());
		JLabel textlevel = new JLabel("Level : ");
		textlevel.setForeground(Color.BLACK);
		level = new JLabel(" 0 ");
		level.setForeground(Color.RED);
		score.add(textscore);
		score.add(score);
		LV.add(textlevel);
		LV.add(level);
		score.setMaximumSize(new Dimension(200, 30));
		LV.setMaximumSize(new Dimension(200, 30));
		score.setBorder(new EtchedBorder());
		LV.setBorder(new EtchBorder());
		r.add(score);
		r.add(LV);
		r.add(Box.createRigidArea(new Dimension(0, 1)));
		JPanel tutoral = new JPanel();
		tutorial.setLayout(new BoxLayout(tutorial, BoxLayout.Y_AXIS));
		JLabel sTut = new JLabel("Tutorial         ");
		sTut.setForeground(Color.RED);
		JLabel sN = new JLabel("N:");
			sN.setForeground(new Color(142,7,158));
		JLabel sP= new JLabel("P:");
			sP.setForeground(Color.BLUE);
		JLabel sR = new JLabel("R:");
			sR.setForeground(Color.RED);
		JLabel sH = new JLabel("H:");
			sH.setForeground(Color.GREEN);
		JLabel sT = new JLabel("T:");
			sT.setForeground(Color.CYAN);
		JLabel sE = new JLabel("E:");
			sE.setForeground(Color.ORANGE);
		JLabel sNewgame = new JLabel(" New game");
		JLabel sPause= new JLabel(" Pause        ");
		JLabel sRestart = new JLabel(" Restart      ");
		JLabel sHiscore = new JLabel(" High score");
		JLabel sPerfect = new JLabel(" Perfect       ");
		JLabel sExit = new JLabel(" Exit              ");
		JPanel pN = new JPanel();
		JPanel pP = new JPanel();
		JPanel pR = new JPanel();
		JPanel pH = new JPanel();
		JPanel pT = new JPanel();
		JPanel pE = new JPanel();
		pN.add(sN);
		pN.add(sNewgame);
		pP.add(sP);
		pP.add(sPause);
		pR.add(sR);
		pR.add(sRestart);
		pH.add(sH);
		pH.add(sHiscore);
		pT.add(sT);
		pT.add(sPerfect);
		pE.add(sE);
		pE.add(sExit);
		pN.setMaximumSize(new Dimension(150,30));
		pP.setMaximumSize(new Dimension(150,30));
		pR.setMaximumSize(new Dimension(150,30));
		pH.setMaximumSize(new Dimension(150,30));
		pT.setMaximumSize(new Dimension(150,30));
		pE.setMaximumSize(new Dimension(150,30));
		tutorial.add(sTut);
		tutorial.add(Box.createRigidArea(new Dimension(0,20)));
		tutorial.add(pN);
		tutorial.add(pP);
		tutorial.add(pR);
		tutorial.add(pH);
		tutorial.add(pT);
		tutorial.add(pE);
		tutorial.setBorder(new EtchedBorder());
		r.add(tutorial);
		r.setMinimumSize(new Dimension(150,0));
		r.setPreferredSize(new Dimension(150,0));
		r.setMaximumSize(new Dimension(150,0));
		return r;
	}
	public void MoveLeft(){
		boolean stop = true;
		for(int i=0;i<4;i++){
			boolean kt= true;
			for(int j=0;j<4;j++){
				if(a[i] == a[j] && b[i]-1==b[j])
					kt=false;
			}
			if(kt==true){
				if(b[i]-1<0)
					stop=false;
				else if((cells[a[i]][b[i]-1].getBackground()!=A)&&(cells[a[i]][b[i]-1].getBackground()!=B)){
					stop=false;
				}
			}
		}
		if(stop==true){
			curClo = cells[a[0]][b[0]].getBackground();
			for(int i=0;i<4;i++){
				if((a[i]%2==0 && b[i]%2==0)|| (a[i]%2!=0 && b[i]%2!=0))
					cells[a[i]][b[i]].setBackground(A);
				else
					cells[a[i]][b[i]].setBackground(B);
					cells[a[i]][b[i]].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
			for(int i=0;i<4;i++){
				b[i]=b[i]-1;
				cells[a[i]][b[i]].setBackground(curClo);
				cells[a[i]][b[i]].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			}
			vitri--;
		}
		public void MoveRight(){
		boolean stop = true;
		for(int i=0;i<4;i++){
			boolean kt= true;
			for(int j=0;j<4;j++){
				if(a[i] == a[j] && b[i]+1==b[j])
					kt=false;
			}
			if(kt==true){
				if(b[i]+1>=10)
					stop=false;
				else if((cells[a[i]][b[i]+1].getBackground()!=A)&&(cells[a[i]][b[i]+1].getBackground()!=B)){
					stop=false;
				}
			}
		}
		if(stop==true){
			curClo = cells[a[0]][b[0]].getBackground();
			for(int i=0;i<4;i++){
				if((a[i]%2==0 && b[i]%2==0)|| (a[i]%2!=0 && b[i]%2!=0))
					cells[a[i]][b[i]].setBackground(A);
				else
					cells[a[i]][b[i]].setBackground(B);
					cells[a[i]][b[i]].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				
			}
			for(int i=0;i<4;i++){
				b[i]=b[i]+1;
				cells[a[i]][b[i]].setBackground(curClo);
				cells[a[i]][b[i]].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			}
			vitri++;
		}
		public void MoveNext(){
		boolean stop = true;
		for(int i=0;i<4;i++){
			boolean kt= true;
			for(int j=0;j<4;j++){
				if(a[i]+1 == a[j] && b[i]==b[j])
					kt=false;
			}
			if(kt==true){
				if(a[i]+1>=20)
					stop=false;
				else if((cells[a[i]+1][b[i]].getBackground()!=A)&&(cells[a[i]+1][b[i]].getBackground()!=B)){
					stop=false;
				}
			}
		}
		if(stop==true){
			curClo = cells[a[0]][b[0]].getBackground();
			for(int i=0;i<4;i++){
				if(a[i]>=0){
					if((a[i]%2==0 && b[i]%2==0)|| (a[i]%2!=0 && b[i]%2!=0))
						cells[a[i]][b[i]].setBackground(A);
					else
						cells[a[i]][b[i]].setBackground(B);
					cells[a[i]][b[i]].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				}
			}
		}
