package com.example.testejaxb.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class BoletoJAXB {

	@XmlElement
	protected String quebraLinha = "\n"; // Boletos tem quebra de linha, consultar o manual

	@XmlElement
	protected String tipoRegistro;
	
	@XmlElement
	protected String codigoServico;

	@XmlElement
	protected String razaoSocial;
	
	@XmlElement
	protected String cnpjEmpresa;
	
	@XmlElement
	protected String nossoNumero;

	public String getQuebraLinha() {
		return quebraLinha;
	}

	public void setQuebraLinha(String quebraLinha) {
		this.quebraLinha = quebraLinha;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(String codigoServico) {
		this.codigoServico = StringUtils.leftPad(codigoServico, 2, '0');;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		razaoSocial = StringUtils.rightPad(razaoSocial, 30);
		this.razaoSocial = StringUtils.substring(razaoSocial, 0, 30);
	}

	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = StringUtils.leftPad(nossoNumero,8,'0');
	}
	
}
