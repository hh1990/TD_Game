package Towers;

import Main.Game;
import Map.World;
import PathFinding.Utils.Node;
import Utils.RenderUtil;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class BaseNode extends Node {
	public World world;
	public boolean isPath = false;
	public float value;
	public Color c = null;

	public BaseNode( World world, int x, int y){
		super(x,y);
		this.world = world;
	}

	public void renderNode( Graphics g2, int x, int y, int sizeX, int sizeY){
		if(this instanceof Turret){
			((Turret)this).renderTower(g2, x, y, sizeX, sizeY);
			return;
		}

		g2.setColor(getColor());
		g2.fill(new Rectangle(x, y, sizeX, sizeY));
	}

	public Color getColor(){
		if(c != null) return c;

		if(Game.world != null && Game.world.getStartNode() != null && Game.world.getStartNode().x == x && Game.world.getStartNode().y == y) return Color.green.darker();
		if(Game.world != null && Game.world.getEndNode() != null && Game.world.getEndNode().x == x && Game.world.getEndNode().y == y) return Color.red.darker();

		if(isPath){
			return RenderUtil.getColorToSlick(new java.awt.Color(255, 215, 109));
		}

		if(value < -1) return Color.green.darker().darker(0.12F);
		if(value < 0) return Color.green.darker();
		if(value < 1) return Color.yellow.darker().darker(0.12F);
		if(value < 2) return Color.yellow.darker();
		if(value < 3) return Color.gray;
		if(value < 4) return Color.darkGray;
		if(value < 5) return Color.darkGray.darker();

		return Color.pink;
	}

}