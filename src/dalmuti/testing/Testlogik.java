package dalmuti.testing;

	import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import dalmuti.shared.Masterobject;
import dalmuti.shared.User;

	public class Testlogik{
		public static ArrayList<User> userlist;

		public static void Spiellogiktest() {
			userlist = new ArrayList<User>(4);
			
			User u1 = new User("Fabio");
			User u2 = new User("Marco");
			User u3 = new User("Bastian");
			User u4 = new User("Silvan");
			
			userlist.add(u1);
			userlist.add(u2);
			userlist.add(u3);
			userlist.add(u4);

			// Sobald 4 User eingeloggt
			if (userlist.size() == 4) {

				// Masterobjekt erstellen
				Masterobject mo = new Masterobject(userlist);

				int[] array = mo.activeusers.get(0).getHand();
				for (int a: array){
					System.out.print(a + " ");
				}
//				mo.activeusers.get(0).setActive(true);
//				System.out.println(mo.whosactive());
			}
		}

		public static void main(String[] args) {
			Spiellogiktest();
			
			

			
			
		}

	}