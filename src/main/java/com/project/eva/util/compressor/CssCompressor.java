package com.project.eva.util.compressor;

import com.googlecode.htmlcompressor.compressor.Compressor;
import com.googlecode.htmlcompressor.compressor.YuiCssCompressor;

/**
 * The class implements a set of methods for compressing CSS data.
 *

 */
public final class CssCompressor extends AbstractCompressor implements Compressor {

    /**
     * The instance of the Compressor class.
     */
    private final Compressor compressor;

    /**
     * Constructor.
     */
    public CssCompressor() {
        this.compressor = new YuiCssCompressor();
    }

    /**
     * Returns a compressor object
     * of the YuiCssCompressor class.
     *
     * @return The CSS compressor instance.
     */
    Compressor getCompressor() {
        return this.compressor;
    }
}
