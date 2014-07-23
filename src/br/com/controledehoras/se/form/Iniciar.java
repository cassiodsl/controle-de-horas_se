package br.com.controledehoras.se.form;

import br.com.controledehoras.core.beans.Feriado;
import br.com.controledehoras.core.beans.RegistroArquivo;
import br.com.controledehoras.core.beans.Tempo;
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

        List<RegistroArquivo> registros = CSVHelper.getInstance().obterRegistrosDoArquivo("caminho do arquivo");

        List<Feriado> feriados = new ArrayList<Feriado>();
        feriados.add(new Feriado(2014, 7, 9));

        Calendar consumirAte = CalcTempoUtil.getInstance().getCalendar(2014, 8, 31);

        Tempo saldoDiario = CalculadoraMediaHelper.getInstance()
                .calcularMediaDiariaParaEliminarSaldo(registros, Quadrimestre.SEGUNDO
                        , feriados, CalcTempoUtil.getInstance().getYYYYMMDD(consumirAte));

        System.out.print("Realizar " + saldoDiario.getHorasString()
                + " por dia até " + CalcTempoUtil.getInstance().getDateFormatDDMMMYY(consumirAte));

        //TODO: Criar um metodo no CalcTempoUtil que recebe um formato de data e uma data e formata
    }

}
