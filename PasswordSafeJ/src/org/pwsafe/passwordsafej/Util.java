/*
 * $Id$
 * 
 * Copyright (c) 2008 David Muller <roxon@users.sourceforge.net>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.passwordsafej;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import sun.rmi.runtime.GetThreadPoolAction;

/**
 *
 * @author Kevin Preece
 */
public final class Util
{
	/**
	 * 
	 */
	private Util()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calculates the X and Y coordinates that a child component should have to be centred
	 * within its parent.  This method does not try to constrain the calculation so that
	 * the point remains wholly onscreen.
	 * 
	 * @param rec  the bounding rectangle of the parent.
	 * @param dim  the dimensions of the child.
	 * 
	 * @return the X and Y coordinates the child should have.
	 */
	public static Point centreWithin( Rectangle rec, Dimension dim )
	{
		Point	pos;

		pos		= new Point();
		pos.x	= rec.x + ((rec.width - dim.width) >> 1);
		pos.y	= rec.y + ((rec.height - dim.height) >> 1);
		
		return pos;
	}

	/**
	 * Centres the child component within its parent.
	 * 
	 * @param parent  the parent component.
	 * @param child   the child component.
	 */
	public static void centreWithin( Component parent, Component child )
	{
		child.setLocation( centreWithin( parent.getBounds(), child.getSize() ) );
	}
}
