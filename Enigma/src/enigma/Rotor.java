package enigma;

public class Rotor {
	static Object[] reflector = {25, 23, 21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1, -1, -3, -5, -7, -9, -11, -13, -15, -17, -19, -21, -23, -25};
	static Object[] rotor3a = {12, -1, 23, 10, 2, 14, 5, -5, 9, -2, -13, 10, -2, -8, 10, -6, 6, -16, 2, -1, -17, -5, -14, -9, -20, -10};
	static Object[] rotor3b = {1, 16, 5, 17, 20, 8, -2, 2, 14, 6, 2, -5, -12, -10, 9, 10, 5, -9, 1, -14, -2, -10, -6, 13, -10, -23}; 
	static Object[] rotor2a = {25, 7, 17, -3, 13, 19, 12, 3, -1, 11, 5, -5, -7, 10, -2, 1, -2, 4, -17, -8, -16, -18, -9, -1, -22, -16}; 
	static Object[] rotor2b = {3, 17, 22, 18, 16, 7, 5, 1, -7, 16, -3, 8, 2, 9, 2, -5, -1, -13, -12, -17, -11, -4, 1, -10, -19, -25}; 
	static Object[] rotor1a = {17, 4, 19, 21, 7, 11, 3, -5, 7, 9, -10, 9, 17, 6, -6, -2, -4, -7, -12, -5, 3, 4, -21, -16, -2, -21};
	static Object[] rotor1b = {10, 21, 5, -17, 21, -4, 12, 16, 6, -3, 7, -7, 4, 2, 5, -7, -11, -17, -9, -6, -9, -19, 2, -3, -21, -4};
	static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	static int c1 = 0;

	static int rot0; static int rot1;  static int rot2;  static int rot3;  static int ref;  static int rot3a;  static int rot2a;  static int rot1a;
	
	
	//Methode de rotation gauche
	static void leftRotate(Object arr[], 
	        int d, int n) 
	{ 
	for (int i = 0; i < d; i++) 
		gauchePar1(arr, n); 
	} 
	//Rotation par 1 des valeur a gauche
	static void gauchePar1(Object arr[], int n) 
	{ 
	int i;
	Object temp; 
	temp = arr[0]; 
	for (i = 0; i < n - 1; i++) 
	arr[i] = arr[i + 1]; 
	arr[i] = temp; 
	} 

	//Methode de rotation droite
	static void rightRotate(Object[] arr2, 
	        int d, int n) 
	{ 
	for (int i = n; i > d; i--) 
		droitePar1(arr2, n); 
	} 
	//rotation par 1 des valeur a droite
	static void droitePar1(Object[] arr2, int n) 
	{ 
	int i;
	Object temp; 
	temp = arr2[0]; 
	for (i = 0; i < n - 1; i++) 
	arr2[i] = arr2[i + 1]; 
	arr2[i] = temp; 
	} 
	
	//Methode de configuration des rotors
	static void configurationRotor(String str[])
	{
		int d = Integer.parseInt(str[2]);
		if (str[0].equals("R3")) {
			if(d > 0)
			{
				rightRotate(rotor3a, d, rotor3a.length);
				rightRotate(rotor3b, d, rotor3b.length);
				
			}
			if(d < 0)
			{
				int d1 = d*(-1);
				leftRotate(rotor3a, d1, rotor3a.length);
				leftRotate(rotor3b, d1, rotor3b.length);
				
			}
		}
		if (str[0].equals("R2")) {
			if(d > 0)
			{
				rightRotate(rotor2a, d, rotor2a.length);
				rightRotate(rotor2b, d, rotor2b.length);
				
			}
			if(d < 0)
			{
				int d1 = d*(-1);
				leftRotate(rotor2a, d1, rotor2a.length);
				leftRotate(rotor2b, d1, rotor2b.length);
				
			}
		}
		if (str[0].equals("R1")) {
			if(d > 0)
			{
				rightRotate(rotor1a, d, rotor1a.length);
				rightRotate(rotor1b, d, rotor1b.length);
				
			}
			if(d < 0)
			{
				int d1 = d*(-1);
				leftRotate(rotor1a, d1, rotor1a.length);
				leftRotate(rotor1b, d1, rotor1b.length);
				
			}
		}
	}
	
