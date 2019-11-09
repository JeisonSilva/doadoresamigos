package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.gestaodoadores.AlteracaoDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDal;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AlteracaoDoadorTest {

    private DoadorRepositorio doadorRepositorio;
    private DoadorDal doadorDal;
    private AlteracaoDoador alteracaoDoador;

    @Before
    public void configurarTestes(){
        this.doadorRepositorio = Mockito.mock(DoadorRepositorio.class);
        this.doadorDal = Mockito.mock(DoadorDal.class);

    }

    @Test
    public void deveAlterarDadosDoador(){
        DoadorDto doadorDto = new DoadorDto();
        when(this.doadorDal.obterDadosInformadosPeloUsuario()).thenReturn(doadorDto);
        when(this.doadorDal.validarPreenchimentoDados()).thenReturn(true);
        this.alteracaoDoador = new AlteracaoDoador(doadorDal, doadorRepositorio);

        this.alteracaoDoador.alterar();

        verify(this.doadorRepositorio).alterar(Mockito.any(DoadorDto.class));
    }
}
