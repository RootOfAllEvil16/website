package com.project.eva.model;


import com.googlecode.htmlcompressor.compressor.Compressor;
import com.project.eva.util.compressor.HtmlCompressor;
import com.project.eva.util.generator.Generator;
import com.project.eva.util.generator.StringGenerator;

public abstract class ModelBuilder<T extends Model, B extends ModelBuilder<T, B>> implements Builder<T> {


    private long id;


    protected ModelBuilder() {
    }


    public B addId(final long id) {
        this.id = id;
        return (B) this;
    }

    protected T build(final T model) {
        model.setId(getId());
        return model;
    }

    protected String generateRandomString() {
        final Generator<String> generator = new StringGenerator();
        return generator.generate();
    }

    protected String compress(final String source) {
        final Compressor compressor = new HtmlCompressor();
        return compressor.compress(source);
    }

    private long getId() {
        return (this.id >= 0) ? this.id : 0;
    }

}
