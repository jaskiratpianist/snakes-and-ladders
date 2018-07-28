import java.awt.*;
import javax.swing.*;
class GameGui
{
	JFrame f;
	JButton b[],dice,player[],startB,resetB;
	JPanel mainP,gameP,userP,nested,playerZ[],controlP,dummy;
	JLabel l[];
	JRadioButton rb[];
	ButtonGroup rbg;
	String ico[]={"","images\\1.gif","images\\2.gif","images\\3.gif","images\\4.gif","images\\5.gif","images\\6.gif","images\\7.gif","images\\8.gif","images\\9.gif","images\\10.gif",
	"images\\11.gif","images\\12.gif","images\\13.gif","images\\14.gif","images\\15.gif","images\\16.gif","images\\17.gif","images\\18.gif","images\\19.gif","images\\20.gif",
	"images\\21.gif","images\\22.gif","images\\23.gif","images\\24.gif","images\\25.gif","images\\26.gif","images\\27.gif","images\\28.gif","images\\29.gif","images\\30.gif",
	"images\\31.gif","images\\32.gif","images\\33.gif","images\\34.gif","images\\35.gif","images\\36.gif","images\\37.gif","images\\38.gif","images\\39.gif","images\\40.gif",
	"images\\41.gif","images\\42.gif","images\\43.gif","images\\44.gif","images\\45.gif","images\\46.gif","images\\47.gif","images\\48.gif","images\\49.gif","images\\50.gif",
	"images\\51.gif","images\\52.gif","images\\53.gif","images\\54.gif","images\\55.gif","images\\56.gif","images\\57.gif","images\\58.gif","images\\59.gif","images\\60.gif",
	"images\\61.gif","images\\62.gif","images\\63.gif","images\\64.gif","images\\65.gif","images\\66.gif","images\\67.gif","images\\68.gif","images\\69.gif","images\\70.gif",
	"images\\71.gif","images\\72.gif","images\\73.gif","images\\74.gif","images\\75.gif","images\\76.gif","images\\77.gif","images\\78.gif","images\\79.gif","images\\80.gif",
	"images\\81.gif","images\\82.gif","images\\83.gif","images\\84.gif","images\\85.gif","images\\86.gif","images\\87.gif","images\\88.gif","images\\89.gif","images\\90.gif",
	"images\\91.gif","images\\92.gif","images\\93.gif","images\\94.gif","images\\95.gif","images\\96.gif","images\\97.gif","images\\98.gif","images\\99.gif","images\\100.gif"};
	
	ImageIcon icoDice[]=new ImageIcon[6];
	
	String s2[]={"images\\Dice\\Dice1.png","images\\Dice\\Dice2.png","images\\Dice\\Dice3.png",
	"images\\Dice\\Dice4.png","images\\Dice\\Dice5.png","images\\Dice\\Dice6.png"};
	
	String s3[]={"images\\Dice\\green1.png","images\\Dice\\red1.png","images\\Dice\\purple1.png","images\\Dice\\yellow1.png"};
	
	GameGui()
	{
		f=new JFrame("Snake And Ladder!!");
		b=new JButton[101];
		mainP=new JPanel(new BorderLayout());
		gameP=new JPanel(new GridLayout(10,10));
		userP=new JPanel(new BorderLayout());
		nested=new JPanel(new FlowLayout());//p|1 p|2
		controlP=new JPanel(new GridLayout(4,1));//radio buttons and start button
		dummy=new JPanel(new GridLayout(2,1));
		player=new JButton[4];//players
		playerZ=new JPanel[b.length];
		rb=new JRadioButton[3];
		rbg=new ButtonGroup();
		startB=new JButton("START!");
		resetB=new JButton("RESET!");
		l=new JLabel[4];
		
		drawBoard();
		
		//players
		for(int i=0;i<player.length;i++)
		{
			player[i]=new JButton(new ImageIcon(s3[i]));
			player[i].setOpaque(false);//opacity a.k.a transparency
			player[i].setContentAreaFilled(false);//no idea!
			player[i].setBorderPainted(false);
			//player[i].setEnabled(false);
		}
		
		//Dice Code
		for(int i=0;i<s2.length;i++)//icoDice object
		{
			icoDice[i]=new ImageIcon(s2[i]);
		}
		dice=new JButton(icoDice[0]);
		dice.setPreferredSize(new Dimension(151,151));
		dice.setBackground(Color.WHITE);
		userP.add(dice,BorderLayout.NORTH);
		GameEng ge=new GameEng(this);//external listener and rest of the working
		dice.addActionListener(ge);
		dice.setEnabled(false);
		
		//player status panel
		for(int i=0;i<l.length;i++)
		{
			l[i]=new JLabel("p"+(i+1)+"=::");
			nested.add(l[i]);
		}
		
		
		//radio button and controlP
		for(int i=0;i<rb.length;i++)
		{
			rb[i]=new JRadioButton(i+2+" Players");
			rbg.add(rb[i]);
			controlP.add(rb[i]);
			rb[i].addActionListener(ge);
		}
		startB.addActionListener(ge);
		startB.setBackground(Color.GREEN);
		dummy.add(startB);
		resetB.addActionListener(ge);
		resetB.setBackground(Color.GRAY);
		dummy.add(resetB);
		controlP.add(dummy);
		
		
		userP.add(controlP,BorderLayout.CENTER);
		userP.add(nested,BorderLayout.SOUTH);
		
		mainP.add(userP,BorderLayout.EAST);
		mainP.add(gameP,BorderLayout.CENTER);
		
		f.add(mainP);
		f.setSize(850,730);
		f.setVisible(true);
		b[0]=null;//useless button[0]
		playerZ[0]=null;//useless panel
		
	}
	
