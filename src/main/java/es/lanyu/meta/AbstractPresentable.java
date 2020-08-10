package es.lanyu.meta;

import java.util.function.Consumer;

public abstract class AbstractPresentable<T> implements Presentable<T> {
	String id;
	protected transient Consumer<Presentable<T>> presentador;
	protected transient T objetoParaPresentar;
	
	@Override
	public String getIdentificador() {
		return id;
	}
	
	public void setIdentificador(String id) {
		this.id = id;
	}

	public AbstractPresentable(String id) {
		this(id, null, null);
		presentador = p -> System.out.println(p.toText());
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
	
}
