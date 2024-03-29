import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/*
	This class can be used as a starting point for creating your Chess game project. The only piece that
	has been coded is a white pawn...a lot done, more to do!
*/



/*
-------------------------------------------

        Name: Liam Flynn
        Student No: X16352296
        Cyber Security Stream

--------------------------------------------

        Bishop - working
        Rook - working
        Queen - working
        King - working (without check system)
        Black pawn - working
        White pawn - working
        Knight - working
        Turn method -
        Win message - working (first part - taking King)
        Pieces can't go off board - working

---------------------------------------------
*/

public class ChessProject extends JFrame implements MouseListener, MouseMotionListener {
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
		int startX;
		int startY;
		int initialX;
		int initialY;
		JPanel panels;
		JLabel pieces;


    public ChessProject(){
        Dimension boardSize = new Dimension(600, 600);

        //  Use a Layered Pane for this application
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        //Add a chess board to the Layered Pane
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout( new GridLayout(8, 8) );
        chessBoard.setPreferredSize( boardSize );
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel( new BorderLayout() );
            chessBoard.add( square );

            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground( i % 2 == 0 ? Color.white : Color.gray );
            else
                square.setBackground( i % 2 == 0 ? Color.gray : Color.white );
        }









    // Setting up the Initial Chess board.
		for(int i=8;i < 16; i++){
        pieces = new JLabel( new ImageIcon("WhitePawn.png") );
  			panels = (JPanel)chessBoard.getComponent(i);
  	    panels.add(pieces);
		}

  		  pieces = new JLabel( new ImageIcon("WhiteRook.png") );
  		  panels = (JPanel)chessBoard.getComponent(0);
  	    panels.add(pieces);
  		  pieces = new JLabel( new ImageIcon("WhiteKnight.png") );
  		  panels = (JPanel)chessBoard.getComponent(1);
  	    panels.add(pieces);
  		  pieces = new JLabel( new ImageIcon("WhiteKnight.png") );
  		  panels = (JPanel)chessBoard.getComponent(6);
  	    panels.add(pieces);
  	  	pieces = new JLabel( new ImageIcon("WhiteBishop.png") );
  		  panels = (JPanel)chessBoard.getComponent(2);
  	    panels.add(pieces);
  		  pieces = new JLabel( new ImageIcon("WhiteBishop.png") );
  		  panels = (JPanel)chessBoard.getComponent(5);
  	    panels.add(pieces);
  	  	pieces = new JLabel( new ImageIcon("WhiteKing.png") );
  	  	panels = (JPanel)chessBoard.getComponent(3);
  	    panels.add(pieces);
  	  	pieces = new JLabel( new ImageIcon("WhiteQueen.png") );
  	  	panels = (JPanel)chessBoard.getComponent(4);
  	    panels.add(pieces);
  		  pieces = new JLabel( new ImageIcon("WhiteRook.png") );
  		  panels = (JPanel)chessBoard.getComponent(7);
  	    panels.add(pieces);


    for(int i=48;i < 56; i++){
      	pieces = new JLabel( new ImageIcon("BlackPawn.png") );
  			panels = (JPanel)chessBoard.getComponent(i);
  	    panels.add(pieces);
		}


