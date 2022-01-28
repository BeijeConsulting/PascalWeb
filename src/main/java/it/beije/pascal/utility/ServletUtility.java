package it.beije.pascal.utility;

import javax.servlet.http.HttpServletRequest;

import it.beije.pascal.bean.Annuncio;
import it.beije.pascal.bean.Indirizzo;
import it.beije.pascal.bean.enums.AriaCondizionata;
import it.beije.pascal.bean.enums.Arredamento;
import it.beije.pascal.bean.enums.ClasseEnergetica;
import it.beije.pascal.bean.enums.Condizione;
import it.beije.pascal.bean.enums.Giardino;
import it.beije.pascal.bean.enums.Riscaldamento;
import it.beije.pascal.bean.enums.StatoRogito;
import it.beije.pascal.bean.enums.TipoAnnuncio;
import it.beije.pascal.bean.enums.TipoImmobile;

public class ServletUtility {

	public static Indirizzo createAddress(HttpServletRequest request) {

		Indirizzo indirizzo = new Indirizzo();
		indirizzo.setComune(request.getParameter("comune"));
		indirizzo.setIndirizzo(request.getParameter("indirizzo"));
		indirizzo.setCap(request.getParameter("cap"));
		indirizzo.setNCivico(Integer.parseInt(request.getParameter("numeroCivico")));

		return indirizzo;

	}

	public static Annuncio createAdvertisement(HttpServletRequest request, int indirizzoId) {
		
		Annuncio annuncio = new Annuncio();
		String ti = request.getParameter("tipoImmobile");
		TipoImmobile tipoImmobile = TipoImmobile.valueOf(ti);

		String ta = request.getParameter("tipoAnnuncio");
		TipoAnnuncio tipoAnnuncio = TipoAnnuncio.valueOf(ta);

		int prezzo = Integer.parseInt(request.getParameter("prezzo"));

		int mq = Integer.parseInt(request.getParameter("mq"));

		int locali = Integer.parseInt(request.getParameter("locali"));

		int bagni = Integer.parseInt(request.getParameter("bagni"));

		int tot_piani = Integer.parseInt(request.getParameter("tot_piani"));

		int piano = Integer.parseInt(request.getParameter("piano"));

		boolean ascensore = Boolean.parseBoolean(request.getParameter("ascensore"));

		int postiAuto = Integer.parseInt(request.getParameter("postiAuto"));

		boolean balcone = Boolean.parseBoolean(request.getParameter("balcone"));

		boolean terrazzo = Boolean.parseBoolean(request.getParameter("terrazzo"));

		String g = request.getParameter("giardino");
		Giardino giardino = Giardino.valueOf(g);

		String c = request.getParameter("condizione");
		Condizione condizione = Condizione.valueOf(c);

		String ce = request.getParameter("classeEnergetica");
		ClasseEnergetica classeEnergetica = ClasseEnergetica.valueOf(ce);

		String r = request.getParameter("riscaldamento");
		Riscaldamento riscaldamento = Riscaldamento.valueOf(r);

		String ac = request.getParameter("ariaCondizionata");
		AriaCondizionata ariaCondizionata = AriaCondizionata.valueOf(ac);

		String ar = request.getParameter("arredamento");
		Arredamento arredamento = Arredamento.valueOf(ar);

		boolean piscina = Boolean.parseBoolean(request.getParameter("piscina"));

		boolean portineria = Boolean.parseBoolean(request.getParameter("portineria"));

		short annoCostruzione = Short.parseShort(request.getParameter("annoCostruzione"));

		String sr = request.getParameter("statoRogito");
		StatoRogito statoRogito = StatoRogito.valueOf(sr);

		boolean visitaGuidata = Boolean.parseBoolean(request.getParameter("visitaGuidata"));

		String descrizioneLunga = request.getParameter("descrizioneLunga");

		boolean virtualTour = Boolean.parseBoolean(request.getParameter("virtualTour"));

		
		//DA SISTEMARE------------------------------------	
		annuncio.setVenditoriId(1);
		//------------------------------------------------
		
		annuncio.setIndirizzoId(indirizzoId);
		annuncio.setTipoImmobile(tipoImmobile);
		annuncio.setTipoAnnuncio(tipoAnnuncio);
		annuncio.setPrezzo(prezzo);
		annuncio.setMq(mq);
		annuncio.setLocali(locali);
		annuncio.setBagni(bagni);
		annuncio.setTotPiani(tot_piani);
		annuncio.setPiano(piano);
		annuncio.setAscensore(ascensore);
		annuncio.setPostiAuto(postiAuto);
		annuncio.setBalcone(balcone);
		annuncio.setTerrazzo(terrazzo);
		annuncio.setGiardino(giardino);
		annuncio.setCondizione(condizione);
		annuncio.setClasseEnergetica(classeEnergetica);
		annuncio.setRiscaldamento(riscaldamento);
		annuncio.setAriaCondizionata(ariaCondizionata);
		annuncio.setArredamento(arredamento);
		annuncio.setPiscina(piscina);
		annuncio.setPortineria(portineria);
		annuncio.setAnno_costruzione(annoCostruzione);
		annuncio.setStatoRogito(statoRogito);
		annuncio.setVisitaGuidata(visitaGuidata);
		annuncio.setDescrizioneLunga(descrizioneLunga);
		annuncio.setVirtualTour(virtualTour);
		
		return annuncio;

	}

}
