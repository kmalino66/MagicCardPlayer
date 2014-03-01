package net.trizmo.mtgcards.inCameCards;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import net.trizmo.mtgcards.Screen;

public class BattlefieldCard {
	private Image textureImage;

	private int x;
	private int y;
	private int tx;
	private int ty;

	private boolean tapped;

	public BattlefieldCard(Image textureImage, int x, int y, boolean tapped)
	{
		this.textureImage = textureImage;
		this.x = x;
		this.y = y;
		this.tapped = tapped;

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
		x = -ty + ((Screen.cardHeight - Screen.cardWidth) / 2);
		y = tx + ((Screen.cardHeight - Screen.cardWidth) / 2);
	}
	
	public Point getPosOnCard(int mouseX, int mouseY)
	{
		if(!tapped)
		{
			return new Point(mouseX - x, mouseY - y);
		}else{
			return new Point( mouseX - (x - (Screen.cardHeight - Screen.cardWidth) / 2), mouseY - (y - (Screen.cardHeight - Screen.cardWidth) / 2));
		}
	}

}