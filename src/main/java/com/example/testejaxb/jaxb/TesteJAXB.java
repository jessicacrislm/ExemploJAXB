package com.example.testejaxb.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class TesteJAXB {

	@XmlElement
	protected String identificacaoRegistro = "JOSYAS";

	public String getIdentificacaoRegistro() {
		return identificacaoRegistro;
	}

	public void setIdentificacaoRegistro(String identificacaoRegistro) {
		this.identificacaoRegistro = identificacaoRegistro;
	}
	
}
