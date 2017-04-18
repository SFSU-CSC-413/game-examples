package collisions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CollisionPanel extends JPanel implements KeyListener {
  private Collidable red;
  private Collidable blue;

  public CollisionPanel() {
    red = new Collidable( 50, 50,Color.red );
    blue = new Collidable( 80, 80, Color.blue );

    this.addKeyListener( this );
    this.setFocusable( true );
  }

  @Override
  public void paintComponent( Graphics graphics ) {
    red.repaint( graphics );
    blue.repaint( graphics );

    String message = blue.collides( red ) ? "YES" : "NO";
    graphics.drawString( message, 20, 20 );
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension( 250, 250 );
  }

  @Override
  public void keyTyped( KeyEvent e ) {
  }

  @Override
  public void keyPressed( KeyEvent e ) {
    switch ( e.getKeyCode() ) {
      case KeyEvent.VK_LEFT:
        red.moveLeft();
        break;
      case KeyEvent.VK_RIGHT:
        red.moveRight();
        break;
      case KeyEvent.VK_UP:
        blue.moveUp();
        break;
      case KeyEvent.VK_DOWN:
        blue.moveDown();
        break;
    }

    repaint();
  }

  @Override
  public void keyReleased( KeyEvent e ) {
  }
}