package es.lanyu.meta;

import java.util.function.Consumer;
import java.util.logging.Logger;

import es.lanyu.commons.identificable.IdentificableString;

public abstract class AbstractPresentable<T> extends IdentificableString implements Presentable<T> {

    private static Logger log = Logger.getLogger(AbstractPresentable.class.getName());
    protected transient Consumer<Presentable<T>> presentador;
    protected transient T objetoParaPresentar;

    public AbstractPresentable(String id) {
        this(id, null, null);
        presentador = p -> log.info(p.toString());
    }

    public AbstractPresentable(String id, T presentable, Consumer<Presentable<T>> presentador) {
        super();
        setIdentificador(id);
        objetoParaPresentar = presentable;
        this.presentador = presentador;
    }

    @Override
    public T getObjetoParaPresentar() {
        return objetoParaPresentar;
    }

    @Override
    public void presentar() {
        presentador.accept(this);
    }

    @Override
    public String toString() {
        return toText();
    }
}
