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

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Creates a blank panel to be used for spacing between components or borders around a dialogue.
 * 
 * @author Kevin Preece
 */
public class SpacerPanel extends JPanel
{
	/**
	 * Creates a JPanel with its preferred size set to the given dimensions.  The resulting
	 * JPanel is suitable for use as whitespace filler in layouts.
	 * 
	 * @param width   the preferred width of this spacer.
	 * @param height  the preferred height of this spacer.
	 */
	public SpacerPanel( int width, int height )
	{
		super();
		setPreferredSize( new Dimension( width, height ) );
	}
}
