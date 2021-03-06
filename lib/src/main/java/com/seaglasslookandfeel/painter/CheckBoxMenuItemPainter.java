/*
 * Copyright (c) 2009 Kathryn Huxtable and Kenneth Orr.
 *
 * This file is part of the SeaGlass Pluggable Look and Feel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * $Id: CheckBoxMenuItemPainter.java 1595 2011-08-09 20:33:48Z rosstauscher@gmx.de $
 */
package com.seaglasslookandfeel.painter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JComponent;

import com.seaglasslookandfeel.painter.AbstractRegionPainter.PaintContext.CacheMode;

/**
 * CheckBox menu item painter. This paints the checkmark for a selected
 * JCheckBoxMenuItem.
 *
 * @author Kathryn Huxtable
 */
public final class CheckBoxMenuItemPainter extends MenuItemPainter {

    /**
     * Control state.
     */
    public static enum Which {
        BACKGROUND_DISABLED, BACKGROUND_ENABLED, BACKGROUND_MOUSEOVER, BACKGROUND_SELECTED_MOUSEOVER, CHECKICON_DISABLED_SELECTED,
        CHECKICON_ENABLED_SELECTED, CHECKICON_SELECTED_MOUSEOVER, CHECKICON_ENABLED_MOUSEOVER, CHECKICON_ENABLED,
    }

    private Which        state;
    private PaintContext ctx;

    private Color iconDisabledSelected  = decodeColor("seaGlassDisabledText");
    // Rossi: Added hints if a menu item is a checkbox
    private Color iconEnabledSelected   = decodeColor("seaGlassMenuIcon");
    private Color iconEnabled           = decodeColor("seaGlassMenuIcon");
    private Color iconSelectedMouseOver = decodeColor("seaGlassSelectedText");

    /**
     * Creates a new CheckBoxMenuItemPainter object.
     *
     * @param state the control state to be painted.
     */
    public CheckBoxMenuItemPainter(Which state) {
        super(MenuItemPainter.Which.BACKGROUND_ENABLED);
        this.state = state;

        switch (state) {

        case BACKGROUND_DISABLED:
        case BACKGROUND_ENABLED:
        case BACKGROUND_MOUSEOVER:
        case BACKGROUND_SELECTED_MOUSEOVER:
            this.ctx = new PaintContext(CacheMode.NO_CACHING);
            break;

        default:
            this.ctx = new PaintContext(CacheMode.FIXED_SIZES);
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doPaint(Graphics2D g, JComponent c, int width, int height, Object[] extendedCacheKeys) {
        switch (state) {

        case BACKGROUND_MOUSEOVER:
            paintBackgroundMouseOver(g, c, width, height);
            break;

        case BACKGROUND_SELECTED_MOUSEOVER:
            paintBackgroundMouseOver(g, c, width, height);
            break;

        case CHECKICON_DISABLED_SELECTED:
            paintCheckIconDisabledAndSelected(g, width, height);
            break;

        case CHECKICON_ENABLED_SELECTED:
            paintCheckIconEnabledAndSelected(g, width, height);
            break;

        case CHECKICON_ENABLED:
            paintCheckIconEnabled(g, width, height);
            break;

        case CHECKICON_ENABLED_MOUSEOVER:
            paintCheckIconEnabledAndMouseOver(g, width, height);
            break;
            
        case CHECKICON_SELECTED_MOUSEOVER:
            paintCheckIconSelectedAndMouseOver(g, width, height);
            break;

        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected PaintContext getPaintContext() {
        return ctx;
    }

    /**
     * Paint the check mark in disabled state.
     *
     * @param g      the Graphics2D context to paint with.
     * @param width  the width.
     * @param height the height.
     */
    private void paintCheckIconDisabledAndSelected(Graphics2D g, int width, int height) {
        Shape s = shapeGenerator.createCheckMark(0, 0, width, height);

        g.setPaint(iconDisabledSelected);
        g.fill(s);

    }
   
    /**
     * Paint the check mark in enabled state.
     *
     * @param g      the Graphics2D context to paint with.
     * @param width  the width.
     * @param height the height.
     */
    private void paintCheckIconEnabledAndSelected(Graphics2D g, int width, int height) {
        Shape s = shapeGenerator.createCheckMark(0, 0, width, height);
        g.setPaint(iconEnabledSelected);
        g.fill(s);
    }

    /**
     * Paint the check mark in enabled state.
     *
     * @param g      the Graphics2D context to paint with.
     * @param width  the width.
     * @param height the height.
     */
    private void paintCheckIconEnabled(Graphics2D g, int width, int height) {
        g.setPaint(iconEnabled);
        g.drawRoundRect(0, 1, width-1, height-2, 4, 4);
    }

    
    /**
     * Paint the check mark in mouse over state.
     *
     * @param g      the Graphics2D context to paint with.
     * @param width  the width.
     * @param height the height.
     */
    private void paintCheckIconSelectedAndMouseOver(Graphics2D g, int width, int height) {
        Shape s = shapeGenerator.createCheckMark(0, 0, width, height);

        g.setPaint(iconSelectedMouseOver);
        g.fill(s);
    }
    
    /**
     * Paint the check mark in mouse over state.
     *
     * @param g      the Graphics2D context to paint with.
     * @param width  the width.
     * @param height the height.
     */
    private void paintCheckIconEnabledAndMouseOver(Graphics2D g, int width, int height) {
        g.setPaint(iconSelectedMouseOver);
        g.drawRoundRect(0, 1, width-1, height-2, 4, 4);
    }
}