	public void drawBoard()
	{
		
		for(int i=100;i>=91;i--)
		{
			b[i]=new JButton(new ImageIcon(ico[i]));
			gameP.add(b[i]);
			
			playerZ[i]=new JPanel(new GridLayout(2,2));
			playerZ[i].setBackground(new Color(0,0,0,0));
			b[i].add(playerZ[i]);
		}
		for(int i=81;i<=90;i++)
		{
			b[i]=new JButton(new ImageIcon(ico[i]));
			gameP.add(b[i]);
			playerZ[i]=new JPanel(new GridLayout(2,2));
			playerZ[i].setBackground(new Color(0,0,0,0));
			b[i].add(playerZ[i]);
		}
		for(int i=80;i>=71;i--)
		{
			b[i]=new JButton(new ImageIcon(ico[i]));
			gameP.add(b[i]);
			playerZ[i]=new JPanel(new GridLayout(2,2));
			playerZ[i].setBackground(new Color(0,0,0,0));
			b[i].add(playerZ[i]);
		}
		for(int i=61;i<=70;i++)
		{
			b[i]=new JButton(new ImageIcon(ico[i]));
			gameP.add(b[i]);
			playerZ[i]=new JPanel(new GridLayout(2,2));
			playerZ[i].setBackground(new Color(0,0,0,0));
			b[i].add(playerZ[i]);
		}
		for(int i=60;i>=51;i--)
		{
			b[i]=new JButton(new ImageIcon(ico[i]));
			gameP.add(b[i]);
			playerZ[i]=new JPanel(new GridLayout(2,2));
			playerZ[i].setBackground(new Color(0,0,0,0));
			b[i].add(playerZ[i]);
		}
		for(int i=41;i<=50;i++)
		{
			b[i]=new JButton(new ImageIcon(ico[i]));
			gameP.add(b[i]);
			playerZ[i]=new JPanel(new GridLayout(2,2));
			playerZ[i].setBackground(new Color(0,0,0,0));
			b[i].add(playerZ[i]);
		}
		for(int i=40;i>=31;i--)
		{
			b[i]=new JButton(new ImageIcon(ico[i]));
			gameP.add(b[i]);
			playerZ[i]=new JPanel(new GridLayout(2,2));
			playerZ[i].setBackground(new Color(0,0,0,0));
			b[i].add(playerZ[i]);
		}
		for(int i=21;i<=30;i++)
		{
			b[i]=new JButton(new ImageIcon(ico[i]));
			gameP.add(b[i]);
			playerZ[i]=new JPanel(new GridLayout(2,2));
			playerZ[i].setBackground(new Color(0,0,0,0));
			b[i].add(playerZ[i]);
		}
		for(int i=20;i>=11;i--)
		{
			b[i]=new JButton(new ImageIcon(ico[i]));
			gameP.add(b[i]);
			playerZ[i]=new JPanel(new GridLayout(2,2));
			playerZ[i].setBackground(new Color(0,0,0,0));
			b[i].add(playerZ[i]);
		}
		for(int i=1;i<=10;i++)
		{
			b[i]=new JButton(new ImageIcon(ico[i]));
			gameP.add(b[i]);
			playerZ[i]=new JPanel(new GridLayout(2,2));
			playerZ[i].setBackground(new Color(0,0,0,0));
			b[i].add(playerZ[i]);
		}
	}
	
	public static void main(String... s)
	{
		new GameGui();
	}
}