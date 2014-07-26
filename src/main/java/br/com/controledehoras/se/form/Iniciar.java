package br.com.controledehoras.se.form;

import br.com.controledehoras.core.beans.Discountable;
import br.com.controledehoras.core.beans.ITempo;
import br.com.controledehoras.core.beans.Registrable;
import br.com.controledehoras.core.saldo.CalculadoraMediaHelper;
import br.com.controledehoras.core.saldo.Quadrimestre;
import br.com.controledehoras.core.csv.CSVHelper;
import br.com.controledehoras.core.tempo.CalcTempoUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Cassio
 */
public class Iniciar {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // Exemplo de como usar a biblioteca
        
        List<Registrable> registros = CSVHelper.getInstance().obterRegistrosDoArquivo("caminho do arquivo");

        List<Discountable> feriados = new ArrayList<Discountable>();
        feriados.add(new Atestado());

        Calendar consumirAte = CalcTempoUtil.getInstance().getCalendar(2014, 8, 31);

        ITempo saldoDiario = CalculadoraMediaHelper.getInstance()
                .calcularMediaDiariaParaEliminarSaldo(registros, Quadrimestre.SEGUNDO
                        , feriados, CalcTempoUtil.getInstance().getYYYYMMDD(consumirAte), 8);

        String horasStr = CalcTempoUtil.getInstance().getHorasString(saldoDiario.getMinutos());
        System.out.print("Realizar " + horasStr
                + " por dia até " + CalcTempoUtil.getInstance().getDateFormatDDMMMYY(consumirAte));

        //TODO: Criar um metodo no CalcTempoUtil que recebe um formato de data e uma data e formata
    }

}
