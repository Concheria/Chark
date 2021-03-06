/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets.Sprites.StaticSprites;

import Assets.Sprites.StaticSprites.StaticSprite;
import java.awt.event.KeyEvent;

/**
 *
 * @author Daniel
 */
public class Bullet extends StaticSprite{
    int bulletSpeed = gameSpeed;
    int damage = 10;
    boolean exploding = false;
    
    String facing;
    public Bullet(int x, int y, String facing)
    {   
        super(x,y);
        this.facing = facing;
        super.setLocation(x, y);
        if(facing.equals("right"))
        {
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Bullet/bullet.png"))); 
        }
        if(facing.equals("left"))
        {
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Bullet/bulletLeft.png"))); 
        }
        super.setIcon(icon); 
        setImageDimensions();
        super.setBounds(0, 0, getW(), getH());
    }
    
    public void move()
    {
        if(facing.equals("right"))
        {
            dx=bulletSpeed;
        }
        if(facing.equals("left"))
        {
            dx=-bulletSpeed;
        }
        x+=dx;
        super.setLocation(x,y);
    }
    
    public boolean getColl()
    {
        boolean collision = false;
        if(isCollisionLeft() || isCollisionRight())
        {
            collision = true;
        }
        return collision;
    }
    
    @Override
    public void moveOnX()
    {
        if(dx > 0)
        {
            if(isCollisionRight() == false)
            {
                x += dx;
            }
        }
        if(dx < 0)
        {
            if(isCollisionLeft() == false)
            {
                x += dx;
            }
        }
        
        super.setLocation(x, y);
    }
    
    public void fall(boolean brinco, boolean movingDown)
    {
        if(!brinco)
        {
            dy = -gameSpeed;
            y += dy;
            movingDown = true;
        }
        else
        {
            dy = 0;
            movingDown = false;
        }
        
        super.setLocation(x, y);
    }
    
    public void showExplosion()
    {
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Bullet/explosion.gif")));
        super.setIcon(icon);
    }
    
    public void setExploding(boolean exploding)
    {
        this.exploding = exploding;
    }
    
    public boolean isExploding()
    {
        return exploding;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_LEFT && key == KeyEvent.VK_RIGHT))
        {
            dx = gameSpeed;
        }
        
        if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_RIGHT && key == KeyEvent.VK_LEFT)) {
            dx = -gameSpeed;
        }
        
        if(key == KeyEvent.VK_UP) {
            dy = gameSpeed;
            setPlayerJumping(true);
        }
    }
    
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_LEFT && key == KeyEvent.VK_RIGHT)) {
            dx = 0;
        }

        if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_RIGHT && key == KeyEvent.VK_LEFT)) {
            dx = 0;
        }
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public void stop()
    {
        bulletSpeed  = 0;
    }
}
