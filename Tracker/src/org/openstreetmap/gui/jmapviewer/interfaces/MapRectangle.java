// License: GPL. For details, see Readme.txt file.
package org.openstreetmap.gui.jmapviewer.interfaces;

import java.awt.Graphics;
import java.awt.Point;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import model.dto.Coordinate;

/**
 * Interface to be implemented by rectangles that can be displayed on the map.
 *
 * @author Stefan Zeller
 * @see JMapViewer#addMapRectangle(MapRectangle)
 * @see JMapViewer#getMapRectangleList()
 */
public interface MapRectangle extends MapObject {

    /**
     * @return Latitude/Longitude of top left of rectangle
     */
    Coordinate getTopLeft();

    /**
     * @return Latitude/Longitude of bottom right of rectangle
     */
    Coordinate getBottomRight();

    /**
     * Paints the map rectangle on the map. The <code>topLeft</code> and
     * <code>bottomRight</code> are specifying the coordinates within <code>g</code>
     *
     * @param g graphics structure for painting
     * @param topLeft lop left edge of painting region
     * @param bottomRight bottom right edge of painting region
     */
    void paint(Graphics g, Point topLeft, Point bottomRight);
}
