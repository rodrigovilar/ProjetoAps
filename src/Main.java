
public class Main {

	public static void main(String[] args) {
		String strComLetras = "uhb";
		String strComNumeros = "156547";
		System.out.println(isNumerico(strComLetras));
	//	System.out.println(isNumerico(strComNumeros));
		
	}

	public static boolean isNumerico(String str){
		if(str == null || str.trim().length()==0) 
			return false;
		if(str.matches("[buhs]{"+ str.length() +"}") ){
			return true;
		}else{
			return false;
		}
	}
}