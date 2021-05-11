package com.olympic.cis143.m03.student.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class DeckIteratorImpl implements Deck
{

	private ArrayList<Card> deck = new ArrayList<>();
	private Iterator<Card> deckIterator = deck.iterator();
	
	public DeckIteratorImpl(final boolean jokers) 
    {
        this.createDeck(jokers);
    }
	
	
	@Override
	public List<Card> getDeck() {
		
		if(deckIterator.hasNext())
		{
			return (List<Card>) deck;		
		} else {
			return null;
		}
	}

	private void createDeck(final boolean jokers) {
		// TODO Auto-generated method stub
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

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		Collections.shuffle(this.deck);
	}

	@Override
	public boolean hasNext() {
		if(deckIterator.hasNext())
		{
			return true;		
		} else {
			return false;
		}
	}

	@Override
	public Card dealCard() {
		// TODO Auto-generated method stub
		if(deckIterator.hasNext())
		{
			return deck.remove(0);		
		} else {
			throw new RuntimeException("There are no cards left!");
		}
	}

}
