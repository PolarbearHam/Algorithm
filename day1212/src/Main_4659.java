import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4659 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] crr = {'a', 'e', 'i', 'o', 'u'};
		while(true) {
			String s = br.readLine();
			if(s.equals("end")) break;
			else {
				boolean acceptable = true;
				boolean hasVowel = false;
				int cntVowel = 0;
				int cntConsonant = 0;
				for(int i=0; i<s.length(); i++) {
					char cur = s.charAt(i);
					boolean isVowel = false;
					for(int j=0; j<crr.length; j++) {
						if(cur == crr[j]) {
							isVowel = true;
							hasVowel = true;
							cntVowel++;
							cntConsonant = 0;
							break;
						}
					}
					if(!isVowel) {
						cntConsonant++;
						cntVowel = 0;
					}
					if(i==s.length()-1) {
						if(!hasVowel) {
							System.out.println("<"+s+"> is not acceptable.");
							acceptable = false;
							break;
						}
					}
					if(i>=1) {
						if(cur==s.charAt(i-1)&&cur!='e'&&cur!='o') {
							System.out.println("<"+s+"> is not acceptable.");
							acceptable = false;
							break;
						}
						else if(cntVowel>=3||cntConsonant>=3) {
							System.out.println("<"+s+"> is not acceptable.");
							acceptable = false;
							break;
						}
					}
				}
				if(acceptable) System.out.println("<"+s+"> is acceptable.");
			}
			
		}
	}
}
