package com.olympic.cis143.m02.student.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//import com.olympic.cis143.m02.student.cards.Card;

/**
 * Note that you can think of the deck implementation as being an iterator in that its creates and used once. Meaning, when a card is
 * delt is  MUST be removed from the deck.
 */
public class DeckLinkedListImpl {

    /**
     * This will be the stack object for you to work with.
     */
    private Deque<Card> deck = new LinkedList<>();
    
    /**
     * Const.
     * @param jokers True if you want jokers in this deck.
     * 
     * Creates the deck by calling the appropriate function and passing whether or not to have Jokers
     */
    public DeckLinkedListImpl(final boolean jokers) 
    {
        this.createDeck(jokers);
    }

    /**
     * Private. THis is the place where you will need to create a deck of cards. You can iterate throug
     * ther enums in Card.
     *
     * Some rules:
     * ============
     * 1. Note the boolean jokers parameter. If true add the Jokers to the deck with a Card.Suite.NONE.
     * 2. Do not create cards, other than jokers, with a Card.Suite.NONE.
     *
     * Outcome
     * ========
     * if jokers == true, 54 cards will be created.
     * if jokers == false, 52 cards are created.
     *
     * @param jokers True if you want jokers added to the deck.
     * 
     * This function first checks if it is to add jokers. If so it will add in two jokers then it will loop through
     * each suit and value. If the suit or value is NONE or JOKER it will just continue on to the next iteration
     * and not do anything else. Otherwise it will add the card to the deck.
     */
    private void createDeck(final boolean jokers) 
    {
    	if(jokers) 
    	{
    		this.deck.push(new Card(Card.Suit.NONE,Card.Value.JOKER)); // Adds 2 jokers to the deck if true
    		this.deck.push(new Card(Card.Suit.NONE,Card.Value.JOKER));
    	}
    	for(Card.Suit suit : Card.Suit.values()) // Loops through the suits
    	{
    		if(suit == Card.Suit.NONE) // Checks if the current suit is 'NONE' if so it'll skip to next suit in loop
    		{
    			continue;
    		}
    		for(Card.Value value : Card.Value.values())
    		{
    			if(value == Card.Value.JOKER) // Checks if the current value is 'JOKER' if so it'll skip to next value in loop
    			{
    				continue;
    			}
    			this.deck.push(new Card(suit,value)); //adds the suit and value of card to the deck
    		}
    	}
    }

    /**
     * Gets the deck.
     * @return The deck.
     */
    public Deque<Card> getDeck() 
    {
    	return this.deck;
    }
    /**
     * Randomize and shuffle the deck of cards.
     * 
     * This is the only thing I had difficulty with. While it says I passed the shuffle test, I know this isn't true.
     * Any assistance with this would be hot as I was confused on how to convert the Deque to a linkedlist so I could
     * shuffle. Alternatively, I believe I could make two new LinkedLists using the same data type as above, pop the first 
     * half to one and the last half to another, then used some sort of randomness to put a card from either stack back into
     * the original simulating a riffle shuffle and iterate that a few times to really shuffle it up. I think that would be
     * the best implementation.
     */
    public void shuffle() 
    {
    	List<Object> tempDeck = new ArrayList<Object>(this.deck.size());
    	for(int i = 0; i < this.deck.size(); i++)
    	{
    		tempDeck.add(this.deck.peek());
    	}
    	Collections.shuffle(tempDeck);
    }

    /**
     * True if the deck has cards remaining else false.
     * @return
     * 
     * Checks to see if the deck is empty
     */
    public boolean hasNext() 
    {
        if(!(this.deck.isEmpty()))
        {
        	return true;
        }
    	return false;
    }

    /**
     * Always call the hasNext() method before calling this method.
     * This method should get the next card in the deck.
     *
     * Outcome
     * =======
     * The method will remove the next from the deck and return it in the method.
     *
     * If the deck is empty it should through a RuntimeException.
     * @return
     * 
     * This will deal the first card or throw a RuntimException if empty
     */
    public Card dealCard() 
    {
        if(hasNext()) 
        {
        	return this.deck.removeFirst();
        }
        else 
        {
        	throw new RuntimeException("There are no cards left in the deck!");
        }
    }
}
