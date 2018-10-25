
import java.util.*;

class Deck 
{
	public int a = 0; //歸零用
	public int b = 0; //歸零用
	private ArrayList<Card> cards;//牌堆  //宣告陣列  arrayList 為Java內建的Class,功能超級強大
	ArrayList<Card> usedCard = new ArrayList<Card>();
	public int nUsed = 0;

	// TODO: Please implement the constructor (30 points)
	public Deck(int nDeck) //有參數的建構子(沒有回傳值)
	{
		cards = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end

		for (int i = 0; i < nDeck; i++)  //幾副牌
		{
		for(int x=0;x<4;x++) //1-4花色
		{
				for (int y = 1; y < 14; y++) //數字
				{
					if(x==0) 
					{
						Card card = new Card(Card.Suit.Clubs, y);
						cards.add(card);
					}
					 else if(x==1) 
					{
						Card card=new Card(Card.Suit.Diamonds,y);
						cards.add(card);
					}
					 else if(x==2) 
					{
						Card card=new Card(Card.Suit.Hearts,y);
						cards.add(card);
					}
					 else if(x==3) 
					{
						Card card=new Card(Card.Suit.Spades,y);
						cards.add(card);
					}
					
					

				}
		}
		}

	}

	public Deck() {
		// TODO Auto-generated constructor stub
	}

	public Card getOneCard() //從洗好牌，隨便選一張牌。(52張牌隨便挑一個)
	{
		Card n = new Card(null, 0);
		Random  r = new Random();
		if (nUsed == 52) 
		{
			shuffle();
		}

		n = cards.get(r.nextInt(52));
		for (int j = 0; j < usedCard.size(); j++) 
		{
			
			while (n.equals(usedCard.get(j))) 
			{
				n = cards.get(r.nextInt(52));
			}
		}
		/*
		 * while(n.equals(usedCard)) { n=cards.get(nc.nextInt(52)); }
		 */
		usedCard.add(a, n);
		nUsed++;
		a++;

		return n;
	}


	public void shuffle() //洗牌
	{
		Random rnd = new Random();
		int rp = rnd.nextInt(52);
		Card rtemp = new Card(null, 0);
		Card emp = new Card(null, 0);

		for (int i = 0; i < 52; i++) 
		{
			while (i == rp) 
			{
				rp = rnd.nextInt(52);
			}
			rtemp = cards.get(rp);
			cards.set(rp, cards.get(i));
			cards.set(i, rtemp);

		}

		usedCard.set(b, emp);
		nUsed = 0;

	}

	// TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck()
	{
		// Hint: print all items in ArrayList<Card> cards,
		// TODO: please implement and reuse printCard method in Card class (5 points)
		for (int i = 0; i < 52; i++) 
		{
			//
			// Card n=cards.get(i);
			// //System.out.println(n.getSuit()+","+n.getRank());
			// n.printCard();
			Card n = new Card(null, 0); 
			n = cards.get(i);
			n.printCard();

		}

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}