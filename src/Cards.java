import static java.lang.System.*;
import java.util.Random;

public class Cards {
	public static void main(String[] args) {
		int num = 52;
		int y[] = new int[52];
		int count = 4;
		Random rand = new Random();
		int x = rand.nextInt(num+1);
		int costD = 0;
		int firstD = 0;
		int win = 0;
		int round = 0;
		boolean drawn = false;
		Player p1 = new Player();
		for(int i = 0 ; i<1000000 ;i++){
			p1 = new Player();
			costD = 0;
			y = new int[52];
			x = rand.nextInt(num+1);
			count = 0;
			while(true){
				
				while(isused(x,y)){
					x = rand.nextInt(num+1);
				}
				
				x = x %13;
				drawn = false;
				if(count == 0 || count == 2){
					if(count == 0){
						firstD = x;
					}
					costD = addCost(x,costD);
					drawn = true;
				}
				else if(count == 1 || count == 3){
					p1.draw(x);
					drawn = true;
				}
				
				
//				else if(p1.cost < 21 && p1.aces >= 1 && p1.cost<17 ){
//					p1.draw(x);
//					drawn = true;
//				}
//				else if(p1.cost < 21 && p1.aces == 0 && firstD >= 7 && p1.cost < 17){
//					p1.draw(x);
//					drawn = true;
//				}
//				else if(p1.cost < 12){
//					p1.draw(x);
//					drawn = true;
//				}
				
				
				else if(p1.cost < 16){
					p1.draw(x);
				}
				
				
				if(drawn==false){
					if(costD < p1.cost && costD <= 17){
						costD = addCost(x,costD);
					}
					else{
						break;
					}
				}
//				out.println(p1.cost + "  " + costD);
				y[count] = x;
				count += 1;
			}
			if(p1.cost <=21 && costD >21){
				win += 1;
//				out.println("win");
			}
			else if(p1.cost <=21 && p1.cost > costD){
				win += 1;
//				out.println("win");
			}
			else{
//				out.println("lose");
			}
			round += 1;
		}
		out.println("win = "+ win + " round = " + round);
	}
	
	public static int addCost(int x,int cost){
		int a = x%13;
		if(a==0){
			cost = cost + 10;
		}
		else if(a == 1){
			if(cost <= 10){
				a = 11;
			}
			else{
				a = 1;
			}
			cost = cost + a;
			
		}
		else if (a < 10){
			cost = cost + a;
		}
		else{
			cost = cost + 10;
		}
		return cost;
	}
	
	public static String printcards(int x){
		int num = x %13;
		String card = "";
		if(num==1 )
		{
			card += 'A';
		}
		else if(num==2)
		{
			card += '2';
		}
		else if(num==3)
		{
			card += '3';
		}
		else if(num==4)
		{
			card += '4';
		}
		else if(num==5)
		{
			card += '5';
		}
		else if(num==6)
		{
			card += '6';
		}
		else if(num==7)
		{
			card += '7';
		}
		else if(num==8)
		{
			card += '8';
		}
		else if(num==9)
		{
			card += '9';
		}
		else if(num==10)
		{
			card += "10";
		}
		else if(num==11)
		{
			card += 'J';
		}
		else if(num==12)
		{
			card += 'Q';
		}
		else
		{
			card += 'K';
		}
		return card;
	}
	public static boolean isused(int x , int[] y){
		for( int i = 0 ; i < y.length  ;i++){
			if(x == y[i]){
				return true;
			}
		}
		return false;
	}

}
