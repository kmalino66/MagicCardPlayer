package net.trizmo.mtgcards.inCameCards;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import net.trizmo.mtgcards.Screen;

public class BattlefieldCard {
	private Image textureImage;

	private int x, y, tx, ty, rarity;
	
	private String cardName;
	
	private CounterAttribute counterInfo;

	private boolean tapped;

	public BattlefieldCard(String cardName, Image textureImage, int x, int y, int rarity, boolean tapped)
	{
		this.cardName = cardName;
		this.textureImage = textureImage;
		this.x = x;
		this.y = y;
		this.tapped = tapped;
		this.rarity = rarity;
		counterInfo = new CounterAttribute();
	}
	
	public BattlefieldCard(String cardName, Image textureImage, int x, int y, int rarity, boolean tapped, CounterAttribute counterInfo)
	{
		this(cardName, textureImage, x, y, rarity, tapped);
		
		this.counterInfo = counterInfo;
	}

	public BattlefieldCard(BattlefieldCard battlefieldCard) {
		this.cardName = battlefieldCard.getCardName();
		this.counterInfo = battlefieldCard.getCounterInfo();
		if(!battlefieldCard.getTapped())
		{
		this.textureImage = battlefieldCard.textureImage;
		this.x = battlefieldCard.getX();
		this.y = battlefieldCard.getY();
		this.tapped = battlefieldCard.getTapped();
		this.rarity = battlefieldCard.getRarity();
	
		}else
		{
			this.textureImage = battlefieldCard.textureImage;
			this.tx = battlefieldCard.getTX();
			this.ty = battlefieldCard.getTY();
			this.tapped = battlefieldCard.getTapped();
			this.rarity = battlefieldCard.getRarity();
		}
	}

	public Image getImage()
	{
		return textureImage;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getTY()
	{
		return ty;
	}

	public int getTX()
	{
		return tx;
	}

	public boolean getTapped()
	{
		return tapped;
	}
	
	public void setTapped(boolean tap)
	{
		tapped = tap;
	}

	public boolean contains(MouseEvent e)
	{
		if(!tapped){
			Rectangle rect = new Rectangle(x, y,  Screen.cardWidth, Screen.cardHeight);
			return rect.contains(e.getPoint());
		}else{
			Rectangle rect = new Rectangle(x - (Screen.cardHeight - Screen.cardWidth) / 2, y - (Screen.cardHeight - Screen.cardWidth) / 2, Screen.cardHeight, Screen.cardWidth);
			return rect.contains(e.getPoint());
		}
	}
	
	public boolean contains(Point e)
	{
		if(!tapped){
			Rectangle rect = new Rectangle(x, y,  Screen.cardWidth, Screen.cardHeight);
			return rect.contains(e);
		}else{
			Rectangle rect = new Rectangle(x - (Screen.cardHeight - Screen.cardWidth) / 2, y - (Screen.cardHeight - Screen.cardWidth) / 2, Screen.cardHeight, Screen.cardWidth);
			return rect.contains(e);
		}
	}

	public void setPos(int xPos, int yPos)
	{
		x = xPos;
		tx = yPos - ((Screen.cardHeight - Screen.cardWidth) / 2);
		y = yPos;
		ty = -xPos - ((Screen.cardHeight - Screen.cardWidth) / 2);
	}

	public void setTappedPos(int txPos, int tyPos)
	{
		tx = txPos;
		ty = tyPos;
		x = -1 * (ty + ((Screen.cardHeight - Screen.cardWidth) / 2));
		y = (tx + ((Screen.cardHeight - Screen.cardWidth) / 2));
	}
	
	public Point getPosOnCard(int mouseX, int mouseY)
	{
		if(!tapped)
		{
			if(mouseX > x && mouseY > y) {
			return new Point(mouseX - x, mouseY - y);
			} else{
				return new Point(0,0);
			}
		}else{
			return new Point(0,0);
		}
	}

	public int getRarity() {
		return rarity;
	}
	
	public String getCardName()
	{
		return cardName;
	}
	
	public void setCounterInfo(CounterAttribute counterInfo)
	{
		this.counterInfo = counterInfo;
	}
	public CounterAttribute getCounterInfo()
	{
		return counterInfo;
	}
	
}