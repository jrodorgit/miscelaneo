package net.rodor.numeroanotacion;

public class TranslateBase26 {

	public static String sDigitosBase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args) {
		System.out.println("Transformado a/desde Base 26");
		
		/** algunas pruebas ***/		
		for(int i = 1; i < 1000 ; i++){
	        String letra=num2Chars(i);
	        int numero=charsToNum(letra);
	        System.out.println(i + "\t"+letra+"\t"+numero);
		}

	}

	/**
	 * Devuelve el numero en base 26 ( las letras validas del numero de asiento )
	 * @param numero entero a transformar a letras
	 * @return Si numero es menor o igual que 0 devuelve nulo.
	 */
	public static String num2Chars(int numero){
		
		//String sDigitosBase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int iBaseSize = sDigitosBase.length();

		String sRet = "";
		
		if (numero <= 0)
				return null;
		
		while(numero > 0){
			numero = numero - 1;
			sRet = sDigitosBase.substring( (numero % iBaseSize), (numero % iBaseSize) + 1 ) + sRet;
			numero = numero / iBaseSize;
		}
		return sRet;
		
	}
	
	/**
	 * Devuelve el numero apartir de la cadena introducida.
	 * Valida que la cadena solo contiene carcateres validos segun los digitos de la base  sDigitosBase
	 * @param cadena
	 * @return devuelve -1 si la cadena introducida tiene algun caracter no valido. Los caracteres validos son'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
	 */
	public static int charsToNum(String cadena){
		
		//String sDigitosBase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int iBaseSize = sDigitosBase.length();
		int iNum=0;
		
		// comprobamos que la cadena introducida no tiene caracteres distintos de la base
		for(int i=0 ; i < cadena.length();i++){
			
			if(!cadena.toUpperCase().matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]+"))
			{
			    System.out.println("Alguno de los caracteres de la cadena no es correcto.");
			}
		}
		
		//for a in range(0,len(sLetras)):
		int pos = 0;
		for( int i = 0 ; i < cadena.length() ; i++){
		//for( int i = cadena.length()  ; i > 0 ; i--){
			//System.out.println(i + "---"+cadena.charAt(i));
			
			//pos=a*-1-1 #La posición empezando por el final segun python (-1, -2, -3...)
			pos = cadena.length() -i -1;
			//System.out.println("pos:"+pos);
			iNum = iNum + ((int)Math.pow(iBaseSize,i) * (sDigitosBase.indexOf(cadena.charAt(pos)) +1));
		}
		
		return iNum;
		
	}
}
