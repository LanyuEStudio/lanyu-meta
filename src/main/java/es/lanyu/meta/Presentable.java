package es.lanyu.meta;

import es.lanyu.commons.identificable.Identificable;

public interface Presentable<T> extends Identificable<String> {

    T getObjetoParaPresentar();

    void presentar();

    default String toText() {
        String text = "Presentable<";
        if (getObjetoParaPresentar() != null) { 
            text += getObjetoParaPresentar().getClass().getSimpleName();
        }
        
        return text + ">: " + getIdentificador();
    }
}
