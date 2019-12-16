package Controll.Learning;
import javafx.scene.text.Text;
import java.util.Map;

public interface Learn {
	
	void get10Random(Map<String,String> full);
	
	Map<String, String> getFinalMap();
	
	String getNextKey(String actualWord);
	
	String getPreKey(String actualWord);
	
	void setNextWord(String actualWord,Text text1, Text text2);
	
	void setPreWord(String actualWord, Text text1, Text text2);
}