  		  pieces = new JLabel( new ImageIcon("BlackRook.png") );
  		  panels = (JPanel)chessBoard.getComponent(56);
  	    panels.add(pieces);
  		  pieces = new JLabel( new ImageIcon("BlackKnight.png") );
  		  panels = (JPanel)chessBoard.getComponent(57);
  	    panels.add(pieces);
  		  pieces = new JLabel( new ImageIcon("BlackKnight.png") );
  		  panels = (JPanel)chessBoard.getComponent(62);
  	    panels.add(pieces);
  		  pieces = new JLabel( new ImageIcon("BlackBishop.png") );
  		  panels = (JPanel)chessBoard.getComponent(58);
  	    panels.add(pieces);
  		  pieces = new JLabel( new ImageIcon("BlackBishop.png") );
  		  panels = (JPanel)chessBoard.getComponent(61);
  	    panels.add(pieces);
  	  	pieces = new JLabel( new ImageIcon("BlackKing.png") );
  	  	panels = (JPanel)chessBoard.getComponent(59);
  	    panels.add(pieces);
  	  	pieces = new JLabel( new ImageIcon("BlackQueen.png") );
  	  	panels = (JPanel)chessBoard.getComponent(60);
  	    panels.add(pieces);
  	  	pieces = new JLabel( new ImageIcon("BlackRook.png") );
  		  panels = (JPanel)chessBoard.getComponent(63);
  	    panels.add(pieces);

    }







	/*
		This method checks if there is a piece present on a particular square.
	*/
	private Boolean piecePresent(int x, int y){
  		Component c = chessBoard.findComponentAt(x, y);

      if(c instanceof JPanel){
  			return false;
  		}
  		else{
  			return true;
  		}
	}







	/*
		This is a method to check if a piece is a Black piece.
	*/
	private Boolean checkWhiteOpponent(int newX, int newY){
  		Boolean opponent;
  		Component c1 = chessBoard.findComponentAt(newX, newY);
  		JLabel awaitingPiece = (JLabel)c1;
  		String tmp1 = awaitingPiece.getIcon().toString();

      //White winner prompt
      if ((tmp1.contains("BlackKing"))) {
        JOptionPane.showMessageDialog(null,"White is the winner");
        System.exit(0);
      }

      if(((tmp1.contains("Black")))){
  			opponent = true;
  		}
  		else{
  			opponent = false;
  		}
  		return opponent;
	}







  /*
		This is a method to check if a piece is a White piece.
	*/
  private Boolean checkBlackOpponent(int newX, int newY){

  		Boolean opponent;
  		Component c1 = chessBoard.findComponentAt(newX, newY);
  		JLabel awaitingPiece = (JLabel)c1;
  		String tmp1 = awaitingPiece.getIcon().toString();

      //Black winner prompt
      if ((tmp1.contains("WhiteKing"))) {
        JOptionPane.showMessageDialog(null,"Black is the winner");
        System.exit(0);
      }

  		if(((tmp1.contains("White")))){
  			opponent = true;
  		}
  		else{
  			opponent = false;
  		}
  		return opponent;
	}









	/*
		This method is called when we press the Mouse. So we need to find out what piece we have
		selected. We may also not have selected a piece!
	*/
  public void mousePressed(MouseEvent e){
      chessPiece = null;
      Component c =  chessBoard.findComponentAt(e.getX(), e.getY());


      if (c instanceof JPanel)
    		  return;

          Point parentLocation = c.getParent().getLocation();
          xAdjustment = parentLocation.x - e.getX();
          yAdjustment = parentLocation.y - e.getY();
          chessPiece = (JLabel)c;
    	    initialX = e.getX();
    	    initialY = e.getY();
    	    startX = (e.getX()/75);
    	    startY = (e.getY()/75);
          chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
          chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
          layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
   }

   public void mouseDragged(MouseEvent me) {
       if (chessPiece == null) return;
          chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
   }









 	 /*
	 This method is used when the Mouse is released...we need to make sure the move was valid before
	 putting the piece back on the board.
	 */
   public void mouseReleased(MouseEvent e) {
        if(chessPiece == null) return;

          chessPiece.setVisible(false);

          Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		      String tmp = chessPiece.getIcon().toString();
		      String pieceName = tmp.substring(0, (tmp.length()-4));
		      Boolean validMove = false;
          Boolean success = false;
          Boolean progression = false;
          Boolean inTheWay = false;

          int landingX=(e.getX()/75);
          int landingY=(e.getY()/75);
          int xMovement=Math.abs((e.getX()/75)-startX);
          int yMovement=Math.abs((e.getY()/75)-startY);

          System.out.println("----------------------------------------------");
          System.out.println("The piece that is being moved is : "+pieceName);
          System.out.println("The starting coordinates are : "+"( "+startX+","+startY+" )");
          System.out.println("The xMovement is :"+xMovement);
          System.out.println("The yMovement is :"+yMovement);
          System.out.println("The landing coordinates are : "+"( "+landingX+","+landingY+")");
          System.out.println("----------------------------------------------");













    /*
			The only piece that has been enabled to move is a White Pawn...but we should really have this is a separate
			method somewhere...how would this work.

			So a Pawn is able to move two squares forward one its first go but only one square after that.
			The Pawn is the only piece that cannot move backwards in chess...so be careful when committing
			a pawn forward. A Pawn is able to take any of the opponent’s pieces but they have to be one
			square forward and one square over, i.e. in a diagonal direction from the Pawns original position.
			If a Pawn makes it to the top of the other side, the Pawn can turn into any other piece, for
			demonstration purposes the Pawn here turns into a Queen.

      75 - height & width of the square [tile]
		*/


    try{


    /*
    ------------------------------
            King Piece
    ------------------------------
    */

    if (pieceName.contains("King")) {
        //moving one square at a time
        if ((xMovement == 1)||(yMovement == 1)) {
          validMove = true;
          int distance = Math.abs(startX-landingX);
          //checking diagonal to see if there is a piece in the way
          if (Math.abs(startX-landingX)==Math.abs(startY-landingY)) {
              if ((startX-landingX < 0)&&(startY-landingY < 0)) {
                for (int i=0; i<distance; i++) {
                  if (piecePresent((initialX+(i*75)), (initialY+(i*75)))) {
                    inTheWay = true;
                  }
                }
              }
              else if ((startX-landingX<0)&&(startY-landingY>0)) {
                for (int i=0; i<distance; i++) {
                  if (piecePresent((initialX+(i*75)), (initialY-(i*75)))) {
                    inTheWay = true;
                  }
                }
              }
              else if ((startX-landingX>0)&&(startY-landingY>0)) {
                for (int i=0; i<distance; i++) {
                  if (piecePresent((initialX-(i*75)), (initialY-(i*75)))) {
                    inTheWay = true;
                  }
                }
              }
              else if ((startX-landingX>0)&&(startY-landingY<0)) {
                for (int i=0; i<distance; i++) {
                  if (piecePresent((initialX-(i*75)), (initialY+(i*75)))) {
                    inTheWay = true;
                  }
                }
              }
              //In the way / Check take black or white
              if (inTheWay) {
                validMove = false;
              }
              else {
                if(piecePresent(e.getX(), (e.getY()))){
                  if (pieceName.contains("White")) {
                    if (checkWhiteOpponent(e.getX(), e.getY())) {
                      validMove = true;
                    }
                    else {
                      validMove = false;
                    }
                  }
                  else {
                    if (checkBlackOpponent(e.getX(), e.getY())) {
                      validMove = true;
                    }
                    else {
                      validMove = false;
                    }
                  }
                }
                else {
                  validMove = true;
                }
              }
            }

            else {
              //Check to see if King has moved along X or Y axis - but not both
              if (((Math.abs(startX-landingX)!=0) && (Math.abs(startY-landingY)==0)) || ((Math.abs(startX-landingX)==0) && (Math.abs(landingY-startY)!=0))) {
                  if (Math.abs(startX-landingX)!=0) {
                    //int xMovement = Math.abs(startX-landingX);
                    if (startX-landingX > 0) {
                      for (int i=0; i<xMovement; i++) {
                        if (piecePresent(initialX-(i*75), e.getY())) {
                          inTheWay = true;
                          break;
                        }
                        else{
                          inTheWay = false;
                        }
                      }
                    }
                    else{
                      for (int i = 0; i<xMovement; i++) {
                        if (piecePresent(initialX+(i*75), e.getY())) {
                          inTheWay = true;
                          break;
                        }
                        else {
                          inTheWay = false;
                        }
                      }
                    }
                  }
                  else {
                    //int yMovement = Math.abs(startY-landingY);
                    if (startY-landingY > 0) {
                      for (int i=0;i<yMovement;i++) {
                        if (piecePresent(e.getX(),initialY-(i*75))) {
                          inTheWay = true;
                          break;
                        }
                        else {
                          inTheWay = false;
                        }
                      }
                    }
                    else {
                      for (int i=0;i<yMovement;i++) {
                        if (piecePresent(e.getX(),initialY+(i*75))) {
                          inTheWay = true;
                          break;
                        }
                        else {
                          inTheWay = false;
                        }
                      }
                    }
                  }
                  //In the way / Check take black or white
                  if (inTheWay == true) {
                    validMove = false;
                  }
                  else{
                    if (piecePresent(e.getX(), (e.getY()))) {
                      if (pieceName.contains("White")) {
                        if (checkWhiteOpponent(e.getX(),e.getY())) {
                          validMove = true;
                        }
                        else{
                          validMove = false;
                        }
                      }
                      else {
                        if (checkBlackOpponent(e.getX(), e.getY())) {
                          validMove = true;
                        }
                        else {
                          validMove = false;
                        }
                      }
                    }
                    else{
                      validMove = true;
                    }
                  }
              }
              else{
                validMove = false;
              }
            }
          }
    }










    /*
    ------------------------------
            Queen Piece
    ------------------------------
    */

    if(pieceName.contains("Queen")){
      int distance = Math.abs(startX-landingX);
      //checking diagonal to see if there is a piece in the way
      if (Math.abs(startX-landingX)==Math.abs(startY-landingY)) {
          if ((startX-landingX < 0)&&(startY-landingY < 0)) {
            for (int i=0; i<distance; i++) {
              if (piecePresent((initialX+(i*75)), (initialY+(i*75)))) {
                inTheWay = true;
              }
            }
          }
          else if ((startX-landingX<0)&&(startY-landingY>0)) {
            for (int i=0; i<distance; i++) {
              if (piecePresent((initialX+(i*75)), (initialY-(i*75)))) {
                inTheWay = true;
              }
            }
          }
          else if ((startX-landingX>0)&&(startY-landingY>0)) {
            for (int i=0; i<distance; i++) {
              if (piecePresent((initialX-(i*75)), (initialY-(i*75)))) {
                inTheWay = true;
              }
            }
          }
          else if ((startX-landingX>0)&&(startY-landingY<0)) {
            for (int i=0; i<distance; i++) {
              if (piecePresent((initialX-(i*75)), (initialY+(i*75)))) {
                inTheWay = true;
              }
            }
          }
          //In the way / Check take black or white
          if (inTheWay) {
            validMove = false;
          }
          else {
            if(piecePresent(e.getX(), (e.getY()))){
              if (pieceName.contains("White")) {
                if (checkWhiteOpponent(e.getX(), e.getY())) {
                  validMove = true;
                }
                else {
                  validMove = false;
                }
              }
              else {
                if (checkBlackOpponent(e.getX(), e.getY())) {
                  validMove = true;
                }
                else {
                  validMove = false;
                }
              }
            }
            else {
              validMove = true;
            }
          }
        }

        else {
          //Check to see if Queen has moved along X or Y axis - but not both
          if (((Math.abs(startX-landingX)!=0) && (Math.abs(startY-landingY)==0)) || ((Math.abs(startX-landingX)==0) && (Math.abs(landingY-startY)!=0))) {
              if (Math.abs(startX-landingX)!=0) {
                //int xMovement = Math.abs(startX-landingX);
                if (startX-landingX > 0) {
                  for (int i=0; i<xMovement; i++) {
                    if (piecePresent(initialX-(i*75), e.getY())) {
                      inTheWay = true;
                      break;
                    }
                    else{
                      inTheWay = false;
                    }
                  }
                }
                else{
                  for (int i = 0; i<xMovement; i++) {
                    if (piecePresent(initialX+(i*75), e.getY())) {
                      inTheWay = true;
                      break;
                    }
                    else {
                      inTheWay = false;
                    }
                  }
                }
              }
              else {
                //int yMovement = Math.abs(startY-landingY);
                if (startY-landingY > 0) {
                  for (int i=0;i<yMovement;i++) {
                    if (piecePresent(e.getX(),initialY-(i*75))) {
                      inTheWay = true;
                      break;
                    }
                    else {
                      inTheWay = false;
                    }
                  }
                }
                else {
                  for (int i=0;i<yMovement;i++) {
                    if (piecePresent(e.getX(),initialY+(i*75))) {
                      inTheWay = true;
                      break;
                    }
                    else {
                      inTheWay = false;
                    }
                  }
                }
              }
              //In the way / Check take black or white
              if (inTheWay == true) {
                validMove = false;
              }
              else{
                if (piecePresent(e.getX(), (e.getY()))) {
                  if (pieceName.contains("White")) {
                    if (checkWhiteOpponent(e.getX(),e.getY())) {
                      validMove = true;
                    }
                    else{
                      validMove = false;
                    }
                  }
                  else {
                    if (checkBlackOpponent(e.getX(), e.getY())) {
                      validMove = true;
                    }
                    else {
                      validMove = false;
                    }
                  }
                }
                else{
                  validMove = true;
                }
              }
          }
          else{
            validMove = false;
          }
        }
      }









    /*
    ------------------------------
            Rook Piece
    ------------------------------
    */

    if (pieceName.contains("Rook")) {
        //Check to see if Rook has moved along X or Y axis - but not both
        if (((Math.abs(startX-landingX)!=0) && (Math.abs(startY-landingY)==0)) || ((Math.abs(startX-landingX)==0) && (Math.abs(landingY-startY)!=0))) {
            //Rook movement along the X axis
            if (Math.abs(startX-landingX)!=0) {
              //int xMovement = Math.abs(startX-landingX);
              if (startX-landingX > 0) {
                for (int i=0; i<xMovement; i++) {
                  if (piecePresent(initialX-(i*75), e.getY())) {
                    inTheWay = true;
                    break;
                  }
                  else{
                    inTheWay = false;
                  }
                }
              }
              else{
                for (int i = 0; i<xMovement; i++) {
                  if (piecePresent(initialX+(i*75), e.getY())) {
                    inTheWay = true;
                    break;
                  }
                  else {
                    inTheWay = false;
                  }
                }
              }
            }
            //Rook movement along the Y axis
            else {
              //int yMovement = Math.abs(startY-landingY);
              if (startY-landingY > 0) {
                for (int i=0;i<yMovement;i++) {
                  if (piecePresent(e.getX(),initialY-(i*75))) {
                    inTheWay = true;
                    break;
                  }
                  else {
                    inTheWay = false;
                  }
                }
              }
              else {
                for (int i=0;i<yMovement;i++) {
                  if (piecePresent(e.getX(),initialY+(i*75))) {
                    inTheWay = true;
                    break;
                  }
                  else {
                    inTheWay = false;
                  }
                }
              }
            }
            //In the way / Check take black or white
            if (inTheWay == true) {
              validMove = false;
            }
            else{
              if (piecePresent(e.getX(), (e.getY()))) {
                if (pieceName.contains("White")) {
                  if (checkWhiteOpponent(e.getX(),e.getY())) {
                    validMove = true;
                  }
                  else{
                    validMove = false;
                  }
                }
                else {
                  if (checkBlackOpponent(e.getX(), e.getY())) {
                    validMove = true;
                  }
                  else {
                    validMove = false;
                  }
                }
              }
              else{
                validMove = true;
              }
            }
        }
        else{
          validMove = false;
        }
      }










    /*
    ------------------------------
            Bishop Piece
    ------------------------------
    */

    if(pieceName.contains("Bishop")){
        //diagonal movement
        int distance = Math.abs(startX-landingX);
        validMove = true;
        //checking diagonal to see if there is a piece in the way
        if (Math.abs(startX-landingX)==Math.abs(startY-landingY)) {
          if ((startX-landingX < 0)&&(startY-landingY < 0)) {
            for (int i=0; i<distance; i++) {
              if (piecePresent((initialX+(i*75)), (initialY+(i*75)))) {
                inTheWay = true;
              }
            }
          }
          else if ((startX-landingX<0)&&(startY-landingY>0)) {
            for (int i=0; i<distance; i++) {
              if (piecePresent((initialX+(i*75)), (initialY-(i*75)))) {
                inTheWay = true;
              }
            }
          }
          else if ((startX-landingX>0)&&(startY-landingY>0)) {
            for (int i=0; i<distance; i++) {
              if (piecePresent((initialX-(i*75)), (initialY-(i*75)))) {
                inTheWay = true;
              }
            }
          }
          else if ((startX-landingX>0)&&(startY-landingY<0)) {
            for (int i=0; i<distance; i++) {
              if (piecePresent((initialX-(i*75)), (initialY+(i*75)))) {
                inTheWay = true;
              }
            }
          }
          //In the way / Check take black or white
          if (inTheWay) {
            validMove = false;
          }
          else {
            if(piecePresent(e.getX(), (e.getY()))){
              if (pieceName.contains("White")) {
                if (checkWhiteOpponent(e.getX(), e.getY())) {
                  validMove = true;
                }
                else {
                  validMove = false;
                }
              }
              else {
                if (checkBlackOpponent(e.getX(), e.getY())) {
                  validMove = true;
                }
                else {
                  validMove = false;
                }
              }
            }
            else {
              validMove = true;
            }
          }
        }
        else {
          validMove = false;
        }
      }










    /*
    ------------------------------
            Knight Piece
    ------------------------------
    */

    if (pieceName.contains("Knight")) {
      //moving in an L direction
      if (((xMovement == 1)&&(yMovement ==2)) || ((xMovement == 2) && (yMovement == 1))) {
            //In the way / Check take black or white
            if (!piecePresent(e.getX(), e.getY())) {
              validMove = true;
            }
            else{
              if (pieceName.contains("White")) {
                if (checkWhiteOpponent(e.getX(), e.getY())) {
                  validMove = true;
                }
              }
              else{
                if (checkBlackOpponent(e.getX(), e.getY())) {
                  validMove = true;
                }
              }
            }
          }
      }










    /*
    ------------------------------
          Black Pawn Piece
    ------------------------------
    */

    if(pieceName.equals("BlackPawn")){
      //if Black Pawn is in starting position you can move it (6 = second row in the bottom)
      if(startY == 6){ //pawn making first move
        if (((yMovement==1)||(yMovement==2)) && (startY>landingY) && (xMovement==0)) {
            //prevention if piece present ahead - same y coordinate
            if (yMovement == 2) {
              if ((!piecePresent(e.getX(), e.getY())) && (!piecePresent(e.getX(), e.getY()+75))) {
                validMove = true;
              }
            }
            else{
                if (!piecePresent(e.getX(), e.getY())) {
                    validMove = true;
                }
            }
        }
        //diagonal movement for black pawn
        else if ((yMovement==1)&&(startY>landingY)&&(xMovement==1)) {
          //determine piece
          if (piecePresent(e.getX(), e.getY())) {
            if (checkBlackOpponent(e.getX(), e.getY())) {
              validMove = true;
            }
          }
        }
      }
      //pawn making all subsequent moves
      else{
        if ((yMovement==1) && (startY>landingY) && (xMovement==0)){
          if (!piecePresent(e.getX(), e.getY())) {
              validMove = true;
              if(landingY == 0){
                progression = true;
              }
          }
          else {
            validMove = false;
          }
        }
        else if ((yMovement==1)&&(startY>landingY)&&(xMovement==1)) {
          //determine piece
          if (piecePresent(e.getX(), e.getY())) {
            if (checkBlackOpponent(e.getX(), e.getY())) {
              validMove = true;
              if(landingY == 0){
                progression = true;
              }
            }
          }
        }
      }
    }









    /*
    ------------------------------
          White Pawn Piece
    ------------------------------
    */

    if(pieceName.equals("WhitePawn")){
      //if White Pawn is in starting position you can move it (1 = second row in the top)
      if(startY == 1){ //pawn making first move
        if (((yMovement==1)||(yMovement==2)) && (startY<landingY) && (xMovement==0)) {
            //prevention if piece present ahead - same y coordinate
            if (yMovement == 2) {
              if ((!piecePresent(e.getX(), e.getY())) && (!piecePresent(e.getX(), e.getY()-75))) {
                validMove = true;
              }
            }
            else{
                if (!piecePresent(e.getX(), e.getY())) {
                    validMove = true;
                }
            }
        }
        //diagonal movement for white pawn
        else if ((yMovement==1)&&(startY<landingY)&&(xMovement==1)) {
          //determine piece
          if (piecePresent(e.getX(), e.getY())) {
            if (checkWhiteOpponent(e.getX(), e.getY())) {
              validMove = true;
            }
          }
        }
      }
      //Pawn making all subsequent moves
      else{
        if ((yMovement==1) && (startY<landingY) && (xMovement==0)){
          if (!piecePresent(e.getX(), e.getY())) {
              validMove = true;
              if(landingY == 7){
                success = true;
              }
          }
          else {
            validMove = false;
          }
        }
        else if ((yMovement==1)&&(startY<landingY)&&(xMovement==1)) {
          //determine piece
          if (piecePresent(e.getX(), e.getY())) {
            if (checkWhiteOpponent(e.getX(), e.getY())) {
              validMove = true;
              if(landingY == 7){
                success = true;
              }
            }
          }
        }
      }
    }


  }
  //pieces can't leave the chess board exception
  catch(Exception offBoard){
    validMove = false;
  }









    /*
    ---------------------------------------
          Black/White Pawn Replacement
    ---------------------------------------
    */

		if(!validMove){
			int location=0;
			if(startY ==0){
				location = startX;
			}
			else{
				location  = (startY*8)+startX;
			}
			String pieceLocation = pieceName+".png";
			pieces = new JLabel( new ImageIcon(pieceLocation) );
			panels = (JPanel)chessBoard.getComponent(location);
		    panels.add(pieces);
		}
		else{
			if(success){
				int location = 56 + (e.getX()/75);
				if (c instanceof JLabel){
	            	Container parent = c.getParent();
	            	parent.remove(0);
					pieces = new JLabel( new ImageIcon("WhiteQueen.png") );
					parent = (JPanel)chessBoard.getComponent(location);
			    	parent.add(pieces);
				}
				else{
					Container parent = (Container)c;
	            	pieces = new JLabel( new ImageIcon("WhiteQueen.png") );
					parent = (JPanel)chessBoard.getComponent(location);
			    	parent.add(pieces);
				}
			}
      else if (progression) {
        int location = 0 + (e.getX()/75);
				if (c instanceof JLabel){
	            	Container parent = c.getParent();
	            	parent.remove(0);
					pieces = new JLabel( new ImageIcon("BlackQueen.png") );
					parent = (JPanel)chessBoard.getComponent(location);
			    	parent.add(pieces);
				}
				else{
					Container parent = (Container)c;
	            	pieces = new JLabel( new ImageIcon("BlackQueen.png") );
					parent = (JPanel)chessBoard.getComponent(location);
			    	parent.add(pieces);
				}
      }

			else{
				if (c instanceof JLabel){
	            	Container parent = c.getParent();
	            	parent.remove(0);
	            	parent.add( chessPiece );
	        	}
	        	else {
	            	Container parent = (Container)c;
	            	parent.add( chessPiece );
	        	}
	    		chessPiece.setVisible(true);
			}
		}
    }


    public void mouseClicked(MouseEvent e) {

    }
    public void mouseMoved(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e) {

    }











  	/*
    -------------------------------------------
  		Main method that gets the ball moving.
    --------------------------------------------
  	*/
    public static void main(String[] args) {
        JFrame frame = new ChessProject();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
     }
}
