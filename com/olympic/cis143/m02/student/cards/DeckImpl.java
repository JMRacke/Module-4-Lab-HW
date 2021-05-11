package com.olympic.cis143.m02.student.cards;

import java.util.Collections;
import java.util.Stack;

/**
 * Note that you can think of the deck implementation as being an iterator in that its creates and used once. Meaning, when a card is
 * delt is  MUST be removed from the deck.
 */
public class  DeckImpl {

    /**
     * This will be the stack object for you to work with.
     */
    private Stack<Card> deck = new Stack<>();

    /**
     * Const.
     * @param jokers True if you want jokers in this deck.
     */
    public DeckImpl(final boolean jokers) 
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
     */
    private void createDeck(final boolean jokers)
    {
    	if(jokers) 
    	{
    		this.deck.add(new Card(Card.Suit.NONE,Card.Value.JOKER)); // Adds 2 jokers to the deck if true
    		this.deck.add(new Card(Card.Suit.NONE,Card.Value.JOKER));
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
    			this.deck.add(new Card(suit,value)); //adds the suit and value of card to the deck
    		}
    	}
    }

    /**
     * Gets the deck.
     * @return The deck.
     */
    public Stack<Card> getDeck() 
    {    	
        return this.deck; // Returns the deck for use (can call on stack and vector functions ie .size)
    }
    
    /**
     * Randomize and shuffle the deck of cards.
     */
    
    public void shuffle() 
    {
    	Collections.shuffle(this.deck); // Uses the .shuffle function in Collections since a stack is a list it'll randomize the order
    }

    /**
     * True if the deck has cards remaining else false.
     * @return
     */
    public boolean hasNext() {
        if(!(this.deck.isEmpty())) // Boolean to check if the deck is not empty
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
     */
    public Card dealCard() 
    {
    	if(hasNext()) // If has next evaluates true, it'll deal the next card
    	{
    		return this.deck.pop();
    	}
    	else
    	{
    		throw new RuntimeException("There are no cards left in the deck!"); // Otherwise it'll throw a RuntimeException
    	}
    }
}
