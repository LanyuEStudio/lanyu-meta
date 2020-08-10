package es.lanyu.meta;

import es.lanyu.commons.identificable.Identificable;

public interface Presentable<T> extends Identificable<String>{
	
	T getObjetoParaPresentar();
	
	void presentar();
	
	default String toText(){
		return "Presentable<" + getObjetoParaPresentar().getClass().getSimpleName() + ">: " + getIdentificador();
	}
}
