/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AI;

import Assets.Sprites.LiveSprites.Enemies.Enemy;

/**
 *
 * @author DanielSQ
 */
public class SlimAI extends EnemyAI
{
    public SlimAI(Enemy enemy)
    {
        super(enemy);
        distance = 200;
        speed = 10;
    }
    
    @Override
    public void runOps()
    {
        //System.out.println("Corriendo operaciones para Slim");
        setIniPosOnX();
        
        setFinalPosOnX();
        
        moveEnemyOnX();
    }
}
