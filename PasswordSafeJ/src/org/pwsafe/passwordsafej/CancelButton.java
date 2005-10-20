/*
 * $Id$
 * 
 * This file is provided under the standard terms of the Artistic Licence.  See the
 * LICENSE file that comes with this package for details.
 */
package org.pwsafe.passwordsafej;

import javax.swing.JButton;

/**
 *
 * @author Kevin Preece
 */
public class CancelButton extends JButton
{
	/**
	 * 
	 */
	public CancelButton()
	{
		super();
		setText( I18nHelper.getInstance().formatMessage("button.cancel") );
	}
}