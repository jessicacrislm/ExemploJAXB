package com.example.testejaxb;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.example.testejaxb.interceptors.Log;
import com.example.testejaxb.jaxb.BoletoJAXB;
import com.example.testejaxb.jaxb.RemessaJAXB;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
@Log
public class TesteJaxbExecutavel {

	public static void main(String[] args) {
		BoletoJAXB boleto = new BoletoJAXB();
		boleto.setTipoRegistro("1");
		boleto.setCodigoServico("1");
		boleto.setCnpjEmpresa("11111111111111");
		String teste = "tÉstÂndo içù";
		teste = Normalizer.normalize(teste, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""); 
		boleto.setRazaoSocial(teste);
		boleto.setNossoNumero("22222222");
		
		BoletoJAXB boleto2 = new BoletoJAXB();
		boleto2.setTipoRegistro("1");
		boleto2.setCodigoServico("1");
		boleto2.setCnpjEmpresa("11111111111111");
		boleto2.setRazaoSocial("Mecanica Matheussssssssssssssssssssabcd");
		boleto2.setNossoNumero("55555");
		
		RemessaJAXB remessa = new RemessaJAXB();
		remessa.getBoletos().add(boleto);
		remessa.getBoletos().add(boleto2);
 		
		try {
			JAXBContext jc = JAXBContext.newInstance(RemessaJAXB.class);
			Marshaller mars = jc.createMarshaller();
			mars.setProperty(Marshaller.JAXB_ENCODING, StandardCharsets.UTF_8.name());
			mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
			mars.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			StringWriter result = new StringWriter();
			mars.marshal(remessa, result);
			System.out.println(getValorTag(RegExUtils.replaceFirst(result.toString(), "\\n", StringUtils.EMPTY)));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getValorTag(String xml) {
		return xml.replaceAll("(<)([a-zA-Z0-9/]+)(>)", "");
	}

}
