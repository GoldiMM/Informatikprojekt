package dalmuti.server;

import dalmuti.shared.Masterobject;

public class Logic {
	
	static int j = 0;

	public static Masterobject control(Masterobject mo) {
		
		// set user with no more cards to passive
		for (int i = 0; i < mo.users.size(); i++) {
			if (mo.users.get(i).getAmount() == 0) {
				if(mo.users.get(i).isPassive() == true){
					continue;
				}
				mo.users.get(i).setPassive(true);
				mo.nextround.add(mo.users.get(i));
				System.out.println("Jetzt Passiv " + mo.nextround.get(j).getNickname());
				j++;
				System.out.println("Passivstatus " + mo.users.get(i).isPassive());
				break;
			}
		}

		// change active user
		for (int i = 0; i < mo.users.size(); i++) {
			if (mo.users.get(i).getActive() == true && mo.users.get(mo.nextplayer(i)).isPassive() == false) {
				mo.users.get(i).setActive(false);
				mo.users.get(mo.nextplayer(i)).setActive(true);
				break;
			}
			else if(mo.users.get(i).getActive() == true && mo.users.get(mo.nextplayer(i)).isPassive() == true){
				mo.users.get(i).setActive(false);
				mo.users.get(mo.nextplayer(i)).setActive(true);
				i = mo.nextplayer(i);
				continue;
			}
		}
		
		// no one can play
		if (mo.pass == mo.users.size() - 1) {
			mo.playedcards[0] = 0;
			mo.playedcards[1] = 0;
		}
		
		// start of new round
		if (mo.users.size() == 1) {
			mo.nextround.add(mo.users.get(0));
			mo.users.clear();
			mo.users.addAll(mo.nextround);
			for (int i = 0; i < mo.users.size(); i++) {
				mo.users.get(i).setPassive(false);
			}
			
			// distribute new cards
			int[] deck = Masterobject.createdeck();
			Masterobject.shuffle(deck);
			mo.distribute(deck);
			// set Dalmuti to active
			for (int i = 0; i < mo.users.size(); i++) {
				mo.users.get(i).setActive(false);
			}
			mo.users.get(0).setActive(true);

		}
		return mo;
	}
}