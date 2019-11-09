package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorio;
import com.jsonapp.doadoresamigos.gestaodoadores.RegistroDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(Parameterized.class)
public class ValidacaoRegistroDoadorTest {


    @Parameterized.Parameter
    public DoadorDto doadorDtoValidacaoDados;


    @Test
    public void deveNotificarDadosInvalidosParaDadosNaoInformados(){
        DoadorDal doadorDal = Mockito.mock(DoadorDal.class);
        DoadorRepositorio doadorRepositorio = Mockito.mock(DoadorRepositorio.class);
        RegistroDoador registroDoador = new RegistroDoador(doadorDal, doadorRepositorio);
        when(doadorDal.obterDadosInformadosPeloUsuario()).thenReturn(this.doadorDtoValidacaoDados);
        when(doadorDal.validarPreenchimentoDados()).thenReturn(false);

        registroDoador.registrar();

        verify(doadorDal).notificarDadosInvalidos();
    }

    @Parameterized.Parameters
    public static Collection<DoadorDto> data(){
        return Arrays.asList(new DoadorDto[]{
                obterDoadorSemNome(),
                obterDoadorSemSobrenome(),
                obterDoadorSemIdade(),
                obterDoadorSemFatorRh(),
                obterDoadorSemTipoSanguenio(),
                obterDoadorSemTipoPeso(),
                obterDoadorSemAltura()
        });
    }

    public static DoadorDto obterDoadorSemNome() {
        DoadorDto doadorDto = new DoadorDto();
        doadorDto.setSobrenome("Pietro");
        doadorDto.setIdade(31);
        doadorDto.setFatorRh("Rh+");
        doadorDto.setTipoDeSangue("O");
        doadorDto.setPeso(68);
        doadorDto.setAltura(1.68);

        return doadorDto;
    }

    public static DoadorDto obterDoadorSemSobrenome() {
        DoadorDto doadorDto = new DoadorDto();
        doadorDto.setNome("Artur");
        doadorDto.setIdade(31);
        doadorDto.setFatorRh("Rh+");
        doadorDto.setTipoDeSangue("O");
        doadorDto.setPeso(68);
        doadorDto.setAltura(1.68);

        return doadorDto;
    }

    public static DoadorDto obterDoadorSemIdade() {
        DoadorDto doadorDto = new DoadorDto();
        doadorDto.setNome("Artur");
        doadorDto.setSobrenome("Pietro");
        doadorDto.setFatorRh("Rh+");
        doadorDto.setTipoDeSangue("O");
        doadorDto.setPeso(68);
        doadorDto.setAltura(1.68);

        return doadorDto;
    }

    public static DoadorDto obterDoadorSemFatorRh() {
        DoadorDto doadorDto = new DoadorDto();
        doadorDto.setNome("Artur");
        doadorDto.setSobrenome("Pietro");
        doadorDto.setIdade(31);
        doadorDto.setTipoDeSangue("O");
        doadorDto.setPeso(68);
        doadorDto.setAltura(1.68);

        return doadorDto;
    }

    public static DoadorDto obterDoadorSemTipoSanguenio() {
        DoadorDto doadorDto = new DoadorDto();
        doadorDto.setNome("Artur");
        doadorDto.setSobrenome("Pietro");
        doadorDto.setIdade(31);
        doadorDto.setFatorRh("Rh+");
        doadorDto.setPeso(68);
        doadorDto.setAltura(1.68);

        return doadorDto;
    }

    public static DoadorDto obterDoadorSemTipoPeso() {
        DoadorDto doadorDto = new DoadorDto();
        doadorDto.setNome("Artur");
        doadorDto.setSobrenome("Pietro");
        doadorDto.setIdade(31);
        doadorDto.setFatorRh("Rh+");
        doadorDto.setTipoDeSangue("O");
        doadorDto.setAltura(1.68);

        return doadorDto;
    }

    public  static DoadorDto obterDoadorSemAltura(){
        DoadorDto doadorDto = new DoadorDto();
        doadorDto.setNome("Artur");
        doadorDto.setSobrenome("Pietro");
        doadorDto.setIdade(31);
        doadorDto.setFatorRh("Rh+");
        doadorDto.setTipoDeSangue("O");
        doadorDto.setPeso(68);

        return doadorDto;
    }
}
