import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class zad2{
	
	
//String end_of_key=;
	static char[] alphabet={'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f'};
	public static void main(String[] args){
	 
   	 byte[] cipher=new byte[] {(byte)10000001, (byte)01110010, (byte)00011111, (byte)00010000, (byte)00100011, (byte)00111010, (byte)00010010, (byte)10010111, (byte)10110110, (byte)01110011, (byte)01000111, (byte)10110101, (byte)10000110, (byte)00101001, (byte)10000111, (byte)10001001, (byte)11001101, (byte)11110111, (byte)00001011, (byte)10101101, (byte)11100011, (byte)01011011, (byte)11111000, (byte)00000110, (byte)00110101, (byte)01011011, (byte)01100011, (byte)00101010, (byte)01111000, (byte)10011110, (byte)10110011, (byte)10101011, (byte)10110111, (byte)00100110, (byte)11010100, (byte)01000011, (byte)10000111, (byte)01101101, (byte)10010100, (byte)00100111, (byte)11011110, (byte)00111110, (byte)01010101, (byte)00001000, (byte)00011100, (byte)11111010, (byte)10011010, (byte)01001111, (byte)01010001, (byte)11111110, (byte)01001110, (byte)01001000, (byte)10101111, (byte)01110110, (byte)01010101, (byte)10110001, (byte)00011010, (byte)11101101, (byte)11111010, (byte)00011000, (byte)00100111, (byte)11111010, (byte)01010001, (byte)00010011, (byte)10111001, (byte)00011001, (byte)10110011, (byte)00100110, (byte)00000000, (byte)10111011, (byte)01000101, (byte)01011101, (byte)01111010, (byte)10111000, (byte)00000001, (byte)01001010, (byte)01000100};
		
	   try{
		Cipher rc4 = Cipher.getInstance("RC4");
		//System.out.println(cipher[1]);
		for(int q=1;q<alphabet.length;q++)
		 for(int w=0;w<alphabet.length;w++)		// 300 min q=1 w=9
		  for(int e=0;e<alphabet.length;e++)
		   for(int r=0;r<alphabet.length;r++)
		    for(int t=0;t<alphabet.length;t++)
		     for(int y=0;y<alphabet.length;y++)
		      for(int u=0;u<alphabet.length;u++)
		       for(int i=0;i<alphabet.length;i++){
			char[] newkey=new char[16];
			newkey[0]=alphabet[q];
			newkey[1]=alphabet[w];
			newkey[2]=alphabet[e];
			newkey[3]=alphabet[r];
			newkey[4]=alphabet[t];
			newkey[5]=alphabet[y];
			newkey[6]=alphabet[u];
			newkey[7]=alphabet[i];
			newkey[8]='4';newkey[9]='a';newkey[10]='5';newkey[11]='7';newkey[12]='7';newkey[13]='b';newkey[14]='a';newkey[15]='9';
			byte[] key = new String(newkey).getBytes("ASCII");
			SecretKeySpec rc4Key = new SecretKeySpec(key, "RC4");			
			rc4.init(Cipher.DECRYPT_MODE,rc4Key);
			byte[] clearText = rc4.update(cipher);
			String decryptedText = new String(clearText,"ASCII");
			if(decryptedText.matches("[\\w\\s:?;?,?.?!?\"?(?)?]+")){ System.out.println(new String(clearText,"ASCII")); return;}
			System.out.println(q+" "+w+" "+e+" "+r+" "+t+" "+y+" "+u+" "+i);
		}
	   }catch(Exception Ex){
		System.out.println(Ex);	
	   }
	}
}
