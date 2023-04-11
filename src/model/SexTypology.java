package model;

public class SexTypology {
	
	private int id;
	private String descripcion;
	
	/**
	 * 
	 */
	public SexTypology() {
		super();
	}

	/**
	 * @param id
	 * @param descripcion
	 */
	public SexTypology(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			return id == ((SexTypology) obj).getId();
		}
		return false;
	}

	@Override
	public String toString() {
		return descripcion;
	}
	
}
