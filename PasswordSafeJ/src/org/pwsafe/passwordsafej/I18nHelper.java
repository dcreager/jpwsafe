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

import org.pwsafe.lib.I18nHelperBase;

/**
 *
 * @author Kevin Preece
 */
public class I18nHelper extends I18nHelperBase
{
	private static final I18nHelper	TheInstance	= new I18nHelper();

	private I18nHelper()
	{
		super();
	}

	/**
	 * 
	 * @return
	 * 
	 * @see org.pwsafe.lib.I18nHelper#getFilename()
	 */
	public String getFilename()
	{
		return "PasswordSafeJUI";
	}

	/**
	 * Returns an instance of this I18nHelper class.
	 * 
	 * @return An instance of this I18nHelper class.
	 */
	public static I18nHelper getInstance()
	{
		return TheInstance;
	}
}
