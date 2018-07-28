import java.util.Random;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class GameEng implements ActionListener
{
	GameGui gg;
	int rollNo=0;
	int turn=0;
	int nOfPlr=2;//default
	boolean onBoard[]={false,false,false,false};
	static int currentPos[]={1,1,1,1};
	
	GameEng(GameGui gg)
	{
		this.gg=gg;
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==gg.dice)
		{
			rollNo=diceGen();
			gg.dice.setIcon(gg.icoDice[rollNo]);
			move(rollNo);
		}
		if(e.getSource()==gg.rb[0])
		{
			nOfPlr=2;
		}
		if(e.getSource()==gg.rb[1])
		{
			nOfPlr=3;
		}
		if(e.getSource()==gg.rb[2])
		{
			nOfPlr=4;
		}
		if(e.getSource()==gg.startB&&(onBoard[0]==false||onBoard[1]==false||onBoard[2]==false||onBoard[3]==false))
		{
			gg.dice.setEnabled(true);
			gg.rb[0].setEnabled(false);
			gg.rb[1].setEnabled(false);
			gg.rb[2].setEnabled(false);
			gg.startB.setBackground(Color.RED);
		}
		if(e.getSource()==gg.resetB&&(onBoard[0]==true||onBoard[1]==true||onBoard[2]==true||onBoard[3]==true))
		{
			gg.dice.setEnabled(false);
			gg.rb[0].setEnabled(true);
			gg.rb[1].setEnabled(true);
			gg.rb[2].setEnabled(true);
				
			for(int i=0;i<currentPos.length;i++)
			{	
				gg.playerZ[currentPos[i]].remove(gg.player[i]);
				onBoard[i]=false;
				currentPos[i]=1;
			}
			gg.startB.setBackground(Color.GREEN);
			
		}
		switchPlayer();
		SwingUtilities.updateComponentTreeUI(gg.f);//refreash the frame and redraw the components
	}
	
	void move(int move)
	{
		
		if(onBoard[turn]==false)
		{	
			if((move+1)==1)
			{
				gg.playerZ[1].add(gg.player[turn]);
				onBoard[turn]=true;
			}
			if((move+1)==6)
			{
				gg.playerZ[1].add(gg.player[turn]);
				onBoard[turn]=true;
			}
		}
		if(currentPos[turn]!=100 && (currentPos[turn]+move)<=100 && onBoard[turn]==true)
		{
			int prevousMove=currentPos[turn];
			int newMove=move+currentPos[turn]+1;
			gg.playerZ[prevousMove].remove(gg.player[turn]);
			gg.playerZ[newMove].add(gg.player[turn]);
			currentPos[turn]=newMove;
		}
		
		
		snakeAndLadders();
		gg.l[turn].setText("p"+(turn+1)+"="+(currentPos[turn]));
		
	}
	
	public void switchPlayer()
	{
		Outer2:if(nOfPlr==2)
		{
			if(turn==0)
			{
				turn=1;
				break Outer2;
			}
			if(turn==1)
			{
				turn=0;
				break Outer2;
			}
		}
		outer3:if(nOfPlr==3)
		{
			if(turn==0)
			{
				turn=1;
				break outer3;
			}
			if(turn==1)
			{
				turn=2;
				break outer3;
			}
			if(turn==2)
			{
				turn=0;
				break outer3;
			}
		}
		outer4:if(nOfPlr==4)
		{
			if(turn==0)
			{
				turn=1;
				break outer4;
			}
			if(turn==1)
			{
				turn=2;
				break outer4;
			}
			if(turn==2)
			{
				turn=3;
				break outer4;
			}
			if(turn==3)
			{
				turn=0;
				break outer4;
			}
		}
	}
	
	public void snakeAndLadders()
	{
		
		if(currentPos[turn]==2)//ladders
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[18].add(gg.player[turn]);
			currentPos[turn]=18;
		}
		if(currentPos[turn]==11)//ladders
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[31].add(gg.player[turn]);
			currentPos[turn]=31;
		}
		if(currentPos[turn]==12)//ladders
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[28].add(gg.player[turn]);
			currentPos[turn]=28;
		}
		if(currentPos[turn]==22)//ladders
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[40].add(gg.player[turn]);
			currentPos[turn]=40;
		}
		if(currentPos[turn]==41)//ladders
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[59].add(gg.player[turn]);
			currentPos[turn]=59;
		}
		if(currentPos[turn]==36)//ladders
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[62].add(gg.player[turn]);
			currentPos[turn]=62;
		}
		if(currentPos[turn]==46)//ladders
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[55].add(gg.player[turn]);
			currentPos[turn]=55;
		}
		if(currentPos[turn]==70)//ladders
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[94].add(gg.player[turn]);
			currentPos[turn]=94;
		}
		if(currentPos[turn]==77)//ladders
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[84].add(gg.player[turn]);
			currentPos[turn]=84;
		}
		if(currentPos[turn]==85)//ladders
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[97].add(gg.player[turn]);
			currentPos[turn]=97;
		}
		
		if(currentPos[turn]==21)//snake
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[15].add(gg.player[turn]);
			currentPos[turn]=15;
		}
		
		if(currentPos[turn]==23)//snake
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[6].add(gg.player[turn]);
			currentPos[turn]=6;
		}
		
		if(currentPos[turn]==29)//snake
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[15].add(gg.player[turn]);
			currentPos[turn]=15;
		}
		
		if(currentPos[turn]==35)//snake
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[18].add(gg.player[turn]);
			currentPos[turn]=18;
		}
		
		if(currentPos[turn]==47)//snake
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[32].add(gg.player[turn]);
			currentPos[turn]=32;
		}
		
		if(currentPos[turn]==52)//snake
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[38].add(gg.player[turn]);
			currentPos[turn]=38;
		}
		
		if(currentPos[turn]==71)//snake
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[34].add(gg.player[turn]);
			currentPos[turn]=34;
		}
		
		if(currentPos[turn]==82)//snake
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[59].add(gg.player[turn]);
			currentPos[turn]=59;
		}
		
		if(currentPos[turn]==95)//snake
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[78].add(gg.player[turn]);
			currentPos[turn]=78;
		}
		
		if(currentPos[turn]==99)//snake
		{
			gg.playerZ[currentPos[turn]].remove(gg.player[turn]);
			gg.playerZ[79].add(gg.player[turn]);
			currentPos[turn]=79;
		}
		
		SwingUtilities.updateComponentTreeUI(gg.f);
	}
	
	static int diceGen()//this static function generate random number
	{	
		Random r=new Random();
		int value=r.nextInt((6-0)+0)+0;
		return value;
	}
}