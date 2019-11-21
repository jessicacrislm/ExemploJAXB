package com.example.testejaxb.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class RemessaJAXB {

	@XmlElement
	protected List<BoletoJAXB> boletos;

	public List<BoletoJAXB> getBoletos() {
		if (this.boletos == null) {
			this.boletos = new ArrayList<>();
		}
		return boletos;
	}

	public void setBoletos(List<BoletoJAXB> boletos) {
		this.boletos = boletos;
	}
	
}
