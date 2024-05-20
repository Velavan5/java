
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class TictacGame implements ActionListener{

JFrame frame=new JFrame();
JPanel tpanel=new JPanel();//title_panel -tpanel
JPanel gpanel=new JPanel(null);//grid_panel - gpanel
JButton[] buttons=new JButton[9];
JLabel title=new JLabel("TicTacToe");//Play TicTacToe
Boolean player_1;//1 - X ,2 - O
Random choose=new Random();
//constructor
public TictacGame(){
frame.setTitle("Tic-Tac-Toe");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(800,600);
frame.setLocation(400,100);

//title for the game
title.setFont(new Font("sharif",Font.BOLD,35));
title.setForeground(new Color(50,250,200));

tpanel.add(title);
tpanel.setBackground(new Color(100,50,200));
frame.add(tpanel,BorderLayout.NORTH);
frame.add(gpanel);
welcomepage();

frame.setVisible(true);

}


public void welcomepage(){
    JButton start=new JButton();
    start.setBackground(new Color(0X05A78F));
    start.setFont(new Font("Fantasy",Font.BOLD,30));
    start.setText("PLAY");
	start.setForeground(Color.MAGENTA);
    start.setBounds(280,150,200,80);
    gpanel.setBackground(new Color(250, 209, 200));
    gpanel.add(start);
    start.setFocusable(false);
    start.addActionListener(e -> updatePanel());

}

public void updatePanel(){
    gpanel.removeAll();
    gpanel.revalidate();
  //  gpanel.repaint();
    gpanel.setLayout(new GridLayout(3,3));
    //creating buttons using loop
    for(int i=0;i<9;i++){
        buttons[i]=new JButton();
        gpanel.add(buttons[i]);
        buttons[i].setBackground(new Color(116, 209, 224));
        buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
        buttons[i].setFocusable(false);
        buttons[i].addActionListener(this);
    }
    playerselection();
}


@Override
public void actionPerformed(ActionEvent e) {
   JButton current=(JButton)e.getSource();
   if(current.getText().equals("")){
    if(player_1){
    current.setForeground(Color.BLACK);
    current.setText("X");
    title.setText("O's turn");
    player_1=false;
   }
   else{
       current.setText("O");
       current.setForeground(new Color(255,200,150));
    title.setText("X's turn");
    player_1=true;
   }
   }
   check();
}



//starting page 
public void playerselection() {

if(choose.nextInt(2)==0){
    title.setText("X's turn");
    player_1=true;
}
else{
    title.setText("O's turn");
    player_1=false;
}
}

//checking for a winner
public void check(){
if(!player_1){
    //i am doing this reduce the time because winner is the last one to play
    if(buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X"))
    {
        displaywin("X",1,2,3,true);
    }
      if(buttons[4].getText().equals("X") && buttons[5].getText().equals("X") && buttons[6].getText().equals("X"))
    {
        displaywin("X",4,5,6,true);
    }

     if ( (buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X") ) {

			displaywin("X",6,7,8,true);
		}

		 if(	(buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X") ) {

			displaywin("X",0,3,6,true);
		}

		 if(	(buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X") ) {

			displaywin("X",1,4,7,true);
		}

		 if(	(buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X") ) {

			displaywin("X",2,5,8,true);
		}

		 if(	(buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X") ) {

			displaywin("X",0,4,8,true);
		}

		 if(	(buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X") ) {

			displaywin("X",2,4,6,true);
		}
    }
    //check O win conditions
    else{

       	if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O") ) {

			displaywin("O",0,1,2,true);
		}

		 if(	(buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O") ) {

			displaywin("O",3,4,5,true);
		}

		 if(	(buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O") ) {

			displaywin("O",6,7,8,true);
		}

		 if(	(buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O") ) {

			displaywin("O",0,3,6,true);
		}

		 if(	(buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O") ) {

			displaywin("O",1,4,7,true);
		}

		 if(	(buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O") ) {

			displaywin("O",2,5,8,true);
		}

		 if(	(buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O") ) {

			displaywin("O",0,4,8,true);
		}

		 if(	(buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O") ) {

			displaywin("O",2,4,6,true);
		}
}
int tie=0;
for(int i=0;i<9;i++){
   if( ! buttons[i].getText().equals("")){
    tie+=1;
   }
}
if(tie==9){
displaywin("Tie No-one",0,0,0,false);
}
//end
}


public void displaywin(String winner,int a,int b,int c,Boolean dis){
    if(dis){
buttons[a].setBackground(Color.GREEN);
buttons[b].setBackground(Color.GREEN);
buttons[c].setBackground(Color.GREEN);}
for (int i=0;i<9;i++){
    buttons[i].setEnabled(false);
}
title.setText(winner+" wins");
tpanel.setBackground(Color.RED);
}

public static void main(String[] args){
        new TictacGame();
    }

}
