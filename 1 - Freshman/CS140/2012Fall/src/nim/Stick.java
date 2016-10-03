package nim;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Stick
{
	private int lowx;
	private int lowy;
	private int hix;
	private int hiy;
	private Color color;
	private double angle;
	private Random random = new Random();

	public Stick(Color color)
	{
		this.color = color;
		throwStick();
	}
	public void throwStick()
	{
		lowx = (int)Math.round(100+200*random.nextDouble());
		lowy = (int)Math.round(50+200*random.nextDouble());
		angle = 180*random.nextDouble();
		hix = (int)Math.round(lowx + 100*Math.cos(Math.toRadians(angle)));
		hiy = (int)Math.round(lowy + 100*Math.sin(Math.toRadians(angle)));
	}
	public void draw(Graphics2D g)
	{
		Color col = g.getColor();
		g.setColor(color);
		g.drawLine(lowx,lowy,hix,hiy);
		g.setColor(col);
		
	}
}
