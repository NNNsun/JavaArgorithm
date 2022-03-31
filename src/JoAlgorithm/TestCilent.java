package JoAlgorithm;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TestCilent {
	public static void main(String[] args) {
		//<key:문자, value:정수>로 이루어진 정보
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		File file;
		//자바스윙
		//JFileChooser : 윈도우의 파일열기, 저장등과 같은 형태의 Dialog를 사용할수있음
		final JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) file= fc.getSelectedFile();
		else {
			JOptionPane.showMessageDialog(null, "파일을 선택하세요","오류",JOptionPane.ERROR_MESSAGE);
			return;
		}
		Scanner sc = null;
		try {
			sc=new Scanner(file);
			for(int i=0;sc.hasNext(); i++) {String key= sc.next(); st.put(key,i);}
			for(String s : st.keys()) System.out.print(s+" "+st.get(s));
		}catch (FileNotFoundException e ) {e.printStackTrace();}
		if(sc != null) sc.close();
		
	}

}