	//Methode pour passer a l'etape suivante
	static void nextStep(String str[]) {
		int d = 1;
		String o = str[1];
		if (str[0].equals("R3")) {
			if(o.equals("D"))
			{
				rightRotate(rotor3a, d, rotor3a.length);
				rightRotate(rotor3b, d, rotor3b.length);
				
			}
			if(o.equals("G"))
			{
				leftRotate(rotor3a, d, rotor3a.length);
				leftRotate(rotor3b, d, rotor3b.length);
				
			}
		}
		if (str[0].equals("R2")) {
			if(o.equals("D"))
			{
				rightRotate(rotor2a, d, rotor2a.length);
				rightRotate(rotor2b, d, rotor2b.length);
				
			}
			if(o.equals("G"))
			{
				leftRotate(rotor2a, d, rotor2a.length);
				leftRotate(rotor2b, d, rotor2b.length);
				
			}
		}
		if (str[0].equals("R1")) {
			if(o.equals("D"))
			{
				rightRotate(rotor1a, d, rotor1a.length);
				rightRotate(rotor1b, d, rotor1b.length);
				
			}
			if(o.equals("G"))
			{
				leftRotate(rotor1a, d, rotor1a.length);
				leftRotate(rotor1b, d, rotor1b.length);
				
			}
		}
	}
	//int rot1;  int rot2;  int rot3;  int ref;  int rot3a;  int rot2a;  int rot1a;
	//Methode pour encrypte et decrypter
	static void encrypt_decrypt(int position) {
		rot0=position;
		rot1 = (((position +  (int)rotor1b[position])%26)+26) % 26;
		
		rot2 = (((rot1 + (int) rotor2b[rot1])%26)+26)%26;

		rot3 = (((rot2 + (int)rotor3b[rot2])%26)+26)%26;

		ref = (((rot3 + (int)reflector[rot3])%26)+26)%26;

		rot3a = (((ref +(int) rotor3a[ref])%26)+26)%26;

		rot2a= (((rot3a +(int) rotor2a[rot3a])%26)+26)%26;

		rot1a= (((rot2a +(int)rotor1a[rot2a])%26)+26)%26;

		
		Ecran.res =rot1a;
	}
	

	
	static void resetTab () {
		 Object[] rotor3aa = {12, -1, 23, 10, 2, 14, 5, -5, 9, -2, -13, 10, -2, -8, 10, -6, 6, -16, 2, -1, -17, -5, -14, -9, -20, -10};
		 Object[] rotor3bb = {1, 16, 5, 17, 20, 8, -2, 2, 14, 6, 2, -5, -12, -10, 9, 10, 5, -9, 1, -14, -2, -10, -6, 13, -10, -23}; 
		 Object[] rotor2aa = {25, 7, 17, -3, 13, 19, 12, 3, -1, 11, 5, -5, -7, 10, -2, 1, -2, 4, -17, -8, -16, -18, -9, -1, -22, -16}; 
		 Object[] rotor2bb = {3, 17, 22, 18, 16, 7, 5, 1, -7, 16, -3, 8, 2, 9, 2, -5, -1, -13, -12, -17, -11, -4, 1, -10, -19, -25}; 
		 Object[] rotor1aa = {17, 4, 19, 21, 7, 11, 3, -5, 7, 9, -10, 9, 17, 6, -6, -2, -4, -7, -12, -5, 3, 4, -21, -16, -2, -21};
		 Object[] rotor1bb = {10, 21, 5, -17, 21, -4, 12, 16, 6, -3, 7, -7, 4, 2, 5, -7, -11, -17, -9, -6, -9, -19, 2, -3, -21, -4};
		
		for(int i = 0 ; i<26; i++) {
			
			rotor3a[i] = rotor3aa[i];
			rotor3b[i] = rotor3bb[i];
			rotor2a[i] = rotor2aa[i];
			rotor2b[i] = rotor2bb[i];
			rotor1a[i] = rotor1aa[i];
			rotor1b[i] = rotor1bb[i];
		}
		
		c1 = 0;
	}
	
	

}
