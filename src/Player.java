import static java.lang.System.*;


public class Player {
	int cost;
	int aces;
	boolean playing;
	public Player(){
		this.cost = 0;
		this.aces = 0;
		this.playing = true;
	}
	
	public void draw(int x){
		if( x == 1){
			aces += 1;
			cost += 11;
//			out.println("ace");
		}
		else if( x < 10 && x>1){
			cost += x;
		}
		else{
			cost += 10;
		}
		if(cost > 21 && aces >= 1){
//			out.println(cost + " " + aces);
			aces -= 1;
			cost -= 10;
		}
	}

}
