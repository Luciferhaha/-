

import javax.swing.JLabel;
public class Check_isexisted {
	public final static int gap=50;//实际棋盘和边框的间距
	public  final static int side=85;//小正方形的边框
	public ChessPoint Point;
	public int x,y;
	public int isexisted[][]=new int[8][8];
	public Check_isexisted() {
		// TODO Auto-generated constructor stub
		//初始化位置
		for (int i = 0; i <8; i++) {
			for (int j = 0; j <8; j++) {
				isexisted[i][j]=0;
			}
		}
	}
	public void SetChessPoint(JLabel label){
		//pawn
		 x=(label.getLocation().x-gap)/side;
		 y=(label.getLocation().y)/side;
		Point=new ChessPoint(x, y);
		if (label.getName().charAt(0)=='1') {
			isexisted[x][y]=1;
		}else if(label.getName().charAt(0)=='2'){
			isexisted[x][y]=2;
		}
	}
	public void findChessPoint (JLabel label) {
		 x=(label.getLocation().x-gap)/side;
		 y=(label.getLocation().y)/side;
		Point=new ChessPoint(x, y);
	}

}
