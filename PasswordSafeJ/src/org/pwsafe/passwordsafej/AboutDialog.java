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

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Kevin Preece
 */
public class AboutDialog extends JDialog
{
	/**
	 * @param owner
	 * @throws java.awt.HeadlessException
	 */
	public AboutDialog( JFrame owner ) throws HeadlessException
	{
		super( owner );
		setModal( true );
		setResizable( false );
		setTitle( I18nHelper.getInstance().formatMessage("about.title"));

		buildTopPanel();
		buildCentrePanel();
		buildButtonPanel();

		pack();
		Util.centreWithin( owner, this );
		show();
	}

	private void buildButtonPanel()
	{
		ButtonBar	buttonbar;
		OkButton	okButton;

		buttonbar	= new ButtonBar();
		okButton	= new OkButton();
		
		okButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				dispose();
			}} );

		buttonbar.add( okButton );

		getContentPane().add( buttonbar, BorderLayout.SOUTH );
		getRootPane().setDefaultButton(okButton);
	}

	private void buildCentrePanel()
	{
		JTextArea	text1;

		text1	= new JTextArea( I18nHelper.getInstance().formatMessage("about.text", new Object [] { "Kevin Preece."} ) );

		text1.setEditable( false );
		text1.setBackground( getBackground() );
		text1.setBorder( new EmptyBorder( 16, 40, 0, 40 ) );

		getContentPane().add( text1, BorderLayout.CENTER );
	}

	private void buildTopPanel()
	{
		ImageIcon	icon;
		JButton		logo;

		icon	= new ImageIcon( "images/psafetxt.gif" );
		logo	= new JButton( icon );

		logo.setDisabledIcon( icon );
		logo.setEnabled( false );
		logo.setBorder( new EmptyBorder( 6, 0, 0, 0 ) );

		getContentPane().add( logo, BorderLayout.NORTH );
	}
}
