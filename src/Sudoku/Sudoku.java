package Sudoku;
import java.io.*;
public class Sudoku {
	static int[][] matrix;
	static int m;//����׼�
	static int n;//�����������Ŀ
	static int complete=0;//��ȡ����ʱ��Ҫ����������
//	static String inputName;//ָ�������ļ�����
	static String outputName;//ָ������ļ�����
	static int sudoku[][]=new int[9][9];
//	���췽��
	public Sudoku(int[][] matrix) {
        this.matrix = matrix;
    }
	
//	������
	public static void main(String args[]) {
		//������ʼ��
		m=Integer.parseInt(args[1]);
		n=Integer.parseInt(args[3]);
		outputName=(args[7]);
//		���ö�ȡ�ļ�����
		for(int k=0;k<n;k++) {
		input2(args[5]);
		Sudoku s = new Sudoku(sudoku);
//		������
        s.backTrace(0, 0);
        complete+=(m+1);
		}
	}
	
	
//	������ȡ�ļ��ĺ���
	public static void input2(String args) {
		String intputName=args;
		File file=new File(intputName);
		try {
			FileReader fr=new FileReader(file);
			BufferedReader bufr=new BufferedReader(fr);//��������
			String s=null;
			
			for(int l=0;l<(complete);l++) {
				s=bufr.readLine();
			}
				int i=0;
//				���ļ����ݴ�������
			while(i<m) {
				i++;
				s=bufr.readLine();
				String str=s;
				String array[]=str.split("  ");
				for(int j=0;j<array.length;j++)
				{
					sudoku[i-1][j]=Integer.parseInt(array[j]);//�ַ�ת��������
//					�������ȡ������
//					System.out.print(sudoku[i-1][j]);
				}
				System.out.println();
			}
//			}
//			�ر���
			bufr.close();
			fr.close();
		}catch(Exception e) {//�����쳣
			e.printStackTrace();
		}
	}
	
	
//	����������
	private void backTrace(int i, int j) {
        if (i == (m-1) && j == m) {
            //�Ѿ��ɹ��ˣ���ӡ���鼴��
            printArray();
            return;
        }
 
        //�Ѿ�������ĩβ�ˣ���û����β���ͻ���
        if (j == m) {
            i++;
            j = 0;
        }
 
        //���i��j���ǿո���ô�Ž�����ո���ֵ���߼�
        if (matrix[i][j] == 0) {
            for (int k = 1; k <= m; k++) {
                //�жϸ�i��j�з�1-9�е�����һ�����Ƿ����������
                if (check(i, j, k)) {
                    //����ֵ�����ÿո�Ȼ�������һ���ո�
                    matrix[i][j] = k;
                    backTrace(i, j + 1);
                    //��ʼ���ÿո�
                    matrix[i][j] = 0;
                }
            }
        } else {
            //�����λ���Ѿ���ֵ�ˣ��ͽ�����һ���ո���м���
            backTrace(i, j + 1);
        }
    }
    private boolean check(int row, int line, int number) {
        //�жϸ��и����Ƿ����ظ�����
        for (int i = 0; i < m; i++) {
            if (matrix[row][i] == number || matrix[i][line] == number) {
                return false;
            }
        }
        return true;
    }
//    ��ӡ����
    
    public void printArray() {
//    	�ò������ڲ��Խ�����
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        ���ӡ����
        File file=new File(outputName);
  	try {
  		FileWriter fw=new FileWriter(file,true);
  		BufferedWriter bufw=new BufferedWriter(fw);
  		for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
          	  String put=String.valueOf(matrix[i][j]);//������Ԫ��ת���ַ�������
          	  bufw.write(put);
          	bufw.write(" ");
            }
            bufw.newLine();
            }
  		bufw.newLine();
  		bufw.close();
  		fw.close();//�ر���
  	}catch(Exception e) {
  		e.printStackTrace();//�����쳣
  	}
  	
  	
    }
}



