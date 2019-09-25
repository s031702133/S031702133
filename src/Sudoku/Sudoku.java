package Sudoku;
import java.io.*;
public class Sudoku {
	static int[][] matrix;
	static int m;//宫格阶级
	static int n;//待解答盘面数目
	static int complete=0;//读取盘面时所要跳过的行数
//	static String inputName;//指定输入文件名称
	static String outputName;//指定输出文件名称
	static int sudoku[][]=new int[9][9];
//	构造方法
	public Sudoku(int[][] matrix) {
        this.matrix = matrix;
    }
	
//	主方法
	public static void main(String args[]) {
		//参数初始化
		m=Integer.parseInt(args[1]);
		n=Integer.parseInt(args[3]);
		outputName=(args[7]);
//		调用读取文件函数
		for(int k=0;k<n;k++) {
		input2(args[5]);
		Sudoku s = new Sudoku(sudoku);
//		解数独
        s.backTrace(0, 0);
        complete+=(m+1);
		}
	}
	
	
//	用来读取文件的函数
	public static void input2(String args) {
		String intputName=args;
		File file=new File(intputName);
		try {
			FileReader fr=new FileReader(file);
			BufferedReader bufr=new BufferedReader(fr);//创建对象
			String s=null;
			
			for(int l=0;l<(complete);l++) {
				s=bufr.readLine();
			}
				int i=0;
//				将文件内容存入数组
			while(i<m) {
				i++;
				s=bufr.readLine();
				String str=s;
				String array[]=str.split("  ");
				for(int j=0;j<array.length;j++)
				{
					sudoku[i-1][j]=Integer.parseInt(array[j]);//字符转换成整形
//					输出所读取的内容
//					System.out.print(sudoku[i-1][j]);
				}
				System.out.println();
			}
//			}
//			关闭流
			bufr.close();
			fr.close();
		}catch(Exception e) {//处理异常
			e.printStackTrace();
		}
	}
	
	
//	解数独函数
	private void backTrace(int i, int j) {
        if (i == (m-1) && j == m) {
            //已经成功了，打印数组即可
            printArray();
            return;
        }
 
        //已经到了列末尾了，还没到行尾，就换行
        if (j == m) {
            i++;
            j = 0;
        }
 
        //如果i行j列是空格，那么才进入给空格填值的逻辑
        if (matrix[i][j] == 0) {
            for (int k = 1; k <= m; k++) {
                //判断给i行j列放1-9中的任意一个数是否能满足规则
                if (check(i, j, k)) {
                    //将该值赋给该空格，然后进入下一个空格
                    matrix[i][j] = k;
                    backTrace(i, j + 1);
                    //初始化该空格
                    matrix[i][j] = 0;
                }
            }
        } else {
            //如果该位置已经有值了，就进入下一个空格进行计算
            backTrace(i, j + 1);
        }
    }
    private boolean check(int row, int line, int number) {
        //判断该行该列是否有重复数字
        for (int i = 0; i < m; i++) {
            if (matrix[row][i] == number || matrix[i][line] == number) {
                return false;
            }
        }
        return true;
    }
//    打印函数
    
    public void printArray() {
//    	该部分用于测试解数独
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        输打印部分
        File file=new File(outputName);
  	try {
  		FileWriter fw=new FileWriter(file,true);
  		BufferedWriter bufw=new BufferedWriter(fw);
  		for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
          	  String put=String.valueOf(matrix[i][j]);//将数组元素转成字符串类型
          	  bufw.write(put);
          	bufw.write(" ");
            }
            bufw.newLine();
            }
  		bufw.newLine();
  		bufw.close();
  		fw.close();//关闭流
  	}catch(Exception e) {
  		e.printStackTrace();//处理异常
  	}
  	
  	
    }
}



