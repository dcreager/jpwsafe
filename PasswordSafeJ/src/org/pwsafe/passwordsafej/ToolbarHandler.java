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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import org.pwsafe.lib.Log;

/**
 *
 * @author Kevin Preece
 */
public class ToolbarHandler
{
	/**
	 * Log4j logger
	 */
	private static final Log	LOG	= Log.getInstance( ToolbarHandler.class.getPackage().getName() );

	private JToolBar		ToolBar;
	private PasswordSafeJ	Owner;
	private JButton			ButtonAdd;
	private JButton			ButtonEdit;
	private JButton			ButtonDelete;
	private JButton			ButtonCopyPass;
	private JButton			ButtonCopyUser;

	/**
	 * 
	 */
	public ToolbarHandler( PasswordSafeJ owner )
	{
		super();

		JButton		button;

		ToolBar	= new JToolBar();
		Owner	= owner;

		ToolBar.setFloatable( false );

		button	= makeButton("filenew", "toolbar.new");
		ToolBar.add( button );

		button	= makeButton("fileopen", "toolbar.open");
		button.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent event )
			{
				LOG.debug1( "Open file menu option selected" );
				Owner.openFile();
			}
		} );
		ToolBar.add( button );

		button	= makeButton("filesave", "toolbar.save");
		button.setEnabled( false );
		ToolBar.add( button );

		ToolBar.addSeparator();

		ButtonCopyPass	= makeButton("copypass", "toolbar.copypass");
		ButtonCopyPass.setEnabled( false );
		ToolBar.add( ButtonCopyPass );

		ButtonCopyUser	= makeButton("copyuser", "toolbar.copyuser");
		ButtonCopyUser.setEnabled( false );
		ToolBar.add( ButtonCopyUser );

		button	= makeButton("clearclip", "toolbar.clearclip");
		button.setEnabled( false );
		ToolBar.add( button );

		ToolBar.addSeparator();

		ButtonAdd		= makeButton("add", "toolbar.add");
		ButtonAdd.setEnabled( false );
		ButtonAdd.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent event )
			{
				LOG.debug1( "Toolbar/Add menu option selected" );
				Owner.addEntry();
			}
		} );
		ToolBar.add( ButtonAdd );

		ButtonEdit		= makeButton("edit", "toolbar.edit");
		ButtonEdit.setEnabled( false );
		ToolBar.add( ButtonEdit );

		ButtonDelete	= makeButton("delete", "toolbar.delete");
		ButtonDelete.setEnabled( false );
		ToolBar.add( ButtonDelete );

		ToolBar.addSeparator();

		button	= makeButton("help", "toolbar.help");
		ToolBar.add( button );
	}

	void fileOpened()
	{
		ButtonAdd.setEnabled( true );
	}

	void leafSelected( boolean isLeafNode )
	{
		ButtonEdit.setEnabled( isLeafNode );
		ButtonDelete.setEnabled( isLeafNode );
		ButtonCopyUser.setEnabled( isLeafNode );
		ButtonCopyPass.setEnabled( isLeafNode );
	}

	private JButton makeButton( String imgName, String buttonName )
	{
		LOG.enterMethod( "makeButton" );

		String	imgLoc;
		JButton	button;

		imgLoc	= "images/" + imgName + ".gif";
		button	= new JButton();

		button.setToolTipText( I18nHelper.getInstance().formatMessage(buttonName+".tooltip") );
		button.setIcon( new ImageIcon(imgLoc, I18nHelper.getInstance().formatMessage(buttonName)) );

		LOG.leaveMethod( "makeButton" );

		return button;
	}

	/**
	 * @return Returns the toolBar.
	 */
	public JToolBar getToolBar()
	{
		return ToolBar;
	}
}
