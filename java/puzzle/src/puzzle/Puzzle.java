package puzzle;

import java.awt.*;
import java.applet.Applet;

class Piece extends Object {
	int		x, y, width, height, unit;
	int		xloc, yloc;
	
	public Piece (int xloc, int yloc, int x, int y, int width, int height, int unit) {
		this.xloc = xloc;
		this.yloc = yloc;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.unit = unit;
	}
	
	public void drawPiece (Graphics g, Image pieceImage) {
		int x = (xloc * unit) + (unit >> 1);
		int y = (yloc * unit) + (unit >> 1);
		Graphics gcopy = g.create();
		gcopy.clipRect(x, y, width * unit, height * unit);
		gcopy.drawImage(pieceImage, x - (this.x * unit), y - (this.y * unit), null);
		gcopy.dispose();
	}
	
	public boolean intersects (Piece piece, int x, int y) {
		if (((x + piece.width - 1) < xloc)  ||  (x > (xloc + width - 1)))
			return false;
		if (((y + piece.height - 1) < yloc)  ||  (y > (yloc + height - 1)))
			return false;
		return true;
	}
	
	public boolean picks (int x, int y) {
		if (x < xloc  ||  x > (xloc + width - 1)  ||  y < yloc ||  y > (yloc + height - 1))
			return false;
		return true;
	}
	
	public boolean onBoard (int x, int y) {
		if (x < 0  ||  y < 0  ||  (x + width) > 4  ||  (y + height) > 5)
			return false;
		return true;
	}

	public void moveTo (int x, int y) {
		this.xloc = x;
		this.yloc = y;
	}
}

class PuzzleBoard extends Canvas {
	private Image			offscreenImage, boardImg, piecesImg;
	private int			width, height, unit, pickedX, pickedY, pickedXoff, pickedYoff, lastX, lastY;
	private int			widthBoard, heightBoard, widthPieces, heightPieces;
	private Graphics		offscr;
	private Piece[]		pieces = new Piece[10];
	private Piece			pickedPiece = null;

	public PuzzleBoard (int x, int y, int width, int height, Applet a) {
		super();
		this.width = width;
		this.height = height;
	 	MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(boardImg = a.getImage(a.getCodeBase(), "board.gif"), 0);
		tracker.addImage(piecesImg = a.getImage(a.getCodeBase(), "pieces.gif"), 0);
		// Start loading Images and wait for both to finish loading
		try { tracker.waitForAll(); } catch (InterruptedException e) { ; }
		// Get width and height of both Images, now that they're loaded
		widthBoard = boardImg.getWidth(this);
		heightBoard = boardImg.getHeight(this);
		widthPieces = piecesImg.getWidth(this);
		heightPieces = piecesImg.getHeight(this);
		a.add(this);
		reshape(x, y, width, height);
		// Define the puzzle pieces
		unit = heightPieces >> 2;
		pieces[0] = new Piece(0, 0, 0, 0, 1, 2, unit);
		pieces[1] = new Piece(0, 2, 1, 0, 1, 2, unit);
		pieces[2] = new Piece(3, 0, 0, 2, 1, 2, unit);
		pieces[3] = new Piece(3, 2, 1, 2, 1, 2, unit);
		pieces[4] = new Piece(0, 4, 2, 0, 1, 1, unit);
		pieces[5] = new Piece(1, 3, 2, 1, 1, 1, unit);
		pieces[6] = new Piece(2, 3, 2, 2, 1, 1, unit);
		pieces[7] = new Piece(3, 4, 2, 3, 1, 1, unit);
		pieces[8] = new Piece(1, 2, 3, 2, 2, 1, unit);
		pieces[9] = new Piece(1, 0, 3, 0, 2, 2, unit);
		// Create offscreen buffer <width> pixels wide and <height> pixels tall
		offscreenImage = createImage(width, height);
		offscr = offscreenImage.getGraphics();
		repaint();
	}
	
	public void pickPiece (int x, int y) {
		int off = unit >> 1;
		if (x >= off  &&  y >= off  &&  x < ((unit * 4) + off)  &&  y < ((unit * 5) + off)) {
			x = (x - off) / unit;
			y = (y - off) / unit;
			for (int ii = 0; ii < pieces.length; ii++) {
				if (pieces[ii].picks(x, y)) {
					pickedPiece = pieces[ii];
					pickedXoff = x - pickedPiece.xloc;
					pickedYoff = y - pickedPiece.yloc;
					pickedX = pickedPiece.xloc;
					pickedY = pickedPiece.yloc;
					return;
				}
			}
		}
		pickedPiece = null;
	}
	
	public void tryMove (int x, int y) {
		pickedX += x;
		pickedY += y;
		x = pickedPiece.xloc + x;
		y = pickedPiece.yloc + y;
		if (pickedPiece.onBoard(x, y)) {
			for (int ii = 0; ii < pieces.length; ii++) {
				if (pickedPiece != pieces[ii]  &&  pieces[ii].intersects(pickedPiece, x, y))
					return;
			}
			pickedPiece.moveTo(x, y);
			repaint();
		}
	}
	
	public void movePiece (int x, int y) {
		int		dx, dy;
		int 	off = unit >> 1;
		
		if (pickedPiece != null) {
			if (x >= off  &&  y >= off  &&  x < ((unit * 4) + off)  &&  y < ((unit * 5) + off)) {
				x = ((x - off) / unit) - pickedXoff;
				y = ((y - off) / unit) - pickedYoff;
				while (pickedX != x  ||  pickedY != y) {
					if (x > pickedX)
						tryMove(1, 0);
					else if (x < pickedX)
						tryMove(-1, 0);
					else if (y > pickedY)
						tryMove(0, 1);
					else
						tryMove(0, -1);
				}
			}
		}
	}
	
	public void paint (Graphics g) {
		if (offscr != null) {
			offscr.drawImage(boardImg, 0, 0, this);
			for (int ii = 0; ii < pieces.length; ii++)
				pieces[ii].drawPiece(offscr, piecesImg);
			g.drawImage(offscreenImage, 0, 0, this);
		}
	}

	public void update (Graphics g) {
		paint(g);
	}
}

public class Puzzle extends Applet {
	private PuzzleBoard	slider;

	public void init() {
		super.init();
		setLayout(null);
		slider = new PuzzleBoard(0, 0, size().width, size().height, this);
	}

	public boolean mouseDown (Event evt, int x, int y) {
		if (slider != null)
			slider.pickPiece(x, y);
		return true;
	}
	
	public boolean mouseDrag (Event evt, int x, int y) {
		if (slider != null)
			slider.movePiece(x, y);
		return true;
	}
}

