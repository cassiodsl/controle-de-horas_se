package com.jovens.system;

import br.com.controledehoras.core.beans.Feriado;
import br.com.controledehoras.core.beans.RegistroArquivo;
import br.com.controledehoras.core.beans.Tempo;
import br.com.controledehoras.core.saldo.CalculadoraMediaHelper;
import br.com.controledehoras.core.saldo.Quadrimestre;
import br.com.controledehoras.core.sintonia.SintoniaHelper;
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

        CalcTempoUtil calc = new CalcTempoUtil();

        SintoniaHelper sintonia = new SintoniaHelper();
        List<RegistroArquivo> registros = sintonia.obterRegistrosDoArquivo("caminho do arquivo");

        List<Feriado> feriados = new ArrayList<>();
        feriados.add(new Feriado(calc.getCalendar(20140709), 1d));

        Calendar consumirAte = calc.getCalendar(20140831);

        CalculadoraMediaHelper helper = new CalculadoraMediaHelper();
        Tempo saldoDiario = helper.calcularMediaDiariaParaEliminarSaldo(registros, Quadrimestre.SEGUNDO, feriados, calc.getYYYYMMDD(consumirAte));

        System.out.print("Realizar " + saldoDiario.getHorasString()
                + " por dia até " + calc.getDateFormatDDMMMYY(consumirAte));

        //TODO: Criar um metodo no CalcTempoUtil que recebe um formato de data e uma data e formata
    }

}
